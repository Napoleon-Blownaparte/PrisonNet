package com.prison.net.frontend.modules.pickaxes;

import com.prison.net.backend.api.Messages;
import com.prison.net.backend.files.PickaxeFile;
import com.prison.net.frontend.illegalitems.ItemAuth;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PickaxeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (label.equalsIgnoreCase("pickaxe")){
                if (args[0].equalsIgnoreCase("configure")){
                    if (args.length == 2) {
                        if (player.hasPermission("prisonnet.pickaxes.admin")) {
                            Pickaxe.createPickaxe(2, 500, "&fDiamond Pickaxe &8(&7Tier &bI&8)", Material.DIAMOND_PICKAXE, 1, 10, 35, 25,
                                    Arrays.asList(
                                            "&7This is the starter pickaxe!"
                                    ));
                        }
                    }
                } else if (args[0].equalsIgnoreCase("give")){ // /pickaxe give <player> <tier> <amount>
                    if (args.length == 4) {
                        Pickaxe.give(Bukkit.getPlayer(args[1]), Integer.valueOf(args[2]), Integer.valueOf(args[3]));
                    }
                } else if (args[0].equalsIgnoreCase("upgrade")){
                    Pickaxe.upgrade(player, player.getInventory().getItemInMainHand());
                }
            }

        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }


}
