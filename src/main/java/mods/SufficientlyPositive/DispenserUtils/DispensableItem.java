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
    boolean dispense(BlockPointer pointer, ItemStack armor, Direction dispenserDirection);
}
