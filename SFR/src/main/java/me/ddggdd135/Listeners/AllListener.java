package me.ddggdd135.Listeners;

import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import me.ddggdd135.Researches;
import me.ddggdd135.Thread;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

public class AllListener implements Listener {
    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event){
        List<Research> research = Researches.getResearches(event.getPlayer());
        Researches.SaveResearches(research, event.getPlayer());
        System.out.println("§e" + event.getPlayer().getName() + "的研究已保存");
    }
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event){
        Thread tmp = new Thread();
        tmp.start(event.getPlayer().getName());
    }
}
