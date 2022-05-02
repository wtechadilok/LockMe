import java.io.File;
import java.util.Scanner;

import org.screens.ActionMenuScreen;
import org.screens.Screen;
import org.screens.WelcomeScreen;
import org.services.Directory;

public class App {
    public static void main(String[] args) {
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        ActionMenuScreen actionMenuScreen = new ActionMenuScreen();
        Screen currentScreen = welcomeScreen;
        Directory folder = new Directory("../Storage/");

        Scanner sc = new Scanner(System.in);
        boolean running = true;


        while (running) {
            currentScreen.display();
            String input = sc.nextLine();
            if (currentScreen instanceof WelcomeScreen) {
                switch (input) {
                    case "1":
                        folder.printFiles();
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
                        System.out.println("Enter the filename to add: ");
                        folder.addFile(sc.nextLine());
                        break;
                    case "2":
                        System.out.println("Enter the filename to delete: ");
                        folder.deleteFile(sc.nextLine());
                        break;
                    case "3":
                        System.out.println("Enter the filename to search: ");
                        File result = folder.searchFile(sc.nextLine());
                        if (result == null) {
                            System.out.println("File not found");
                        }
                        else{
                            System.out.println(result);
                        }
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
