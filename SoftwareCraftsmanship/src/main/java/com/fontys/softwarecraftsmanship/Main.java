package com.fontys.softwarecraftsmanship;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        IntWrapper intWrapperObject = new IntWrapper(2);
        Computer computerObject = new Computer();
        computerObject.AddPart(new Casing(new StringWrapper("Cooler Master Centurion 6"), new DoubleWrapper(49.50), new StringWrapper("Midi tower")));
        computerObject.AddPart(new Processor(new StringWrapper("Intel i7-4790"), new DoubleWrapper(295.0), new DoubleWrapper(3.6)));
        computerObject.AddPart(new Memory(new StringWrapper("G.SKILL Ripjaws X Series"), new DoubleWrapper(99.99), new StringWrapper("DDR3"), new IntWrapper(16)));
        computerObject.AddPart(new Motherboard(new StringWrapper("MSI H97 PC MATE - Socket 1150 - ATX"), new DoubleWrapper(89.0)));
        if (computerObject.IsComplete()) {
            intWrapperObject.intValue = 1;
        }
        DoubleWrapper DoubleWrapperObject = new DoubleWrapper(computerObject.GetPrice());
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
