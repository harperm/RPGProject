import java.util.Random;
import java.util.Scanner;

public class Combat
{
	private boolean turn = true;
	static Scanner keyboard = new Scanner(System.in);
	static Random rand = new Random();
	
	public Combat(Character player, Enemy enemy)
	{
		System.out.println("A "+enemy.getRole()+" "+enemy.getName()+" has appeared!");
		System.out.println();
		
		System.out.println(player.getName()+" HP: "+player.getHealth());
		System.out.println(enemy.getName()+" HP: "+enemy.getHealth());
		System.out.println();
		
		while(true){
			if(this.turn){
				attack(player, enemy);
			}else{
				attack(enemy, player);
			}
			System.out.println();
			
			this.turn = !this.turn;
			
			if(player.getHealth()<=0){
				death();
				break;
			}else if(enemy.getHealth()<=0){
				victory(player, enemy);
				break;
			}
			
			System.out.println("Player HP: "+player.getHealth());
			System.out.println("Enemy HP: "+enemy.getHealth());
			System.out.println();
		}
	}
	
	public void attack(Character attacker, Character target)
	{
		int choice = 0;
		
		if(!this.turn){
			choice = rand.nextInt(3)+1;
		}else{
			String[] attacks = attacker.getAttacks();
			
			for(int i=0;i<attacks.length;i++){
				System.out.println((i+1)+". "+attacks[i]);
			}
			
			do{
				if(choice>attacks.length || choice<0){
					System.out.println("Error: Not a valid attack");
				}
				
				System.out.print("Enter attack number: ");
				choice = keyboard.nextInt();
				System.out.println();
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
		
		if(randomHit+speedBonus >= 50){
			return true;
		}else{
			return false;
		}
	}
	
	public int damage(Character target, int choice)
	{
		//set to attack[i]*10 until i fix Character for assigning damage to attacks
		int damageAmount = choice*10; 
		target.setHealth(target.getHealth()-damageAmount);
		
		return damageAmount;
	}
	
	public void victory(Character player, Character enemy)
	{	
		player.setExperience(player.getExperience()+(enemy.getLevel()*30));
		player.setHealth(player.getMaxHealth());
		System.out.println("You won the battle!");
		keyboard.nextLine();
		keyboard.nextLine();
	}
	
	public void death()
	{
		System.out.println("You are dead.");
		System.out.println("Game Over");
		System.exit(0);
	}
}
