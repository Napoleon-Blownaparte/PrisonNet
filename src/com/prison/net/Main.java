package com.prison.net;

import com.prison.net.backend.UpdateChecker;
import com.prison.net.backend.api.Messages;
import com.prison.net.backend.files.*;
import com.prison.net.frontend.modules.joinmessage.JoinMessages;
import com.prison.net.frontend.modules.skins.SkinsCommand;
import com.prison.net.frontend.modules.skins.SkinsMenu;
import com.prison.net.frontend.events.PlayerJoin;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private String ver = getDescription().getVersion();
    private String author = getDescription().getAuthors().get(0);

    public void onEnable(){

        // Load files
        ConfigFile.save();
//        PickaxeFile.save();
//        SellFile.save();
//        SkinsFile.save();

        // Register Events
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new SkinsMenu(), this);

        // Register Commands
        this.getCommand("skins").setExecutor(new SkinsCommand());

        // Check for updates
        new UpdateChecker(this, 94241).getVersion(version -> {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("|                               PrisonNet                               |");
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("|                             Get In Touch                              |");
            System.out.println("| Discord: Bahzinga#0001                                                |");
            System.out.println("| Github: Napoleon-Blownaparte                                          |");
            System.out.println("| Spigot: Bahhzinga                                                     |");
            System.out.println("-------------------------------------------------------------------------");
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                System.out.println("| Latest Version: Oh, it looks like you're up-to-date!                  |");
                System.out.println("-------------------------------------------------------------------------");
            } else {
                System.out.println("| Latest Version: " + version + "                                                 |");
                System.out.println("| Type /prisonnet update to download the latest version                 |");
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("| Disclaimer: You will NOT receive support for outdated versions        |");
                System.out.println("-------------------------------------------------------------------------");

                for (Player player : Bukkit.getOnlinePlayers()){
                    if (player.isOp()){
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 1);
                        Messages.sendJSON(player, " &b&lPrison&3&lNet &8 &7A new version &8(&a" + ver + "&8) &7is now available, it is recommended that you install it. &8[Hover&8]",
                                ClickEvent.Action.OPEN_URL, "", "&8[&a+&8] &7Click this message to download the latest version of PrisonNet.");
                    }
                }

            }
        });

        // CONNECT TO DATABASE

    }

    public void onDisable(){

    }

}
