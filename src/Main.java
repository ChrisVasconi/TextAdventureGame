import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		
		//System objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		//Game variables
		String[] enemies = {"Cheetos", "Pepper", "Login and Regestration", "The learn platform"};
		int maxEnemyHealth = 100;
		int enemyAttackDamage = 25;
		
		//Player variables
		int health = 101;
		int attackDamage = 50;
		int numHealthPots = 3; 
		int healthPotionHealAmmount = 30;
		int healthPotionDropChance = 50; //Percentage
		
		boolean running = true;
		
		System.out.println("Welcome to the Dojo");
		
		GAME: 
		while(running) {
			System.out.println("------------------------------");
			
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " appeared! #\n");
			
			while(enemyHealth > 0) {
				System.out.println("\tYour HP: " + health);
				System.out.println("\t" + enemy + ";s HP:" + enemyHealth);
				System.out.println("\n\tWhatchu wanna do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink some hooch");
				System.out.println("\t3. Dip!");
				
				String input = in.nextLine();
				if(input.equals("1")) {
					int damageDealt = rand.nextInt(attackDamage);
					int damageTaken = rand.nextInt(enemyAttackDamage);
					
					enemyHealth -= damageDealt;
					health -= damageTaken;
					
					
					System.out.println( enemy + "Got them hands for" + damageDealt + "damage" );
					System.out.println("\t> You recieved" + damageTaken + "In emotional damage");
					
					if (health < 1) {
						System.out.println("/t You need a break and cant go any further");
						break;
					}
				}
				else if (input.equals("2") ) {
					if (numHealthPots > 0) {
						health += healthPotionHealAmmount;
						numHealthPots--;
						System.out.println("/t> You drank a potion" + healthPotionHealAmmount + "."
													 + "\n\t> You now have " + health + "HP"
													 + "\n\t> You have" + numHealthPots + "Potions left \n");
					}
					else {
						System.out.println("\t> You have no Health poeshys left! Start throwin them hands for a chance to get one!!");
					}
				}
				else if (input.equals("3")) {
					System.out.println("\tYou Run away from the " + enemy);
					continue GAME;
				}
				else {
					System.out.println("\t invalid cmmoand!");
				}
			}
			if(health < 1) {
				System.out.println("You limp away");
				break;
			}
			System.out.println("------------------------------");
			System.out.println( " # " + enemy + " was defeated! #");
			System.out.println("# You have" + health + "HP left. #");
			if(rand.nextInt(100) < healthPotionDropChance) {
				numHealthPots++;
				System.out.println("The " + enemy + "Dropped a health pot! #");
				System.out.println(" # You now have " + numHealthPots + "Health potion(s) #");
				
			}
			System.out.println("------------------------------");
			System.out.println("What would you like to do?");
			System.out.println("1. Continue Fighting");
			System.out.println("2. Exit the Dojo");
			
			String input = in.nextLine();
			
			while(!input.equals("1") && !input.equals("2")) {
				System.out.println("Invalid Command!");
				input = in.nextLine();
				
			}
			if(input.equals("1") ) {
				System.out.println("Shall you continue?");
			}
			else if(input.equals("2") ) {
				System.out.println("You exit from the Dojo, Successful!");
				break;
			}
		}
		System.out.println("####################");
		System.out.println("Thanks for playing!");
		System.out.println("####################");
		
	}	
}
