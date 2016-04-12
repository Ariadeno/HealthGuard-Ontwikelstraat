package com.fontys.softwarecraftsmanship;

import java.util.*;

public class Computer {
    
    public ListPartWrapper listPartWrapper;

	public Computer(){
		this.listPartWrapper = new ListPartWrapper();
	}

    public int NumberOfParts() {
		IntWrapper intWrapper = new IntWrapper(0);
        for (Part p : listPartWrapper.listPart) { 
            intWrapper.intValue++;
        }
        return intWrapper.intValue;
    }
    
    public void AddPart(Part p) {
        listPartWrapper.add(p);
    }
    
    public double GetPrice() {
        DoubleWrapper price = new DoubleWrapper(0.0);
        
        for (IntWrapper i = new IntWrapper(0); i.intValue < NumberOfParts(); i.intValue++) {
            Part part = listPartWrapper.get(i);
            price.doubleValue += part.GetPrice();
        }
        
        return price.doubleValue;
    }
    
    public boolean IsComplete() {
        BooleanWrapper hasCasing = new BooleanWrapper(false);
        BooleanWrapper hasProcessor = new BooleanWrapper(false);
        BooleanWrapper hasMemory = new BooleanWrapper(false);
        BooleanWrapper hasMotherboard = new BooleanWrapper(false);
        
        for (Part part : listPartWrapper.listPart) {
            if (part.GetType().equals("Casing")) {
                hasCasing = true;
            }
            else {
                if (part.GetType().equals("Processor")) {
                    hasProcessor = true;
                }
                else {
                    if (part.GetType().equals("Memory")) {
                        hasMemory = true;
                    }
                    else {
                        if (part.GetType().equals("Motherboard")) {
                            hasMotherboard = true;
                        }
                    }
                }
            }
        }
        
        if (!hasCasing || !hasProcessor || !hasMemory || !hasMotherboard) {
            return false;
        } else {
            return true;
        }
    }
}
