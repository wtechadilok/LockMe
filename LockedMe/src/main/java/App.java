import java.util.Scanner;

import org.screens.ActionMenuScreen;
import org.screens.Screen;
import org.screens.WelcomeScreen;

public class App {
    public static void main(String[] args) {
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        ActionMenuScreen actionMenuScreen = new ActionMenuScreen();
        Scanner sc = new Scanner(System.in);
        Screen currentScreen = welcomeScreen;

        boolean running = true;

        while (running) {
            currentScreen.display();
            String input = sc.nextLine();
            if (currentScreen instanceof WelcomeScreen) {
                switch (input) {
                    case "1":
                        System.out.println("Display the file");
                        break;
                    case "2":
                        currentScreen = actionMenuScreen;
                        break;
                    case "3":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            } else {
                switch (input) {
                    case "1":
                        System.out.println("Add the file");
                        break;
                    case "2":
                        System.out.println("Delete the file");
                        break;
                    case "3":
                        System.out.println("Search a file");
                        break;
                    case "4":
                        currentScreen = welcomeScreen;
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            }
        }
    }
}
