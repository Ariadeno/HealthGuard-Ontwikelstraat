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
        Computer c = new Computer();
        
        assertEquals(0, c.NumberOfParts());
    }

    /**
     * Test of AddPart method with one part, of class Computer.
     */
    @org.junit.Test
    public void testAddOnePart() {
        Part p = new Part("", "", 0.0);
        Computer c = new Computer();
        c.AddPart(p);
        
        assertEquals(1, c.NumberOfParts());
    }

    /**
     * Test of AddPart method with more parts, of class Computer.
     */
    @org.junit.Test
    public void testAddMoreParts() {
        final int PARTS_COUNT = 10;
        Computer c = new Computer();
        
        for (int i = 0; i < PARTS_COUNT; i++) {
            assertEquals(i, c.NumberOfParts());
            c.AddPart(new Part("", "", 0.0));
        }
        
        assertEquals(PARTS_COUNT, c.NumberOfParts());
    }

    
    /**
     * Test of AddPart method with a null reference part, of class Computer.
     */
    /*
     ***WERKT NOG NIET - CHARLES***
    @org.junit.Test
    public void testAddNullPart() {
        Computer c = new Computer();
        
        c.AddPart(null);
        
        assertEquals(0, c.NumberOfParts());
    }
*/
    /**
     * Test of AddPart method with more null references as parts, of class Computer.
     */
    /*
    ***WERKT NOG NIET - CHARLES***
    @org.junit.Test
    public void testAddNullParts() {
        final int PARTS_COUNT = 10;
        Computer c = new Computer();
        
        for (int i = 0; i < PARTS_COUNT; i++) {
            c.AddPart(null);
            assertEquals(0, c.NumberOfParts());
        }
    }
    /*

    /**
     * Test of GetPrice method, of class Computer without any parts.
     */
    @org.junit.Test
    public void testGetEmptyComputerPrice() {
        Computer c = new Computer();
        
        assertEquals(0.0, c.GetPrice(), 0.0);
    }

    /**
     * Test of GetPrice method, of class Computer with one part.
     */
    @org.junit.Test
    public void testGetOnePartComputerPrice() {
        final double EXPECTED_PRICE = 10.0;
        Computer c = new Computer();
        
        c.AddPart(new Part("", "", 10.0));
        
        assertEquals(EXPECTED_PRICE, c.GetPrice(), 0.0);
    }

    /**
     * Test of GetPrice method, of class Computer with more parts.
     */
    @org.junit.Test
    public void testGetMorePartsComputerPrice() {
        final int PARTS_COUNT = 10;
        final double PART_PRICE = 10.0;
        double expectedPrice = 0.0;
        Computer c = new Computer();
        
        for (int i = 0; i < PARTS_COUNT; i++) {
            c.AddPart(new Part("", "", PART_PRICE));
            expectedPrice += PART_PRICE;
        }
        
        assertEquals(expectedPrice, c.GetPrice(), 0.0);
    }

    /**
     * Test of IsComplete method of an empty Computer.
     */
    @org.junit.Test
    public void testEmptyComputerIsIncomplete() {
        Computer c = new Computer();
        
        assertEquals(false, c.IsComplete());
    }

    /**
     * Test of IsComplete method of a Computer with one part.
     */
    @org.junit.Test
    public void testOnePartComputerIsIncomplete() {
        Computer c = new Computer();
        
        c.AddPart(new Part("", "", 0.0));
        
        assertEquals(false, c.IsComplete());
    }

    /**
     * Test of IsComplete method of a Computer with more parts, but not complete.
     */
    @org.junit.Test
    public void testMorePartsComputerIsIncomplete() {
        Computer c = new Computer();
        
        c.AddPart(new Part("", "", 0.0));
        c.AddPart(new Part("", "", 0.0));
        c.AddPart(new Part("", "", 0.0));
        c.AddPart(new Part("", "", 0.0));
        c.AddPart(new Part("", "", 0.0));
        
        assertEquals(false, c.IsComplete());
    }

    /**
     * Test of IsComplete method of a complete Computer.
     */
    @org.junit.Test
    public void testComputerIsComplete() {
        Computer c = new Computer();
        
        c.AddPart(new Part("Casing", "", 0.0, ""));
        c.AddPart(new Part("Motherboard", "", 0.0));
        c.AddPart(new Part("Processor", "", 0.0, 0.0));
        c.AddPart(new Part("Memory", "", 0.0, "",0));
        
        assertEquals(true, c.IsComplete());
    }

    /**
     * Test of IsComplete method of an incomplete Computer.
     */
    @org.junit.Test
    public void testComputerIsIncomplete() {
        
        for (int i = 0; i < 4; i++) {
            Computer c = new Computer();

            if (i != 0) {
                c.AddPart(new Part("Casing", "", 0.0, ""));
            }
            if (i != 1) {
                c.AddPart(new Part("Motherboard", "", 0.0));
            }
            if (i != 2) {
                c.AddPart(new Part("Processor", "", 0.0, 0.0));
            }
            if (i != 3) {
                c.AddPart(new Part("Memory", "", 0.0, "", 0));
            }

            assertEquals(false, c.IsComplete());
        }
    }
}
