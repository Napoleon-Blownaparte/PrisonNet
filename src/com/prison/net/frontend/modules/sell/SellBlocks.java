package com.prison.net.frontend.modules.sell;

import com.prison.net.backend.files.SellFile;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SellBlocks {

    public static void sellBlocks(Player player, double multiplier){

        // Check the contents of the player's inventory
        for (ItemStack sellblock : player.getInventory().getContents()) {

            // Check the blocks which are listed in 'sell.yml'
            for (String blockName : SellFile.get().getConfigurationSection("prices").getKeys(false)){

                // Check contents against listed blocks
//                if (sellblock.isSimilar(new ItemStack(Material.valueOf(blockName)))){
//                    player.sendMessage("E!");
//                }

                player.sendMessage(sellblock.getType().toString());

            }

        }


    }

}
