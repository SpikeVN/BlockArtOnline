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

import java.util.Arrays;
import java.util.List;

/**
 * Represents an item's ability.
 */
public class Ability {
    private ItemAbilityUseAction usage;
    private String name;
    private List<String> description;
    private int cost;
    private int cooldown;

    public List<String> getDescription() {
        return description;
    }

    public Ability setDescription(String description) {
        this.description = Arrays.stream(description.split("\n")).toList();
        return this;
    }

    public String getName() {
        return name;
    }

    public Ability setName(String name) {
        this.name = name;
        return this;
    }

    public ItemAbilityUseAction getUsage() {
        return usage;
    }

    public Ability setUsage(ItemAbilityUseAction usage) {
        this.usage = usage;
        return this;
    }

    public int getCost() {
        return cost;
    }

    public Ability setCost(int cost) {
        this.cost = cost;
        return this;
    }

    public int getCooldown() {
        return cooldown;
    }

    public Ability setCooldown(int c) {
        this.cooldown = c;
        return this;
    }
}
