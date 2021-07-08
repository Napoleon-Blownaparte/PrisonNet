package com.prison.net.frontend.modules.joinmessage;

import com.prison.net.backend.api.Messages;
import com.prison.net.backend.files.PlayerFile;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessages implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();
        send(player, 5);
        PlayerFile.create(player);

    }

    /**
     * Broadcasts a server message without a permission.
     * @param player - The subject of the message
     * @param id - The ID of the join message
     */
    public static void send(Player player, Integer id){

        String message = null, output = null, tooltip = null;
        ClickEvent.Action action = null;
        Sound sound = null;
        Particle particle = null;

        // Select the message, tooltip, action and click-event, pertaining to the given ID.
        if (id == 1){

            for (Player players : Bukkit.getOnlinePlayers()){

                if (PlayerFile.get(players).getBoolean(players.getUniqueId().toString() + ".system-messages-enabled")){

                    Messages.sendJSON(players, "&8[&4&l+&8] &c" + player.getDisplayName() + " &ejoined the server!",
                            ClickEvent.Action.RUN_COMMAND, "/profile " + player.getName(), "&7Click to view this player's profile!"); // JSON
                    players.playSound(players.getLocation(), Sound.BLOCK_FURNACE_FIRE_CRACKLE, 1, 2); // SOUND
                    players.getWorld().spawnParticle(Particle.FLAME, players.getLocation(), 200);

                }
            }
        } else if (id == 2) {

            for (Player players : Bukkit.getOnlinePlayers()) {

                if (PlayerFile.get(players).getBoolean(players.getUniqueId().toString() + ".system-messages-enabled")) {

                    Messages.sendJSON(players, "&8[&d&l+&8] &5" + player.getDisplayName() + " &dhas joined the server!",
                            ClickEvent.Action.RUN_COMMAND, "/profile " + player.getName(), "&7Click to view this player's profile!"); // JSON
                    players.playSound(players.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 1, 2); // SOUND
                    players.getWorld().spawnParticle(Particle.PORTAL, players.getLocation(), 200);

                }
            }
        } else if (id == 3) {

            for (Player players : Bukkit.getOnlinePlayers()) {

                if (PlayerFile.get(players).getBoolean(players.getUniqueId().toString() + ".system-messages-enabled")) {

                    Messages.sendJSON(players, "&8[&f&l+&8] &7" + player.getDisplayName() + " &fhas joined the server!",
                            ClickEvent.Action.RUN_COMMAND, "/profile " + player.getName(), "&7Click to view this player's profile!"); // JSON
                    players.playSound(players.getLocation(), Sound.BLOCK_SMOKER_SMOKE, 1, 2); // SOUND
                    players.getWorld().spawnParticle(Particle.CLOUD, players.getLocation(), 200);

                }
            }
        } else if (id == 4) {

            for (Player players : Bukkit.getOnlinePlayers()) {

                if (PlayerFile.get(players).getBoolean(players.getUniqueId().toString() + ".system-messages-enabled")) {

                    Messages.sendJSON(players, "&8[&e&lCREATOR&8] &b" + player.getDisplayName() + " &bhas joined the server, click this message to check out their content!",
                            ClickEvent.Action.RUN_COMMAND, "/profile " + player.getName(), "&7Click to view this player's profile!"); // JSON
                    players.playSound(players.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 2); // SOUND
                    players.getWorld().spawnParticle(Particle.CRIT_MAGIC, players.getLocation(), 200);

                }
            }
        } else if (id == 5) {

            for (Player players : Bukkit.getOnlinePlayers()) {

                if (PlayerFile.get(players).getBoolean(players.getUniqueId().toString() + ".system-messages-enabled")) {

                    Messages.sendJSON(players, "&8[&6&lSUPPORTER&8] &6" + player.getDisplayName() + " &ehas joined the server!",
                            ClickEvent.Action.RUN_COMMAND, "/profile " + player.getName(), "&7Click to view this player's profile!"); // JSON
                    players.playSound(players.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 2); // SOUND
                    players.getWorld().spawnParticle(Particle.NOTE, players.getLocation(), 200);

                }
            }
        }
    }

    public static void set(Player player, int id){
        PlayerFile.get(player).set(player.getUniqueId().toString() + ".profile.customJoinMessage", id);
        PlayerFile.save(player);
    }

    public static int get(Player player){
        return PlayerFile.get(player).getInt(player.getUniqueId().toString() + ".profile.customJoinMessage");
    }

}
