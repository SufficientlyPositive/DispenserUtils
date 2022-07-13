package mods.SufficientlyPositive.DispenserUtils.DispenserBehaviours;

import mods.SufficientlyPositive.DispenserUtils.DispensableItem;
import mods.SufficientlyPositive.DispenserUtils.DispenserUtils;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.Direction;

public class UseDispenseableItem extends FallibleItemDispenserBehavior {

    public UseDispenseableItem() {}

    protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
        this.setSuccess(false);
        Item item = stack.getItem();

        if (item instanceof DispensableItem) {
            Direction direction = (Direction)pointer.getBlockState().get(DispenserBlock.FACING);

            try {
                this.setSuccess(((DispensableItem)item).dispense(pointer, stack, direction));
            } catch (Exception var8) {
                DispenserUtils.LOGGER.error("Error trying to use dispensable item by dispenser at {}", pointer.getPos(), var8);
            }
        }

        return stack;
    }

}
