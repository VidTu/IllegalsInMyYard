package ru.vidtu.illegalsinmyyard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

/**
 * IllegalsInMyYard logger holder class.
 *
 * @author VidTu
 */
public final class IIMY {
    static final Logger LOGGER = LogManager.getLogger("IllegalsInMyYard");
    private static final boolean SHUTUP = Boolean.getBoolean("illegalsinmyyard.shutup");
    private static final Set<String> ALREADY_JOINED = new HashSet<>(); // OMG, IP memory leak 😱

    private IIMY() {
        throw new AssertionError("No instances.");
    }

    /**
     * Logs the state of blocked server if hasn't been logged yet.
     *
     * @param blocked Is this server blocked?
     * @param object  Server address
     */
    public static void onServerCheck(boolean blocked, Object object, String source) {
        if (!blocked || SHUTUP) return;
        String server = String.valueOf(object);
        if (!ALREADY_JOINED.add(server)) return;
        LOGGER.warn("Bro is NOT reading terms and conditions! (IP: {}, source: {})", server, source);
    }
}
