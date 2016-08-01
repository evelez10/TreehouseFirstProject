
import java.util.Random;
import java.util.Scanner;

/*Used to Check For Integer Value For ItemMax*/
final class numChecker{
	 static boolean numberChecker(String checker){
		try{
			Integer.parseInt(checker);
		}
		catch(NumberFormatException ex){
			return false;
		}
		return true;
	}
}


public class Jar {
	
	/*DECLARATIONS*/
	private static Scanner input;
	private String mSetName;
	private String mSetItem;
	private int mSetItemMax;
	private String mSetReset;
	private static boolean select = true;
	private static boolean letterValidation = true;
	
	
	
	/*SETTERS*/
	public void setName(String name){
		mSetName = name;
	}
	public void setItem(String item){
		mSetItem = item;
	}
	public void setItemMax(int itemMax){
		mSetItemMax = itemMax;
	}
	public void setReset(String reset){
		mSetReset = reset;
	}
	
	/*GETTERS*/
	public String getName(){
		return mSetName;
	}
	public String getItem(){
		return mSetItem;
	}
	public int getItemMax(){
		return mSetItemMax;
	}
	public String getReset(){
		return mSetReset;
	}
	
	/*RETURNS*/
	public void nameReturn(){
		input = new Scanner(System.in);
		/*Introduction*/
		System.out.println("WELCOME TO THE JAR GAME!\n ==============================================");
		System.out.println("You as the player will guess how many items of your choice are in the jar.\n ==============================================");
		
		/*Requesting Player Name*/
		System.out.print("Before we begin, may I have your first name please? ");
		String tempName = input.nextLine();
		setName(tempName);
		char[] charsName = tempName.toCharArray();
		while(letterValidation){
			for(char n :charsName){
				if(!Character.isLetter(n)){
				System.out.println("***Please enter letters only!***");	
				nameReturn();
				}
				else{
				System.out.printf("\nGreat! Welcome to the game %s.\n", getName());
				itemReturn();
				}
			}
		}
	}
	public void itemReturn(){
		/*Requesting Player to Enter Item Type*/
		System.out.printf("\nNow, %s can you please enter what item you would like to place in the jar? ", getName());
		String tempItem = input.nextLine();
		setItem(tempItem);
		char[] charsItem = tempItem.toCharArray();
		while(letterValidation){
			for(char i :charsItem){
				if(!Character.isLetter(i)){
				System.out.println("***Please enter letters only!***");	
				itemReturn();
				}
				else{
				System.out.printf("\nYou choose to place %s's inside the jar! Awesome!\n", getItem());
				itemMaxReturn();
				}
			}
		}
	} 
	public void itemMaxReturn(){
		
		/*Requesting Player to Enter Max Item Number, Generating Random Number, Prompting for Guess */
		System.out.printf("\nLast question %s, how many %s's do you think can realistically fit into the jar? ", getName(), getItem());
		int tempItemMaxReturn = input.nextInt();
		setItemMax(tempItemMaxReturn);
		resetReturn();
	}
	
	public void resetReturn(){
		/*Requesting Player to Validate Their Settings*/
		System.out.printf("\n%s, you selected to place %s %s's inside of the jar. Are you okay with these settings? (Enter 'Y' to continue or enter 'N' to re-select.)\n ", getName(),getItemMax(),getItem());
		String tempSelect = input.next();
		while(select){
			if(!tempSelect.equalsIgnoreCase("Y") && !tempSelect.equalsIgnoreCase("N")){
				System.out.println("Please enter Y or N: ");
				input = new Scanner(System.in);
				tempSelect = input.next();
			}
			if(tempSelect.equalsIgnoreCase("y")){
				gameReturn();
			}
			if(tempSelect.equalsIgnoreCase("n")){
				nameReturn();
			}
		}
	}
	
	public void gameReturn(){
		
		Random random = new Random();
		int numberToGuess = random.nextInt(getItemMax() + 1);
		int numberTries = 0;
		boolean win = false;
		
		while(win == false){
			
			System.out.println("\nYou will be guessing a number between 1 and " + getItemMax() + ".");
			System.out.println("You have attemtped (" + numberTries + ") guesses");
			System.out.print("\nEnter Guess: ");
			int guess = input.nextInt();
			numberTries++;
		
			if(guess == numberToGuess){
				win = true;
			}
			else if(guess > getItemMax() || guess <= 0){
					System.out.println("\n***Guess is out of Range***");
				}
			
			else if(guess < numberToGuess){
				System.out.println("\nYour guess is too low!");
			}
			else if(guess > numberToGuess){
				System.out.println("\nYour guess is too high!");
			}
			
		}
		
		System.out.println("\nCongratulations " + getName() + "! You Win!");
		System.out.println("The correct number was: " + numberToGuess);
		System.out.println("It took you (" + numberTries + ") tries.\n");
		System.out.println("\n Would you like to try again? (Y/N)");
		String tempReturn = input.next();
		while(select){
			if(!tempReturn.equalsIgnoreCase("Y") && !tempReturn.equalsIgnoreCase("N")){
				System.out.println("Please enter Y or N: ");
				input = new Scanner(System.in);
				tempReturn = input.next();
			}
			if(tempReturn.equalsIgnoreCase("y")){
				gameReturn();
			}
			if(tempReturn.equalsIgnoreCase("n")){
				System.out.println("Goodbye!");
				System.exit(0);
			}
		}
		
	}	
}
	
	

