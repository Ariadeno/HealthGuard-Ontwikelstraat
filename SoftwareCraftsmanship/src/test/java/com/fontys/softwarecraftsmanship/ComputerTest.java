package com.fontys.softwarecraftsmanship;

import static org.junit.Assert.*;

/**
 *
 * @author 873955
 */
public class ComputerTest {

    /**
     * Test of AddPart method without parts, of class Computer.
     */
    @org.junit.Test
    public void testAddZeroParts() {
        Computer computerObject = new Computer();

        assertEquals(0, computerObject.NumberOfParts());
    }

    /**
     * Test of AddPart method with one part, of class Computer.
     */
    @org.junit.Test
    public void testAddOnePart() {

        Casing partObject = new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper(""));
        Computer computerObject = new Computer();
        computerObject.AddPart(partObject);

        assertEquals(1, computerObject.NumberOfParts());
    }

    /**
     * Test of AddPart method with more parts, of class Computer.
     */
    @org.junit.Test
    public void testAddMoreParts() {
        final int PARTS_COUNT = 10;
        Computer computerObject = new Computer();

        for (int integer = 0; integer < PARTS_COUNT; integer++) {
            assertEquals(integer, computerObject.NumberOfParts());
            computerObject.AddPart(new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper("")));
        }

        assertEquals(PARTS_COUNT, computerObject.NumberOfParts());
    }

    /**
     * Test of AddPart method with a null reference part, of class Computer.
     */
    @org.junit.Test
    public void testAddNullPart() {
        Computer computerObject = new Computer();

        computerObject.AddPart(null);

        assertEquals(1, computerObject.NumberOfParts());
    }

    /**
     * Test of AddPart method with more null references as parts, of class
     * Computer.
     */
    /*
    @org.junit.Test
    public void testAddNullParts() {
        final int PARTS_COUNT = 10;
        Computer computerObject = new Computer();

        for (int integer = 0; integer < PARTS_COUNT; integer++) {
            computerObject.AddPart(null);
            assertEquals(0, computerObject.NumberOfParts());
        }
    }
*/
    /**
     * Test of GetPrice method, of class Computer without any parts.
     */
    @org.junit.Test
    public void testGetEmptyComputerPrice() {
        Computer computerObject = new Computer();

        assertEquals(0.0, computerObject.GetPrice(), 0.0);
    }

    /**
     * Test of GetPrice method, of class Computer with one part.
     */
    @org.junit.Test
    public void testGetOnePartComputerPrice() {
        final double EXPECTED_PRICE = 10.0;
        Computer computerObject = new Computer();

        computerObject.AddPart(new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper("")));

        assertEquals(EXPECTED_PRICE, computerObject.GetPrice(), 0.0);
    }

    /**
     * Test of GetPrice method, of class Computer with more parts.
     */
    @org.junit.Test
    public void testGetMorePartsComputerPrice() {
        final int PARTS_COUNT = 10;
        final double PART_PRICE = 10.0;
        double expectedPrice = 0.0;
        Computer computerObject = new Computer();

        for (int integer = 0; integer < PARTS_COUNT; integer++) {
            computerObject.AddPart(new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper("")));
            expectedPrice += PART_PRICE;
        }

        assertEquals(expectedPrice, computerObject.GetPrice(), 0.0);
    }

    /**
     * Test of IsComplete method of an empty Computer.
     */
    @org.junit.Test
    public void testEmptyComputerIsIncomplete() {
        Computer computerObject = new Computer();

        assertEquals(false, computerObject.IsComplete());
    }

    /**
     * Test of IsComplete method of a Computer with one part.
     */
    @org.junit.Test
    public void testOnePartComputerIsIncomplete() {
        Computer computerObject = new Computer();

        computerObject.AddPart(new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper("")));

        assertEquals(false, computerObject.IsComplete());
    }

    /**
     * Test of IsComplete method of a Computer with more parts, but not
     * complete.
     */
    @org.junit.Test
    public void testMorePartsComputerIsIncomplete() {
        Computer computerObject = new Computer();

        computerObject.AddPart(new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper("")));
        computerObject.AddPart(new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper("")));
        computerObject.AddPart(new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper("")));
        computerObject.AddPart(new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper("")));
        computerObject.AddPart(new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper("")));

        assertEquals(false, computerObject.IsComplete());
    }

    /**
     * Test of IsComplete method of a complete Computer.
     */
    @org.junit.Test
    public void testComputerIsComplete() {
        Computer computerObject = new Computer();

        computerObject.AddPart(new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper("")));
        computerObject.AddPart(new Motherboard(new StringWrapper("Motherboard"), new DoubleWrapper(10.0)));
        computerObject.AddPart(new Processor(new StringWrapper("Processor"), new DoubleWrapper(10.0), new DoubleWrapper(0.0)));
        computerObject.AddPart(new Memory(new StringWrapper("Memory"), new DoubleWrapper(10.0), new StringWrapper(""), new IntWrapper(0)));

        assertEquals(true, computerObject.IsComplete());
    }

    /**
     * Test of IsComplete method of an incomplete Computer.
     */
    @org.junit.Test
    public void testComputerIsIncomplete() {

        for (int integer = 0; integer < 4; integer++) {
            Computer computerObject = new Computer();
            if (integer != 0) {
                computerObject.AddPart(new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper("")));
            }
            if (integer != 1) {
                computerObject.AddPart(new Motherboard(new StringWrapper("Motherboard"), new DoubleWrapper(10.0)));

            }
            if (integer != 2) {
                computerObject.AddPart(new Processor(new StringWrapper("Processor"), new DoubleWrapper(10.0), new DoubleWrapper(0.0)));

            }
            if (integer != 3) {
                computerObject.AddPart(new Memory(new StringWrapper("Memory"), new DoubleWrapper(10.0), new StringWrapper(""), new IntWrapper(0)));

            }
            assertEquals(false, computerObject.IsComplete());
        }
    }
}
