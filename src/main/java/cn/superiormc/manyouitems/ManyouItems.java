package cn.superiormc.manyouitems;

import org.bukkit.plugin.java.JavaPlugin;

public final class ManyouItems extends JavaPlugin {

    public static ManyouItems instance;

    @Override
    public void onEnable() {
        instance = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
