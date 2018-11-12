import java.util.Random;
import java.util.Scanner;
//lol
/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class MathBot
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int emotion = 0;
	Scanner twonumbers = new Scanner(System.in);
	/**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement)
	{
		Scanner in = new Scanner (System.in);
		System.out.println (getGreeting());


		while (!statement.equals("Bye"))
		{


			statement = in.nextLine();
			//getResponse handles the user reply
			System.out.println(getResponse(statement));
		}

	}
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */	
	public String getGreeting()
	{
		return "Hi, would you like to do some math?";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		
		if (statement.length() == 0)
		{
			response = "Say something, please.";
		}
		else if (findKeyword(statement, "yes")>=0){
			response = "Great! I can add, multiply, subtract, or divide. If you ask for explanation, I can also tell you the rules for each one. What do you want to do?";
			emotion++;
		}
		else if (findKeyword(statement, "no")>=0){
			response = "Why not? Math is fun! Why would you not want to learn about math?";
			emotion--;
		}
		else if (findKeyword(statement, "hate math") >= 0){
			response = "Why do you hate math?";
		}
		else if (findKeyword(statement, "like math") >= 0){
			response = "Why do you like math";
		}
		else if (findKeyword(statement, "explanation")>=0){
			response = "Multiplication is repeated adding of one number, by the amount of the other.\n Division is the number of times a number goes into the other. Addition and Subtraction you should know because I don't want to tell you.";
		}
		else if (findKeyword(statement, "add") >= 0)
		{
			System.out.println("Choose the first number you want to add!");
			int x = twonumbers.nextInt();
			System.out.println("Choose the next number you want to add!");
			int y = twonumbers.nextInt();
			int z = x + y;
			response = ""+z+"";
		}
		else if (findKeyword(statement, "subtract") >= 0){
			System.out.println("Which number do you want to be subtracted from?");
			int x = twonumbers.nextInt();
			System.out.println("How much do you want to subtract from the number before?");
			int y = twonumbers.nextInt();
			int z = x + y;
			response = ""+z+"";
		}
		else if (findKeyword(statement, "multiply")>= 0){
			System.out.println("Choose your first number!");
			int x = twonumbers.nextInt();
			System.out.println("Choose your next number!");
			int y = twonumbers.nextInt();
			int z = x*y;
			response = ""+z+"";
		}
		else if (findKeyword(statement, "divide")>= 0){
			System.out.println("Choose the number you want to be divided!");
			int x = twonumbers.nextInt();
			System.out.println("Choose the number you want to divide by!");
			int y = twonumbers.nextInt();
			int z = x/y;
			response = ""+z+"";
		}
		else if (findKeyword(statement, "levin") >= 0)
		{
			response = "More like LevinTheDream, amiright?";
			emotion++;
		}
		else if (findKeyword(statement, "folwell") >= 0)
		{
			response = "Watch your backpacks, Mr. Folwell doesn't fall well.";
			emotion++;
		}
		else if (findKeyword(statement, "goldman") >= 0)
		{
			response = "Go for the gold, man.";
			emotion++;
		}

		// Response transforming I want to statement
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "I want",0) >= 0)
		{
			response = transformIWantStatement(statement);
		}
		else if  (findKeyword(statement, "I hate",0) >= 0)
		{
		response = transformIHateStatement(statement);
		}
		else
		{
			response = getRandomResponse();
		}
		
		return response;
	}
	
	/**
	 * Take a statement with "I want to <something>." and transform it into 
	 * "Why do you want to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIHateStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I hate", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Why do you hate " + restOfStatement + "?";
	}
	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do you want to " + restOfStatement + "?";
	}

	
	/**
	 * Take a statement with "I want <something>." and transform it into 
	 * "Would you really be happy if you had <something>?"
	 * @param statement the user statement, assumed to contain "I want"
	 * @return the transformed statement
	 */
	private String transformIWantStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}
	
	
	/**
	 * Take a statement with "I <something> you" and transform it into 
	 * "Why do you <something> me?"
	 * @param statement the user statement, assumed to contain "I" followed by "you"
	 * @return the transformed statement
	 */
	private String transformIYouStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI);
		
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
	}
	

	
	
	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	


	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse ()
	{
		Random r = new Random ();
		if (emotion >= -2 && emotion <= 2)
		{	
			return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
		}
		if (emotion < -3)
		{	
			return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
		}	
		return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
	}
	
	private String [] randomNeutralResponses = {"Interesting, tell me more",
			"Hmmm.",
			"Do you really think so?",
			"You don't say.",
			"I'm sure you know, that 2+4 =6?",
			"The quotient is the result you get when you divide a number by another number",
			"The dividend is the number you divide by.",
			"The sum is the answer you get when you add two or more numbers together",
			"The product is the answer you get when you multiply two or more numbers.",
			"Do you like math?",
			"Would you like to do math?"
	};
	private String [] randomAngryResponses = {"You are unworthy of the knowledge I possess.","You shall not know.","Begone, mere mortal. My knowledge is not for the likes of your kind.","Would you like to do math yet?"};
	private String [] randomHappyResponses = {"How many fingers do you have on one hand?", "Why are we all here?","The possibilities are endless!", "Would you like to do math yet?"};
	
}
