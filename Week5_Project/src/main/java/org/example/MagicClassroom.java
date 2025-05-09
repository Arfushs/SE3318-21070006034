package org.example;

import java.util.ArrayList;
import java.util.List;

public class MagicClassroom {
    List<Student> classroom;

    public MagicClassroom() {
        classroom = new ArrayList<>();
    }

    /**
     * it is deterministic specification because it has one output per one valid input
     * @param student
     * requires : there is no preconditions
     * effects : adds student to classroom
     */

    public void addStudent(Student student) {
        if (student != null) {
            classroom.add(student);
        }
    }

    /**
     * it is deterministic specification because it has one output per one valid input
     * @param name the name of the student we are searching for
     * @return first student whose name is equal to the given name
     * requires : there may be or not may not be a student that has this name
     * effects : returns student with that name and null otherwise
     */

    public Student findStudent(String name) {
        for (Student student : classroom) {
            if (student.name.equals(name)) {
                return student;
            }
        }
        return null;
    }

    /**
     * it is deterministic specification because it has one output per one valid input
     * @param spell the spell that student knows which we are searching
     * @return first student who knows the given spell
     * requires : there may be or may not be a student who knows the given spell
     * effects : returns the first student who knows the given spell and null otherwise
     */

    public Student findStudentBySpell(Spell spell) {
        for (Student student : classroom) {
            if (student.knowsSpell(spell)) {
                return student;
            }
        }
        return null;
    }

    /**
     * it is declarative specification
     * effects : prints out student names, grouped and ordered by their houses
     */

    public void getStudentsSortedByHouse() {
        for (Student.House house : Student.House.values()) {
            System.out.println(house);
            System.out.println("-------------");
            for (Student student : classroom) {
                System.out.println(student.name);
            }
        }
    }

    /**
     * it is declarative specification
     * @param house the house for which to list student names
     * effects : prints out the student names that belongs to the given house
     */

    public void getStudentsByHouse(Student.House house) {
        for (Student student : classroom) {
            if (student.house == house) {
                System.out.println(student.name);
            }
        }
    }

    public int getSize() {
        return classroom.size();
    }
}
