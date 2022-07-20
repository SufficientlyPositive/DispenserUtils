package mods.SufficientlyPositive.DispenserUtils;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DispenserUtils implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger("DispenserUtils");

    public static final String MOD_ID = "dispenser-utils";
    public static final String MOD_NAME = "Dispenser Utils";

    @Override
    public void onInitialize() {
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