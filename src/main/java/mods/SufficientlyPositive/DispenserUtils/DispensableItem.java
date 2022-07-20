package mods.SufficientlyPositive.DispenserUtils;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.Direction;

/**
 * An interface providing a hook for the UseDispensableItem behaviour in this mod.
 * In order to successfully utilise a behaviour using any variation of the useDispense()
 * function, the item needs to first implement the DispensableItem interface.
 */
public interface DispensableItem {

    /**
     * Function called whenever the specified item is used by a dispenser. The behaviour is
     * specified by the modder.
     *
     * @param pointer the BlockPointer to the dispenser block
     * @param item the specific ItemStack being used, make sure that any damaging/decrementing
     *             is specified here as it is not automatic.
     * @param dispenserDirection the direction the dispenser is facing in.
     * @return whether dispensing the item was successful or not.
     */
    boolean dispense(BlockPointer pointer, ItemStack item, Direction dispenserDirection);
}
