package com.prison.net.backend;

import com.prison.net.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class PlayerData {

    private static Plugin plugin = Main.getPlugin(Main.class);

    public static void create(Player player){

        File file = new File(plugin.getDataFolder(), "config.yml");
        YamlConfiguration confYml = YamlConfiguration.loadConfiguration(file);

        // If databases aren't enabled
        if (confYml.getBoolean("config.database.enabled") == false) {
            File playerFile = new File(plugin.getDataFolder() + "/playerdata/" + player.getUniqueId().toString() + ".yml");
            YamlConfiguration yml = YamlConfiguration.loadConfiguration(playerFile);

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            yml.set("player.rank", "A");
            yml.set("player.prestige", 0);
            yml.set("player.title", "");
            yml.set("player.chat-colour", confYml.getString("config.chat.chatcolour"));
            yml.set("player.multipliers.block", 1.0f);
            yml.set("player.multipliers.sell", 1.0f);

            yml.set("player.blocksBroken.STONE", 0);
            yml.set("player.blocksBroken.COBBLESTONE", 0);
            yml.set("player.blocksBroken.DIAMOND_ORE", 0);
            yml.set("player.blocksBroken.DIAMOND_BLOCK", 0);
            yml.set("player.blocksBroken.EMERALD_ORE", 0);
            yml.set("player.blocksBroken.EMERALD_BLOCK", 0);
            yml.set("player.blocksBroken.IRON_ORE", 0);
            yml.set("player.blocksBroken.IRON_BLOCK", 0);
            yml.set("player.blocksBroken.GOLD_ORE", 0);
            yml.set("player.blocksBroken.GOLD_BLOCK", 0);
            yml.set("player.blocksBroken.COAL_ORE", 0);
            yml.set("player.blocksBroken.COAL_BLOCK", 0);
            yml.set("player.blocksBroken.END_STONE", 0);

            try {
                yml.save(file);
                System.out.println("PrisonNet | Successfully created playerdata file for user '" + player.getName() + "'.");
            } catch (IOException e) {
                System.out.println("PrisonNet | [ERROR] Failed to create new playerdata file, please report this error to the developer via Discord.");
                e.printStackTrace();
            }

        } else {

            // DATABASE CONNECTION CODE

        }
    }


}
