package com.prison.net.frontend.events;

import com.prison.net.Main;
import com.prison.net.backend.api.Messages;
import com.prison.net.backend.files.PlayerFile;
import com.prison.net.frontend.illegalitems.ItemAuth;
import com.prison.net.frontend.modules.joinmessage.JoinMessages;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.List;

public class PlayerJoin implements Listener {

    private static Plugin plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        File file = new File(plugin.getDataFolder(), "config.yml");
        FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

        Player player = event.getPlayer();

        // Check if messages are enabled
        if (yml.getBoolean("config.events.joinEvent.message.enabled") == true){

            List<String> msg = yml.getStringList("config.events.joinEvent.message.contents");
            for (int a = 0;a<msg.size();a++){
                Messages.sendJSON(player, msg.get(a).replaceAll("PLAYER", player.getDisplayName()), ClickEvent.Action.valueOf(yml.getString("config.events.joinEvent.message.action")),
                        yml.getString("config.events.joinEvent.message.output").replaceAll("PLAYER", player.getDisplayName()),
                        yml.getString("config.events.joinEvent.message.tooltip").replaceAll("PLAYER", player.getDisplayName()));
            }
        }

        // SUBJECT

        // Check if sounds are enabled
        if (yml.getBoolean("config.events.joinEvent.subject.sound.enabled") == true){
            player.playSound(player.getLocation(), Sound.valueOf(yml.getString("config.events.joinEvent.subject.sound.type")),
                    yml.getInt("config.events.joinEvent.subject.sound.volume"), yml.getInt("config.events.joinEvent.subject.sound.pitch"));
        }

        // Check if actionbar is enabled
        if (yml.getBoolean("config.events.joinEvent.subject.actionbar.enabled") == true){
            Messages.sendActionbar(player, yml.getString("config.events.joinEvent.subject.actionbar.content").replaceAll("PLAYER", player.getDisplayName()));
        }

        // Check if title is enabled
        if (yml.getBoolean("config.events.joinEvent.subject.title.enabled") == true){
            Messages.sendTitle(player, yml.getString("config.events.joinEvent.subject.title.1").replaceAll("PLAYER", player.getDisplayName())
                    , yml.getString("config.events.joinEvent.subject.title.2").replaceAll("PLAYER", player.getDisplayName()),
                    2, 2, 15);
        }

        // Check if particles are enabled
        if (yml.getBoolean("config.events.joinEvent.subject.particles.enabled") == true){
            List<String> types = yml.getStringList("config.events.joinEvent.subject.particles.type");
            for (int b = 0;b<types.size();b++) {
                player.getWorld().spawnParticle(Particle.valueOf(types.get(b)), player.getLocation(), yml.getInt("config.events.joinEvent.subject.particles.amount"));
            }
        }

        // Check if lightning is enabled
        if (yml.getBoolean("config.events.joinEvent.subject.lightning.enabled") == true){
            for (int b = 0;b<yml.getInt("config.events.joinEvent.subject.lightning.amount");b++) {
                player.getWorld().strikeLightningEffect(player.getLocation());
            }
        }

        // GENERAL

        for (Player general : Bukkit.getOnlinePlayers()){
            if (general != player){

                // Check if sounds are enabled
                if (yml.getBoolean("config.events.joinEvent.general.sound.enabled") == true){
                    general.playSound(general.getLocation(), Sound.valueOf(yml.getString("config.events.joinEvent.general.sound.type")),
                            yml.getInt("config.events.joinEvent.general.sound.volume"), yml.getInt("config.events.joinEvent.general.sound.pitch"));
                }

                // Check if actionbar is enabled
                if (yml.getBoolean("config.events.joinEvent.general.actionbar.enabled") == true){
                    Messages.sendActionbar(general, yml.getString("config.events.joinEvent.general.actionbar.content").replaceAll("PLAYER", player.getDisplayName()));
                }

                // Check if title is enabled
                if (yml.getBoolean("config.events.joinEvent.general.title.enabled") == true){
                    Messages.sendTitle(general, yml.getString("config.events.joinEvent.general.title.1").replaceAll("PLAYER", player.getDisplayName()),
                            yml.getString("config.events.joinEvent.general.title.2").replaceAll("PLAYER", player.getDisplayName()),
                            2, 2, 15);
                }

                // Check if particles are enabled
                if (yml.getBoolean("config.events.joinEvent.general.particles.enabled") == true){
                    List<String> types = yml.getStringList("config.events.joinEvent.general.particles.type");
                    for (int b = 0;b<types.size();b++) {
                        general.getWorld().spawnParticle(Particle.valueOf(types.get(b)), player.getLocation(), yml.getInt("config.events.joinEvent.general.particles.amount"));
                    }
                }

                // Check if lightning is enabled
                if (yml.getBoolean("config.events.joinEvent.general.lightning.enabled") == true){
                    for (int b = 0;b<yml.getInt("config.events.joinEvent.general.lightning.amount");b++) {
                        general.getWorld().strikeLightningEffect(player.getLocation());
                    }
                }

            }
        }

    }



}
