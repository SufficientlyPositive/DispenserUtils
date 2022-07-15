package mods.SufficientlyPositive.DispenserUtils;

import mods.SufficientlyPositive.DispenserUtils.DispenserBehaviours.BlockAboveBlockPlacement;
import mods.SufficientlyPositive.DispenserUtils.DispenserBehaviours.ItemBlockInteraction;
import mods.SufficientlyPositive.DispenserUtils.DispenserBehaviours.BlockPlacement;
import mods.SufficientlyPositive.DispenserUtils.DispenserBehaviours.UseDispensableItem;
import net.minecraft.block.Block;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Functions for adding behaviours to specific Minecraft items.
 * NOTE: items can only be tied to one behaviour, further added behaviours on the same item will override previously added behaviours.
 */
public class BehaviourFunctions {

    /*
     * BLOCK PLACEMENT
     */
    /**
     * Allows dispenser to use the item to place a block using Minecraft's AutomaticItemPlacementContext().
     * @param item the item to add placement behaviour for.
     */
    public static void blockPlacement(Item item) {
        DispenserBlock.registerBehavior(item.asItem(), new BlockPlacement());
        if (!DispenserUtils.isPlaceable(item.asItem())) {
            DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
        }
    }

    /**
     * Allows dispenser to use the items to place a block using Minecraft's AutomaticItemPlacementContext().
     * @param items the collection of items to add placement behaviour for.
     */
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
    /**
     * Allows dispenser to use the item to place a block as long as it is above another (non-air) block using Minecraft's AutomaticItemPlacementContext().
     * @param item the item to add placement behaviour for.
     */
    public static void blockPlacementOnTopOfBlocks(Item item) {
        DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement());
        if (!DispenserUtils.isPlaceable(item.asItem())) {
            DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
        }
    }

    /**
     * Allows dispenser to use the items to place a block as long as it is above another (non-air) block using Minecraft's AutomaticItemPlacementContext().
     * @param items the collection of items to add placement behaviour for.
     */
    public static void blockPlacementOnTopOfBlocks(Collection<Item> items) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement());
            if (!DispenserUtils.isPlaceable(item.asItem())) {
                DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
            }
        }
    }

    /**
     * Allows dispenser to use the item to place a block as long as it is above the specified block using Minecraft's AutomaticItemPlacementContext().
     * @param item the item to add placement behaviour for.
     * @param block restricts attempted placement of item to this block.
     */
    public static void blockPlacementOnTopOfBlocks(Item item, Block block) {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(block);
        DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement(blocks, null));
        if (!DispenserUtils.isPlaceable(item.asItem())) {
            DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
        }
    }

    /**
     * Allows dispenser to use the item to place a block as long as it is above the specified blocks using Minecraft's AutomaticItemPlacementContext().
     * @param item the item to add placement behaviour for.
     * @param blocks restricts attempted placement of item to any blocks within this collection of blocks.
     */
    public static void blockPlacementOnTopOfBlocks(Item item, Collection<Block> blocks) {
        DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement(blocks, null));
        if (!DispenserUtils.isPlaceable(item.asItem())) {
            DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
        }
    }

    /**
     * Allows dispenser to use the items to place a block as long as it is above the specified block using Minecraft's AutomaticItemPlacementContext().
     * @param items the collection of items to add placement behaviour for.
     * @param block restricts attempted placement of item to this block.
     */
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

    /**
     * Allows dispenser to use the items to place a block as long as it is above the specified blocks using Minecraft's AutomaticItemPlacementContext().
     * @param items the collection of items to add placement behaviour for.
     * @param blocks restricts attempted placement of item to any blocks within this collection of blocks.
     */
    public static void blockPlacementOnTopOfBlocks(Collection<Item> items, Collection<Block> blocks) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement(blocks, null));
            if (!DispenserUtils.isPlaceable(item.asItem())) {
                DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
            }
        }
    }

    /**
     * Allows dispenser to use the item to place a block as long as it is above a block with the specified tags using Minecraft's AutomaticItemPlacementContext().
     * @param item the item to add placement behaviour for.
     * @param tag restricts attempted placement of item to any blocks with this tag.
     */
    public static void blockPlacementOnTopOfBlocksWithTags(Item item, TagKey<Block> tag) {
        ArrayList<TagKey<Block>> tags = new ArrayList<>();
        tags.add(tag);
        DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement(null, tags));
        if (!DispenserUtils.isPlaceable(item.asItem())) {
            DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
        }
    }

    /**
     * Allows dispenser to use the item to place a block as long as it is above a block with any of the specified tags using Minecraft's AutomaticItemPlacementContext().
     * @param item the item to add placement behaviour for.
     * @param tags restricts attempted placement of item to any blocks with a tag within this collection of tags.
     */
    public static void blockPlacementOnTopOfBlocksWithTags(Item item, Collection<TagKey<Block>> tags) {
        DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement(null, tags));
        if (!DispenserUtils.isPlaceable(item.asItem())) {
            DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
        }
    }

    /**
     * Allows dispenser to use the items to place a block as long as it is above a block with the specified tags using Minecraft's AutomaticItemPlacementContext().
     * @param items the collection of items to add placement behaviour for.
     * @param tag restricts attempted placement of item to any blocks with this tag.
     */
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

    /**
     * Allows dispenser to use the items to place a block as long as it is above a block with any of the specified tags using Minecraft's AutomaticItemPlacementContext().
     * @param items the collection of items to add placement behaviour for.
     * @param tags restricts attempted placement of item to any blocks with a tag within this collection of tags.
     */
    public static void blockPlacementOnTopOfBlocksWithTags(Collection<Item> items, Collection<TagKey<Block>> tags) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement(null, tags));
            if (!DispenserUtils.isPlaceable(item.asItem())) {
                DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
            }
        }
    }

    /**
     * Allows dispenser to use the item to place a block as long as it is above any of the specified blocks, or above a
     * block with any of the specified tags using Minecraft's AutomaticItemPlacementContext().
     * @param item the item to add placement behaviour for.
     * @param blocks restricts attempted placement of item to any blocks within this collection of blocks (or if the block has any of the tags specified in the next argument).
     * @param tags restricts attempted placement of item to any blocks with a tag within this collection of tags (or if the block is within the collection specified in the previous argument).
     */
    public static void blockPlacementOnTopOfBlocksWithTags(Item item, Collection<Block> blocks, Collection<TagKey<Block>> tags) {
        DispenserBlock.registerBehavior(item.asItem(), new BlockAboveBlockPlacement(blocks, tags));
        if (!DispenserUtils.isPlaceable(item.asItem())) {
            DispenserUtils.LOGGER.error("Item {} is not an instance of BlockItem and will likely not function as expected! Try useItemOnBlocks() instead?", item.asItem());
        }
    }

    /**
     * Allows dispenser to use the items to place a block as long as it is above any of the specified blocks, or above a
     * block with any of the specified tags using Minecraft's AutomaticItemPlacementContext().
     * @param items the collection of items to add placement behaviour for.
     * @param blocks restricts attempted placement of item to any blocks within this collection of blocks (or if the block has any of the tags specified in the next argument).
     * @param tags restricts attempted placement of item to any blocks with a tag within this collection of tags (or if the block is within the collection specified in the previous argument).
     */
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
    /**
     * Allows dispenser to use the item on blocks using the item's own useOnBlock() function.
     * Durability usage is decided automatically by whether the item is damageable.
     * @param item the item the dispenser should attempt to use.
     */
    public static void useItemOnBlocks(Item item) {
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable()));
    }

    /**
     * Allows dispenser to use the items on blocks using the items' own useOnBlock() function.
     * Durability usage is decided automatically by whether the item is damageable.
     * @param items the items the dispenser should attempt to use.
     */
    public static void useItemOnBlocks(Collection<Item> items) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable()));
        }
    }

    /**
     * Allows dispenser to use the item on blocks using the item's own useOnBlock() function.
     * Durability usage is decided manually in this case, but will not be used if the item
     * cannot use durability.
     * @param item the item the dispenser should attempt to use.
     * @param useDurability whether the item should use durability.
     */
    public static void useItemOnBlocks(Item item, boolean useDurability) {
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability));
    }

    /**
     * Allows dispenser to use the items on blocks using the items' own useOnBlock() function.
     * Durability usage is decided manually in this case, but will not be used if the item
     * cannot use durability.
     * @param items the items the dispenser should attempt to use.
     * @param useDurability whether the item should use durability.
     */
    public static void useItemOnBlocks(Collection<Item> items, boolean useDurability) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability));
        }
    }

    /**
     * Allows dispenser to use the item on the specified block using the item's own useOnBlock() function.
     * Durability usage is decided automatically by whether the item is damageable.
     * @param item the item the dispenser should attempt to use.
     * @param block the specified block to use the item on.
     */
    public static void useItemOnBlocks(Item item, Block block) {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(block);
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable(), blocks, null));
    }

    /**
     * Allows dispenser to use the items on the specified block using the items' own useOnBlock() function.
     * Durability usage is decided automatically by whether the item is damageable.
     * @param items the items the dispenser should attempt to use.
     * @param block the specified block to use the item on.
     */
    public static void useItemOnBlocks(Collection<Item> items, Block block) {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(block);
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable(), blocks, null));
        }
    }

    /**
     * Allows dispenser to use the item on the specified block using the item's own useOnBlock() function.
     * Durability usage is decided manually in this case, but will not be used if the item
     * cannot use durability.
     * @param item the item the dispenser should attempt to use.
     * @param block the specified block to use the item on.
     * @param useDurability whether the item should use durability.
     */
    public static void useItemOnBlocks(Item item, Block block, boolean useDurability) {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(block);
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, blocks, null));
    }

    /**
     * Allows dispenser to use the items on the specified block using the items' own useOnBlock() function.
     * Durability usage is decided manually in this case, but will not be used if the item
     * cannot use durability.
     * @param items the items the dispenser should attempt to use.
     * @param block the specified block to use the item on.
     * @param useDurability whether the item should use durability.
     */
    public static void useItemOnBlocks(Collection<Item> items, Block block, boolean useDurability) {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(block);
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, blocks, null));
        }
    }

    /**
     * Allows dispenser to use the item on the specified blocks using the item's own useOnBlock() function.
     * Durability usage is decided automatically by whether the item is damageable.
     * @param item the item the dispenser should attempt to use.
     * @param blocks the specified blocks to use the item on.
     */
    public static void useItemOnBlocks(Item item, Collection<Block> blocks) {
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable(), blocks, null));
    }

    /**
     * Allows dispenser to use the items on the specified blocks using the items' own useOnBlock() function.
     * Durability usage is decided automatically by whether the item is damageable.
     * @param items the item the dispenser should attempt to use.
     * @param blocks the specified blocks to use the item on.
     */
    public static void useItemOnBlocks(Collection<Item> items, Collection<Block> blocks) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable(), blocks, null));
        }
    }

    /**
     * Allows dispenser to use the item on the specified blocks using the item's own useOnBlock() function.
     * Durability usage is decided manually in this case, but will not be used if the item
     * cannot use durability.
     * @param item the item the dispenser should attempt to use.
     * @param blocks the specified blocks to use the item on.
     * @param useDurability whether the item should use durability.
     */
    public static void useItemOnBlocks(Item item, Collection<Block> blocks, boolean useDurability) {
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, blocks, null));
    }

    /**
     * Allows dispenser to use the items on the specified blocks using the items' own useOnBlock() function.
     * Durability usage is decided manually in this case, but will not be used if the item
     * cannot use durability.
     * @param items the item the dispenser should attempt to use.
     * @param blocks the specified blocks to use the item on.
     * @param useDurability whether the item should use durability.
     */
    public static void useItemOnBlocks(Collection<Item> items, Collection<Block> blocks, boolean useDurability) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, blocks, null));
        }
    }

    /**
     * Allows dispenser to use the item on blocks with the specified tag using the item's own useOnBlock() function.
     * Durability usage is decided automatically by whether the item is damageable.
     * @param item the item the dispenser should attempt to use.
     * @param tag the specified tag to restrict blocks the item can be used on to.
     */
    public static void useItemOnBlocksWithTags(Item item, TagKey<Block> tag) {
        ArrayList<TagKey<Block>> tags = new ArrayList<>();
        tags.add(tag);
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable(), null, tags));
    }

    /**
     * Allows dispenser to use the items on blocks with the specified tag using the items' own useOnBlock() function.
     * Durability usage is decided automatically by whether the item is damageable.
     * @param items the items the dispenser should attempt to use.
     * @param tag the specified tag to restrict blocks the item can be used on to.
     */
    public static void useItemOnBlocksWithTags(Collection<Item> items, TagKey<Block> tag) {
        for (Item item : items) {
            ArrayList<TagKey<Block>> tags = new ArrayList<>();
            tags.add(tag);
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable(), null, tags));
        }
    }

    /**
     * Allows dispenser to use the item on blocks with a tag using the item's own useOnBlock() function.
     * Durability usage is decided automatically by whether the item is damageable.
     * @param item the item the dispenser should attempt to use.
     * @param tags the specified tags to restrict blocks the item can be used on to, a block simply needs to match
     *             one tag to be considered viable.
     */
    public static void useItemOnBlocksWithTags(Item item, Collection<TagKey<Block>> tags) {
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable(), null, tags));
    }

    /**
     * Allows dispenser to use the items on blocks with a tag using the items' own useOnBlock() function.
     * Durability usage is decided automatically by whether the item is damageable.
     * @param items the items the dispenser should attempt to use.
     * @param tags the specified tags to restrict blocks the item can be used on to, a block simply needs to match
     *             one tag to be considered viable.
     */
    public static void useItemOnBlocksWithTags(Collection<Item> items, Collection<TagKey<Block>> tags) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(item.isDamageable(), null, tags));
        }
    }

    /**
     * Allows dispenser to use the item on blocks with a tag using the item's own useOnBlock() function.
     * Durability usage is decided manually in this case, but will not be used if the item
     * cannot use durability.
     * @param item the item the dispenser should attempt to use.
     * @param tag the specified tag to restrict blocks the item can be used on to.
     * @param useDurability whether the item should use durability.
     */
    public static void useItemOnBlocksWithTags(Item item, TagKey<Block> tag, boolean useDurability) {
        ArrayList<TagKey<Block>> tags = new ArrayList<>();
        tags.add(tag);
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, null, tags));
    }

    /**
     * Allows dispenser to use the items on blocks with the specified tag using the items' own useOnBlock() function.
     * Durability usage is decided manually in this case, but will not be used if the item
     * cannot use durability.
     * @param items the items the dispenser should attempt to use.
     * @param tag the specified tag to restrict blocks the item can be used on to.
     * @param useDurability whether the item should use durability.
     */
    public static void useItemOnBlocksWithTags(Collection<Item> items, TagKey<Block> tag, boolean useDurability) {
        for (Item item : items) {
            ArrayList<TagKey<Block>> tags = new ArrayList<>();
            tags.add(tag);
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, null, tags));
        }
    }

    /**
     * Allows dispenser to use the item on blocks with a tag using the item's own useOnBlock() function.
     * Durability usage is decided manually in this case, but will not be used if the item
     * cannot use durability.
     * @param item the item the dispenser should attempt to use.
     * @param tags the specified tags to restrict blocks the item can be used on to, a block simply needs to match
     *             one tag to be considered viable.
     * @param useDurability whether the item should use durability.
     */
    public static void useItemOnBlocksWithTags(Item item, Collection<TagKey<Block>> tags, boolean useDurability) {
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, null, tags));
    }

    /**
     * Allows dispenser to use the items on blocks with a tag using the items' own useOnBlock() function.
     * Durability usage is decided manually in this case, but will not be used if the item cannot use durability.
     * @param items the items the dispenser should attempt to use.
     * @param tags the specified tags to restrict blocks the item can be used on to, a block simply needs to match
     *             one tag to be considered viable.
     * @param useDurability whether the item should use durability.
     */
    public static void useItemOnBlocksWithTags(Collection<Item> items, Collection<TagKey<Block>> tags, boolean useDurability) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, null, tags));
        }
    }

    /**
     * Allows dispenser to use the item on blocks either in the blocks whitelist or with a tag using the item's own useOnBlock() function.
     * Durability usage is decided manually in this case, but will not be used if the item cannot use durability.
     * @param item the item the dispenser should attempt to use.
     * @param tags the specified tags to restrict blocks the item can be used on to, a block simply needs to match
     *             one tag to be considered viable (or be in the set of blocks).
     * @param blocks the specified blocks to use the item on (or have one of the previous tags).
     * @param useDurability whether the item should use durability.
     */
    public static void useItemOnBlocksWithTags(Item item, Collection<TagKey<Block>> tags, Collection<Block> blocks, boolean useDurability) {
        DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, blocks, tags));
    }

    /**
     * Allows dispenser to use the items on blocks either in the blocks whitelist or with a tag using the items' own useOnBlock() function.
     * Durability usage is decided manually in this case, but will not be used if the item cannot use durability.
     * @param items the items the dispenser should attempt to use.
     * @param tags the specified tags to restrict blocks the item can be used on to, a block simply needs to match
     *             one tag to be considered viable (or be in the set of blocks).
     * @param blocks the specified blocks to use the item on (or have one of the previous tags).
     * @param useDurability whether the item should use durability.
     */
    public static void useItemOnBlocksWithTags(Collection<Item> items, Collection<TagKey<Block>> tags, Collection<Block> blocks, boolean useDurability) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new ItemBlockInteraction(useDurability, blocks, tags));
        }
    }

    /*
     * USING CUSTOM DISPENSE FUNCTION
     * !!! UNTESTED !!!
     */
    /**
     * Allows dispensers to access the item's dispense() function. Custom items intending
     * to use this feature should make sure to implement DispenseableItem.
     * @param item the item to add behaviour for.
     */
    public static void useDispense(Item item) {
        DispenserBlock.registerBehavior(item.asItem(), new UseDispensableItem());
    }

    /**
     * Allows dispensers to access the item's dispense() function. Custom items intending
     * to use this feature should make sure to implement DispenseableItem.
     * @param items the items to add behaviour for.
     */
    public static void useDispense(Collection<Item> items) {
        for (Item item : items) {
            DispenserBlock.registerBehavior(item.asItem(), new UseDispensableItem());
        }
    }
}
