package com.prison.net.backend;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PrisonServer {

    private static Boolean canJoin;

    private static void setJoin(Boolean bool){
        canJoin = bool;
    }

    private static Boolean getCanJoin(){
        return canJoin;
    }

    public static void setMaintenance(ErrorCode code){
        for (Player player : Bukkit.getOnlinePlayers()){
            player.kickPlayer("&cYou were disconnected/n&cCause: &7" + code.toString() + "(" + ErrorCode.getReason(code)
                    + ")/n/n&7Please contact an administrator immediately,/n&7you will not be able to rejoin the server/n&7until this problem is resolved./n/n&7Apologies for any inconveniences caused");
        }
        setJoin(false);
    }

}
