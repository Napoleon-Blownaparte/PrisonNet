package com.prison.net.backend.files;

import com.prison.net.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ConfigFile {

    private static Plugin plugin = Main.getPlugin(Main.class);

    public static FileConfiguration get(){
        File file = new File(plugin.getDataFolder(), "config.yml");
        FileConfiguration yml = YamlConfiguration.loadConfiguration(file);
        return yml;
    }

    public static void save(){

        File file = new File(plugin.getDataFolder(), "config.yml");
        FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

        // Check if file exists
        if (!file.exists()){

            // Create new file
            try {
                file.createNewFile();
                System.out.println("PrisonNet | Created file 'config.yml'.");
            } catch (IOException e) {
                System.out.println("PrisonNet | [ERROR] Failed to create new file 'config.yml', please report this error to the developer via Discord.");
                e.printStackTrace();
            }

            // Set values
            yml.set("config.prefix", "&b&lPrison&3&lNet &8|");
            yml.set("config.resources.use-resource-pack", false);
            yml.set("config.resources.mandatory", false);
            yml.set("config.resources.exempt", "prisonnet.resources.exempt");
            yml.set("config.resources.url", "");
            yml.set("config.resources.kickreason", "&cYou &nmust&c download the resource pack to play on this server!");

            // --------------------------------------- SQL CREDS ----------------------------------------
            yml.set("config.database.enabled", false);
            yml.set("config.database.host", "");
            yml.set("config.database.port", 3306);
            yml.set("config.database.username", "");
            yml.set("config.database.password", "");
            yml.set("config.database.database", "");

            // ----------------------------------------- EVENTS -----------------------------------------

            // First Join Event
            // Join Event
            yml.set("config.events.firstJoinEvent.message.enabled", true);
            yml.set("config.events.firstJoinEvent.message.contents", Arrays.asList("&b&lPrison&3&lNet &8| &aPLAYER &7joined the server!"));
            yml.set("config.events.firstJoinEvent.message.tooltip", "&7Click to view this player's profile!");
            yml.set("config.events.firstJoinEvent.message.action", "RUN_COMMAND");
            yml.set("config.events.firstJoinEvent.message.output", "/profile PLAYER");

            yml.set("config.events.firstJoinEvent.subject.sound.enabled", true);
            yml.set("config.events.firstJoinEvent.subject.sound.type", "BLOCK_BEACON_ACTIVATE");
            yml.set("config.events.firstJoinEvent.subject.sound.volume", 1);
            yml.set("config.events.firstJoinEvent.subject.sound.pitch", 1);

            yml.set("config.events.firstJoinEvent.subject.actionbar.enabled", true);
            yml.set("config.events.firstJoinEvent.subject.actionbar.content", "&8[&a+&8] &aPLAYER &7joined the server!");

            yml.set("config.events.firstJoinEvent.subject.title.enabled", true);
            yml.set("config.events.firstJoinEvent.subject.title.1", "&b&lPrison&3&lNet");
            yml.set("config.events.firstJoinEvent.subject.title.2", "&aPLAYER &7joined the server!");

            yml.set("config.events.firstJoinEvent.subject.particles.enabled", true);
            yml.set("config.events.firstJoinEvent.subject.particles.types", Arrays.asList("PORTAL"));
            yml.set("config.events.firstJoinEvent.subject.particles.amount", 200);

            yml.set("config.events.firstJoinEvent.subject.lightning.enabled", false);
            yml.set("config.events.firstJoinEvent.subject.lightning.amount", 10);

            yml.set("config.events.firstJoinEvent.general.sound.enabled", true);
            yml.set("config.events.firstJoinEvent.general.sound.type", "BLOCK_BEACON_ACTIVATE");
            yml.set("config.events.firstJoinEvent.general.sound.volume", 1);
            yml.set("config.events.firstJoinEvent.general.sound.pitch", 1);

            yml.set("config.events.firstJoinEvent.general.actionbar.enabled", true);
            yml.set("config.events.firstJoinEvent.general.actionbar.content", "&7Welcome &aPLAYER&7 to the server&7!");

            yml.set("config.events.firstJoinEvent.general.title.enabled", true);
            yml.set("config.events.firstJoinEvent.general.title.1", "&b&lPrison&3&lNet");
            yml.set("config.events.firstJoinEvent.general.title.2", "&aPLAYER &7joined the server!");

            yml.set("config.events.firstJoinEvent.general.particles.enabled", false);
            yml.set("config.events.firstJoinEvent.general.particles.types", Arrays.asList("PORTAL"));
            yml.set("config.events.firstJoinEvent.general.particles.amount", 200);

            yml.set("config.events.firstJoinEvent.general.lightning.enabled", false);
            yml.set("config.events.firstJoinEvent.general.lightning.amount", 10);


            // Join Event
            yml.set("config.events.joinEvent.message.enabled", true);
            yml.set("config.events.joinEvent.message.contents", Arrays.asList("&b&lPrison&3&lNet &8| &aPLAYER &7joined the server!"));
            yml.set("config.events.joinEvent.message.tooltip", "&7Click to view this player's profile!");
            yml.set("config.events.joinEvent.message.action", "RUN_COMMAND");
            yml.set("config.events.joinEvent.message.output", "/profile PLAYER");

            yml.set("config.events.joinEvent.subject.sound.enabled", true);
            yml.set("config.events.joinEvent.subject.sound.type", "BLOCK_BEACON_ACTIVATE");
            yml.set("config.events.joinEvent.subject.sound.volume", 1);
            yml.set("config.events.joinEvent.subject.sound.pitch", 1);

            yml.set("config.events.joinEvent.subject.actionbar.enabled", true);
            yml.set("config.events.joinEvent.subject.actionbar.content", "&8[&a+&8] &aPLAYER &7joined the server!");

            yml.set("config.events.joinEvent.subject.title.enabled", true);
            yml.set("config.events.joinEvent.subject.title.1", "&b&lPrison&3&lNet");
            yml.set("config.events.joinEvent.subject.title.2", "&aPLAYER &7joined the server!");

            yml.set("config.events.joinEvent.subject.particles.enabled", true);
            yml.set("config.events.joinEvent.subject.particles.types", Arrays.asList("PORTAL"));
            yml.set("config.events.joinEvent.subject.particles.amount", 200);

            yml.set("config.events.joinEvent.subject.lightning.enabled", false);
            yml.set("config.events.joinEvent.subject.lightning.amount", 10);

            yml.set("config.events.joinEvent.general.sound.enabled", true);
            yml.set("config.events.joinEvent.general.sound.type", "BLOCK_BEACON_ACTIVATE");
            yml.set("config.events.joinEvent.general.sound.volume", 1);
            yml.set("config.events.joinEvent.general.sound.pitch", 1);

            yml.set("config.events.joinEvent.general.actionbar.enabled", true);
            yml.set("config.events.joinEvent.general.actionbar.content", "&7Welcome &aPLAYER&7 to the server&7!");

            yml.set("config.events.joinEvent.general.title.enabled", true);
            yml.set("config.events.joinEvent.general.title.1", "&b&lPrison&3&lNet");
            yml.set("config.events.joinEvent.general.title.2", "&aPLAYER &7joined the server!");

            yml.set("config.events.joinEvent.general.particles.enabled", false);
            yml.set("config.events.joinEvent.general.particles.types", Arrays.asList("PORTAL"));
            yml.set("config.events.joinEvent.general.particles.amount", 200);

            yml.set("config.events.joinEvent.general.lightning.enabled", false);
            yml.set("config.events.joinEvent.general.lightning.amount", 10);

            // Leave Event
            yml.set("config.events.leaveEvent.message.enabled", true);
            yml.set("config.events.leaveEvent.message.contents", Arrays.asList("&b&lPrison&3&lNet &8| &aPLAYER &7joined the server!"));
            yml.set("config.events.leaveEvent.message.tooltip", "&7Click to view this player's profile!");
            yml.set("config.events.leaveEvent.message.action", "RUN_COMMAND");
            yml.set("config.events.leaveEvent.message.output", "/profile PLAYER");

            yml.set("config.events.leaveEvent.general.sound.enabled", true);
            yml.set("config.events.leaveEvent.general.sound.type", "BLOCK_BEACON_ACTIVATE");
            yml.set("config.events.leaveEvent.general.sound.volume", 1);
            yml.set("config.events.leaveEvent.general.sound.pitch", 1);

            yml.set("config.events.leaveEvent.general.actionbar.enabled", true);
            yml.set("config.events.leaveEvent.general.actionbar.content", "&7Goodbye, &aPLAYER&7!");

            yml.set("config.events.leaveEvent.general.title.enabled", true);
            yml.set("config.events.leaveEvent.general.title.1", "&b&lPrison&3&lNet");
            yml.set("config.events.leaveEvent.general.title.2", "&7Goodbye, &aPLAYER&!");

            yml.set("config.events.leaveEvent.general.particles.enabled", false);
            yml.set("config.events.leaveEvent.general.particles.types", Arrays.asList("PORTAL"));
            yml.set("config.events.leaveEvent.general.particles.amount", 200);

            // Death
            yml.set("config.events.playerDeath.message.enabled", false);
            yml.set("config.events.playerDeath.message.contents", Arrays.asList("&b&lPrison&3&lNet &8| &aVICTIM &7was slaughtered by &aKILLER!"));
            yml.set("config.events.playerDeath.message.tooltip", "&7Click to view their profile!");
            yml.set("config.events.playerDeath.message.action", "RUN_COMMAND");
            yml.set("config.events.playerDeath.message.output", "/profile VICTIM");

            yml.set("config.events.playerDeath.victim.lightning.enabled", true);
            yml.set("config.events.playerDeath.victim.lightning.amount", 10);

            yml.set("config.events.playerDeath.victim.particles.enabled", false);
            yml.set("config.events.playerDeath.victim.particles.types", Arrays.asList("REDSTONE"));
            yml.set("config.events.playerDeath.victim.particles.amount", 200);

            yml.set("config.events.playerDeath.victim.actionbar.enabled", true);
            yml.set("config.events.playerDeath.victim.actionbar.content", "&7You were slain by &aKILLER&!");

            yml.set("config.events.playerDeath.victim.title.enabled", true);
            yml.set("config.events.playerDeath.victim.title.1", "&b&lPrison&3&lNet");
            yml.set("config.events.playerDeath.victim.title.2", "&7You were slain by &aKILLER&!");

            yml.set("config.events.playerDeath.killer.lightning.enabled", false);
            yml.set("config.events.playerDeath.killer.lightning.amount", 10);

            yml.set("config.events.playerDeath.killer.particles.enabled", false);
            yml.set("config.events.playerDeath.killer.particles.types", Arrays.asList("CRIT"));
            yml.set("config.events.playerDeath.killer.particles.amount", 200);

            yml.set("config.events.playerDeath.killer.actionbar.enabled", true);
            yml.set("config.events.playerDeath.killer.actionbar.content", "&7You slaughtered &aVICTIM&7!");

            yml.set("config.events.playerDeath.killer.title.enabled", true);
            yml.set("config.events.playerDeath.killer.title.1", "&b&lPrison&3&lNet");
            yml.set("config.events.playerDeath.killer.title.2", "&7You slaughtered &aVICTIM&7!");


            // Save file
            try {
                yml.save(file);
                System.out.println(" PrisonNet | Saved file 'config.yml'.");
            } catch (IOException e) {
                System.out.println(" PrisonNet | [ERROR] Failed to save file 'config.yml', please report this error to the developer via Discord.");
                e.printStackTrace();
            }

        }

    }

}
