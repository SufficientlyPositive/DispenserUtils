package mods.SufficientlyPositive.DispenserUtils;

import mods.SufficientlyPositive.DispenserUtils.DispenserBehaviours.BlockAboveBlockPlacement;
import mods.SufficientlyPositive.DispenserUtils.DispenserBehaviours.ItemBlockInteraction;
import mods.SufficientlyPositive.DispenserUtils.DispenserBehaviours.BlockPlacement;
import mods.SufficientlyPositive.DispenserUtils.DispenserBehaviours.UseDispenseableItem;
import net.minecraft.block.Block;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;

import java.util.ArrayList;
import java.util.Collection;

public class BehaviourFunctions {

    /*
     * BLOCK PLACEMENT
     */
    // Note: all placement uses AutomaticItemPlacementContext() and therefore is still constrained by what minecraft considers valid placement by default.
    public static void blockPlacement(Item item) {
        DispenserBlock.registerBehavior(item.asItem(), new BlockPlacement());
        if (!DispenserUtils.isPlaceable(item.asItem())) {
            DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
        }
    }

    public static void blockPlacement(Collection<Item> items) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new BlockPlacement());
            if (!DispenserUtils.isPlaceable(item.asItem())) {
                DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
            }
        }
    }

    /*
     * BLOCK PLACEMENT ABOVE OTHER BLOCKS
     */
    public static void blockPlacementOnTopOfBlocks(Item item) {
        DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement());
        if (!DispenserUtils.isPlaceable(item.asItem())) {
            DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
        }
    }

    public static void blockPlacementOnTopOfBlocks(Collection<Item> items) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement());
            if (!DispenserUtils.isPlaceable(item.asItem())) {
                DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
            }
        }
    }

    public static void blockPlacementOnTopOfBlocks(Item item, Block block) {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(block);
        DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement(blocks, null));
        if (!DispenserUtils.isPlaceable(item.asItem())) {
            DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
        }
    }

    public static void blockPlacementOnTopOfBlocks(Item item, Collection<Block> blocks) {
        DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement(blocks, null));
        if (!DispenserUtils.isPlaceable(item.asItem())) {
            DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
        }
    }

    public static void blockPlacementOnTopOfBlocks(Collection<Item> items, Block block) {
        for (Item item : items) {
            ArrayList<Block> blocks = new ArrayList<>();
            blocks.add(block);
            DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement(blocks, null));
            if (!DispenserUtils.isPlaceable(item.asItem())) {
                DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
            }
        }
    }

    public static void blockPlacementOnTopOfBlocks(Collection<Item> items, Collection<Block> blocks) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement(blocks, null));
            if (!DispenserUtils.isPlaceable(item.asItem())) {
                DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
            }
        }
    }

    public static void blockPlacementOnTopOfBlocksWithTags(Item item, TagKey<Block> tag) {
        ArrayList<TagKey<Block>> tags = new ArrayList<>();
        tags.add(tag);
        DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement(null, tags));
        if (!DispenserUtils.isPlaceable(item.asItem())) {
            DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
        }
    }

    public static void blockPlacementOnTopOfBlocksWithTags(Item item, Collection<TagKey<Block>> tags) {
        DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement(null, tags));
        if (!DispenserUtils.isPlaceable(item.asItem())) {
            DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
        }
    }

    public static void blockPlacementOnTopOfBlocksWithTags(Collection<Item> items, TagKey<Block> tag) {
        ArrayList<TagKey<Block>> tags = new ArrayList<>();
        tags.add(tag);
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement(null, tags));
            if (!DispenserUtils.isPlaceable(item.asItem())) {
                DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
            }
        }
    }

    public static void blockPlacementOnTopOfBlocksWithTags(Collection<Item> items, Collection<TagKey<Block>> tags) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement(null, tags));
            if (!DispenserUtils.isPlaceable(item.asItem())) {
                DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
            }
        }
    }

    public static void blockPlacementOnTopOfBlocksWithTags(Item item, Collection<Block> blocks, Collection<TagKey<Block>> tags) {
        DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement(blocks, tags));
        if (!DispenserUtils.isPlaceable(item.asItem())) {
            DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
        }
    }

    public static void blockPlacementOnTopOfBlocksWithTags(Collection<Item> items, Collection<Block> blocks, Collection<TagKey<Block>> tags) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement(blocks, tags));
            if (!DispenserUtils.isPlaceable(item.asItem())) {
                DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
            }
        }
    }

    /*
     * BLOCK INTERACTIONS
     */
    public static void useItemOnBlocks(Item item) {
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable()));
    }

    public static void useItemOnBlocks(Collection<Item> items) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable()));
        }
    }

    public static void useItemOnBlocks(Item item, boolean useDurability) {
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability));
    }

    public static void useItemOnBlocks(Collection<Item> items, boolean useDurability) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability));
        }
    }

    public static void useItemOnBlocks(Item item, Block block) {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(block);
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable(), blocks, null));
    }

    public static void useItemOnBlocks(Collection<Item> items, Block block) {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(block);
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable(), blocks, null));
        }
    }

    public static void useItemOnBlocks(Item item, Block block, boolean useDurability) {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(block);
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, blocks, null));
    }

    public static void useItemOnBlocks(Collection<Item> items, Block block, boolean useDurability) {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(block);
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, blocks, null));
        }
    }

    public static void useItemOnBlocks(Item item, Collection<Block> blocks) {
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable(), blocks, null));
    }

    public static void useItemOnBlocks(Collection<Item> items, Collection<Block> blocks) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable(), blocks, null));
        }
    }

    public static void useItemOnBlocks(Item item, Collection<Block> blocks, boolean useDurability) {
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, blocks, null));
    }

    /**
     *
     * With both tags and blocks, the intended functionality is that if the block falls in either category,
     * then the item is used.
     *
     * @param items
     * @param blocks
     * @param useDurability
     */
    public static void useItemOnBlocks(Collection<Item> items, Collection<Block> blocks, boolean useDurability) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, blocks, null));
        }
    }

    public static void useItemOnBlocksWithTags(Item item, TagKey<Block> tag) {
        ArrayList<TagKey<Block>> tags = new ArrayList<>();
        tags.add(tag);
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable(), null, tags));
    }

    public static void useItemOnBlocksWithTags(Collection<Item> items, TagKey<Block> tag) {
        for (Item item : items) {
            ArrayList<TagKey<Block>> tags = new ArrayList<>();
            tags.add(tag);
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable(), null, tags));
        }
    }

    public static void useItemOnBlocksWithTags(Item item, Collection<TagKey<Block>> tags) {
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable(), null, tags));
    }

    public static void useItemOnBlocksWithTags(Collection<Item> items, Collection<TagKey<Block>> tags) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable(), null, tags));
        }
    }

    public static void useItemOnBlocksWithTags(Item item, TagKey<Block> tag, boolean useDurability) {
        ArrayList<TagKey<Block>> tags = new ArrayList<>();
        tags.add(tag);
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, null, tags));
    }

    public static void useItemOnBlocksWithTags(Collection<Item> items, TagKey<Block> tag, boolean useDurability) {
        for (Item item : items) {
            ArrayList<TagKey<Block>> tags = new ArrayList<>();
            tags.add(tag);
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, null, tags));
        }
    }

    public static void useItemOnBlocksWithTags(Item item, Collection<TagKey<Block>> tags, boolean useDurability) {
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, null, tags));
    }

    public static void useItemOnBlocksWithTags(Collection<Item> items, Collection<TagKey<Block>> tags, boolean useDurability) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, null, tags));
        }
    }

    public static void useItemOnBlocksWithTags(Item item, Collection<TagKey<Block>> tags, Collection<Block> blocks, boolean useDurability) {
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, blocks, tags));
    }

    public static void useItemOnBlocksWithTags(Collection<Item> items, Collection<TagKey<Block>> tags, Collection<Block> blocks, boolean useDurability) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, blocks, tags));
        }
    }

    /*
     * USING CUSTOM DISPENSE FUNCTION
     * !!! UNTESTED !!!
     */
    public static void useDispense(Item item) {
        DispenserBlock.registerBehavior(item.asItem(), new UseDispenseableItem());
    }

    public static void useDispense(Collection<Item> items) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new UseDispenseableItem());
        }
    }
}
