package com.fontys.softwarecraftsmanship;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        IntWrapper intWrapperObject = new IntWrapper();
        intWrapperObject.intWrap = 2;
        Computer computerObject = new Computer();

        computerObject.AddPart(new Part("Casing", "Cooler Master Centurion 6", 49.50, "Midi tower"));
        computerObject.AddPart(new Part("Processor", "Intel i7-4790", 295.0, 3.6));
        computerObject.AddPart(new Part("Memory", "G.SKILL Ripjaws X Series", 99.99, "DDR3", 16));
        computerObject.AddPart(new Part("Motherboard", "MSI H97 PC MATE - Socket 1150 - ATX", 89.0));

        if (computerObject.IsComplete()) {
          intWrapperObject.intWrap = 1;
        }
        double value = computerObject.GetPrice();
        switch ( intWrapperObject.intWrap ) {
            case 1:
                out.println("Total price is € " + value);
                break;
            case 2:
                out.println("Your computer is not ready yet...");
                break;
            default:
                out.println("Total price is € " + value);
                break;
        }
    }
}
