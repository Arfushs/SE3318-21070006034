import questmanagement.model.*;
import Interfaces.IJoinable;

public class App {
    public static void main(String[] args) {
        // Mentor oluşturma
        Mentor gandalf = new Mentor("Gandalf", "the Grey");

        // Quest oluşturma
        Quest destroyRing = new Quest("Destroy the One Ring", 10, gandalf);
        Quest defendHelmsDeep = new Quest("Defend Helm's Deep", 8, gandalf);

        // Adventurer oluşturma
        Adventurer frodo = new Adventurer("Frodo Baggins", "Ring Bearer", "Hobbit");
        Adventurer aragorn = new Adventurer("Aragorn", "Ranger", "Man");
        Adventurer legolas = new Adventurer("Legolas", "Archer", "Elf");
        Adventurer gimli = new Adventurer("Gimli", "Warrior", "Dwarf");

        // Quest'lere katılım
        frodo.joinQuest(destroyRing);
        aragorn.joinQuest(defendHelmsDeep);
        legolas.joinQuest(defendHelmsDeep);
        gimli.joinQuest(defendHelmsDeep);

        // Bilgi yazdırma
        System.out.println("Adventurer " + frodo.getName() + " hangi quest'lere katıldı:");
        for (Quest q : frodo.getQuests()) {
            System.out.println(" - " + q.getName());
        }

        System.out.println("\nQuest '" + defendHelmsDeep.getName() + "' içinde bulunan adventurerlar:");
        for (Adventurer a : defendHelmsDeep.getAdventurers()) {
            System.out.println(" - " + a.getName());
        }
    }
}