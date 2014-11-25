//Derek Chaplin  (chaplind@wit.edu)
//Mallory Harper (harperm@wit.edu)

/*
	 * Characters:
	 * Character(name,role,positionx,positiony)
	 * Enemy(name,role,level,health,mana,strength,defense,speed,status,attack0,attack1,attack2)
	 * NPC(name,role,dialog0,dialog1,dialog2,dialog3,dialog4)
	 * 
	 * The Game Map:
	 * Map(mapx,mapy)
	 * map.place(character,x,y)
	 * 
	 * Equipments:
	 * Equipment(name,type,stat0,effect0)
	 * Equipment(name,type,stat0,effect0,stat1,effect1)
	 * Equipment(name,type,stat0,effect0,stat1,effect1,stat2,effect2)
	 * equipment.equip(character)
	 * equipment.unequip(character)
	 * 
	 * Items:
	 * Item(name)
	 * Potion(name,stat,heal)
	 * StatusPotion(name,status)
	 * QuestItem(name,npc)
	 * 
	 * Combat is done through Combat(player, enemy)
	 * 
 */

public class RPGTest
{
	public static void main(String[] args)
	{
		Map map = new Map(5,5);
		
		Character player0 = new Character("lonk","warrior");
		//Character player1 = new Character("bob","mage");
		//Character player2 = new Character("zio","thief");
		
		Enemy enemy0 = new Enemy("orc","warrior",1,80,150,0,80,60,null,null,null,null);
		Enemy enemy1 = new Enemy("orc","mage",1,80,150,0,80,60,null,null,null,null);
		
		NPC npc0 = new NPC("grand wizard","npc","hello","welcome, adventurer","i am here to guide you",null,null);
		
		Equipment sword0 = new Equipment("rookie blade","weapon","strength",10);
		//Equipment sword1 = new Equipment("test blade","weapon","strength",5);
		
		Potion smallHealth = new Potion("small health potion","health",10);
		
		map.place(player0,0,0);
		map.place(enemy0,0,0);
		map.place(enemy1,0,1);
		map.place(npc0,1,0);
		map.place(smallHealth,0,0);
		
		player0.printCharacter();
		map.checkCollision(player0);
		
		sword0.printEquipment();
		sword0.equip(player0);
		
		//smallHealth.printItem();
		//smallHealth.add(player0);
		//smallHealth.add(player0);
		//smallHealth.use(player0);
		
		player0.printCharacter();
		
		
		
		
		//new Combat(player0, enemy0);
		//new Combat(player0, enemy1);
		
		System.out.println();		
		System.out.println("You completed the game!");
		System.out.println("Congradulations!");
	}
}
