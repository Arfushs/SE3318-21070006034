package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpellBookTest {
    private SpellBook spellBook;
    private Spell spell1;
    private Spell spell2;
    private Spell spell3;

    @BeforeEach
    void setUp() {
        spellBook = new SpellBook();
        spell1 = new Spell("Fireball");
        spell2 = new Spell("Firestorm");
        spell3 = new Spell("Icebolt");
        spellBook.addSpell(spell1);
        spellBook.addSpell(spell2);
        spellBook.addSpell(spell3);
    }

    @Test
    public void testValidIndex() {
        assertEquals(spell2, spellBook.getSpell(1));
    }

    @Test
    public void testInvalidIndex() {
        assertEquals(null, spellBook.getSpell(5));
    }

    @Test
    public void testGetSpellByPrefix() {
        List<Spell> result = spellBook.getSpellsByPrefix("Firestorm");
        assertEquals("Firestorm", result.get(0).name);
    }

    @Test
    public void testEmptyPrefix() {
        List<Spell> result = spellBook.getSpellsByPrefix("");

        assertEquals("Fireball", result.get(0).name);
        assertEquals("Firestorm", result.get(1).name);
        assertEquals("Icebolt", result.get(2).name);
    }

    @Test
    public void testNoMatchingSpells() {
        List<Spell> result = spellBook.getSpellsByPrefix("Icestorm");

        assertTrue(result.isEmpty());
    }
}
