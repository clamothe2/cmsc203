package assignment5;

/*
 * Class: CMSC203
 * Instructor:
 * Description: Utility class for working with two-dimensional ragged arrays
 *              of doubles (reading/writing files and doing various calculations).
 * Due: MM/DD/YYYY
 * Platform/compiler: 
 * 
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * 
 * Print your Name here:
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

    /**
     * Reads a file of doubles into a two-dimensional ragged array.
     * One row per line, values separated by spaces.
     * 
     * @param file the file to read from
     * @return a two-dimensional ragged array of doubles
     * @throws FileNotFoundException if the file cannot be opened
     */
    public static double[][] readFile(File file) throws FileNotFoundException {
        ArrayList<double[]> rows = new ArrayList<>();
        Scanner in = new Scanner(file);

        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            if (line.length() == 0) {
                continue;
            }

            String[] tokens = line.split(" ");
            ArrayList<Double> values = new ArrayList<>();

            for (String token : tokens) {
                if (token.trim().length() > 0) {
                    values.add(Double.parseDouble(token));
                }
            }

            double[] row = new double[values.size()];
            for (int i = 0; i < values.size(); i++) {
                row[i] = values.get(i);
            }
            rows.add(row);
        }

        in.close();

        double[][] data = new double[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            data[i] = rows.get(i);
        }

        return data;
    }

    /**
     * Writes a two-dimensional ragged array of doubles to a file.
     * Each row is on its own line; values separated by a single space.
     * 
     * @param data the two-dimensional ragged array of doubles
     * @param file the file to write to
     * @throws FileNotFoundException if the file cannot be opened for writing
     */
    public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(file);

        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                out.print(data[r][c]);
                if (c < data[r].length - 1) {
                    out.print(" ");
                }
            }
            out.println();
        }

        out.close();
    }

    /**
     * Returns the total of all elements in the two-dimensional array.
     * 
     * @param data the two-dimensional array
     * @return total of all elements
     */
    public static double getTotal(double[][] data) {
        double total = 0;

        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                total += data[r][c];
            }
        }

        return total;
    }

    /**
     * Returns the average of all elements in the two-dimensional array.
     * 
     * @param data the two-dimensional array
     * @return average of all elements
     */
    public static double getAverage(double[][] data) {
        double total = 0;
        int count = 0;

        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                total += data[r][c];
                count++;
            }
        }

        if (count == 0) {
            return 0;
        }

        return total / count;
    }

    /**
     * Returns the total of the elements in a given row.
     * Row index 0 is the first row.
     * 
     * @param data the two-dimensional array
     * @param row the row index
     * @return total for that row
     */
    public static double getRowTotal(double[][] data, int row) {
        double total = 0;

        for (int c = 0; c < data[row].length; c++) {
            total += data[row][c];
        }

        return total;
    }

    /**
     * Returns the total of the elements in a given column.
     * Column index 0 is the first column.
     * If a row does not have this column, that row is skipped.
     * 
     * @param data the two-dimensional array
     * @param col the column index
     * @return total for that column
     */
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;

        for (int r = 0; r < data.length; r++) {
            if (col < data[r].length) {
                total += data[r][col];
            }
        }

        return total;
    }

    /**
     * Returns the highest value in a given row.
     * 
     * @param data the two-dimensional array
     * @param row the row index
     * @return highest value in that row
     */
    public static double getHighestInRow(double[][] data, int row) {
        double highest = data[row][0];

        for (int c = 1; c < data[row].length; c++) {
            if (data[row][c] > highest) {
                highest = data[row][c];
            }
        }

        return highest;
    }

    /**
     * Returns the index of the highest value in a given row.
     * 
     * @param data the two-dimensional array
     * @param row the row index
     * @return index of the highest value in that row
     */
    public static int getHighestInRowIndex(double[][] data, int row) {
        double highest = data[row][0];
        int index = 0;

        for (int c = 1; c < data[row].length; c++) {
            if (data[row][c] > highest) {
                highest = data[row][c];
                index = c;
            }
        }

        return index;
    }

    /**
     * Returns the lowest value in a given row.
     * 
     * @param data the two-dimensional array
     * @param row the row index
     * @return lowest value in that row
     */
    public static double getLowestInRow(double[][] data, int row) {
        double lowest = data[row][0];

        for (int c = 1; c < data[row].length; c++) {
            if (data[row][c] < lowest) {
                lowest = data[row][c];
            }
        }

        return lowest;
    }

    /**
     * Returns the index of the lowest value in a given row.
     * 
     * @param data the two-dimensional array
     * @param row the row index
     * @return index of the lowest value in that row
     */
    public static int getLowestInRowIndex(double[][] data, int row) {
        double lowest = data[row][0];
        int index = 0;

        for (int c = 1; c < data[row].length; c++) {
            if (data[row][c] < lowest) {
                lowest = data[row][c];
                index = c;
            }
        }

        return index;
    }

    /**
     * Returns the highest value in a given column.
     * Only rows that actually have that column are considered.
     * 
     * @param data the two-dimensional array
     * @param col the column index
     * @return highest value in that column
     */
    public static double getHighestInColumn(double[][] data, int col) {
        boolean found = false;
        double highest = 0;

        for (int r = 0; r < data.length; r++) {
            if (col < data[r].length) {
                if (!found) {
                    highest = data[r][col];
                    found = true;
                } else if (data[r][col] > highest) {
                    highest = data[r][col];
                }
            }
        }

        return highest;
    }

    /**
     * Returns the index of the row that has the highest value in a given column.
     * Only rows that actually have that column are considered.
     * 
     * @param data the two-dimensional array
     * @param col the column index
     * @return row index of the highest value in that column
     */
    public static int getHighestInColumnIndex(double[][] data, int col) {
        boolean found = false;
        double highest = 0;
        int index = -1;

        for (int r = 0; r < data.length; r++) {
            if (col < data[r].length) {
                if (!found) {
                    highest = data[r][col];
                    index = r;
                    found = true;
                } else if (data[r][col] > highest) {
                    highest = data[r][col];
                    index = r;
                }
            }
        }

        return index;
    }

    /**
     * Returns the lowest value in a given column.
     * Only rows that actually have that column are considered.
     * 
     * @param data the two-dimensional array
     * @param col the column index
     * @return lowest value in that column
     */
    public static double getLowestInColumn(double[][] data, int col) {
        boolean found = false;
        double lowest = 0;

        for (int r = 0; r < data.length; r++) {
            if (col < data[r].length) {
                if (!found) {
                    lowest = data[r][col];
                    found = true;
                } else if (data[r][col] < lowest) {
                    lowest = data[r][col];
                }
            }
        }

        return lowest;
    }

    /**
     * Returns the index of the row that has the lowest value in a given column.
     * Only rows that actually have that column are considered.
     * 
     * @param data the two-dimensional array
     * @param col the column index
     * @return row index of the lowest value in that column
     */
    public static int getLowestInColumnIndex(double[][] data, int col) {
        boolean found = false;
        double lowest = 0;
        int index = -1;

        for (int r = 0; r < data.length; r++) {
            if (col < data[r].length) {
                if (!found) {
                    lowest = data[r][col];
                    index = r;
                    found = true;
                } else if (data[r][col] < lowest) {
                    lowest = data[r][col];
                    index = r;
                }
            }
        }

        return index;
    }

    /**
     * Returns the highest value in the entire two-dimensional array.
     * 
     * @param data the two-dimensional array
     * @return highest value in the array
     */
    public static double getHighestInArray(double[][] data) {
        double highest = data[0][0];

        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                if (data[r][c] > highest) {
                    highest = data[r][c];
                }
            }
        }

        return highest;
    }

    /**
     * Returns the lowest value in the entire two-dimensional array.
     * 
     * @param data the two-dimensional array
     * @return lowest value in the array
     */
    public static double getLowestInArray(double[][] data) {
        double lowest = data[0][0];

        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                if (data[r][c] < lowest) {
                    lowest = data[r][c];
                }
            }
        }

        return lowest;
    }
}
