package com.prison.net.frontend.modules.skins;

import com.prison.net.backend.api.Messages;
import com.prison.net.backend.files.SkinsFile;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SkinsMenu implements Listener {

    public static void open(Player player){

        Inventory inv = Bukkit.createInventory(null, 54, Messages.format("&b&lPrison&3&lNet &8» &dSkins"));

        // Borders
        ItemStack gray = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);   ItemMeta grayMeta = gray.getItemMeta();
        ItemStack black = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);  ItemMeta blackMeta = black.getItemMeta();

        grayMeta.setDisplayName(" ");   blackMeta.setDisplayName(" ");
        gray.setItemMeta(grayMeta); black.setItemMeta(blackMeta);

        for (int h = 0;h<9;h++){
            inv.setItem(h, gray);
        }

        for (int f = 45;f<54;f++){
            inv.setItem(f, gray);
        }

        ItemStack reset = new ItemStack(Material.RED_DYE);   ItemMeta resetMeta = reset.getItemMeta();
        resetMeta.setDisplayName(Messages.format("&cReset Your Skin")); reset.setItemMeta(resetMeta);
        inv.setItem(8, reset);

        // List available skins
        for (String id : SkinsFile.get().getConfigurationSection("skins").getKeys(false)){

            // Get slot
            int slot = SkinsFile.get().getInt("skins." + Integer.valueOf(id) + ".slot");

            // Create ItemStack
            ItemStack item = new ItemStack(Material.valueOf(SkinsFile.get().getString("skins." + id + ".material")));
            ItemMeta meta = item.getItemMeta();

            meta.setDisplayName(Messages.format(SkinsFile.get().getString("skins." + id + ".displayName")));
            meta.setCustomModelData(SkinsFile.get().getInt("skins." + id + ".customModelData"));

            item.setItemMeta(meta);
            inv.setItem(slot, item);

        }

        player.openInventory(inv);

    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if (event.getView().getTitle().equalsIgnoreCase(Messages.format("&b&lPrison&3&lNet &8» &dSkins"))) {

            Player player = Bukkit.getPlayer(event.getWhoClicked().getName());
            event.setCancelled(true);

            // List available skins
            for (String id : SkinsFile.get().getConfigurationSection("skins").getKeys(false)) {

                // Get slot
                int slot = SkinsFile.get().getInt("skins." + Integer.valueOf(id) + ".slot");

                if (event.getSlot() == slot) {
                    Skins.setSkin(player, SkinsFile.get().getInt("skins." + id + ".customModelData"));
                } else if (event.getSlot() == 8){
                    Skins.reset(player);
                }
            }
        }
    }

}
