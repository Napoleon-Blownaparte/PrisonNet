package com.prison.net.frontend.modules.pickaxes;

import com.prison.net.Main;
import com.prison.net.backend.api.Messages;
import com.prison.net.frontend.modules.skins.SkinsMenu;
import com.prison.net.frontend.modules.currencies.Scrolls;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class PickaxeMenu implements Listener {

    private static Plugin plugin = Main.getPlugin(Main.class);


    // MAIN MENU
    public static void open(Player player){

        // Create Inventory
        Inventory inv = Bukkit.createInventory(null, 45, ChatColor.translateAlternateColorCodes('&', "&b&lPrison&3&lNet &8» &dPickaxes"));

        // Background
        ItemStack bg = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
        ItemMeta bgMeta = bg.getItemMeta();

        bgMeta.setDisplayName(" ");
        bgMeta.setLore(Arrays.asList(
                Messages.format("&8[&e+&8] &7You are able to upgrade your pickaxe with"),
                Messages.format("&7 enchantments, skins and increase your multipliers."),
                " "));

        bg.setItemMeta(bgMeta);

        for (int i = 0;i<45;i++){
            inv.setItem(i, bg);
        }

        // Borders
        ItemStack gray = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);   ItemMeta grayMeta = gray.getItemMeta();
        ItemStack black = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);  ItemMeta blackMeta = black.getItemMeta();

        grayMeta.setDisplayName(" ");   blackMeta.setDisplayName(" ");
        gray.setItemMeta(grayMeta); black.setItemMeta(blackMeta);

        for (int h = 0;h<9;h++){
            inv.setItem(h, gray);
        }

        for (int f = 36;f<45;f++){
            inv.setItem(f, gray);
        }

        // Icons
        ItemStack icon1 = new ItemStack(Material.DIAMOND_PICKAXE); ItemMeta icon1Meta = icon1.getItemMeta();
        icon1Meta.setDisplayName(Messages.format("&b&lPickaxe Menu")); icon1.setItemMeta(icon1Meta);

        ItemStack icon2 = new ItemStack(Material.ENCHANTED_BOOK);  ItemMeta icon2Meta = icon2.getItemMeta();
        icon2Meta.setDisplayName(Messages.format("&dEnchantments")); icon2.setItemMeta(icon2Meta);

        ItemStack icon3 = new ItemStack((Material.NETHER_STAR));   ItemMeta icon3Meta = icon3.getItemMeta();
        icon3Meta.setDisplayName(Messages.format("&dUpgrade Your Pickaxe")); icon3.setItemMeta(icon3Meta);

        ItemStack icon4 = new ItemStack(Material.PAINTING);        ItemMeta icon4Meta = icon4.getItemMeta();
        icon4Meta.setDisplayName(Messages.format("&dChange Your Skin"));     icon4.setItemMeta(icon4Meta);

        inv.setItem(4, icon1); inv.setItem(19, icon2); inv.setItem(22, icon3); inv.setItem(25, icon4);

        // Open inventory
        player.openInventory(inv);

    }

    // ENCHANTMENTS
    public static void openEnchantMenu(Player player) {

        // Create Inventory
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "&b&lPrison&3&lNet &8» &dEnchantments"));

        // Background
        ItemStack bg = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
        ItemMeta bgMeta = bg.getItemMeta();

        bgMeta.setDisplayName(" ");
        bgMeta.setLore(Arrays.asList(
                Messages.format("&8[&e+&8] &7You are able to upgrade your pickaxe with"),
                Messages.format("&7enchantments, skins and increase your multipliers."),
                " "
                ));

        bg.setItemMeta(bgMeta);

        for (int i = 0; i < 54; i++) {
            inv.setItem(i, bg);
        }

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



        // FORTUNE
        ItemStack fortune1 = new ItemStack(Material.DIAMOND);   ItemMeta fort1Meta = fortune1.getItemMeta();
        ItemStack fortune10 = new ItemStack(Material.DIAMOND);  ItemMeta fort10Meta = fortune10.getItemMeta();

        fort1Meta.setDisplayName(Messages.format("&8[&a+1&8] &bFortune &8(&7Cost: &d3 Scrolls&8)"));
        fort10Meta.setDisplayName(Messages.format("&8[&a+10&8] &bFortune &8(&7Cost: &d30 Scrolls&8)"));

        // EFFICIENCY
        ItemStack effic1 = new ItemStack(Material.DIAMOND);   ItemMeta effic1Meta = effic1.getItemMeta();
        ItemStack effic10 = new ItemStack(Material.DIAMOND);  ItemMeta effic10Meta = effic10.getItemMeta();

        effic1Meta.setDisplayName(Messages.format("&8[&a+1&8] &bEfficiency &8(&7Cost: &d2 Scrolls&8)"));
        effic10Meta.setDisplayName(Messages.format("&8[&a+10&8] &bEfficiency &8(&7Cost: &d20 Scrolls&8)"));

        // UNBREAKING
        ItemStack unbreak1 = new ItemStack(Material.DIAMOND);   ItemMeta unbreak1Meta = unbreak1.getItemMeta();
        ItemStack unbreak10 = new ItemStack(Material.DIAMOND);  ItemMeta unbreak10Meta = unbreak10.getItemMeta();

        unbreak1Meta.setDisplayName(Messages.format("&8[&a+1&8] &bUnbreaking &8(&7Cost: &d10 Scrolls&8)"));
        unbreak10Meta.setDisplayName(Messages.format("&8[&a+10&8] &bUnbreaking &8(&7Cost: &d10 Scrolls&8)"));

        fortune1.setItemMeta(fort1Meta);    fortune10.setItemMeta(fort10Meta);
        effic1.setItemMeta(effic1Meta);     effic10.setItemMeta(effic10Meta);
        unbreak1.setItemMeta(unbreak1Meta); unbreak10.setItemMeta(unbreak10Meta);

        inv.setItem(20, fortune1); inv.setItem(29, fortune10);
        inv.setItem(22, effic1);   inv.setItem(31, effic10);
        inv.setItem(24, unbreak1); inv.setItem(33, unbreak10);

        // Back button
        ItemStack back = new ItemStack(Material.ARROW);     ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName(Messages.format("&8[&d<---&8] &7Previous Page")); back.setItemMeta(bgMeta);

        inv.setItem(0, back);

        player.openInventory(inv);

    }

    @EventHandler
    public void onMenuInteract(InventoryClickEvent event){

        Player player = Bukkit.getPlayer(event.getWhoClicked().getName());

        if (event.getView().getTitle().equalsIgnoreCase(Messages.format("&b&lPrison&3&lNet &8» &dPickaxes"))){

            if (event.getSlot() == 19) {
                PickaxeMenu.openEnchantMenu(player);
            } else if (event.getSlot() == 22) {
                //Pickaxe.upgrade(player);
            } else if (event.getSlot() == 25) {
                SkinsMenu.open(player);
            }

            event.setCancelled(true);

        } else if (event.getView().getTitle().equalsIgnoreCase(Messages.format("&b&lPrison&3&lNet &8» &dEnchantments"))) {

            event.setCancelled(true);

            if (event.getSlot() == 0){
                open(player);
            }

            // ADD 1 FORTUNE LEVEL
            else if (event.getSlot() == 20) {

                if (Scrolls.balance(player) >= 3) {

                    File file = new File(plugin.getDataFolder(), "/playerdata/" + player.getUniqueId().toString() + ".yml");
                    FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

                    yml.set("balance.scrolls", Scrolls.balance(player) - 3);
                    try {
                        yml.save(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS,
                            player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) + 1);

                    player.closeInventory();
                    Messages.sendJSON(player, "&8[&a+&8] &7You added &a1 &7level of &aFortune &7to your pickaxe!", ClickEvent.Action.RUN_COMMAND, "/pickaxes menu", "&7Click to configure your pickaxe.");
                } else {
                    player.sendMessage(Messages.format("&8[&c-&8] &7You need at least &a3 &7scrolls to purchase this upgrade."));
                }


            } else if (event.getSlot() == 29) { // ADD 10 FORTUNE LEVELS

                if (Scrolls.balance(player) >= 30) {

                    File file = new File(plugin.getDataFolder(), "/playerdata/" + player.getUniqueId().toString() + ".yml");
                    FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

                    yml.set("balance.scrolls", Scrolls.balance(player) - 30);
                    try {
                        yml.save(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS,
                            player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) + 10);

                    player.closeInventory();
                    Messages.sendJSON(player, "&8[&a+&8] &7You added &a10 &7levels of &aFortune &7to your pickaxe!", ClickEvent.Action.RUN_COMMAND, "/pickaxes menu", "&7Click to configure your pickaxe.");
                } else {
                    player.sendMessage(Messages.format("&8[&c-&8] &7You need at least &a30 &7scrolls to purchase this upgrade."));
                }


            } else if (event.getSlot() == 22) { // ADD 1 EFFICIENCY LEVELS

                if (Scrolls.balance(player) >= 2) {

                    File file = new File(plugin.getDataFolder(), "/playerdata/" + player.getUniqueId().toString() + ".yml");
                    FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

                    yml.set("balance.scrolls", Scrolls.balance(player) - 2);
                    try {
                        yml.save(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.DIG_SPEED,
                            player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.DIG_SPEED) + 1);

                    player.closeInventory();
                    Messages.sendJSON(player, "&8[&a+&8] &7You added &a1 &7levels of &aEfficiency &7to your pickaxe!", ClickEvent.Action.RUN_COMMAND, "/pickaxes menu", "&7Click to configure your pickaxe.");
                } else {
                    player.sendMessage(Messages.format("&8[&c-&8] &7You need at least &a2 &7scrolls to purchase this upgrade."));
                }

            } else if (event.getSlot() == 31) { // ADD 10 EFFICIENCY LEVELS

                if (Scrolls.balance(player) >= 2) {

                    File file = new File(plugin.getDataFolder(), "/playerdata/" + player.getUniqueId().toString() + ".yml");
                    FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

                    yml.set("balance.scrolls", Scrolls.balance(player) - 20);
                    try {
                        yml.save(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.DIG_SPEED,
                            player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.DIG_SPEED) + 10);

                    player.closeInventory();
                    Messages.sendJSON(player, "&8[&a+&8] &7You added &a10 &7levels of &aEfficiency &7to your pickaxe!", ClickEvent.Action.RUN_COMMAND, "/pickaxes menu", "&7Click to configure your pickaxe.");
                } else {
                    player.sendMessage(Messages.format("&8[&c-&8] &7You need at least &a20 &7scrolls to purchase this upgrade."));
                }

            } else if (event.getSlot() == 29) { // ADD 1 EFFICIENCY LEVELS

                if (Scrolls.balance(player) >= 2) {

                    File file = new File(plugin.getDataFolder(), "/playerdata/" + player.getUniqueId().toString() + ".yml");
                    FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

                    yml.set("balance.scrolls", Scrolls.balance(player) - 2);
                    try {
                        yml.save(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.DIG_SPEED,
                            player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.DIG_SPEED) + 1);

                    player.closeInventory();
                    Messages.sendJSON(player, "&8[&a+&8] &7You added &a10 &7levels of &aEfficiency &7to your pickaxe!", ClickEvent.Action.RUN_COMMAND, "/pickaxes menu", "&7Click to configure your pickaxe.");
                } else {
                    player.sendMessage(Messages.format("&8[&c-&8] &7You need at least &a2 &7scrolls to purchase this upgrade."));
                }


            } else if (event.getSlot() == 24) { // ADD 1 UNBREAKING LEVELS

                if (Scrolls.balance(player) >= 1) {

                    File file = new File(plugin.getDataFolder(), "/playerdata/" + player.getUniqueId().toString() + ".yml");
                    FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

                    yml.set("balance.scrolls", Scrolls.balance(player) - 1);
                    try {
                        yml.save(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.DURABILITY,
                            player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.DURABILITY) + 1);

                    player.closeInventory();
                    Messages.sendJSON(player, "&8[&a+&8] &7You added &a1 &7levels of &aUnbreaking &7to your pickaxe!", ClickEvent.Action.RUN_COMMAND, "/pickaxes menu", "&7Click to configure your pickaxe.");
                } else {
                    player.sendMessage(Messages.format("&8[&c-&8] &7You need at least &a1 &7scrolls to purchase this upgrade."));
                }
            } else if (event.getSlot() == 33) { // ADD 10 UNBREAKING LEVELS

                if (Scrolls.balance(player) >= 10) {

                    File file = new File(plugin.getDataFolder(), "/playerdata/" + player.getUniqueId().toString() + ".yml");
                    FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

                    yml.set("balance.scrolls", Scrolls.balance(player) - 10);
                    try {
                        yml.save(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.DURABILITY,
                            player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.DURABILITY) + 10);

                    player.closeInventory();
                    Messages.sendJSON(player, "&8[&a+&8] &7You added &a10 &7levels of &aUnbreaking &7to your pickaxe!", ClickEvent.Action.RUN_COMMAND, "/pickaxes menu", "&7Click to configure your pickaxe.");
                } else {
                    player.sendMessage(Messages.format("&8[&c-&8] &7You need at least &a10 &7scrolls to purchase this upgrade."));
                }
            }
        }

    }

}
