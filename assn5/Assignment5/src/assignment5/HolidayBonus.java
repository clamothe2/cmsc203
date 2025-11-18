package assignment5;

/*
 * Class: CMSC203
 * Instructor:
 * Description: Calculates holiday bonuses for each store given a ragged
 *              array of sales. Uses fixed bonus amounts for highest,
 *              lowest, and all other qualifying stores in each category.
 * Due: MM/DD/YYYY
 * Platform/compiler: Eclipse
 * 
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * 
 * Print your Name here: Carlos Lamothe
 */

public class HolidayBonus {

    // Bonus amounts (in dollars)
    public static final double HIGH_BONUS  = 5000.0; // highest in category
    public static final double LOW_BONUS   = 1000.0; // lowest in category
    public static final double OTHER_BONUS = 2000.0; // all other positive stores

    /**
     * Calculates the holiday bonus for each store.
     * 
     * Rules:
     * - Work column by column (each column is a category).
     * - Only positive sales values are eligible for bonuses.
     * - If no store has positive sales in a category, no one gets a bonus in that category.
     * - If exactly one store has positive sales in a category, that store gets HIGH_BONUS only.
     * - If 2+ stores have positive sales:
     *      highest value in the column gets HIGH_BONUS
     *      lowest positive value gets LOW_BONUS
     *      all other positive stores get OTHER_BONUS
     * - Zero or negative sales get no bonus in that category.
     *
     * @param data ragged 2D array of sales by store and category
     * @return an array of bonuses for each store (same number of rows as data)
     */
    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];

        // Find the maximum number of columns (since it is ragged)
        int maxColumns = 0;
        for (int r = 0; r < data.length; r++) {
            if (data[r].length > maxColumns) {
                maxColumns = data[r].length;
            }
        }

        // Process each column (category)
        for (int col = 0; col < maxColumns; col++) {

            // First pass: find highest and lowest positive sales in this column
            double highest = Double.NEGATIVE_INFINITY;
            double lowest = Double.POSITIVE_INFINITY;
            int positiveCount = 0;

            for (int r = 0; r < data.length; r++) {
                if (col < data[r].length) {
                    double value = data[r][col];
                    if (value > 0) {  // only positive values are eligible
                        positiveCount++;
                        if (value > highest) {
                            highest = value;
                        }
                        if (value < lowest) {
                            lowest = value;
                        }
                    }
                }
            }

            // If no positive values in this category, skip it
            if (positiveCount == 0) {
                continue;
            }

            // Second pass: assign bonuses based on the rules
            for (int r = 0; r < data.length; r++) {
                if (col >= data[r].length) {
                    continue;
                }

                double value = data[r][col];

                // Non-positive sales get no bonus
                if (value <= 0) {
                    continue;
                }

                if (positiveCount == 1) {
                    // Only one positive store: that store gets HIGH_BONUS only.
                    if (value == highest) {
                        bonuses[r] += HIGH_BONUS;
                    }
                } else {
                    // 2+ positive stores: use highest / lowest / other logic
                    if (value == highest) {
                        bonuses[r] += HIGH_BONUS;
                    } else if (value == lowest) {
                        bonuses[r] += LOW_BONUS;
                    } else {
                        bonuses[r] += OTHER_BONUS;
                    }
                }
            }
        }

        return bonuses;
    }

    /**
     * Calculates the total of all holiday bonuses for the district.
     * 
     * @param data ragged 2D array of sales
     * @return total holiday bonuses
     */
    public static double calculateTotalHolidayBonus(double[][] data) {
        double[] bonuses = calculateHolidayBonus(data);
        double total = 0;

        for (int i = 0; i < bonuses.length; i++) {
            total += bonuses[i];
        }

        return total;
    }
}
