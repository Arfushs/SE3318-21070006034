package org.example;

import java.util.ArrayList;
import java.util.List;

// Interface for entities that can join quests
interface Joinable {
    void joinQuest(Quest quest);
}

// Base Character class
abstract class Character {
    protected String name;
    protected String title;

    public Character(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public String getName() { return name; }
    public String getTitle() { return title; }
}

// Mentor class
class Mentor extends Character {
    private List<Quest> quests;

    public Mentor(String name, String title) {
        super(name, title);
        this.quests = new ArrayList<>();
    }

    public void assignQuest(Quest quest) {
        quests.add(quest);
        quest.setMentor(this);
    }

    public List<Quest> getQuests() {
        return quests;
    }
}

// Adventurer class implementing Joinable
class Adventurer extends Character implements Joinable {
    private String race;
    private List<Quest> quests;

    public Adventurer(String name, String title, String race) {
        super(name, title);
        this.race = race;
        this.quests = new ArrayList<>();
    }

    @Override
    public void joinQuest(Quest quest) {
        if (!quests.contains(quest)) {
            quests.add(quest);
            quest.addAdventurer(this);
        }
    }

    public List<Quest> getQuests() {
        return quests;
    }
}

// Quest class
class Quest {
    public String name;
    private int difficultyLevel;
    public Mentor mentor;
    private List<Adventurer> adventurers;

    public Quest(String name, int difficultyLevel) {
        this.name = name;
        this.difficultyLevel = difficultyLevel;
        this.adventurers = new ArrayList<>();
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public void addAdventurer(Adventurer adventurer) {
        adventurers.add(adventurer);
    }

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }
}

