package com.prison.net.backend.files;

import com.prison.net.Main;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class SkinsFile {

    private static Plugin plugin = Main.getPlugin(Main.class);

    public static void createSkin(int id, String displayName, String permission, Material material, int customModelData) {

        // Create File
        File file = new File(plugin.getDataFolder(), "/skins.yml");
        FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

        // Add values
        yml.set("skins." + id + ".displayName", displayName);
        yml.set("skins." + id + ".customModelData", customModelData);
        yml.set("skins." + id + ".permission", permission);
        yml.set("skins." + id + ".material", material.toString());

        // Save file
        try {
            yml.save(file);
            System.out.println("[PrisonNet] Successfully saved skins file.");
        } catch (IOException e) {
            System.out.println("[PrisonNet] Failed to save skins file");
            e.printStackTrace();
        }
    }

    public static void save(){

        // Get File
        File file = new File(plugin.getDataFolder(), "/skins.yml");
        FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

        if (!file.exists()){
            try {
                file.createNewFile();
                yml.set("skins." + 1 + ".displayName", "&fEmerald Pickaxe");
                yml.set("skins." + 1 + ".customModelData", 1);
                yml.set("skins." + 1 + ".permission", "prisonnet.skins.emerald_pickaxe");
                yml.set("skins." + 1 + ".material", "DIAMOND_PICKAXE");
                yml.set("skins." + 1 + ".slot", 9);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Save file
        try {
            yml.save(file);
            System.out.println("[PrisonNet] Successfully saved skins file.");
        } catch (IOException e) {
            System.out.println("[PrisonNet] Failed to save skins file");
            e.printStackTrace();
        }
    }

    public static FileConfiguration get(){

        // Get File
        File file = new File(plugin.getDataFolder(), "/skins.yml");
        FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

        return yml;

    }

}
