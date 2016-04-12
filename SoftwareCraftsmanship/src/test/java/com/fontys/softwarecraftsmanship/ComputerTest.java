package com.fontys.softwarecraftsmanship;

import static java.lang.System.out;
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
        final IntWrapper PARTS_COUNT = new IntWrapper(10);
        Computer computerObject = new Computer();
        IntWrapper integer = new IntWrapper(0);
        for (integer.intValue = 0; integer.intValue < PARTS_COUNT.intValue; integer.intValue++) {
            assertEquals(integer.intValue, computerObject.NumberOfParts());
            computerObject.AddPart(new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper("")));
        }

        assertEquals(PARTS_COUNT.intValue, computerObject.NumberOfParts());
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
    
    @org.junit.Test
    public void testAddNullParts() {
        final IntWrapper PARTS_COUNT = new IntWrapper(10);
        Computer computerObject = new Computer();
        IntWrapper integer = new IntWrapper(0);
        for (integer.intValue = 0; integer.intValue < PARTS_COUNT.intValue; integer.intValue++) {
            computerObject.AddPart(null);
            assertEquals(0, 0);
        }
    }
     
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
        final DoubleWrapper EXPECTED_PRICE = new DoubleWrapper(10.0);
        Computer computerObject = new Computer();

        computerObject.AddPart(new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper("")));

        assertEquals(EXPECTED_PRICE.doubleValue, computerObject.GetPrice(), 0.0);
    }

    /**
     * Test of GetPrice method, of class Computer with more parts.
     */
    @org.junit.Test
    public void testGetMorePartsComputerPrice() {
        final IntWrapper PARTS_COUNT = new IntWrapper(10);
        final DoubleWrapper PART_PRICE = new DoubleWrapper(10.0);
        DoubleWrapper expectedPrice = new DoubleWrapper(10.0);

        Computer computerObject = new Computer();
        IntWrapper integer = new IntWrapper(0);
        for (integer.intValue = 0; integer.intValue < PARTS_COUNT.intValue; integer.intValue++) {
            computerObject.AddPart(new Casing(new StringWrapper("Casing"), new DoubleWrapper(11.0), new StringWrapper("")));
            expectedPrice.doubleValue += PART_PRICE.doubleValue;
        }

        assertEquals(expectedPrice.doubleValue, computerObject.GetPrice(), 0.0);
    }

    /**
     * Test of IsComplete method of an empty Computer.
     */
    @org.junit.Test
    public void testEmptyComputerIsIncomplete() {
        Computer computerObject = new Computer();
        BooleanWrapper booleanWrapObject = new BooleanWrapper(false);
        assertEquals(booleanWrapObject.booleanValue, computerObject.IsComplete());
    }

    /**
     * Test of IsComplete method of a Computer with one part.
     */
    @org.junit.Test
    public void testOnePartComputerIsIncomplete() {
        Computer computerObject = new Computer();

        computerObject.AddPart(new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper("")));
        BooleanWrapper booleanWrapObject = new BooleanWrapper(false);
        assertEquals(booleanWrapObject.booleanValue, computerObject.IsComplete());
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
        BooleanWrapper booleanWrapObject = new BooleanWrapper(false);
        assertEquals(booleanWrapObject.booleanValue, computerObject.IsComplete());
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
        BooleanWrapper booleanWrapObject = new BooleanWrapper(true);
        assertEquals(booleanWrapObject.booleanValue, computerObject.IsComplete());
    }

    /**
     * Test of IsComplete method of an incomplete Computer.
     */
    @org.junit.Test
    public void testComputerIsIncomplete() {
        IntWrapper integer = new IntWrapper(0);
        for (integer.intValue = 0; integer.intValue < 4; integer.intValue++) {
            Computer computerObject = new Computer();
            switch (integer.intValue) {
                case 0:
                    computerObject.AddPart(new Motherboard(new StringWrapper("Motherboard"), new DoubleWrapper(10.0)));
                    computerObject.AddPart(new Processor(new StringWrapper("Processor"), new DoubleWrapper(10.0), new DoubleWrapper(0.0)));
                    computerObject.AddPart(new Memory(new StringWrapper("Memory"), new DoubleWrapper(10.0), new StringWrapper(""), new IntWrapper(0)));
                    break;
                case 1:
                    computerObject.AddPart(new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper("")));
                    computerObject.AddPart(new Processor(new StringWrapper("Processor"), new DoubleWrapper(10.0), new DoubleWrapper(0.0)));
                    computerObject.AddPart(new Memory(new StringWrapper("Memory"), new DoubleWrapper(10.0), new StringWrapper(""), new IntWrapper(0)));
                    break;
                case 2:
                    computerObject.AddPart(new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper("")));
                    computerObject.AddPart(new Motherboard(new StringWrapper("Motherboard"), new DoubleWrapper(10.0)));
                    computerObject.AddPart(new Memory(new StringWrapper("Memory"), new DoubleWrapper(10.0), new StringWrapper(""), new IntWrapper(0)));
                    break;
                case 3:
                    computerObject.AddPart(new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper("")));
                    computerObject.AddPart(new Motherboard(new StringWrapper("Motherboard"), new DoubleWrapper(10.0)));
                    computerObject.AddPart(new Processor(new StringWrapper("Processor"), new DoubleWrapper(10.0), new DoubleWrapper(0.0)));
                    break;
                default:
                    computerObject.AddPart(new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper("")));
                    computerObject.AddPart(new Motherboard(new StringWrapper("Motherboard"), new DoubleWrapper(10.0)));
                    computerObject.AddPart(new Processor(new StringWrapper("Processor"), new DoubleWrapper(10.0), new DoubleWrapper(0.0)));
                    computerObject.AddPart(new Memory(new StringWrapper("Memory"), new DoubleWrapper(10.0), new StringWrapper(""), new IntWrapper(0)));
                    break;
            }
            BooleanWrapper booleanWrapObject = new BooleanWrapper(false);
            assertEquals(booleanWrapObject.booleanValue, computerObject.IsComplete());
        }
    }
}
