package questmanagement.model;

import java.util.ArrayList;
import java.util.List;

public class Mentor extends Character {
    private List<Quest> questsOverseeing;

    public Mentor(String name, String title) {
        super(name, title);
        this.questsOverseeing = new ArrayList<>();
    }

    public void addQuest(Quest quest) {
        questsOverseeing.add(quest);
    }

    // Getter metodları
    public List<Quest> getQuestsOverseeing() {
        return questsOverseeing;
    }
}