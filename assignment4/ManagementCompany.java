package assignmentfour;

/**
 * This class represents a management company that manages multiple properties.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class ManagementCompany {
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    private String name;
    private String taxID;
    private double mgmFee;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;

    /**
     * No-arg constructor that creates a ManagementCompany with default values
     */
    public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.mgmFee = 0.0;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }

    /**
     * Parameterized constructor with name, tax ID, and management fee
     * Creates a plot with default values (0,0,MGMT_WIDTH,MGMT_DEPTH)
     * @param name The name of the management company
     * @param taxID The tax ID
     * @param mgmFee The management fee percentage
     */
    public ManagementCompany(String name, String taxID, double mgmFee) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }

    /**
     * Parameterized constructor with name, tax ID, management fee, and plot dimensions
     * @param name The name of the management company
     * @param taxID The tax ID
     * @param mgmFee The management fee percentage
     * @param x The x-coordinate of the plot
     * @param y The y-coordinate of the plot
     * @param width The width of the plot
     * @param depth The depth of the plot
     */
    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(x, y, width, depth);
        this.numberOfProperties = 0;
    }

    /**
     * Copy constructor that creates a new ManagementCompany using the information of the parameter
     * @param otherCompany A ManagementCompany object
     */
    public ManagementCompany(ManagementCompany otherCompany) {
        this.name = otherCompany.name;
        this.taxID = otherCompany.taxID;
        this.mgmFee = otherCompany.mgmFee;
        this.plot = new Plot(otherCompany.plot);
        this.numberOfProperties = otherCompany.numberOfProperties;
        this.properties = new Property[MAX_PROPERTY];
        for (int i = 0; i < otherCompany.numberOfProperties; i++) {
            this.properties[i] = new Property(otherCompany.properties[i]);
        }
    }

    /**
     * Get the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the tax ID
     * @return the tax ID
     */
    public String getTaxID() {
        return taxID;
    }

    /**
     * Set the tax ID
     * @param taxID the tax ID
     */
    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    /**
     * Get the management fee
     * @return the management fee
     */
    public double getMgmFee() {
        return mgmFee;
    }

    /**
     * Set the management fee
     * @param mgmFee the management fee
     */
    public void setMgmFee(double mgmFee) {
        this.mgmFee = mgmFee;
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
     * Get the properties array
     * @return a copy of the properties array
     */
    public Property[] getProperties() {
        Property[] propertiesCopy = new Property[MAX_PROPERTY];
        for (int i = 0; i < numberOfProperties; i++) {
            propertiesCopy[i] = new Property(properties[i]);
        }
        return propertiesCopy;
    }

    /**
     * Get the number of properties
     * @return the number of properties
     */
    public int getPropertiesCount() {
        return numberOfProperties;
    }

    /**
     * Adds a property to the properties array
     * @param property A Property object
     * @return Returns either -1, -2, -3, -4, or the index in the array where the property was added
     */
    public int addProperty(Property property) {
        // Check if property is null
        if (property == null) {
            return -2;
        }

        // Check if array is full
        if (numberOfProperties >= MAX_PROPERTY) {
            return -1;
        }

        // Check if the property's plot is encompassed by the management company's plot
        if (!plot.encompasses(property.getPlot())) {
            return -3;
        }

        // Check if the property's plot overlaps with any existing property's plot
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }

        // Add the property to the array
        properties[numberOfProperties] = new Property(property);
        numberOfProperties++;
        return numberOfProperties - 1;
    }

    /**
     * Adds a property to the properties array
     * @param name The property name
     * @param city The city
     * @param rent The rent amount
     * @param owner The owner
     * @return Returns either -1, -2, -3, -4, or the index in the array where the property was added
     */
    public int addProperty(String name, String city, double rent, String owner) {
        Property property = new Property(name, city, rent, owner);
        return addProperty(property);
    }

    /**
     * Adds a property to the properties array
     * @param name The property name
     * @param city The city
     * @param rent The rent amount
     * @param owner The owner
     * @param x The x-coordinate of the plot
     * @param y The y-coordinate of the plot
     * @param width The width of the plot
     * @param depth The depth of the plot
     * @return Returns either -1, -2, -3, -4, or the index in the array where the property was added
     */
    public int addProperty(String name, String city, double rent, String owner, 
                          int x, int y, int width, int depth) {
        Property property = new Property(name, city, rent, owner, x, y, width, depth);
        return addProperty(property);
    }

    /**
     * Removes (nullifies) the LAST property in the properties array
     */
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    /**
     * Checks if the properties array has reached the maximum capacity
     * @return true if the array is full, false otherwise
     */
    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }

    /**
     * Gets the total rent of all properties
     * @return the total rent
     */
    public double getTotalRent() {
        double totalRent = 0.0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    /**
     * Gets the property with the highest rent amount
     * @return the Property object with the highest rent amount
     */
    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) {
            return null;
        }

        Property highestRentProperty = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                highestRentProperty = properties[i];
            }
        }
        return new Property(highestRentProperty);
    }

    /**
     * Checks if the management fee is valid (between 0 and 100)
     * @return true if the fee is valid, false otherwise
     */
    public boolean isMangementFeeValid() {
        return mgmFee >= 0 && mgmFee <= 100;
    }

    /**
     * Represents the ManagementCompany and its properties in string format
     * @return a String representation of all properties and the total management fee
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("List of the properties for ").append(name).append(", taxID: ").append(taxID).append("\n");
        result.append("______________________________________________________\n");

        for (int i = 0; i < numberOfProperties; i++) {
            result.append(properties[i].toString()).append("\n");
        }

        result.append("______________________________________________________\n");
        result.append("\n");
        result.append(" total management Fee: ");
        
        double totalManagementFee = getTotalRent() * mgmFee / 100.0;
        result.append(String.format("%.2f", totalManagementFee));

        return result.toString();
    }
}
