import java.util.Scanner;
import org.screens.WelcomeScreen;

public class App {
    public static void main(String[] args) {

        WelcomeScreen welcomeScreen = new WelcomeScreen();

        Scanner sc = new Scanner(System.in);
        welcomeScreen.display();

        String input = sc.nextLine();
        System.out.println("Your number is " + input);
    }
}
