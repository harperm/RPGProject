import java.util.Random;
import java.util.Scanner;

public class Combat
{
	private boolean turn = true;
	static Scanner keyboard = new Scanner(System.in);
	static Random rand = new Random();
	
	public Combat(Character player, Enemy enemy)
	{
		System.out.println("Player HP: "+player.getHealth());
		System.out.println("Enemy HP: "+enemy.getHealth());
		System.out.println();
		
		while(true){
			if(this.turn){
				attack(player, enemy);
			}else{
				attack(enemy, player);
			}
			
			this.turn = !this.turn;
			
			if(player.getHealth()<=0){
				death();
				break;
			}else if(enemy.getHealth()<=0){
				victory();
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
		
		if(hitChance(attacker, target)){
			System.out.println("Hit: "+attacker.getAttacks()[choice-1]);
			damage(target, choice);
		}else{
			System.out.println("Miss");
		}
	}
	
	public boolean hitChance(Character attacker, Character target)
	{
		int randomHit = rand.nextInt(100)+1;
		int speedBonus = (attacker.getSpeed() - target.getSpeed())/5;
		
		if(randomHit+speedBonus >= 50){
			return true;
		}else{
			return false;
		}
	}
	
	public void damage(Character target, int choice)
	{
		target.setHealth(target.getHealth()-(choice*10));
	}
	
	public void victory()
	{
		System.out.println("You won!");
	}
	
	public void death()
	{
		System.out.println("You are dead.");
		System.out.println("Game Over");
	}
	
	public static void main(String[] args)
	{
		Character player = new Character("link","warrior");
		Enemy enemy = new Enemy("orc","warrior",3,80,150,0,80,60,null,null,null,null);
		new Combat(player, enemy);
	}
}
