package com.prison.net.frontend.illegalitems;

import com.prison.net.Main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class ItemAuth {

    private static Plugin plugin = Main.getPlugin(Main.class);

    public static void send(Player player){

        ItemStack item = new ItemStack(Material.DIRT);
        setPDV(item, PersistentDataType.STRING, "tier", "Test");
        player.sendMessage((String) getPDV(item, PersistentDataType.STRING, "tier"));
        player.getInventory().addItem(item);

    }

    public static boolean hasPDV(ItemStack item){
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer cont = meta.getPersistentDataContainer();
        return cont.isEmpty();
    }

    public static Object getPDV(ItemStack item, PersistentDataType pdv, Object key){
        NamespacedKey pdvKey = new NamespacedKey(plugin, String.valueOf(key));

        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer cont = meta.getPersistentDataContainer();
        Object result = null;
        if (cont.has(pdvKey, pdv)) {
            result = cont.get(pdvKey, pdv);
        }
        return result;
    }

    public static void setPDV(ItemStack item, PersistentDataType pdv, String key, Object value){
        NamespacedKey nsKey = new NamespacedKey(plugin, key);

        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(nsKey, pdv, value);
        item.setItemMeta(meta);
    }

    public static void resetPDV(ItemStack item, PersistentDataType pdv, String key){
        NamespacedKey nsKey = new NamespacedKey(plugin, key);

        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(nsKey, pdv, null);
        item.setItemMeta(meta);
    }


}
