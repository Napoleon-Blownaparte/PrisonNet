package com.prison.net.backend.files;

import com.prison.net.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class PickaxeFile {

    private static Plugin plugin = Main.getPlugin(Main.class);

    public static void createSkin(int id, String displayName, int customModelData) {

        // Create File
        File file = new File(plugin.getDataFolder(), "/pickaxes.yml");
        FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

        // Add values
        yml.set("pickaxes.1.material", "DIAMOND_PICKAXE");
        yml.set("pickaxes.1.displayName", "&bLevel &3I &7Pickaxe");
        yml.set("pickaxes.1.lore", Arrays.asList("&7This is a Tier One pickaxe,", "&7it comes with basic enchantments", " "));
        yml.set("pickaxes.1.customModelData", 1);
        yml.set("pickaxes.1.cost", 0);
        yml.set("pickaxes.1.luckyBlockMultiplier", 1);

        // Save file
        try {
            yml.save(file);
            System.out.println("[PrisonNet] Successfully saved pickaxes file.");
        } catch (IOException e) {
            System.out.println("[PrisonNet] Failed to save pickaxes file");
            e.printStackTrace();
        }
    }

    public static void save(){

        // Get File
        File file = new File(plugin.getDataFolder(), "/pickaxes.yml");
        FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

        // Save file
        try {
            yml.save(file);
            System.out.println("[PrisonNet] Successfully saved pickaxes file.");
        } catch (IOException e) {
            System.out.println("[PrisonNet] Failed to save pickaxes file");
            e.printStackTrace();
        }
    }

    public static FileConfiguration get(){

        // Get File
        File file = new File(plugin.getDataFolder(), "/pickaxes.yml");
        FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

        return yml;

    }

}
