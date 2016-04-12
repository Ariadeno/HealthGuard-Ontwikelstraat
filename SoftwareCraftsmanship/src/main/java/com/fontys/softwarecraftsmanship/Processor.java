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
public class Processor extends Part {
	
	public final DoubleWrapper speed;

	public Processor(StringWrapper title, DoubleWrapper price, DoubleWrapper speed) {
		super(title, price);
		if(speed == null) {
			throw new IllegalArgumentException("Argument may not be null.");
		}
		this.speed = new DoubleWrapper(speed.doubleValue);
	}
}
