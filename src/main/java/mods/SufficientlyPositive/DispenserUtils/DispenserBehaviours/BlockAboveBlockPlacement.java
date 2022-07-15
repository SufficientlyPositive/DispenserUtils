package mods.SufficientlyPositive.DispenserUtils.DispenserBehaviours;

import mods.SufficientlyPositive.DispenserUtils.DispenserUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.item.AutomaticItemPlacementContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.TagKey;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Behaviour allowing dispensers to place specific blocks above non-air blocks.
 * Behaviour works by using Minecraft's AutomaticItemPlacementContext to attempt
 * to place a block facing downwards if the block underneath matches any tags or
 * other specified blocks.
 *
 * If the default constructor is used, as long as there is something underneath the
 * block, the dispenser can place it.
 */
public class BlockAboveBlockPlacement extends FallibleItemDispenserBehavior {

    private ArrayList<Block> whitelistedBlocks = null;
    private ArrayList<TagKey<Block>> tags = null;

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

    public BlockAboveBlockPlacement() {}

    public BlockAboveBlockPlacement(Collection<Block> blocks, Collection<TagKey<Block>> tags) {
        if (!(blocks == null || blocks.isEmpty())) this.whitelistedBlocks = new ArrayList<>(blocks);
        if (!(tags == null || tags.isEmpty())) this.tags = new ArrayList<>(tags);
    }

    protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
        this.setSuccess(false);
        Item item = stack.getItem();

        if (item instanceof BlockItem) {
            Direction direction = (Direction)pointer.getBlockState().get(DispenserBlock.FACING);
            World world = pointer.getWorld();
            BlockPos blockPos = pointer.getPos().offset(direction);

            BlockState underneath = world.getBlockState(blockPos.down());

            if (!underneath.isAir() && (noWhitelists() || inBlocks(underneath.getBlock()) || hasTag(underneath))) {
                try {
                    this.setSuccess(((BlockItem)item).place(new AutomaticItemPlacementContext(world, blockPos, direction, stack, Direction.DOWN)).isAccepted());
                } catch (Exception var8) {
                    DispenserUtils.LOGGER.error("Error trying to place on top of block at {}", blockPos, var8);
                }
            }
        }

        return stack;
    }
}
