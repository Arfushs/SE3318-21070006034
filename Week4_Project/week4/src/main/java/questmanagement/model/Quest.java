package questmanagement.model;

import java.util.ArrayList;
import java.util.List;

public class Quest {
    private String name;
    private int difficultyLevel;
    private Mentor mentor;
    private List<Adventurer> adventurers;

    public Quest(String name, int difficultyLevel, Mentor mentor) {
        this.name = name;
        this.difficultyLevel = difficultyLevel;
        this.mentor = mentor;
        this.adventurers = new ArrayList<>();
        // Oluşturulan quest, mentor tarafından da yönetilsin
        mentor.addQuest(this);
    }

    // Getter metodları
    public String getName() {
        return name;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }

    // Quest'e bir adventurer eklemek için
    public void addAdventurer(Adventurer adventurer) {
        if (!adventurers.contains(adventurer)) {
            adventurers.add(adventurer);
        }
    }
}