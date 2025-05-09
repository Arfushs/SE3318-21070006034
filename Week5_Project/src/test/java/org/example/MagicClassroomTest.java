package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MagicClassroomTest {
    private MagicClassroom magicClassroom;
    private Student student1;
    private Student student2;
    private Student student3;
    private Spell spell;

    @BeforeEach
    void setUp() {
        magicClassroom = new MagicClassroom();
        student1 = new Student("John", 2025, Student.House.Gryffindor);
        student2 = new Student("James", 2024, Student.House.Gryffindor);
        student3 = new Student("Dave", 2023, Student.House.Slytherin);
        spell = new Spell("Fireball");
        student1.learnSpell(spell);
        magicClassroom.addStudent(student1);
        magicClassroom.addStudent(student2);
        magicClassroom.addStudent(student3);
    }

    @Test
    public void testValidStudent() {
        magicClassroom.addStudent(student1);
        assertEquals(student1, magicClassroom.findStudent(student1.name));
    }

    @Test
    public void testNullStudent() {
        int sizeBefore = magicClassroom.getSize();
        magicClassroom.addStudent(null);
        assertEquals(sizeBefore, magicClassroom.getSize());
    }

    @Test
    public void testFindByName() {
        assertEquals("John", magicClassroom.findStudent("John").name);
    }

    @Test
    public void testFindBySpell() {
        assertEquals(student1, magicClassroom.findStudentBySpell(spell));
    }

    @Test
    public void testGetStudentsSortedByHouse() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        magicClassroom.getStudentsSortedByHouse();

        System.setOut(originalOut);

        String output = outputStream.toString();
        assertTrue(output.contains("Gryffindor"));
        assertTrue(output.contains("John"));
        assertTrue(output.contains("James"));
        assertTrue(output.contains("Slytherin"));
        assertTrue(output.contains("Dave"));
    }
}
