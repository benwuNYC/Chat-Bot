import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotRunner {

    /**
     * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
     */
    public static void main(String[] args) {
        MathBot chatbot1 = new MathBot();
        RhymesBot chatbot2 = new RhymesBot();
        AnimalFactBot chatbot3 = new AnimalFactBot();


        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to chatbot for kids!");
        String statement = in.nextLine();


        while (!statement.equals("Bye")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Hey, do you want to learn about math, animals, or rhymes?");
            String statement1 = input.nextLine();
            String phrase = statement.trim().toLowerCase();
            statement1 = statement1.toLowerCase();
            if (statement1.equals("math")) {
                chatbot1.chatLoop(statement);
            } else if (statement1.equals("rhymes")) {
                chatbot2.chatLoop(statement);
            } else if (statement1.equals("animals")) {
                chatbot3.chatLoop(statement);
            } else System.out.println("Try again");
        }
    }
}