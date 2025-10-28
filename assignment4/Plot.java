package assignmentfour;

/**
 * This class represents a plot of land with x, y coordinates and dimensions.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    /**
     * No-arg constructor that creates a default Plot with x=0, y=0, width=1, depth=1
     */
    public Plot() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }

    /**
     * Copy constructor that creates a new Plot using the information of the Plot passed to it
     * @param p A Plot object
     */
    public Plot(Plot p) {
        this.x = p.x;
        this.y = p.y;
        this.width = p.width;
        this.depth = p.depth;
    }

    /**
     * Parameterized constructor
     * @param x The x-coordinate of the upper left corner of the plot
     * @param y The y-coordinate of the upper left corner of the plot
     * @param width The horizontal extent of the plot
     * @param depth The vertical extent of the plot
     */
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    /**
     * Determines if this plot overlaps the parameter
     * @param plot A Plot object
     * @return true if the plots overlap, false otherwise
     */
    public boolean overlaps(Plot plot) {
        // Two rectangles do not overlap if one is completely to the left, right, above, or below the other
        // Therefore, they overlap if none of these conditions are true
        
        // Check if this plot is completely to the right of the other plot
        if (this.x >= plot.x + plot.width) {
            return false;
        }
        // Check if this plot is completely to the left of the other plot
        if (this.x + this.width <= plot.x) {
            return false;
        }
        // Check if this plot is completely below the other plot
        if (this.y >= plot.y + plot.depth) {
            return false;
        }
        // Check if this plot is completely above the other plot
        if (this.y + this.depth <= plot.y) {
            return false;
        }
        
        // If none of the above conditions are true, the plots overlap
        return true;
    }

    /**
     * Determines if this plot encompasses the parameter
     * @param plot A Plot object
     * @return true if this plot contains the parameter, false otherwise
     */
    public boolean encompasses(Plot plot) {
        // This plot encompasses the parameter if the parameter's boundaries are within this plot's boundaries
        // The determination is inclusive (edges can touch)
        
        return (plot.x >= this.x && 
                plot.y >= this.y && 
                (plot.x + plot.width) <= (this.x + this.width) && 
                (plot.y + plot.depth) <= (this.y + this.depth));
    }

    /**
     * Get the x-coordinate
     * @return the x-coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Set the x-coordinate
     * @param x the x-coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Get the y-coordinate
     * @return the y-coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Set the y-coordinate
     * @param y the y-coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Get the width
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Set the width
     * @param width the width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Get the depth
     * @return the depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Set the depth
     * @param depth the depth
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Represents a Plot in string format
     * @return a String in the format: x,y,width,depth
     */
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
