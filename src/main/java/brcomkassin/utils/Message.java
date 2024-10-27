package brcomkassin.utils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Arrays;

@SuppressWarnings("deprecation")
public interface Message {

    final class Chat {
        public static void send(Player player, String message) {
            final String colored = ChatColor.translateAlternateColorCodes('&', message);
            player.sendMessage(colored);
        }

        public static void send(Player player, String... message) {
            for (String line : message)
                send(player, line);
        }
    }

    final class ActionBar {
        public static void send(Player player, String message) {
            String colored = ChatColor.translateAlternateColorCodes('&', message);
            BaseComponent baseComponent = new TextComponent(colored);
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, baseComponent);
        }
    }
}
