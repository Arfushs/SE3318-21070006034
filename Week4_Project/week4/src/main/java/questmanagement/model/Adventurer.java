package questmanagement.model;

import Interfaces.IJoinable;
import java.util.ArrayList;
import java.util.List;

public class Adventurer extends Character implements IJoinable {
    private String race;
    private List<Quest> quests;

    public Adventurer(String name, String title, String race) {
        super(name, title);
        this.race = race;
        this.quests = new ArrayList<>();
    }

    @Override
    public void joinQuest(Quest quest) {
        // Adventurer quest listesine ekleniyor
        quests.add(quest);
        // Quest'e de bu adventurer ekleniyor
        quest.addAdventurer(this);
    }

    // Getter metodları
    public String getRace() {
        return race;
    }

    public List<Quest> getQuests() {
        return quests;
    }
}