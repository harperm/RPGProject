//Derek Chaplin  (chaplind@wit.edu)
//Mallory Harper (harperm@wit.edu)

/*
	 * Character creation is done with these constuctors:
	 * Character(name,role,positionx,positiony)
	 * Enemy(name,role,positionx,positiony,level,health,mana,strength,defense,speed,status,attack0,attack1,attack2)
	 * NPC(name,role,positionx,positiony,dialog0,dialog1,dialog2,dialog3,dialog4)
	 * 
	 * Equipment is created using:
	 * Equipment(name,type,stat0,effect0)
	 * Equipment(name,type,stat0,effect0,stat1,effect1)
	 * Equipment(name,type,stat0,effect0,stat1,effect1,stat2,effect2)
	 * 
	 * Equipment is equipped using: equipment.equip(character)
	 * Equipment is uneqipped using: equipment.unequip(character)
	 * 
	 * Items are created using:
	 * Item(name,stat,heal) //restore potions
	 * Item(name,status) //cure item
	 * Item(name,npc) //quest item
	 * Item(name) //misc item
	 * 
	 * Combat is done through Combat(player, enemy)
	 * 
 */

public class RPGTest
{
	public static void main(String[] args)
	{
		Character player0 = new Character("lonk","warrior",0,0);
		Map map = new Map(5,5);
		//map.checkCollision(player0);
		//Character player1 = new Character("bob","mage");
		//Character player2 = new Character("zio","thief");
		
		Equipment sword0 = new Equipment("rookie blade","weapon","strength",10);
		Equipment sword1 = new Equipment("test blade","weapon","strength",5);
		Potion smallHealth = new Potion("small health potion","health",10);
		
		player0.printCharacter();
		
		sword0.printEquipment();
		sword0.equip(player0);
		
		smallHealth.printItem();
		smallHealth.add(player0);
		smallHealth.add(player0);
		smallHealth.use(player0);
		
		player0.printCharacter();
		
		
		Enemy enemy0 = new Enemy("orc","warrior",0,0,1,80,150,0,80,60,null,null,null,null);
		Enemy enemy1 = new Enemy("orc","mage",0,1,1,80,150,0,80,60,null,null,null,null);
		//NPC npc0 = new NPC("grand wizard","npc","hello","welcome, adventurer","i am here to guide you",null,null);
		
		//new Combat(player0, enemy0);
		//new Combat(player0, enemy1);
		
		System.out.println();		
		System.out.println("You completed the game!");
		System.out.println("Congradulations!");
	}
}
