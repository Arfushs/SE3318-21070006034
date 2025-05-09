package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class DuelTest {
    private Student s1;
    private Student s2;
    private Spell knownSpell;
    private Spell unknownSpell;

    @BeforeEach
    void setUp() {
        s1 = new Student("Harry", 2025, Student.House.Gryffindor);
        s2 = new Student("Draco", 2025, Student.House.Slytherin);

        knownSpell = new Spell("Expelliarmus");
        unknownSpell = new Spell("Unknownus");
        s1.learnSpell(knownSpell);
        s2.learnSpell(knownSpell);
    }

    @Test
    public void testBothStudentsKnowSpell() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Duel.start(s1, s2, knownSpell);
        System.setOut(System.out);

        String result = output.toString().trim();
        assertTrue(result.contains("wins the duel!") || result.contains("It's a draw!"));
    }

    @Test
    public void testOnlyFirstStudentKnowsSpell() {
        s2 = new Student("Neville", 2025, Student.House.Gryffindor);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Duel.start(s1, s2, knownSpell);
        System.setOut(System.out);

        assertEquals("Harry wins the duel!", output.toString().trim());
    }

    @Test
    public void testOnlySecondStudentKnowsSpell() {
        s1 = new Student("Ron", 2025, Student.House.Gryffindor);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Duel.start(s1, s2, knownSpell);
        System.setOut(System.out);

        assertEquals("Draco wins the duel!", output.toString().trim());
    }

    @Test
    public void testNeitherStudentKnowsSpell() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Duel.start(s1, s2, unknownSpell);
        System.setOut(System.out);

        assertEquals("It's a draw!", output.toString().trim());
    }

    @Test
    void testNullInputs() {
        Student s1 = new Student("Harry", 2024, Student.House.Gryffindor);
        Student s2 = new Student("Draco", 2025, Student.House.Slytherin);
        Spell spell = new Spell("Expelliarmus");

        assertThrows(NullPointerException.class, () -> Duel.start(null, s2, spell));
        assertThrows(NullPointerException.class, () -> Duel.start(s1, null, spell));
        assertThrows(NullPointerException.class, () -> Duel.start(s1, s2, null));
    }
}
