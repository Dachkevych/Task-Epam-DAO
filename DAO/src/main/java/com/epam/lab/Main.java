package com.epam.lab;

import org.apache.log4j.PropertyConfigurator;

import com.epam.lab.controller.MenuController;

public class Main {

	public static void main(String[] args) {
		PropertyConfigurator.configure("resources/log4j.properties");
		MenuController controller = new MenuController();
		controller.showMenu();
	}
}
