package org.example;

// Main application
public class AppClasses {
    public static void main(String[] args) {
        // Creating mentors
        Mentor gandalf = new Mentor("Gandalf", "The Grey");
        Mentor elrond = new Mentor("Elrond", "Lord of Rivendell");

        // Creating adventurers
        Adventurer frodo = new Adventurer("Frodo Baggins", "Ring Bearer", "Hobbit");
        Adventurer aragorn = new Adventurer("Aragorn", "King of Gondor", "Man");
        Adventurer legolas = new Adventurer("Legolas", "Prince of Mirkwood", "Elf");
        Adventurer gimli = new Adventurer("Gimli", "Son of Gloin", "Dwarf");

        // Creating quests
        Quest destroyRing = new Quest("Destroy the One Ring", 10);
        Quest defendHelmsDeep = new Quest("Defend Helm's Deep", 8);

        // Assign mentors
        gandalf.assignQuest(destroyRing);
        elrond.assignQuest(defendHelmsDeep);

        // Adventurers joining quests
        frodo.joinQuest(destroyRing);
        aragorn.joinQuest(defendHelmsDeep);
        legolas.joinQuest(defendHelmsDeep);
        gimli.joinQuest(defendHelmsDeep);

        // Display quests and participants
        System.out.println("Quest: " + destroyRing.name + " (Mentor: " + destroyRing.mentor.getName() + ")");
        System.out.println("Adventurers: " + destroyRing.getAdventurers().stream().map(Character::getName).toList());

        System.out.println("\nQuest: " + defendHelmsDeep.name + " (Mentor: " + defendHelmsDeep.mentor.getName() + ")");
        System.out.println("Adventurers: " + defendHelmsDeep.getAdventurers().stream().map(Character::getName).toList());
    }
}
