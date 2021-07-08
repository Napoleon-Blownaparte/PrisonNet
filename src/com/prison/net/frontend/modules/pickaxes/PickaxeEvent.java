package com.prison.net.frontend.modules.pickaxes;

import com.prison.net.backend.api.Messages;
import com.prison.net.frontend.illegalitems.BlockedItems;
import com.prison.net.frontend.illegalitems.ItemAuth;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;


public class PickaxeEvent implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if (event.getAction() == Action.RIGHT_CLICK_AIR){
            if (player.isSneaking()) {
                if (event.getItem().getType() == Material.DIAMOND_PICKAXE || event.getItem().getType() == Material.NETHERITE_PICKAXE) {

                    PickaxeMenu.open(player);

                }
            }
        }
    }

    // Fortune
    @EventHandler
    public void onMine(BlockBreakEvent event) {

        Player player = event.getPlayer();

        if (player.getGameMode() == GameMode.SURVIVAL) {

            if (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_PICKAXE) {

                int fortuneLevel = player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);

                if (fortuneLevel > 0) {
                    int fortuneMultiplier = (int) Math.round(1 * (fortuneLevel * 0.75));

                    if (event.getBlock().getType() != Material.AIR ||
                            event.getBlock().getType() != Material.VOID_AIR ||
                            event.getBlock().getType() != Material.WATER ||
                            event.getBlock().getType() != Material.LAVA) {
                        event.getBlock().getLocation().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.getMaterial(event.getBlock().getType().toString()), fortuneMultiplier));
                        event.setDropItems(false);
                    }
                }
            }
        }
    }

}
