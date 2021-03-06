/*
 * Copyright (c) 2022 the Block Art Online Project contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package ga.baoproject.theseed.abc;

import ga.baoproject.theseed.TheSeed;
import ga.baoproject.theseed.utils.Utils;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Weapon extends CustomItem {
    private int damage;
    private int strength;

    public Weapon(Material i) {
        super(i);
    }

    public float calculateDamage() {
        return (float) damage * (100 + strength) / 100;
    }

    public ItemStack getItem() {
        ItemStack item = new ItemStack(getMaterial());
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.displayName(Component.text(Utils.itemRarityColor(getRarity()) + getName()));
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text(ChatColor.GRAY + "S??t th????ng: " + ChatColor.RED + "+" + getDamage()));
        lore.add(Component.text(ChatColor.GRAY + "S???c m???nh ra ????n: " + ChatColor.RED + "+" + getStrength()));
        lore.add(Component.space());
        for (Ability a : getAbilities()) {
            lore.add(Component.text(ChatColor.GOLD + "K?? n??ng ?????c bi???t: " + a.getName() + " " + ChatColor.YELLOW + ChatColor.BOLD + Utils.toActionString(a.getUsage())));
            lore.addAll(Utils.convListString(a.getDescription()));
            lore.add(Component.text(ChatColor.DARK_GRAY + "T???n Mana: " + ChatColor.DARK_AQUA + a.getCost()));
            lore.add(Component.text(ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + a.getCooldown() + "s"));
        }
        lore.add(Component.space());
        lore.add(Component.text(Rarity.toRarityString(getRarity())));
        meta.lore(lore);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
        Plugin pl = TheSeed.getInstance();
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(new NamespacedKey(pl, "id"), PersistentDataType.STRING, getID());
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Called when the item is used to attack other entities.
     * Child class must override this method.
     *
     * @param e the {@link EntityDamageByEntityEvent} received.
     */
    public void attackAction(EntityDamageByEntityEvent e) {
    }

    public final int getStrength() {
        return strength;
    }

    public final void setStrength(int s) {
        strength = s;
    }

    public final int getDamage() {
        return damage;
    }

    public final void setDamage(int d) {
        damage = d;
    }

}

