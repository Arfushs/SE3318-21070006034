package org.example;

import java.util.Random;

public class Duel {
    public static void start(Student s1, Student s2, Spell spell) {
        if (s1 == null || s2 == null || spell == null) {
            throw new NullPointerException("Parameters cannot be null.");
        }

        if (!s1.knowsSpell(spell) && !s2.knowsSpell(spell)) {
            System.out.println("It's a draw!");
        } else if (s1.knowsSpell(spell) && !s2.knowsSpell(spell)) {
            System.out.println(s1.name + " wins the duel!");
        } else if (!s1.knowsSpell(spell) && s2.knowsSpell(spell)) {
            System.out.println(s2.name + " wins the duel!");
        } else {
            Random random = new Random();
            int s1Strength = random.nextInt(100);
            int s2Strength = random.nextInt(100);

            if (s1Strength > s2Strength) {
                System.out.println(s1.name + " wins the duel!");
            } else if (s1Strength < s2Strength) {
                System.out.println(s2.name + " wins the duel!");
            } else {
                System.out.println("It's a draw!");
            }
        }
    }
}
