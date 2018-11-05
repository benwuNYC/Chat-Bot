import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotRunner
{

	/**
	 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
	 */
	public static void main(String[] args)
	{
		MathBot chatbot1 = new MathBot();
		RhymesBot chatbot2 = new RhymesBot();
		AnimalFactBot chatbot3 = new AnimalFactBot();
		

		Scanner in = new Scanner (System.in);
		System.out.println("Welcome to the chatbot, nice to meet you.");
		String statement = in.nextLine();


		while (!statement.equals("Bye"))
		{
			//Use Logic to control which chatbot is handling the conversation\
			//This example has only chatbot1


			chatbot2.chatLoop(statement);
			//chatbot1.chatLoop(statement);


			statement = in.nextLine();


		}
	}

}
