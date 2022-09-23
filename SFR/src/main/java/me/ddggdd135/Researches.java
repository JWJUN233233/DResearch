package me.ddggdd135;

import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.*;

public class Researches {
    public static void SaveResearches(List<Research> researches,Player player){
        FileConfiguration research = DResearch.GetConfig(player.getName(), DResearch.Config.getString("SaveFileFolder"));
        for(Research r : researches){
            research.set("researches." + r.getID(),true);
        }
        DResearch.SaveConfig(research,player.getName(),DResearch.Config.getString("SaveFileFolder"));
    }
    public static List<Research> getResearches(Player player) {
        List<Research> ret = new ArrayList<>();
        Optional<PlayerProfile> playerProfile = PlayerProfile.find(player);
        Set<Research> research = playerProfile.get().getResearches();
        for (Research tmp2 : research) {
            ret.add(tmp2);
        }
        return ret;
    }
    public static List<Research> getThisResearches(Player player) {
        List<Research> tmp = Slimefun.getRegistry().getResearches();
        List<Research> ret = new ArrayList<>();
        FileConfiguration researchConfig = DResearch.GetConfig(player.getName(), DResearch.Config.getString("SaveFileFolder"));
        for(Research r : tmp){
            if(researchConfig.getBoolean("researches." + r.getID())){
                ret.add(r);
            }
        }
        return ret;
    }
}
