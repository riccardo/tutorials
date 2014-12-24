/**
 * This file is part of JEMMA - http://jemma.energy-home.org
 * (C) Copyright 2014 Istituto Superiore Mario Boella (http://www.ismb.it)
 *
 * JEMMA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License (LGPL) version 3
 * or later as published by the Free Software Foundation, which accompanies
 * this distribution and is available at http://www.gnu.org/licenses/lgpl.html
 *
 * JEMMA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License (LGPL) for more details.
 *
 */

package org.energy_home.jemma.tutorials.osgi.ipdservice.api;

/**
* IPDService interface
* 
* @author https://github.com/riccardo
* */
public interface IPDService {
	public void pushNewTextMessage(String textmessage);
	public String popOlderTextMessage() throws NoMessageAvailableExeption;
	public String getCurrentlyDisplayedTextMessage();
	public int countStackedTextMessages();
}
