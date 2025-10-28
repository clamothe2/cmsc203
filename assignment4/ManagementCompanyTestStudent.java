package assignmentfour;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents student test cases for the ManagementCompany class.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class ManagementCompanyTestStudent {
    private ManagementCompany company1, company2;
    private Property property1, property2, property3, property4, property5, property6;

    @Before
    public void setUp() throws Exception {
        company1 = new ManagementCompany("ABC Properties", "123456789", 10.0);
        company2 = new ManagementCompany("XYZ Realty", "987654321", 5.0, 0, 0, 15, 15);
        
        property1 = new Property("Park Place", "Boston", 3000.0, "Owner1", 1, 1, 2, 2);
        property2 = new Property("Boardwalk", "Miami", 4000.0, "Owner2", 4, 1, 2, 2);
        property3 = new Property("Main Street", "Seattle", 3500.0, "Owner3", 1, 4, 2, 2);
        property4 = new Property("Oak Avenue", "Denver", 2800.0, "Owner4", 4, 4, 2, 2);
        property5 = new Property("Elm Street", "Austin", 3200.0, "Owner5", 7, 1, 2, 2);
        property6 = new Property("Maple Drive", "Portland", 2900.0, "Owner6", 1, 7, 2, 2);
    }

    @After
    public void tearDown() throws Exception {
        company1 = company2 = null;
        property1 = property2 = property3 = property4 = property5 = property6 = null;
    }

    @Test
    public void testDefaultConstructor() {
        ManagementCompany company = new ManagementCompany();
        assertEquals("", company.getName());
        assertEquals("", company.getTaxID());
        assertEquals(0.0, company.getMgmFee(), 0.001);
        assertEquals(0, company.getPropertiesCount());
    }

    @Test
    public void testParameterizedConstructor() {
        assertEquals("ABC Properties", company1.getName());
        assertEquals("123456789", company1.getTaxID());
        assertEquals(10.0, company1.getMgmFee(), 0.001);
        assertEquals(0, company1.getPropertiesCount());
    }

    @Test
    public void testAddPropertySuccess() {
        int result = company1.addProperty(property1);
        assertEquals(0, result);
        assertEquals(1, company1.getPropertiesCount());
    }

    @Test
    public void testAddPropertyWithStringParametersSuccess() {
        int result = company1.addProperty("Test Property", "Boston", 2500.0, "Test Owner");
        assertEquals(0, result);
        assertEquals(1, company1.getPropertiesCount());
    }

    @Test
    public void testAddPropertyWithPlotParametersSuccess() {
        int result = company1.addProperty("Test Property", "Boston", 2500.0, "Test Owner", 1, 1, 2, 2);
        assertEquals(0, result);
        assertEquals(1, company1.getPropertiesCount());
    }

    @Test
    public void testAddPropertyNull() {
        int result = company1.addProperty(null);
        assertEquals(-2, result);
        assertEquals(0, company1.getPropertiesCount());
    }

    @Test
    public void testAddPropertyArrayFull() {
        company1.addProperty(property1);
        company1.addProperty(property2);
        company1.addProperty(property3);
        company1.addProperty(property4);
        company1.addProperty(property5);
        
        int result = company1.addProperty(property6);
        assertEquals(-1, result);
    }

    @Test
    public void testAddPropertyNotEncompassed() {
        Property outsideProperty = new Property("Outside", "City", 1000.0, "Owner", 11, 11, 2, 2);
        int result = company1.addProperty(outsideProperty);
        assertEquals(-3, result);
    }

    @Test
    public void testAddPropertyOverlaps() {
        company1.addProperty(property1);
        Property overlappingProperty = new Property("Overlap", "City", 1000.0, "Owner", 2, 2, 2, 2);
        int result = company1.addProperty(overlappingProperty);
        assertEquals(-4, result);
    }

    @Test
    public void testGetTotalRent() {
        company1.addProperty(property1);
        company1.addProperty(property2);
        company1.addProperty(property3);
        
        double expectedTotal = 3000.0 + 4000.0 + 3500.0;
        assertEquals(expectedTotal, company1.getTotalRent(), 0.001);
    }

    @Test
    public void testGetHighestRentProperty() {
        company1.addProperty(property1);
        company1.addProperty(property2);
        company1.addProperty(property3);
        
        Property highest = company1.getHighestRentProperty();
        assertEquals("Boardwalk", highest.getPropertyName());
        assertEquals(4000.0, highest.getRentAmount(), 0.001);
    }

    @Test
    public void testRemoveLastProperty() {
        company1.addProperty(property1);
        company1.addProperty(property2);
        assertEquals(2, company1.getPropertiesCount());
        
        company1.removeLastProperty();
        assertEquals(1, company1.getPropertiesCount());
    }

    @Test
    public void testIsPropertiesFull() {
        assertFalse(company1.isPropertiesFull());
        
        company1.addProperty(property1);
        company1.addProperty(property2);
        company1.addProperty(property3);
        company1.addProperty(property4);
        company1.addProperty(property5);
        
        assertTrue(company1.isPropertiesFull());
    }

    @Test
    public void testIsMangementFeeValid() {
        assertTrue(company1.isMangementFeeValid());
        
        ManagementCompany invalidCompany = new ManagementCompany("Test", "123", 150.0);
        assertFalse(invalidCompany.isMangementFeeValid());
        
        ManagementCompany invalidCompany2 = new ManagementCompany("Test", "123", -5.0);
        assertFalse(invalidCompany2.isMangementFeeValid());
    }

    @Test
    public void testToString() {
        company1.addProperty(property1);
        String result = company1.toString();
        
        assertTrue(result.contains("ABC Properties"));
        assertTrue(result.contains("123456789"));
        assertTrue(result.contains("Park Place"));
        assertTrue(result.contains("total management Fee"));
    }

    @Test
    public void testCopyConstructor() {
        company1.addProperty(property1);
        company1.addProperty(property2);
        
        ManagementCompany companyCopy = new ManagementCompany(company1);
        assertEquals(company1.getName(), companyCopy.getName());
        assertEquals(company1.getTaxID(), companyCopy.getTaxID());
        assertEquals(company1.getMgmFee(), companyCopy.getMgmFee(), 0.001);
        assertEquals(company1.getPropertiesCount(), companyCopy.getPropertiesCount());
    }
}
