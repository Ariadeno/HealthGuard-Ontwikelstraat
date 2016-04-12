/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fontys.softwarecraftsmanship;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ismail Gürler <ismailgurler@fhict>
 */
public class ListPartWrapper {
	public List<Part> listPart;

	public ListPartWrapper(){
		this.listPart = new ArrayList<>();
	}

	public void add(Part element) {
		listPart.add(element);
	}

	public Part get(IntWrapper intWrapper) {
		return listPart.get(intWrapper.intValue);
	}
}
