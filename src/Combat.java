import java.util.Random;

public class Combat
{
	public static boolean hitChance(Character attacker, Enemy target)
	{
		Random rand = new Random();
		int randomNum = rand.nextInt(100)+1;
		int speedBonus = (attacker.getSpeed() - target.getSpeed())/5;
		
		System.out.println("RandomNum: "+randomNum);
		System.out.println("Player Speed: "+attacker.getSpeed());
		System.out.println("Enemy Speed: "+target.getSpeed());
		System.out.println("SpeedBonus: "+speedBonus);
		System.out.println("Outcome: "+(randomNum+speedBonus));
		
		if(randomNum+speedBonus >= 50){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args)
	{
		Character player = new Character("link","warrior");
		Enemy enemy = new Enemy("orc","warrior",3,500,150,0,80,60,null,null,null,null);
		
		System.out.println(hitChance(player, enemy));
		System.out.println();
		System.out.println(hitChance(player, enemy));
		System.out.println();
		System.out.println(hitChance(player, enemy));
		System.out.println();
		System.out.println(hitChance(player, enemy));
		System.out.println();
		System.out.println(hitChance(player, enemy));
		System.out.println();
	}
}
