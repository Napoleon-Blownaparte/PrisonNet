package com.prison.net.backend.files;

import com.prison.net.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class PlayerFile {

    private static Plugin plugin = Main.getPlugin(Main.class);

    public static void create(Player player) {

        // Create File
        File file = new File(plugin.getDataFolder(), "/playerdata/" + player.getUniqueId().toString() + ".yml");
        FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

        try {
            file.createNewFile();

            // Add values
            yml.set("profile.nickname", "");
            yml.set("profile.chatcolour", "");
            yml.set("profile.title", "");
            yml.set("profile.customJoinMessage", "");

            yml.set("cosmetics.joinMessage", 1);

            yml.set("balance.tokens", 0);
            yml.set("balance.shards", 0);
            yml.set("balance.engrams", 0);
            yml.set("balance.scrolls", 0);
            yml.set("balance.blocks-broken", 0);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Save file
        try {
            yml.save(file);
            System.out.println("[PrisonNet] Successfully saved player data file of " + player.getName() + " (" + player.getUniqueId().toString() + ").");
        } catch (IOException e) {
            System.out.println("[PrisonNet] Failed to save player data file of " + player.getName() + " (" + player.getUniqueId().toString() + ").");
            e.printStackTrace();
        }
    }

    public static void save(Player player){

        // Get File
        File file = new File(plugin.getDataFolder(), "/playerdata/" + player.getUniqueId().toString() + ".yml");
        FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

        // Save file
        try {
            yml.save(file);
            System.out.println("[PrisonNet] Successfully saved player data file of " + player.getName() + " (" + player.getUniqueId().toString() + ").");
        } catch (IOException e) {
            System.out.println("[PrisonNet] Failed to save player data file of " + player.getName() + " (" + player.getUniqueId().toString() + ").");
            e.printStackTrace();
        }
    }

    public static FileConfiguration get(Player player){

        // Get File
        File file = new File(plugin.getDataFolder(), "/playerdata/" + player.getUniqueId().toString() + ".yml");
        FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

        return yml;

    }

}
