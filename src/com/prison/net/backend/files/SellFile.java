package com.prison.net.backend.files;

import com.prison.net.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class SellFile {

    private static Plugin plugin = Main.getPlugin(Main.class);

    public static void save(){

        File file = new File(plugin.getDataFolder(), "/sell.yml");
        FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

        if (file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            yml.set("prices.DIAMOND_BLOCK", 10);
            yml.set("prices.DIAMOND_ORE", 7.5);

            yml.set("prices.EMERALD_BLOCK", 15);
            yml.set("prices.EMERALD_ORE", 12.5);
        }

        try {
            yml.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static FileConfiguration get(){
        File file = new File(plugin.getDataFolder(), "/sell.yml");
        return YamlConfiguration.loadConfiguration(file);
    }

}
