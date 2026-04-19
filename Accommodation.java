public class Accommodation extends Destination {
    private double price;

    public Accommodation(String name, String location, String description, double price) {
        super(name, location, description);
        this.price = price;
    }

    @Override
    public String getType() {
        return "Accommodation";
    }

    @Override
    public String toFileFormat() {
        return "Accommodation," + getName() + "," + getLocation() + "," + getDescription() + "," + price;
    }

    @Override
    public void displayInfo() {
        System.out.println("[Accommodation] " + getName() + " | $" + price + " | " + getLocation());
    }
}