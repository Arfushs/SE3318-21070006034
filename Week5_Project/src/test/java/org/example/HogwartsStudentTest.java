package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HogwartsStudentTest {

    private Student student;
    private Spell spell;
    private Spell nullSpell;

    @BeforeEach
    void setUp() {
        student = new Student("John", 2025, Student.House.Gryffindor);
        spell = new Spell("Fireball");
        student.learnSpell(spell);
    }

    @Test
    public void testLearnNullSpell() {
        assertEquals(false, student.learnSpell(nullSpell));
    }

    @Test
    public void testLearnSpell() {
        if (spell == nullSpell) {
            assertEquals(false, student.learnSpell(spell));
        }
    }

    @Test
    public void testKnowSpell() {
        assertEquals(true, student.knowsSpell(spell));
    }
}
