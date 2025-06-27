package edu.odu.cs.cs330.items;

import java.util.Scanner;

/**
 * This class represents one Consumable Item--as found in most video games.
 * This includes food.
 *
 * Consumable Items must be stackable.
 */
public class Consumable extends Item {
    /**
     * The effect "buff" or "debuff" that is received when using this item.
     */
    protected String effect;

    /**
     * The number of times this item can be used.
     */
    protected int uses;

    /**
     * Default to a Consumable Item with an empty name, no effect and zero
     * uses.
     */
    public Consumable() {
        super("Consumable");
        this.effect = "";
        this.uses = 0;
    }

    /**
     * Create a copy of this Consumable.
     *
     * @param src consumable item to duplicate
     */
    public Consumable(Consumable src) {
        super(src.getName());
        this.effect = src.effect;
        this.uses = src.uses;
    }

    /**
     * Retrieve the effect.
     *
     * @return the set effect (i.e., buff or debuff)
     */
    public String getEffect() {
        return this.effect;
    }

    /**
     * Set a new buff or debuff.
     *
     * @param newEff replacement effect
     */
    public void setEffect(String newEff) {
        this.effect = newEff;
    }

    /**
     * Retrieve permitted number of uses.
     *
     * @return number of total uses
     */
    public int getNumberOfUses() {
        return this.uses;
    }

    /**
     * Set the number of permitted uses.
     *
     * @param allowed number of allowed uses
     */
    public void setNumberOfUses(int allowed) {
        this.uses = allowed;
    }

    @Override
    public boolean isStackable() {
        return true;
    }

    /**
     * Read Consumable Item attributes.
     */
    @Override
    public void read(Scanner snr) {
        super.name = snr.next();
        effect = snr.next();
        uses = snr.nextInt();
    }

    /**
     * Clone--i.e., copy--this Consumable Item.
     */
    @Override
    public Item clone() {
        // Replace the next line
        return new Consumable(this);
    }

    /**
     * Check for logical equivalence--based on name and effect.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs) {
        if (!(rhs instanceof Consumable)) {
            return false;
        }

        Consumable rhsItem = (Consumable) rhs;

        if (this.name.compareToIgnoreCase(rhsItem.getName()) != 0)
            return false;
        if (this.effect.compareToIgnoreCase(rhsItem.getEffect()) != 0)
            return false;

        return true;
    }

    /**
     * Generate a hash code based on name and effect.
     *
     * Add <code>name.hashCode()</code> and <code>effect.hashCode</code>, then
     * return the result.
     */
    @Override
    public int hashCode() {
        // Replace the next line
        return (int) name.hashCode() + effect.hashCode();
    }

    /**
     * *Print* the Consumable Item.
     */
    @Override
    public String toString() {
        StringBuilder strBld = new StringBuilder();
        strBld.append("  Nme: ")
                .append(this.name)
                .append(System.lineSeparator())
                .append("  Eft: ")
                .append(this.effect)
                .append(System.lineSeparator())
                .append("  Use: ")
                .append(this.uses)
                .append(System.lineSeparator());
        return strBld.toString();
    }
}
