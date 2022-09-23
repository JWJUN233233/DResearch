package me.ddggdd135;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.ddggdd135.Listeners.AllListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;

public final class DResearch extends JavaPlugin implements SlimefunAddon {
    public static FileConfiguration Config;
    public FileConfiguration GetConfig(String ConfigName){
        File tmp = new File(DResearch.getPlugin(DResearch.class).getDataFolder(),ConfigName + ".yml");
        if(!tmp.exists()){
            try {
                saveResource(ConfigName + ".yml", false);
            } finally {
                try {
                    tmp.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return YamlConfiguration.loadConfiguration(tmp);
    }
    public static FileConfiguration GetConfig(String ConfigName,String Folder){
        File tmp = new File(Folder,ConfigName + ".yml");
        if(!tmp.exists()){
            try {
                tmp.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return YamlConfiguration.loadConfiguration(tmp);
    }
    public static void SaveConfig(FileConfiguration configuration, String ConfigName,String Folder){
        try {
            configuration.save(new File(Folder,ConfigName + ".yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        Config = GetConfig("config");
        getServer().getPluginManager().registerEvents(new AllListener(),this);
        File file = new File(Config.getString("SaveFileFolder"));
        file.mkdir();
        Bukkit.getServer().getConsoleSender().sendMessage("[DResearch]" + "§e研究同步器已加载");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Nullable
    @Override
    public String getBugTrackerURL() {
        return null;
    }

    @Nonnull
    @Override
    public String getPluginVersion() {
        return "1.0";
    }

    @Nullable
    @Override
    public String getWikiURL() {
        return null;
    }
}
