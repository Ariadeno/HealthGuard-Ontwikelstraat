package com.fontys.softwarecraftsmanship;

import static org.junit.Assert.*;
import java.util.*;

public class PartTest {
    
    /**
     * Test of GetPrice method.
     */
    @org.junit.Test
    public void testGetPrice() {
        final DoubleWrapper DEFAULT_PRICE = new DoubleWrapper(10.0);
         ListPartWrapper parts = new ListPartWrapper();
        
        parts.add(new Part("Casing", "", DEFAULT_PRICE.doubleValue, "", 0));
        parts.add(new Part("Processor", "", DEFAULT_PRICE.doubleValue, 0.0));
        parts.add(new Part("Memory", "", DEFAULT_PRICE.doubleValue, "", 0));
        parts.add(new Part("Motherboard", "", DEFAULT_PRICE.doubleValue));
        
        for (Part part : parts.listPart) {
            assertEquals(DEFAULT_PRICE.doubleValue, part.GetPrice(), 0.0);
        }
    }
}
