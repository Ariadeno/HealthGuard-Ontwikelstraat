package com.fontys.softwarecraftsmanship;

public abstract class Part {
    
//    private final String type;
    public final StringWrapper title;
    public final DoubleWrapper price;
//    private String subtype = null;
//    private int size = -1;
//    private double speed = -1.0;

	public Part(StringWrapper title, DoubleWrapper price) {
		if(title == null || price == null) {
			throw new IllegalArgumentException("Argument may not be null.");
		}
		this.title = new StringWrapper(title.stringValue);
		this.price = new DoubleWrapper(price.doubleValue);
	}
}
