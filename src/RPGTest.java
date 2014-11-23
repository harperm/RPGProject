//Derek Chaplin  (chaplind@wit.edu)
//Mallory Harper (harperm@wit.edu)

	/*
	 * Character creation is done with these constuctors:
	 * Character(name,role)
	 * Enemy(name,role,level,health,mana,strength,defense,speed,status,attack0,attack1,attack2)
	 * NPC(name,role,dialog0,dialog1,dialog2,dialog3,dialog4)
	 * 
	 * Combat is done through Combat(player, enemy)
	 */

public class RPGTest
{
	public static void main(String[] args)
	{
		
		Character test0 = new Character("lonk","warrior");
		Character test1 = new Character("bob","mage");
		Character test2 = new Character("zio","thief");
		Enemy test3 = new Enemy("orc","warrior",1,80,150,0,80,60,null,null,null,null);
		Enemy test4 = new Enemy("orc","mage",1,80,150,0,80,60,null,null,null,null);
		NPC test5 = new NPC("grand wizard","npc","hello","welcome, adventurer","i am here to guide you",null,null);
		
		new Combat(test0, test3);
		new Combat(test0, test4);
		System.out.println();
		
		System.out.println("You completed the game");
		System.out.println("Congradulations!");
	}
}
