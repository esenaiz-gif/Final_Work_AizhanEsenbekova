public class Destination {
    private String name;
    private String location;
    private String description;

    public Destination(String name, String location, String description) {
        this.name = name;
        this.location = location;
        this.description = description;
    }

    public String getName() { return name; }
    public String getLocation() { return location; }
    public String getDescription() { return description; }

    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
    public void setDescription(String description) { this.description = description; }

    public String getType() {
        return "Destination";
    }

    public String toFileFormat() {
        return "Destination," + name + "," + location + "," + description;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + " | Location: " + location + " | " + description);
    }
}