package com.prison.net.frontend.events;

import com.prison.net.Main;
import com.prison.net.backend.PlayerData;
import com.prison.net.backend.api.Messages;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PlayerFirstJoin implements Listener {

    private static Plugin plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        File file = new File(plugin.getDataFolder(), "config.yml");
        File playerFile = new File(plugin.getDataFolder(), "playerdata/" + player.getUniqueId().toString() + ".yml");
        FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

        // Check if player has joined before
        if (!playerFile.exists()) {

            PlayerData.create(player);

            try {
                playerFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Check if messages are enabled
            if (yml.getBoolean("config.events.firstJoinEvent.message.enabled") == true) {

                List<String> msg = yml.getStringList("config.events.firstJoinEvent.message.contents");
                for (int a = 0; a < msg.size(); a++) {
                    Messages.sendJSON(player, msg.get(a).replaceAll("PLAYER", player.getDisplayName()), ClickEvent.Action.valueOf(yml.getString("config.events.firstJoinEvent.message.action")),
                            yml.getString("config.events.firstJoinEvent.message.output").replaceAll("PLAYER", player.getDisplayName()),
                            yml.getString("config.events.firstJoinEvent.message.tooltip").replaceAll("PLAYER", player.getDisplayName()));
                }
            }

            // SUBJECT

            // Check if sounds are enabled
            if (yml.getBoolean("config.events.firstJoinEvent.subject.sound.enabled") == true) {
                player.playSound(player.getLocation(), Sound.valueOf(yml.getString("config.events.firstJoinEvent.subject.sound.type")),
                        yml.getInt("config.events.firstJoinEvent.subject.sound.volume"), yml.getInt("config.events.firstJoinEvent.subject.sound.pitch"));
            }

            // Check if actionbar is enabled
            if (yml.getBoolean("config.events.firstJoinEvent.subject.actionbar.enabled") == true) {
                Messages.sendActionbar(player, yml.getString("config.events.firstJoinEvent.subject.actionbar.content").replaceAll("PLAYER", player.getDisplayName()));
            }

            // Check if title is enabled
            if (yml.getBoolean("config.events.firstJoinEvent.subject.title.enabled") == true) {
                Messages.sendTitle(player, yml.getString("config.events.firstJoinEvent.subject.title.1").replaceAll("PLAYER", player.getDisplayName())
                        , yml.getString("config.events.firstJoinEvent.subject.title.2").replaceAll("PLAYER", player.getDisplayName()),
                        2, 2, 15);
            }

            // Check if particles are enabled
            if (yml.getBoolean("config.events.firstJoinEvent.subject.particles.enabled") == true) {
                List<String> types = yml.getStringList("config.events.firstJoinEvent.subject.particles.type");
                for (int b = 0; b < types.size(); b++) {
                    player.getWorld().spawnParticle(Particle.valueOf(types.get(b)), player.getLocation(), yml.getInt("config.events.firstJoinEvent.subject.particles.amount"));
                }
            }

            // Check if lightning is enabled
            if (yml.getBoolean("config.events.firstJoinEvent.subject.lightning.enabled") == true) {
                for (int b = 0; b < yml.getInt("config.events.firstJoinEvent.subject.lightning.amount"); b++) {
                    player.getWorld().strikeLightningEffect(player.getLocation());
                }
            }

            // GENERAL

            for (Player general : Bukkit.getOnlinePlayers()) {
                if (general != player) {

                    // Check if sounds are enabled
                    if (yml.getBoolean("config.events.firstJoinEvent.general.sound.enabled") == true) {
                        general.playSound(general.getLocation(), Sound.valueOf(yml.getString("config.events.firstJoinEvent.general.sound.type")),
                                yml.getInt("config.events.firstJoinEvent.general.sound.volume"), yml.getInt("config.events.firstJoinEvent.general.sound.pitch"));
                    }

                    // Check if actionbar is enabled
                    if (yml.getBoolean("config.events.firstJoinEvent.general.actionbar.enabled") == true) {
                        Messages.sendActionbar(general, yml.getString("config.events.firstJoinEvent.general.actionbar.content").replaceAll("PLAYER", player.getDisplayName()));
                    }

                    // Check if title is enabled
                    if (yml.getBoolean("config.events.firstJoinEvent.general.title.enabled") == true) {
                        Messages.sendTitle(general, yml.getString("config.events.firstJoinEvent.general.title.1").replaceAll("PLAYER", player.getDisplayName()),
                                yml.getString("config.events.firstJoinEvent.general.title.2").replaceAll("PLAYER", player.getDisplayName()),
                                2, 2, 15);
                    }

                    // Check if particles are enabled
                    if (yml.getBoolean("config.events.firstJoinEvent.general.particles.enabled") == true) {
                        List<String> types = yml.getStringList("config.events.firstJoinEvent.general.particles.type");
                        for (int b = 0; b < types.size(); b++) {
                            general.getWorld().spawnParticle(Particle.valueOf(types.get(b)), player.getLocation(), yml.getInt("config.events.firstJoinEvent.general.particles.amount"));
                        }
                    }

                    // Check if lightning is enabled
                    if (yml.getBoolean("config.events.firstJoinEvent.general.lightning.enabled") == true) {
                        for (int b = 0; b < yml.getInt("config.events.firstJoinEvent.general.lightning.amount"); b++) {
                            general.getWorld().strikeLightningEffect(player.getLocation());
                        }
                    }

                }
            }
        }
    }



}
