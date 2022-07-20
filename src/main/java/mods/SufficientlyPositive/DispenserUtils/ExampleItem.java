package mods.SufficientlyPositive.DispenserUtils;

import net.minecraft.block.BlockState;
import net.minecraft.item.*;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;


public class ExampleItem extends Item implements DispensableItem {

    public ExampleItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public boolean dispense(BlockPointer pointer, ItemStack item, Direction dispenserDirection) {

        BlockPos blockPos = pointer.getPos().offset(dispenserDirection);
        World world = pointer.getWorld();

        BlockState[] surroundings = new BlockState[] { world.getBlockState(blockPos.down()),
                world.getBlockState(blockPos.up()),
                world.getBlockState(blockPos.north()),
                world.getBlockState(blockPos.east()),
                world.getBlockState(blockPos.south()),
                world.getBlockState(blockPos.west())
        };

        for (BlockState nextTo : surroundings) {
            if (nextTo.isIn(BlockTags.LEAVES)) {
                try {
                    return (((BlockItem) Items.ACACIA_LOG).place(new AutomaticItemPlacementContext(world, blockPos, dispenserDirection, item, dispenserDirection)).isAccepted());
                } catch (Exception var8) {
                    DispenserUtils.LOGGER.error("Error trying to place block at {}", blockPos, var8);
                }
            }
        }

        return false;
    }
}
