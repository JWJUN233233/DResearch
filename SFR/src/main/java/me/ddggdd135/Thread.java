package me.ddggdd135;

import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class Thread implements Runnable {
    java.lang.Thread thread;
    public String u;
    @Override
    public void run() {
        try {
            java.lang.Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }Player player = Bukkit.getPlayer(u);
        if(player != null){
            List<Research> research = Researches.getThisResearches(player);
            for(Research r : research){
                r.unlock(player,true);
            }
            player.sendMessage("§e您的研究已同步");
        }
        System.out.println("§e" + u + "的研究同步完成");
    }
    public void start(String u){
        thread = new java.lang.Thread(this);
        this.u = u;
        thread.start();
    }
}
