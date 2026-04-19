public class Activity extends Destination {
    private String difficulty;

    public Activity(String name, String location, String description, String difficulty) {
        super(name, location, description);
        this.difficulty = difficulty;
    }

    @Override
    public String getType() {
        return "Activity";
    }

    @Override
    public String toFileFormat() {
        return "Activity," + getName() + "," + getLocation() + "," + getDescription() + "," + difficulty;
    }

    @Override
    public void displayInfo() {
        System.out.println("[Activity] " + getName() + " | Difficulty: " + difficulty);
    }
}