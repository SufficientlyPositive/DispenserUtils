package mods.SufficientlyPositive.DispenserUtils;

import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tag.BlockTags;

import java.util.List;

import static mods.SufficientlyPositive.DispenserUtils.BehaviourFunctions.*;

public class Examples {

    public static void init() {

        // Placing various crops, note that you do not need to specify that they should be placed on farmland, Minecraft works this out itself.
        blockPlacement(Items.CARROT);
        blockPlacement(List.of(new Item[]{Items.POTATO, Items.BEETROOT_SEEDS}));

        // Placing oak planks
        blockPlacement(Items.OAK_PLANKS);

        // Placing sugar cane on sand only
        blockPlacementOnTopOfBlocks(Items.SUGAR_CANE, Blocks.SAND);

        // Placing torches on top of walls
        blockPlacementOnTopOfBlocksWithTags(Items.TORCH, BlockTags.WALLS);

        // Diamond hoes can now be used in dispensers
        useItemOnBlocks(Items.DIAMOND_HOE);

        // Wooden axes can now be used on dark oak logs
        useItemOnBlocks(Items.WOODEN_AXE, Blocks.DARK_OAK_LOG);

        // Stone axes can now be used on all log types (including WOOD blocks)
        useItemOnBlocksWithTags(Items.STONE_AXE, BlockTags.LOGS);
    }
}
