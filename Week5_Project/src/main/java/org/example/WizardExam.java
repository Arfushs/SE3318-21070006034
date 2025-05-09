package org.example;

import java.util.ArrayList;
import java.util.List;

public class WizardExam {
    List<Spell> examSpell;

    public WizardExam(SpellBook spellBook) {
        examSpell = new ArrayList<>();
        examSpell.add(spellBook.getSpell(6));
        examSpell.add(spellBook.getSpell(7));
        examSpell.add(spellBook.getSpell(8));
    }

    /**
     * It is a deterministic specification because there is only one valid output per valid input
     * @param student the student whose knowledge of spells is being checked
     * @return true if student knows the spells in the examSpell and false otherwise
     * requires : there may be or may not be a student who knows all spells in the examSpell
     * effects : determines if a student passes the WizardExam based on their spell knowledge
     */

    public boolean pass(Student student) {
        for (Spell spell : examSpell) {
            if (!student.knowsSpell(spell)) {
                return false;
            }
        }
        return true;
    }

    /**
     * It is a deterministic specification because there is only one valid output per valid input
     * @param student the student whose grades should be listed
     * effects : evaluates the grade of the student's exam
     */

    public void evaluate(Student student) {
        if (pass(student)) {
            System.out.println(student.name + " has passed the exam.");
        } else {
            System.out.println(student.name + " has failed the exam.");
        }
    }
}
