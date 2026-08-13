package org.turbojax.invisplaceholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.UUID;

public class Placeholders extends PlaceholderExpansion {
    private final Main plugin;

    public Placeholders(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NonNull String getAuthor() {
        return "turbojax";
    }

    @Override
    public @NonNull String getIdentifier() {
        return "invisplaceholders";
    }

    @Override
    public @NonNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {
        UUID uuid = player.getUniqueId();

        return switch (params.toLowerCase()) {
            case "no_name" -> hasInvis(player) ? "" : player.getName();
            case "fake_name" -> hasInvis(player) ? "Someone" : player.getName();
            default -> null;
        };
    }

    public boolean hasInvis(OfflinePlayer player) {
        if (!player.isOnline()) return false;

        Player p = player.getPlayer();
        return p.hasPotionEffect(PotionEffectType.INVISIBILITY);
    }
}
