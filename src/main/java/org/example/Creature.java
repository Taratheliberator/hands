package org.example;

import java.util.Random;
public abstract class Creature {
    protected int attack;
    protected int defense;
    protected int health;
    protected int maxHealth;
    protected int minDamage;
    protected int maxDamage;

    public Creature(int attack, int defense, int health, int minDamage, int maxDamage) {
        if (attack < 1 || attack > 30) throw new IllegalArgumentException("Attack should be between 1 and 30.");
        if (defense < 1 || defense > 30) throw new IllegalArgumentException("Defense should be between 1 and 30.");
        if (health <= 0) throw new IllegalArgumentException("Health should be a positive number.");
        if (minDamage <= 0 || maxDamage <= 0) throw new IllegalArgumentException("Damage values should be positive.");
        if (minDamage > maxDamage) throw new IllegalArgumentException("Minimum damage should not exceed maximum damage.");

        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.maxHealth = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void attack(Creature target) {
        int attackModifier = this.attack - target.defense + 1;
        boolean isSuccessful = false;
        for (int i = 0; i < attackModifier; i++) {
            if (Dice.roll() >= 5) {
                isSuccessful = true;
                break;
            }
        }

        if (isSuccessful) {
            int damage = new Random().nextInt(maxDamage - minDamage + 1) + minDamage;
            System.out.println(this.getClass().getSimpleName() + " attacks and deals " + damage + " damage!");
            target.takeDamage(damage);
        } else {
            System.out.println(this.getClass().getSimpleName() + " attacks but misses!");
        }
    }

    public void takeDamage(int damage) {
        if (damage < 0) throw new IllegalArgumentException("Damage should be non-negative.");
        health -= damage;
        if (health < 0) health = 0;
        System.out.println(this.getClass().getSimpleName() + " now has " + health + " health left.");
    }
}
