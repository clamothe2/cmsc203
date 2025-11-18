package assignment5;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;

public class TwoDimRaggedArrayUtilityTestStudent {

    private double[][] data = {
            { 1, 2, 3 },
            { 4, 5 },
            { 6, 7, 8 }
    };

    @Test
    public void testGetTotal() {
        assertEquals(36, TwoDimRaggedArrayUtility.getTotal(data), 0.001);
    }

    @Test
    public void testGetAverage() {
        assertEquals(36.0 / 8, TwoDimRaggedArrayUtility.getAverage(data), 0.001);
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(6, TwoDimRaggedArrayUtility.getRowTotal(data, 0), 0.001);
        assertEquals(9, TwoDimRaggedArrayUtility.getRowTotal(data, 1), 0.001);
        assertEquals(21, TwoDimRaggedArrayUtility.getRowTotal(data, 2), 0.001);
    }

    @Test
    public void testGetColumnTotal() {
        assertEquals(1 + 4 + 6, TwoDimRaggedArrayUtility.getColumnTotal(data, 0), 0.001);
        assertEquals(2 + 5 + 7, TwoDimRaggedArrayUtility.getColumnTotal(data, 1), 0.001);
        assertEquals(3 + 8, TwoDimRaggedArrayUtility.getColumnTotal(data, 2), 0.001);
    }

    @Test
    public void testGetHighestInRow() {
        assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRow(data, 0), 0.001);
        assertEquals(5, TwoDimRaggedArrayUtility.getHighestInRow(data, 1), 0.001);
        assertEquals(8, TwoDimRaggedArrayUtility.getHighestInRow(data, 2), 0.001);
    }

    @Test
    public void testGetHighestInRowIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 0));
        assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 1));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 2));
    }

    @Test
    public void testGetLowestInRow() {
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRow(data, 0), 0.001);
        assertEquals(4, TwoDimRaggedArrayUtility.getLowestInRow(data, 1), 0.001);
        assertEquals(6, TwoDimRaggedArrayUtility.getLowestInRow(data, 2), 0.001);
    }

    @Test
    public void testGetLowestInRowIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 2));
    }

    @Test
    public void testGetHighestInColumn() {
        assertEquals(6, TwoDimRaggedArrayUtility.getHighestInColumn(data, 0), 0.001);
        assertEquals(7, TwoDimRaggedArrayUtility.getHighestInColumn(data, 1), 0.001);
        assertEquals(8, TwoDimRaggedArrayUtility.getHighestInColumn(data, 2), 0.001);
    }

    @Test
    public void testGetHighestInColumnIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 0));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 1));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 2));
    }

    @Test
    public void testGetLowestInColumn() {
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumn(data, 0), 0.001);
        assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumn(data, 1), 0.001);
        assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumn(data, 2), 0.001);
    }

    @Test
    public void testGetLowestInColumnIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 2));
    }

    @Test
    public void testGetHighestInArray() {
        assertEquals(8, TwoDimRaggedArrayUtility.getHighestInArray(data), 0.001);
    }

    @Test
    public void testGetLowestInArray() {
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInArray(data), 0.001);
    }

    @Test
    public void testReadAndWriteFile() throws Exception {
        File file = new File("testOutput.txt");
        TwoDimRaggedArrayUtility.writeToFile(data, file);

        double[][] read = TwoDimRaggedArrayUtility.readFile(file);

        assertEquals(data.length, read.length);

        for (int r = 0; r < data.length; r++) {
            assertEquals(data[r].length, read[r].length);
            for (int c = 0; c < data[r].length; c++) {
                assertEquals(data[r][c], read[r][c], 0.001);
            }
        }

        file.delete();
    }
}
