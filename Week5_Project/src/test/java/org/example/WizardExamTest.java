package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class WizardExamTest {
    private SpellBook spellBook;
    private Student student;
    private WizardExam wizardExam;

    @BeforeEach
    void setUp() {
        spellBook = new SpellBook();
        for (int i = 0; i < 10; i++) {
            spellBook.addSpell(new Spell("Spell" + i));
        }

        student = new Student("Hermione", 2025, Student.House.Gryffindor);
        wizardExam = new WizardExam(spellBook);
    }

    @Test
    public void testPassReturnsTrueIfAllSpellsKnown() {
        student.learnSpell(spellBook.getSpell(6));
        student.learnSpell(spellBook.getSpell(7));
        student.learnSpell(spellBook.getSpell(8));

        assertTrue(wizardExam.pass(student));
    }

    @Test
    public void testPassReturnsFalseIfAnySpellMissing() {
        student.learnSpell(spellBook.getSpell(6));
        student.learnSpell(spellBook.getSpell(7));

        assertFalse(wizardExam.pass(student));
    }

    @Test
    public void testEvaluatePrintsPass() {
        student.learnSpell(spellBook.getSpell(6));
        student.learnSpell(spellBook.getSpell(7));
        student.learnSpell(spellBook.getSpell(8));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        wizardExam.evaluate(student);
        System.setOut(System.out);

        String result = output.toString().trim();
        assertEquals("Hermione has passed the exam.", result);
    }

    @Test
    public void testEvaluatePrintsFail() {
        student.learnSpell(spellBook.getSpell(6));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        wizardExam.evaluate(student);
        System.setOut(System.out);

        String result = output.toString().trim();
        assertEquals("Hermione has failed the exam.", result);
    }
}
