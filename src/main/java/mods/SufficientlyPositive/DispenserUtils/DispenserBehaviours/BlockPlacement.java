package mods.SufficientlyPositive.DispenserUtils.DispenserBehaviours;

import mods.SufficientlyPositive.DispenserUtils.DispenserUtils;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.item.AutomaticItemPlacementContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

/**
 * Behaviour allowing dispensers to place blocks in the world, directly in front
 * of themselves. This uses AutomaticItemPlacementContext, similar to
 * BlockAboveBlockPlacement, but does not check for any additional placement
 * conditions.
 */
public class BlockPlacement extends FallibleItemDispenserBehavior {

    public BlockPlacement() {}

    // places in direction dispenser is facing
    protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
        this.setSuccess(false);
        Item item = stack.getItem();

        if (item instanceof BlockItem) {
            Direction direction = (Direction)pointer.getBlockState().get(DispenserBlock.FACING);
            BlockPos blockPos = pointer.getPos().offset(direction);

            try {
                this.setSuccess(((BlockItem)item).place(new AutomaticItemPlacementContext(pointer.getWorld(), blockPos, direction, stack, direction)).isAccepted());
            } catch (Exception var8) {
                DispenserUtils.LOGGER.error("Error trying to place block at {}", blockPos, var8);
            }
        }

        return stack;
    }
}
