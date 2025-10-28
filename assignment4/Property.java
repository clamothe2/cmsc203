package assignmentfour;

/**
 * This class represents a rental property with name, city, rent amount, owner, and plot location.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    /**
     * No-arg constructor that creates a Property with default values
     */
    public Property() {
        this.propertyName = "";
        this.city = "";
        this.rentAmount = 0.0;
        this.owner = "";
        this.plot = new Plot();
    }

    /**
     * Copy constructor that creates a new Property using the information of the Property passed to it
     * @param p A Property object
     */
    public Property(Property p) {
        this.propertyName = p.propertyName;
        this.city = p.city;
        this.rentAmount = p.rentAmount;
        this.owner = p.owner;
        this.plot = new Plot(p.plot);
    }

    /**
     * Parameterized constructor without plot information
     * Creates a Property with a default plot (0,0,1,1)
     * @param propertyName The property name
     * @param city The city where the property is located
     * @param rentAmount The monthly rent amount
     * @param owner The owner's name
     */
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot();
    }

    /**
     * Parameterized constructor with plot information
     * @param propertyName The property name
     * @param city The city where the property is located
     * @param rentAmount The monthly rent amount
     * @param owner The owner's name
     * @param x The x-coordinate of the plot
     * @param y The y-coordinate of the plot
     * @param width The width of the plot
     * @param depth The depth of the plot
     */
    public Property(String propertyName, String city, double rentAmount, String owner, 
                    int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    /**
     * Get the property name
     * @return the property name
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Set the property name
     * @param propertyName the property name
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * Get the city
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the city
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the rent amount
     * @return the rent amount
     */
    public double getRentAmount() {
        return rentAmount;
    }

    /**
     * Set the rent amount
     * @param rentAmount the rent amount
     */
    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    /**
     * Get the owner
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Set the owner
     * @param owner the owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Get the plot
     * @return a copy of the plot
     */
    public Plot getPlot() {
        return new Plot(plot);
    }

    /**
     * Set the plot
     * @param plot the plot
     */
    public void setPlot(Plot plot) {
        this.plot = new Plot(plot);
    }

    /**
     * Represents a Property in string format
     * @return a String in the format: propertyName,city,owner,rentAmount
     */
    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}
