package org.example;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Student student1 = new Student("Harry Potter", 2012, Student.House.Gryffindor);
        Student student2 = new Student("Harmonie Granger", 2008, Student.House.Gryffindor);
        Student student3 = new Student("Draco Malfoy", 2009, Student.House.Slytherin);

        Spell spell1 = new Spell("Expelliarmus");
        Spell spell2 = new Spell("Patronus Charm");
        Spell spell3 = new Spell("Leviosa");
        Spell spell4 = new Spell("Sectumsempra");
        Spell spell5 = new Spell("Petrificus Totalus");
        Spell spell6 = new Spell("Wingardium Leviosa");
        Spell spell7 = new Spell("Fireball");
        Spell spell8 = new Spell("Firebolt");
        Spell spell9 = new Spell("Firestorm");

        SpellBook spellBook = new SpellBook();
        spellBook.addSpell(spell1);
        spellBook.addSpell(spell2);
        spellBook.addSpell(spell3);
        spellBook.addSpell(spell4);
        spellBook.addSpell(spell5);
        spellBook.addSpell(spell6);
        spellBook.addSpell(spell7);
        spellBook.addSpell(spell8);
        spellBook.addSpell(spell9);

        student1.learnSpell(spellBook.getSpell(0));
        student1.learnSpell(spellBook.getSpell(2));
        student1.learnSpell(spellBook.getSpell(4));
        student1.learnSpell(spellBook.getSpell(5));

        student2.learnSpell(spellBook.getSpell(0));
        student2.learnSpell(spellBook.getSpell(2));
        student2.learnSpell(spellBook.getSpell(4));

        student3.learnSpell(spellBook.getSpell(0));
        student3.learnSpell(spellBook.getSpell(4));
        student3.learnSpell(spellBook.getSpell(6));
        student3.learnSpell(spellBook.getSpell(7));
        student3.learnSpell(spellBook.getSpell(8));

        List<Spell> filteredSpells = spellBook.getSpellsByPrefix("Fire");
        for (Spell spell : filteredSpells) {
            System.out.println(spell.name);
        }

        MagicClassroom classroom = new MagicClassroom();
        classroom.addStudent(student1);
        classroom.addStudent(student2);
        classroom.addStudent(student3);

        System.out.println((classroom.findStudent(student3.name)).name);
        System.out.println((classroom.findStudentBySpell(spell3)).name);

        WizardExam wizardExam = new WizardExam(spellBook);
        wizardExam.evaluate(student1);
        wizardExam.evaluate(student2);
        wizardExam.evaluate(student3);

        Duel.start(student1, student3, spell4);
        Duel.start(student1, student3, spell6);
    }
}
