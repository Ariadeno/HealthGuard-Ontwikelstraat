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
public class Casing extends Part {
	
	public final StringWrapper subtype;

	public Casing(StringWrapper title, DoubleWrapper price, StringWrapper subtype) {
		super(title, price);
		if(subtype == null) {
			throw new IllegalArgumentException("Argument may not be null.");
		}
		this.subtype = new StringWrapper(subtype.stringValue);
	}
}
