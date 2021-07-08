package com.prison.net.frontend.modules.sell;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SellEvents implements Listener {

    @EventHandler
    public void onShiftRightClick(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if (event.getAction() == Action.RIGHT_CLICK_AIR){
            if (player.isSneaking()){
                SellBlocks.sellBlocks(player, 1);
            }
        }

    }

}
