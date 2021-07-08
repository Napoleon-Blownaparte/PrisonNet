package com.prison.net.backend.api;

import com.prison.net.backend.files.PlayerFile;
import org.bukkit.entity.Player;

public enum Currency {

    TOKENS,
    SHARDS,
    SCROLLS,
    ENGRAMS;


    // Currency Methods
    public static void giveCurrency(Currency currency, Integer amount, Player player){
        PlayerFile.get(player).set(player.getUniqueId().toString() + ".balance." + currency.toString().toLowerCase(), getCurrencyBalance(currency, player)+amount);
        PlayerFile.save(player);
    }

    public static void setCurrency(Currency currency, Integer amount, Player player){
        PlayerFile.get(player).set(player.getUniqueId().toString() + ".balance." + currency.toString().toLowerCase(), amount);
        PlayerFile.save(player);
    }

    public static void removeCurrency(Currency currency, Integer amount, Player player){
        PlayerFile.get(player).set(player.getUniqueId().toString() + ".balance." + currency.toString().toLowerCase(), getCurrencyBalance(currency, player)-amount);
        PlayerFile.save(player);
    }

    public static void resetCurrency(Currency currency, Player player){
        PlayerFile.get(player).set(player.getUniqueId().toString() + ".balance." + currency.toString().toLowerCase(), 0);
        PlayerFile.save(player);
    }

    public static Integer getCurrencyBalance(Currency currency, Player player){
        return PlayerFile.get(player).getInt(player.getUniqueId().toString() + ".balance." + currency.toString().toLowerCase());
    }


}
