package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            Player player = new Player(15, 10, 100, 5, 10);
            Monster monster = new Monster(12, 8, 80, 4, 9);

            System.out.println("The game begins!");
            System.out.println("Player's Health: " + player.health);
            System.out.println("Monster's Health: " + monster.health);
            System.out.println("-----------------------");

            while (player.isAlive() && monster.isAlive()) {
                player.attack(monster);
                if (monster.isAlive()) monster.attack(player);
            }

            System.out.println("-----------------------");
            if (player.isAlive()) {
                System.out.println("Player wins!");
            } else {
                System.out.println("Monster wins!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
