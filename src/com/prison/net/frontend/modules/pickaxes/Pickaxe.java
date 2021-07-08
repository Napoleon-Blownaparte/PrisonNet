package com.prison.net.frontend.modules.pickaxes;

import com.prison.net.Main;
import com.prison.net.backend.api.Messages;
import com.prison.net.backend.files.PickaxeFile;
import com.prison.net.frontend.illegalitems.ItemAuth;
import com.prison.net.frontend.modules.currencies.Engrams;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pickaxe {

    private static Plugin plugin = Main.getPlugin(Main.class);

    private static NamespacedKey key = new NamespacedKey(plugin, "tier");

    /**
     * Broadcasts a server message without a permission.
     * @param tier - The tier of the pickaxe
     * @param cost - The cost of the pickaxe
     * @param displayName - The name of the pickaxe
     * @param material - It must be either a Diamond pickaxe or a Netherite pickaxe
     * @param customModelData - The texture of the pickaxe
     * @param fortuneLevel - The level of the fortune enchantment
     * @param effficiencyLevel - The level of the efficiency enchantment
     * @param unbreakingLevel - The level of the unbreaking enchantment
     * @param lore - The description of the pickaxe
     */
    public static void createPickaxe(int tier, int cost, String displayName, Material material, int customModelData, int fortuneLevel, int effficiencyLevel, int unbreakingLevel, List<String> lore){

        File file = new File(plugin.getDataFolder(), "/pickaxes.yml");
        FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

        // Add pickaxe to file
        yml.set("pickaxes." + tier + ".displayName", displayName);
        yml.set("pickaxes." + tier + ".cost", cost);
        yml.set("pickaxes." + tier + ".material", material.toString());
        yml.set("pickaxes." + tier + ".customModelData", customModelData);
        yml.set("pickaxes." + tier + ".fortuneLevel", fortuneLevel);
        yml.set("pickaxes." + tier + ".efficiencyLevel", effficiencyLevel);
        yml.set("pickaxes." + tier + ".unbreakingLevel", unbreakingLevel);
        yml.set("pickaxes." + tier + ".lore", lore);

        // Save file
        try {
            yml.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Notify admins
        for (Player player : Bukkit.getOnlinePlayers()){
            if (player.hasPermission("prisonnet.admin")){
                Messages.sendJSON(player, "&b&lPrison&3&lNet &8» &7Created new pickaxe &8(&7Tier: " + tier + ", &7Displayname: " + displayName + ", &7Material: " + material.toString() + "&8)&7.", ClickEvent.Action.RUN_COMMAND, "/pickaxe configure " + tier, "&7CLick to configure this pickaxe.");
            }
        }
    }

    public static void setTier(Player player, ItemStack item, Integer tier){

        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, tier);
        meta.setDisplayName(Messages.format(PickaxeFile.get().getString("pickaxes." + tier + ".displayName") + " &8(&3Tier &b" + tier.toString() + "&8)"));
        item.setItemMeta(meta);
    }

    public static Integer getTier(Player player, ItemStack item){
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer cont = meta.getPersistentDataContainer();
        Integer tier = null;
        if (cont.has(key, PersistentDataType.INTEGER)) {
            tier = cont.get(key, PersistentDataType.INTEGER);
        } else {
            tier = 0;
            System.out.println("[PrisonNet] Error: Failed to find PersistentData ('') in pickaxe owned by player '" + player.getName() + "', named " + Messages.format(meta.getDisplayName()) + " - this item is most likely illegal or broken.");
        }
        return tier;
    }

    public static void updateBlocksBroken(Player player, Integer amount){

        // Get player's ItemStack
        ItemStack item = player.getInventory().getItemInMainHand();

        // Get current blocks broken
        Integer current = (Integer) ItemAuth.getPDV(player.getInventory().getItemInMainHand(), PersistentDataType.INTEGER, "blocksbroken");

        // Update
        ItemAuth.setPDV(player.getInventory().getItemInMainHand(), PersistentDataType.INTEGER, "blocksbroken",current+amount);

    }

    // Get blocks broken
    public static Integer getBlocksBroken(ItemStack item){
        return (Integer) ItemAuth.getPDV(item, PersistentDataType.INTEGER, "blockbroken");
    }

    // Give Pickaxe
    public static void give(Player player, Integer tier, Integer amount){

        // ItemStack
        ItemStack pick = new ItemStack(Material.valueOf(PickaxeFile.get().getString("pickaxes." + tier + ".material")));     ItemMeta meta = pick.getItemMeta();
        meta.setDisplayName(Messages.format(PickaxeFile.get().getString("pickaxes." + tier + ".displayName") + " &8(&3Tier &b" + tier.toString() + "&8)"));

        List<String> lore = new ArrayList<>();
        List<String> rawLore = PickaxeFile.get().getStringList("pickaxes." + tier + ".lore");
        for (int i = 0;i<rawLore.size();i++){
            lore.add(Messages.format(rawLore.get(i)));
        }
        meta.setLore(lore);

        // Set texture
        meta.setCustomModelData(PickaxeFile.get().getInt("pickaxes." + tier + ".customModelData"));

        // Set tier of pickaxe
        setTier(player, pick, tier);
        pick.setItemMeta(meta);

        // Enchantments
        pick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, PickaxeFile.get().getInt("pickaxes." + tier + ".fortuneLevel"));
        pick.addUnsafeEnchantment(Enchantment.DIG_SPEED, PickaxeFile.get().getInt("pickaxes." + tier + ".efficiencyLevel"));
        pick.addUnsafeEnchantment(Enchantment.DURABILITY, PickaxeFile.get().getInt("pickaxes." + tier + ".unbreakingLevel"));

        // Give player item
        for (int l = 0;l<amount;l++){
            player.getInventory().addItem(pick);
        }
    }

    // Upgrade Pickaxe
    public static void upgrade(Player player, ItemStack item){

        // Get tier of the pickaxe
        Integer tier = (Integer) ItemAuth.getPDV(item, PersistentDataType.INTEGER, "tier");

        // Get ItemMeta
        ItemMeta meta = item.getItemMeta();

        // Get cost of upgrade
        Integer cost = PickaxeFile.get().getInt("pickaxes." + tier+1 + ".cost");

        // Get player's Engram balance
        Integer balance = Engrams.balance(player);

        // Check if player has enough engrams
        if (balance >= cost){

            Engrams.remove(player, cost);
            setTier(player, item, 2);

        }


    }


}
