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
		System.out.println("Welcome to chatbot for kids!");
		String statement = in.nextLine();


		while (!statement.equals("Bye"))
		{
			Scanner input = new Scanner (System.in);
			System.out.println("Hey, do you want to learn some math?");
			String statement1 = input.nextLine();

			if (statement1.equals("yes"))
			{
			chatbot1.chatLoop(statement);
			}
			else if (statement1.equals("no"))
			{

				System.out.println("Do you want to read some rhymes?");
				statement1 = input.nextLine();

				if (statement1.equals("yes"))
				{
				chatbot2.chatLoop(statement);
				}
				else {
				chatbot3.chatLoop(statement);
				}
		}
			statement = in.nextLine();
		}
	}

}
