package org.example;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    int year;
    House house;
    List<Spell> spellBook;

    enum House {Gryffindor, Ravenclaw, Slytherin, Hufflepuff};

    public Student(String name, int year, House house) {
        this.name = name;
        this.year = year;
        this.house = house;
        spellBook = new ArrayList<>();
    }

    /**
     * it is deterministic specification because it has one output per one valid input
     * @param spell spell to add to spellBook
     * @return true if spell added to spellBook and false otherwise
     * requires : spell is not null and does not exist in the spellBook
     * effects : returns true if spell is added to spellBook and false otherwise
     */

    public boolean learnSpell(Spell spell) {
        if (spell == null) {
            return false;
        } else if (!knowsSpell(spell)) {
            spellBook.add(spell);
            System.out.println(this.name + " successfully learned " + spell.name);
            return true;
        } else {
            System.out.println(this.name + " failed to learn " + spell.name);
            return false;
        }
    }

    /**
     * it is deterministic specification because it has one output per one valid input
     * @param spell spell to be checked whether it exist on the spellBook
     * @return true if spell exists on the spellBook and false otherwise
     * requires : spell is not null
     * effects : returns true if spell is already in the book and false otherwise
     */

    public boolean knowsSpell(Spell spell) {
        if (spell == null) {
            return false;
        } else {
            return spellBook.contains(spell);
        }
    }
}
