public class Attraction extends Destination {
    private String type;

    public Attraction(String name, String location, String description, String type) {
        super(name, location, description);
        this.type = type;
    }

    @Override
    public String getType() {
        return "Attraction";
    }

    @Override
    public String toFileFormat() {
        return "Attraction," + getName() + "," + getLocation() + "," + getDescription() + "," + type;
    }

    @Override
    public void displayInfo() {
        System.out.println("[Attraction] " + getName() + " | " + type + " | " + getLocation());
    }
}