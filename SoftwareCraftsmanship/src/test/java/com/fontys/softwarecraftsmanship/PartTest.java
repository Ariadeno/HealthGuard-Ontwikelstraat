package com.fontys.softwarecraftsmanship;

import static org.junit.Assert.*;
import java.util.*;

public class PartTest {
    
    /**
     * Test of GetPrice method.
     */
    @org.junit.Test
    public void testGetPrice() {
        final double DEFAULT_PRICE = 10.0;
        List<Part> parts = new ArrayList<>();
        
        parts.add(new Part("Casing", "", DEFAULT_PRICE, "", 0));
        parts.add(new Part("Processor", "", DEFAULT_PRICE, 0.0));
        parts.add(new Part("Memory", "", DEFAULT_PRICE, "", 0));
        parts.add(new Part("Motherboard", "", DEFAULT_PRICE));
        
        for (Part p : parts) {
            assertEquals(DEFAULT_PRICE, p.GetPrice(), 0.0);
        }
    }
}
