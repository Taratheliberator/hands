package org.example;

public class Player extends Creature {
    private int healsUsed = 0;

    public Player(int attack, int defense, int health, int minDamage, int maxDamage) {
        super(attack, defense, health, minDamage, maxDamage);
    }

    public void heal() {
        if (healsUsed < 0 || healsUsed > 4) throw new IllegalArgumentException("Invalid number of heals used.");
        if (healsUsed < 4) {
            int previousHealth = health;
            health += maxHealth * 0.3;
            if (health > maxHealth) health = maxHealth;
            healsUsed++;
            System.out.println("Player heals from " + previousHealth + " to " + health + " health.");
        } else {
            System.out.println("Player has no heals left.");
        }
    }
}


