package com.prison.net.frontend.modules.currencies;

import com.prison.net.backend.files.PlayerFile;
import org.bukkit.entity.Player;

public class Engrams {

    public static void add(Player player, int amount){
        PlayerFile.get(player).set("balance.engrams", balance(player)+amount);
        PlayerFile.save(player);
    }

    public static void remove(Player player, int amount){
        PlayerFile.get(player).set("balance.engrams", balance(player)-amount);
        PlayerFile.save(player);
    }

    public static void reset(Player player){
        PlayerFile.get(player).set("balance.engrams", 0);
        PlayerFile.save(player);
    }

    public static int balance(Player player){
        return PlayerFile.get(player).getInt("balance.engrams");
    }
}
