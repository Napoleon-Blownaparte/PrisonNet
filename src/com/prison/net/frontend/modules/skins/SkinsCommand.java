package com.prison.net.frontend.modules.skins;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SkinsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (label.equalsIgnoreCase("skins")) {
                SkinsMenu.open(player);
            }
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
