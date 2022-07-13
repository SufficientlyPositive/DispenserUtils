package mods.SufficientlyPositive.DispenserUtils;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.tag.BlockTags;

import java.util.List;

import static mods.SufficientlyPositive.DispenserUtils.BehaviourFunctions.*;

public class Examples {

    public static void init() {
        blockPlacementOnTopOfBlocks(Items.WHEAT_SEEDS, Blocks.FARMLAND);
        blockPlacementOnTopOfBlocks(Items.MELON_SEEDS, Blocks.FARMLAND);
        blockPlacementOnTopOfBlocks(Items.PUMPKIN_SEEDS, Blocks.FARMLAND);
        blockPlacementOnTopOfBlocks(Items.BEETROOT_SEEDS, Blocks.FARMLAND);
        blockPlacement(Items.CARROT);
        blockPlacement(Items.POTATO);
        blockPlacementOnTopOfBlocks(Items.SUGAR_CANE, List.of(new Block[]{Blocks.SAND, Blocks.DIRT, Blocks.GRASS_BLOCK}));
        blockPlacementOnTopOfBlocks(Items.DARK_OAK_WOOD);
        useItemOnBlocks(Items.DIAMOND_HOE);
        useItemOnBlocks(Items.WOODEN_AXE);
        blockPlacement(Items.STRING);
        useItemOnBlocksWithTags(Items.DIAMOND_AXE, BlockTags.LOGS);
    }
}
