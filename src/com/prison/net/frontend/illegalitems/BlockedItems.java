package com.prison.net.frontend.illegalitems;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class BlockedItems {


    public static void scanItem(Player subject, ItemStack item){

        /*
        Check the material of the ItemStack
         - DIAMOND_PICKAXE: Relative to tier - requires PDV, regardless.
         */

        if (item.getType() == Material.DIAMOND_PICKAXE){

            // Check if item has PDV
            if (ItemAuth.hasPDV(item)) {


            }

        }

    }


}
