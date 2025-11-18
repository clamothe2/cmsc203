package assignment5;

import static org.junit.Assert.*;
import org.junit.Test;

public class HolidayBonusTestStudent {

    private double[][] data = {
            { 1.0, 2.0, 3.0 },
            { 4.0, 5.0 },
            { 6.0, 7.0, 8.0 }
    };

    @Test
    public void testCalculateHolidayBonus() {
        double[] bonus = HolidayBonus.calculateHolidayBonus(data);

        // Expected logic:
        // Column 0: highest=6 → +5000, lowest=1 → +1000, middle=4 → +2000
        // Column 1: highest=7 → +5000, lowest=2 → +1000, middle=5 → +2000
        // Column 2: highest=8 → +5000, lowest=3 → +1000 (only 2 stores here)

        assertEquals(1_000 + 1_000 + 1_000, bonus[0], 0.001); // store 0
        assertEquals(2_000 + 2_000, bonus[1], 0.001);         // store 1
        assertEquals(5_000 + 5_000 + 5_000, bonus[2], 0.001); // store 2
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double total = HolidayBonus.calculateTotalHolidayBonus(data);

        // Sum of expected bonuses = 1,000 + 1,000 + 1,000 + 2,000 + 2,000 + 15,000
        double expected = 22_000;
        assertEquals(expected, total, 0.001);
    }
}
