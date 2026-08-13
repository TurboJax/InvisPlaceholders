package org.turbojax.invisplaceholders;

import me.chancesd.pvpmanager.player.CombatPlayer;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class Placeholders extends PlaceholderExpansion {
    @Override
    public String getAuthor() {
        return "turbojax";
    }

    @Override
    public String getIdentifier() {
        return "invisplaceholders";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    @Nullable
    public String onRequest(@Nullable OfflinePlayer player, String params) {
        if (!player.isOnline()) return null;

        Player p = player.getPlayer();
        CombatPlayer cp = CombatPlayer.get(p);

        CombatPlayer enemy = cp.getEnemy();
        if (enemy == null) return null;

        return switch (params.toLowerCase()) {
            case "no_name" -> hasInvis(enemy.getPlayer()) ? "" : enemy.getName();
            case "fake_name" -> hasInvis(enemy.getPlayer()) ? "Someone" : enemy.getName();
            default -> null;
        };
    }

    public boolean hasInvis(Player player) {
        return player.hasPotionEffect(PotionEffectType.INVISIBILITY);
    }
}
