package com.prison.net.frontend.events;

import com.prison.net.backend.api.Messages;
import com.prison.net.backend.files.PlayerFile;
import com.prison.net.frontend.illegalitems.ItemAuth;
import com.prison.net.frontend.modules.joinmessage.JoinMessages;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataType;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();
        JoinMessages.send(player, PlayerFile.get(player).getInt("cosmetics.joinMessage"));
        Messages.sendActionbar(player, "&b&lPrison&3&lNet &8» &dWelcome to the server!");
        Messages.sendTitle(player, "&b&lPrison&3&lNet", "&dWelcome to the server!", 1, 40, 1);

        ItemAuth.send(player);

    }

    @EventHandler
    public void onMine(BlockBreakEvent event){

        Player player = event.getPlayer();

        if (player.getInventory().getItemInMainHand().getType() == Material.DIRT){
            String value = (String) ItemAuth.getPDV(player.getInventory().getItemInMainHand(),
                    PersistentDataType.STRING, "tier");
            if (value != null){
                player.getInventory().remove(player.getInventory().getItemInMainHand());
            }
        }

    }



}
