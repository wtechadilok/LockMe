package org.screens;

public class WelcomeScreen implements Screen {

    @Override
    public void display() {
        System.out.println("LockedMe");
        System.out.println("Developed by Wassana Techadilok");
        System.out.println("1. View file");
        System.out.println("2. See file actions");
        System.out.println("3. Close program");
    }

    @Override
    public void processInput(int option) {

    }
}
