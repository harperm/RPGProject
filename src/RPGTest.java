//Derek Chaplin  (chaplind@wit.edu)
//Mallory Harper (harperm@wit.edu)

	/*
	 * Character creation is done with these constuctors:
	 * Character(name,role)
	 * Enemy(name,role,level,health,mana,strength,defense,speed,status,attack0,attack1,attack2)
	 * NPC(name,role,dialog0,dialog1,dialog2,dialog3,dialog4)
	 * 
	 * Equipment is created using:
	 * Equipment(name,type,stat0,effect0)
	 * Equipment(name,type,stat0,effect0,stat1,effect1)
	 * Equipment(name,type,stat0,effect0,stat1,effect1,stat2,effect2)
	 * 
	 * equipment is equipped using: equipment.equip(character)
	 * equipment is uneqipped using: equipment.unequip(character)
	 * 
	 * Combat is done through Combat(player, enemy)
	 */

public class RPGTest
{
	public static void main(String[] args)
	{
		Character test0 = new Character("lonk","warrior");
		Equipment sword0 = new Equipment("rookie blade","weapon","strength",10);
		Equipment sword1 = new Equipment("test blade","weapon","strength",5);
		test0.printCharacter();
		sword0.printEquipment();
		sword0.equip(test0);
		//test0.printCharacter();
		//test0.equip(sword1);
		//sword0.unequip(test0);
		//test0.printCharacter();
		
		Character test1 = new Character("bob","mage");
		Character test2 = new Character("zio","thief");
		Enemy test3 = new Enemy("orc","warrior",1,80,150,0,80,60,null,null,null,null);
		Enemy test4 = new Enemy("orc","mage",1,80,150,0,80,60,null,null,null,null);
		NPC test5 = new NPC("grand wizard","npc","hello","welcome, adventurer","i am here to guide you",null,null);
		
		new Combat(test0, test3);
		new Combat(test0, test4);
		System.out.println();
		
		System.out.println("You completed the game!");
		System.out.println("Congradulations!");
	}
}
