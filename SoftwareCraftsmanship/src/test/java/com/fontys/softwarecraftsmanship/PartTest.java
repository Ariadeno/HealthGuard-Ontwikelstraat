package com.fontys.softwarecraftsmanship;

import static org.junit.Assert.*;
import java.util.*;

public class PartTest {
    
    /**
     * Test of GetPrice method.
     */
    @org.junit.Test
    public void testGetPrice() {
         ListPartWrapper parts = new ListPartWrapper();
        
        parts.add(new Casing(new StringWrapper("Casing"), new DoubleWrapper(10.0), new StringWrapper("")));
        parts.add(new Processor(new StringWrapper("Processor"),  new DoubleWrapper(10.0), new DoubleWrapper(0.0)));
        parts.add(new Memory(new StringWrapper("Memory"),  new DoubleWrapper(10.0) , new StringWrapper(""), new IntWrapper(0)));
        parts.add(new Motherboard(new StringWrapper("Motherboard"),  new DoubleWrapper(10.0)));
        
        for (Part part : parts.listPart) {
            assertEquals(10.0, part.price.doubleValue, 0.0);
        }
    }
}
