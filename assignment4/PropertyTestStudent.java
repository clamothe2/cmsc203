package assignmentfour;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents student test cases for the Property class.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class PropertyTestStudent {
    private Property property1, property2, property3;

    @Before
    public void setUp() throws Exception {
        property1 = new Property();
        property2 = new Property("Sunset Villa", "Miami", 3500.0, "John Doe");
        property3 = new Property("Ocean View", "Tampa", 4200.0, "Jane Smith", 2, 3, 4, 5);
    }

    @After
    public void tearDown() throws Exception {
        property1 = property2 = property3 = null;
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals("", property1.getPropertyName());
        assertEquals("", property1.getCity());
        assertEquals(0.0, property1.getRentAmount(), 0.001);
        assertEquals("", property1.getOwner());
        assertNotNull(property1.getPlot());
    }

    @Test
    public void testParameterizedConstructorWithoutPlot() {
        assertEquals("Sunset Villa", property2.getPropertyName());
        assertEquals("Miami", property2.getCity());
        assertEquals(3500.0, property2.getRentAmount(), 0.001);
        assertEquals("John Doe", property2.getOwner());
        // Default plot should be 0,0,1,1
        assertEquals(0, property2.getPlot().getX());
        assertEquals(0, property2.getPlot().getY());
        assertEquals(1, property2.getPlot().getWidth());
        assertEquals(1, property2.getPlot().getDepth());
    }

    @Test
    public void testParameterizedConstructorWithPlot() {
        assertEquals("Ocean View", property3.getPropertyName());
        assertEquals("Tampa", property3.getCity());
        assertEquals(4200.0, property3.getRentAmount(), 0.001);
        assertEquals("Jane Smith", property3.getOwner());
        assertEquals(2, property3.getPlot().getX());
        assertEquals(3, property3.getPlot().getY());
        assertEquals(4, property3.getPlot().getWidth());
        assertEquals(5, property3.getPlot().getDepth());
    }

    @Test
    public void testCopyConstructor() {
        Property propertyCopy = new Property(property3);
        assertEquals(property3.getPropertyName(), propertyCopy.getPropertyName());
        assertEquals(property3.getCity(), propertyCopy.getCity());
        assertEquals(property3.getRentAmount(), propertyCopy.getRentAmount(), 0.001);
        assertEquals(property3.getOwner(), propertyCopy.getOwner());
        assertEquals(property3.getPlot().getX(), propertyCopy.getPlot().getX());
        assertEquals(property3.getPlot().getY(), propertyCopy.getPlot().getY());
    }

    @Test
    public void testGettersAndSetters() {
        property1.setPropertyName("Test Property");
        property1.setCity("Orlando");
        property1.setRentAmount(2500.0);
        property1.setOwner("Test Owner");
        
        assertEquals("Test Property", property1.getPropertyName());
        assertEquals("Orlando", property1.getCity());
        assertEquals(2500.0, property1.getRentAmount(), 0.001);
        assertEquals("Test Owner", property1.getOwner());
    }

    @Test
    public void testToString() {
        assertEquals("Sunset Villa,Miami,John Doe,3500.0", property2.toString());
    }
}
