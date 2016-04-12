/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fontys.softwarecraftsmanship;

/**
 *
 * @author Ismail Gürler <ismailgurler@fhict>
 */
public class Memory extends Part {
	public final StringWrapper subtype;
	public final IntWrapper size;

	public Memory(StringWrapper title, DoubleWrapper price, StringWrapper subtype, IntWrapper size) {
		super(title, price);
		if(subtype == null || size == null) {
			throw new IllegalArgumentException("Argument may not be null.");
		}
		this.subtype = new StringWrapper(subtype.stringValue);
		this.size = new IntWrapper(size.intValue);
	}
}
