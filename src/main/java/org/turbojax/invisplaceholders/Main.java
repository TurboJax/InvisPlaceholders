package org.turbojax.invisplaceholders;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public void onEnable() {
        new Placeholders(this).register();
        getLogger().info("Loaded InvisPlaceholders");
    }
}
