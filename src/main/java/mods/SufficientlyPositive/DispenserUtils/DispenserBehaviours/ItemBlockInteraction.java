package mods.SufficientlyPositive.DispenserUtils.DispenserBehaviours;

import mods.SufficientlyPositive.DispenserUtils.DispenserUtils;
import mods.SufficientlyPositive.DispenserUtils.Helpers.DispenserItemUsageContext;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Behaviour allowing dispensers to use items using their useOnBlock() function.
 * The behaviour also provides options for whether the dispenser should use durability
 * on the item when using it, as well as further narrowing down the blocks the item can
 * be used on.
 */
public class ItemBlockInteraction extends FallibleItemDispenserBehavior {

    private ArrayList<Block> whitelistedBlocks = null;
    private ArrayList<TagKey<Block>> tags = null;
    private final boolean useDurability;

    private boolean noWhitelists() {
        return this.tags == null && this.whitelistedBlocks == null;
    }

    private boolean inBlocks(Block block) {
        if (whitelistedBlocks == null) {
            return false;
        }
        return whitelistedBlocks.contains(block);
    }

    private boolean hasTag(BlockState state) {
        if (this.tags == null) {
            return false;
        }
        for (TagKey<Block> tag : this.tags) {
            if (state.isIn(tag)) {
                return true;
            }
        }
        return false;
    }

    public ItemBlockInteraction(boolean useDurability) {
        this.useDurability = useDurability;
    }

    public ItemBlockInteraction(boolean useDurability, Collection<Block> interactableBlocks, Collection<TagKey<Block>> tags) {
        this.useDurability = useDurability;
        if (!(interactableBlocks == null || interactableBlocks.isEmpty())) this.whitelistedBlocks = new ArrayList<>(interactableBlocks);
        if (!(tags == null || tags.isEmpty())) this.tags = new ArrayList<>(tags);
    }

    // Investigate conflicts with allowing buckets to be used by dispensers and other similar functionality
    // Should overwrite completely? Behaviours are stored in a map, so using the same key (item) should completely override them.
    protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
        this.setSuccess(false);
        Item item = stack.getItem();
        World world = pointer.getWorld();

        Direction direction = (Direction)pointer.getBlockState().get(DispenserBlock.FACING);
        BlockPos blockPos = pointer.getPos().offset(direction);

        try {
            BlockState blockState = world.getBlockState(blockPos);
            if (noWhitelists() || inBlocks(blockState.getBlock()) || hasTag(blockState)) {
                setSuccess(item.useOnBlock(new DispenserItemUsageContext(world, Hand.MAIN_HAND, stack, new BlockHitResult(new Vec3d(0, 0, 0), direction, blockPos, false))).isAccepted());
            }
        } catch (Exception e) {
            DispenserUtils.LOGGER.error("Error trying to interact with block at {}", blockPos, e);
        }

        if (useDurability && this.isSuccess() && stack.damage(1, world.getRandom(), (ServerPlayerEntity)null)) {
            stack.setCount(0);
        }

        return stack;
    }
}
