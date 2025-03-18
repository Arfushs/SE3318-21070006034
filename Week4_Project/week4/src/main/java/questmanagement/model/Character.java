package questmanagement.model;

public abstract class Character {
    protected String name;
    protected String title;

    public Character(String name, String title) {
        this.name = name;
        this.title = title;
    }

    // Getter ve Setter metodları
    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}