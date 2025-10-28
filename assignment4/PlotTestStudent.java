package assignmentfour;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents student test cases for the Plot class.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class PlotTestStudent {
    private Plot plot1, plot2, plot3, plot4, plot5;

    @Before
    public void setUp() throws Exception {
        plot1 = new Plot();
        plot2 = new Plot(5, 5, 3, 3);
        plot3 = new Plot(plot2);
        plot4 = new Plot(6, 6, 2, 2);
        plot5 = new Plot(10, 10, 5, 5);
    }

    @After
    public void tearDown() throws Exception {
        plot1 = plot2 = plot3 = plot4 = plot5 = null;
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(0, plot1.getX());
        assertEquals(0, plot1.getY());
        assertEquals(1, plot1.getWidth());
        assertEquals(1, plot1.getDepth());
    }

    @Test
    public void testParameterizedConstructor() {
        assertEquals(5, plot2.getX());
        assertEquals(5, plot2.getY());
        assertEquals(3, plot2.getWidth());
        assertEquals(3, plot2.getDepth());
    }

    @Test
    public void testCopyConstructor() {
        assertEquals(plot2.getX(), plot3.getX());
        assertEquals(plot2.getY(), plot3.getY());
        assertEquals(plot2.getWidth(), plot3.getWidth());
        assertEquals(plot2.getDepth(), plot3.getDepth());
    }

    @Test
    public void testOverlapsTrue() {
        // plot4 overlaps with plot2
        assertTrue(plot2.overlaps(plot4));
        assertTrue(plot4.overlaps(plot2));
    }

    @Test
    public void testOverlapsFalse() {
        // plot5 does not overlap with plot2
        assertFalse(plot2.overlaps(plot5));
        assertFalse(plot5.overlaps(plot2));
    }

    @Test
    public void testEncompassesTrue() {
        // plot2 encompasses plot4
        assertTrue(plot2.encompasses(plot4));
    }

    @Test
    public void testEncompassesFalse() {
        // plot4 does not encompass plot2
        assertFalse(plot4.encompasses(plot2));
        // plot2 does not encompass plot5
        assertFalse(plot2.encompasses(plot5));
    }

    @Test
    public void testGettersAndSetters() {
        plot1.setX(10);
        plot1.setY(20);
        plot1.setWidth(5);
        plot1.setDepth(8);
        
        assertEquals(10, plot1.getX());
        assertEquals(20, plot1.getY());
        assertEquals(5, plot1.getWidth());
        assertEquals(8, plot1.getDepth());
    }

    @Test
    public void testToString() {
        assertEquals("5,5,3,3", plot2.toString());
    }
}
