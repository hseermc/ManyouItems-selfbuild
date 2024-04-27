package cn.superiormc.manyouitems;

import cn.superiormc.manyouitems.libs.easyplugin.ColorParser;
import cn.superiormc.manyouitems.util.CommonUtil;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TextUtil {

    public static String parse(String text) {
        if (text == null)
            return "";
        return ColorParser.parse(text);
    }

    public static String parse(Player player, String text) {
        return parse(withPAPI(text, player));
    }

    public static String withPAPI(String text, Player player) {
        if (text.matches("[0-9]+")) {
            return text;
        }
        if (text.contains("%") && CommonUtil.checkPluginLoad("PlaceholderAPI")) {
            return PlaceholderAPI.setPlaceholders(player, text);
        }
        else {
            return text;
        }
    }

    public static List<String> getListWithColor(List<String> inList) {
        List<String> resultList = new ArrayList<>();
        for (String s : inList) {
            if (s.isEmpty()) {
                s = " ";
            }
            for (String b : s.split("\n")) {
                resultList.add(TextUtil.parse(b));
            }
        }
        return resultList;
    }

    public static List<String> getListWithColorAndPAPI(Player player, List<String> inList) {
        List<String> resultList = new ArrayList<>();
        for (String s : inList) {
            if (s.isEmpty()) {
                s = " ";
            } else if (CommonUtil.checkPluginLoad("PlaceholderAPI")) {
                s = PlaceholderAPI.setPlaceholders(player, s);
            }
            for (String b : s.split("\n")) {
                resultList.add(TextUtil.parse(b));
            }
        }
        return resultList;
    }
}
