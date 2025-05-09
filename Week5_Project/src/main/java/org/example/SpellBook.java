package org.example;

import java.util.ArrayList;
import java.util.List;

public class SpellBook {
    List<Spell> spellBook;

    public SpellBook() {
        spellBook = new ArrayList<>();
    }

    public void addSpell(Spell spell) {
        spellBook.add(spell);
    }

    /**
     * it is deterministic specification because it has one output per one valid input
     * @param index defines the index of the spell in the list
     * @return Spell exact Spell on the list in index and null if index is invalid
     * requires : index must be in the valid range (0<=index<=spells.size())
     * effects : returns the Spell if exists or null otherwise
     */

    public Spell getSpell(int index) {
        if (index >= 0 && index <= spellBook.size()) {
            return spellBook.get(index);
        } else {
            return null;
        }
    }

    /**
     * these are declarative specifications that give properties of the final outcomes
     * @param prefix prefix that spells starts with
     * @return a list of matching spells that starts with this prefix
     * requires : spell name is not null
     * effects : checks if there is a spell starts with this prefix
     * requires : there exist a spell that starts with this prefix
     * effects : adds the spell to matchingSpells list,
     *              if there is no spell starting with this prefix
     *              returns an empty list
     */

    public List<Spell> getSpellsByPrefix(String prefix) {
        List<Spell> matchingSpellBooks = new ArrayList<>();

        for (Spell spellBook : this.spellBook) {
            if (spellBook.name != null && spellBook.name.startsWith(prefix)) {
                matchingSpellBooks.add(spellBook);
            }
        }
        return matchingSpellBooks;
    }
}
