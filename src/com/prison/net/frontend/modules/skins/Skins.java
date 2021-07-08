package com.prison.net.frontend.modules.skins;

import com.prison.net.backend.api.Messages;
import com.prison.net.backend.files.SkinsFile;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Skins {


    // Set skin
    public static void setSkin(Player player, int id){

        // Get permission node for skin
        String permission = SkinsFile.get().getString("skins." + id + ".permission");

        // Get display name for skin
        String displayName = SkinsFile.get().getString("skins." + id + ".displayName");

        // Get customModelData for skin
        int customModelData = SkinsFile.get().getInt("skins." + id + ".customModelData");

        // Get material for skin
        Material material = Material.valueOf(SkinsFile.get().getString("skins." + id + ".material"));

        if (player.getInventory().getItemInMainHand().getType() == material) {

            if (player.hasPermission(permission)) {
                ItemStack item = player.getInventory().getItemInMainHand();
                ItemMeta meta = item.getItemMeta();
                meta.setCustomModelData(customModelData);
                item.setItemMeta(meta);

            } else {
                player.sendMessage(Messages.format("&8[&c-&8] &7You haven't unlocked that skin!"));
            }
        }
    }

    // Reset skin
    public static void reset(Player player){

        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(0);
        item.setItemMeta(meta);

    }

}
