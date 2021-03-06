/*
 * Copyright (c) 2022 the Block Art Online Project contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package ga.baoproject.theseed.abc;

import org.bukkit.plugin.Plugin;

/**
 * Reinventing the wheel.
 */
public class DebugLogger {

    private static Plugin pl;
    private static boolean enabled;


    public static void debug(String message) {
        pl.getSLF4JLogger().info("[DEBUG] " + message);
    }

    /**
     * Sets the plugin instance which is used to log the messages.
     *
     * @param plugin the plugin instance.
     */
    public static void setPluginInstance(Plugin plugin) {
        pl = plugin;
    }

    /**
     * Toggles the debug logger.
     *
     * @param e whether to turn on or off the logger.
     */
    public static void setEnabled(boolean e) {
        enabled = e;
    }

    /**
     * Turns on the debug logger.
     */
    public static void setEnabled() {
        enabled = false;
    }
}

