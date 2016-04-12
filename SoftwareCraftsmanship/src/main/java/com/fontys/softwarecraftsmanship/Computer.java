package com.fontys.softwarecraftsmanship;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import java.util.*;

public class Computer {

	public ListPartWrapper listPartWrapper;

	public Computer() {
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
			price.doubleValue += part.price.doubleValue;
		}

		return price.doubleValue;
	}

	public boolean IsComplete() {
		BooleanWrapper hasCasing = new BooleanWrapper(false);
		BooleanWrapper hasProcessor = new BooleanWrapper(false);
		BooleanWrapper hasMemory = new BooleanWrapper(false);
		BooleanWrapper hasMotherboard = new BooleanWrapper(false);

		for (Part part : listPartWrapper.listPart) {
			hasCasing.booleanValue = (part instanceof Casing) || hasCasing.booleanValue;
			hasProcessor.booleanValue = (part instanceof Processor) || hasProcessor.booleanValue;
			hasMemory.booleanValue = (part instanceof Memory) || hasMemory.booleanValue;
			hasMotherboard.booleanValue = (part instanceof Motherboard) || hasMotherboard.booleanValue;
		}

		return !(!hasCasing.booleanValue || !hasProcessor.booleanValue || !hasMemory.booleanValue || !hasMotherboard.booleanValue);
	}
}
