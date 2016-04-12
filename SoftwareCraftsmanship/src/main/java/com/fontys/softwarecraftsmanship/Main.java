package com.fontys.softwarecraftsmanship;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        IntWrapper intWrapperObject = new IntWrapper(2);
        Computer computerObject = new Computer();
        computerObject.AddPart(new Part("Casing", "Cooler Master Centurion 6", 49.50, "Midi tower"));
        computerObject.AddPart(new Part("Processor", "Intel i7-4790", 295.0, 3.6));
        computerObject.AddPart(new Part("Memory", "G.SKILL Ripjaws X Series", 99.99, "DDR3", 16));
        computerObject.AddPart(new Part("Motherboard", "MSI H97 PC MATE - Socket 1150 - ATX", 89.0));
        if (computerObject.IsComplete()) {
            intWrapperObject.intValue = 1;
        }
        DoubleWrapper DoubleWrapperObject = new DoubleWrapper();
        DoubleWrapperObject.doubleValue = computerObject.GetPrice();
        switch (intWrapperObject.intValue) {
            case 1:
                out.println("Total price is € " + DoubleWrapperObject.doubleValue);
                break;
            case 2:
                out.println("Your computer is not ready yet...");
                break;
            default:
                out.println("Total price is € " + DoubleWrapperObject.doubleValue);
                break;
        }
    }
}
