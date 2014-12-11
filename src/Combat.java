import java.util.Random;
import java.util.Scanner;

public class Combat
{
	private boolean turn = true;
	static Scanner keyboard = new Scanner(System.in);
	static Random rand = new Random();
	
	public void fight(Character player, Enemy enemy)
	{
		printHPs(player, enemy);
		
		while(true){
			if(this.turn){
				attack(player, enemy);
				System.out.println();
			}else{
				attack(enemy, player);
				System.out.println();
				printHPs(player, enemy);
			}
			
			this.turn = !this.turn;
			
			if(player.getHealth()<=0){
				death();
				break;
			}else if(enemy.getHealth()<=0){
				victory(player, enemy);
				break;
			}
		}
	}
	
	public void attack(Character attacker, Character target)
	{
		int choice = 0;
		if(!this.turn){ choice = rand.nextInt(3)+1; }
		else{
			String[] attacks = attacker.getAttacks();
			for(int i=0;i<attacks.length;i++){ System.out.println((i+1)+". "+attacks[i]); }
			
			do{
				if(choice>attacks.length || choice<0){ System.out.println("Error: Not a valid attack"); }
				System.out.print("Enter attack number: \n");
				choice = keyboard.nextInt();
			}while(choice>attacks.length || choice<0);
		}
		
		System.out.println(attacker.getName()+" used "+attacker.getAttacks()[choice-1]);
		
		if(hitChance(attacker, target)){
			System.out.println(attacker.getAttacks()[choice-1]+" landed");
			System.out.println("Damage dealt: "+damage(target, choice));
		}else{
			System.out.println(attacker.getAttacks()[choice-1]+" missed");
		}
	}
	
	public boolean hitChance(Character attacker, Character target)
	{
		int randomHit = rand.nextInt(100)+1;
		int speedBonus = (attacker.getSpeed()-target.getSpeed())/5;
		
		if(randomHit+speedBonus >= 35){
			return true;
		}else{
			return false;
		}
	}
	
	public int damage(Character target, int choice)
	{
		//set to choice*10 until Equipment is done
		int damageAmount = choice*10; 
		target.setHealth(target.getHealth()-damageAmount);
		
		return damageAmount;
	}
	
	public void victory(Character player, Character enemy)
	{	
		player.setExperience(player.getExperience()+(enemy.getLevel()*30));
		player.setHealth(player.getMaxHealth());
		System.out.println("You won the battle!");
		System.out.println("Press Enter to continue");
		keyboard.nextLine();
		keyboard.nextLine();
	}
	
	public void death()
	{
		System.out.println("You are dead.");
		System.out.println("Game Over");
		System.exit(0);
	}
	
	public void printHPs(Character player, Character enemy){
		System.out.println("Player HP: "+player.getHealth());
		System.out.println("Enemy HP: "+enemy.getHealth());
		System.out.println();
	}
}
