package com.prison.net.frontend.modules.luckyblocks;

import com.prison.net.Main;
import com.prison.net.backend.api.Messages;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class LuckyBlockEvent implements Listener {

    private static Plugin plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void blockBreak(BlockBreakEvent event){

        Player player = event.getPlayer();

        if (event.getBlock().getType() == Material.DIAMOND_BLOCK) {

            // $10,000

            if (Math.random() <= 0.01) { // $10,000
                player.getWorld().spawnParticle(Particle.DRAGON_BREATH, event.getBlock().getLocation(), 500);
                player.playSound(event.getBlock().getLocation(), Sound.ITEM_BOTTLE_FILL_DRAGONBREATH, 20, 5);
                player.getWorld().strikeLightningEffect(event.getBlock().getLocation());
                Messages.sendTitle(player, Messages.format("&d&lCONGRATULATIONS"), Messages.format("&7You broke a Lucky block and won &a$10,000"), 1, 1, 3);

                File file = new File(plugin.getDataFolder(), "/test.yml");
                FileConfiguration yml = YamlConfiguration.loadConfiguration(file);

                yml.set("balance.tokens", 10000);
                try {
                    yml.save(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }


}
