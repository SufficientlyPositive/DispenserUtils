package mods.SufficientlyPositive.DispenserUtils;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// TODO: see how much lag is caused by 1000 dispensers or doing this or something

// Mod provides several new DispenserBehaviours that grant generalised access to items' useOnBlock
// by the mod to simulate player interaction but with dispensers instead
// Provides support for automatic placement of blocks and crops
// Also provides support for hooking your own item's custom behaviour when used by a dispensed
// Allows generalised support for tags on blocks that the dispenser is interacting with (not the item it's using though!)

// what if using tags and blocks are sent to registries after? Maybe a dispenser mixin that includes a tag map that initialises once?
// what about a function that adds all of an item type to this? Like all axes?
// instead might be best to have some form of config that allows that behaviour on the dispenser side of things? maybe some form of mixin?
public class DispenserUtils implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger("DispenserUtils");

    public static final String MOD_ID = "dispenser-utils";
    public static final String MOD_NAME = "Dispenser Utils";


    @Override
    public void onInitialize() {
       logInfo("Mod Initialised");
       Examples.init();
    }

    // -------------------------------
    //        HELPER FUNCTIONS
    // -------------------------------

    /**
     * Shorthand check for whether the item is a BlockItem or not for readability purposes.
     *
     * @param item the item to check.
     * @return whether the item is an instance of BlockItem or not.
     */
    protected static boolean isPlaceable(Item item) {
        return item instanceof BlockItem;
    }

    /**
     * Log using the mod's logger at a specific level.
     *
     * @param level the specified level to show logging messages at.
     * @param message the message to display, after running it through an identifier for the mod first.
     */
    protected static void log(Level level, String message) {
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

    /**
     * Log a message using the mod's logger at INFO level.
     * @param message message to log.
     */
    protected static void logInfo(String message) {
        log(Level.INFO, message);
    }

    /**
     * Log a message using the mod's logger at DEBUG level.
     * @param message message to log.
     */
    protected static void logDebug(String message) {
        log(Level.DEBUG, message);
    }

}