package com.prison.net;

import com.prison.net.backend.files.PickaxeFile;
import com.prison.net.backend.files.SellFile;
import com.prison.net.backend.files.SkinsFile;
import com.prison.net.frontend.modules.joinmessage.JoinMessages;
import com.prison.net.frontend.modules.skins.SkinsCommand;
import com.prison.net.frontend.modules.skins.SkinsMenu;
import com.prison.net.frontend.events.PlayerJoin;
import com.prison.net.frontend.modules.luckyblocks.LuckyBlockEvent;
import com.prison.net.frontend.modules.pickaxes.PickaxeCommand;
import com.prison.net.frontend.modules.pickaxes.PickaxeEvent;
import com.prison.net.frontend.modules.pickaxes.PickaxeMenu;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable(){

        // Load files
        PickaxeFile.save();
        SellFile.save();
        SkinsFile.save();

        // Register Events
        getServer().getPluginManager().registerEvents(new LuckyBlockEvent(), this);
        getServer().getPluginManager().registerEvents(new JoinMessages(), this);
        getServer().getPluginManager().registerEvents(new PickaxeEvent(), this);
        getServer().getPluginManager().registerEvents(new PickaxeMenu(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new SkinsMenu(), this);

        // Register Commands
        this.getCommand("pickaxe").setExecutor(new PickaxeCommand());
        this.getCommand("skins").setExecutor(new SkinsCommand());

    }

    public void onDisable(){

    }

}
