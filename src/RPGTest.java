//Derek Chaplin  (chaplind@wit.edu)
//Mallory Harper (harperm@wit.edu)

import java.io.IOException;

public class RPGTest
{
	public static void testCharacter(Character player, String name, String role, String attack0, String attack1, String attack2)
	{
		if(player.getName()==name){ System.out.println("Success: Name is "+name); }
		else{ System.out.println("Failure: Name is not "+name+", it is "+player.getName()); }
		
		if(player.getRole()==role){ System.out.println("Success: Role is "+role); }
		else{ System.out.println("Failure: Role is not "+role+", it is "+player.getRole()); }
		
		if(player.getAttacks()[0]==attack0){ System.out.println("Success: Attack0 is "+player.getAttacks()[0]); }
		else{ System.out.println("Failure: Attack0 is not "+attack0+", it is "+player.getAttacks()[0]); }
		
		if(player.getAttacks()[1]==attack1){ System.out.println("Success: Attack1 is "+player.getAttacks()[1]); }
		else{ System.out.println("Failure: Attack1 is not "+attack1+", it is "+player.getAttacks()[1]); }
		
		if(player.getAttacks()[2]==attack2){ System.out.println("Success: Attack2 is "+player.getAttacks()[2]); }
		else{ System.out.println("Failure: Attack2 is not "+attack2+", it is "+player.getAttacks()[2]); }
	}
	
	public static void testEnemy(Enemy enemy, String name, String role, int level, int health,
		int mana, int strength, int defense, int speed, String attack0, String attack1, String attack2)
	{
		testCharacter(enemy,name,role,attack0,attack1,attack2);
		
		if(enemy.getLevel()==level){ System.out.println("Success: Level is "+level); }
		else{ System.out.println("Failure: Level is not "+level+", it is "+enemy.getLevel()); }
		
		if(enemy.getHealth()==health){ System.out.println("Success: Health is "+health); }
		else{ System.out.println("Failure: Health is not "+health+", it is "+enemy.getHealth()); }
		
		if(enemy.getMana()==mana){ System.out.println("Success: Mana is "+mana); }
		else{ System.out.println("Failure: Mana is not "+mana+", it is "+enemy.getMana()); }
		
		if(enemy.getStrength()==strength){ System.out.println("Success: Strength is "+strength); }
		else{ System.out.println("Failure: Strength is not "+strength+", it is "+enemy.getStrength()); }
		
		if(enemy.getDefense()==defense){ System.out.println("Success: Defense is "+defense); }
		else{ System.out.println("Failure: Defense is not "+defense+", it is "+enemy.getDefense()); }
		
		if(enemy.getSpeed()==speed){ System.out.println("Success: Speed is "+speed); }
		else{ System.out.println("Failure: Speed is not "+speed+", it is "+enemy.getSpeed()); }
	}
	
	public static void testNPC(NPC npc, String name, String dialog0, String dialog1,
			String dialog2, String dialog3, String dialog4, boolean isEmperor)
	{
		if(npc.getName()==name){ System.out.println("Success: Name is "+name); }
		else{ System.out.println("Failure: Name is not "+name+", it is "+npc.getName()); }
		
		if(npc.getDialogs()[0]==dialog0){ System.out.println("Success: Dialog0 is "+dialog0); }
		else{ System.out.println("Failure: Dialog0 is not "+dialog0+", it is "+npc.getDialogs()[0]); }
		
		if(npc.getDialogs()[1]==dialog1){ System.out.println("Success: Dialog1 is "+dialog1); }
		else{ System.out.println("Failure: Dialog1 is not "+dialog1+", it is "+npc.getDialogs()[1]); }
		
		if(npc.getDialogs()[2]==dialog2){ System.out.println("Success: Dialog2 is "+dialog2); }
		else{ System.out.println("Failure: Dialog3 is not "+dialog2+", it is "+npc.getDialogs()[2]); }
		
		if(npc.getDialogs()[3]==dialog3){ System.out.println("Success: Dialog3 is "+dialog3); }
		else{ System.out.println("Failure: Dialog3 is not "+dialog3+", it is "+npc.getDialogs()[3]); }
		
		if(npc.getDialogs()[4]==dialog4){ System.out.println("Success: Dialog4 is "+dialog4); }
		else{ System.out.println("Failure: Dialog4 is not "+dialog4+", it is "+npc.getDialogs()[4]); }
		
		if(npc.getIsEmperor()==isEmperor){ System.out.println("Success: isEmperor is "+isEmperor); }
		else{ System.out.println("Failure: isEmperor is not "+isEmperor+", it is "+npc.getIsEmperor()); }
	}
	
	public static void testEquipment(Equipment equipment, String name, String type, String stat0, int effect0)
	{
		if(equipment.getName()==name){ System.out.println("Success: Name is "+name); }
		else{ System.out.println("Failure: Name is not "+name+", it is "+equipment.getName()); }
		
		if(equipment.getType()==type){ System.out.println("Success: Type is "+type); }
		else{ System.out.println("Failure: Type is not "+type+", it is "+equipment.getType()); }
		
		if(equipment.getStat0()==stat0){ System.out.println("Success: Stat0 is "+stat0); }
		else{ System.out.println("Failure: Stat0 is not "+stat0+", it is "+equipment.getStat0()); }
		
		if(equipment.getEffect0()==effect0){ System.out.println("Success: Effect0 is "+effect0); }
		else{ System.out.println("Failure: Effect0 is not "+effect0+", it is "+equipment.getEffect0()); }
	}
	
	public static void testEquipment(Equipment equipment, String name, String type,
			String stat0, int effect0, String stat1, int effect1)
	{
		testEquipment(equipment,name,type,stat0,effect0);
		
		if(equipment.getStat1()==stat1){ System.out.println("Success: Stat1 is "+stat1); }
		else{ System.out.println("Failure: Stat1 is not "+stat1+", it is "+equipment.getStat1()); }
		
		if(equipment.getEffect1()==effect1){ System.out.println("Success: Effect1 is "+effect1); }
		else{ System.out.println("Failure: Effect1 is not "+effect1+", it is "+equipment.getEffect1()); }
	}
	
	public static void testEquipment(Equipment equipment, String name, String type,
			String stat0, int effect0, String stat1, int effect1, String stat2, int effect2)
	{
		testEquipment(equipment,name,type,stat0,effect0,stat1,effect1);
		
		if(equipment.getStat2()==stat2){ System.out.println("Success: Stat2 is "+stat1); }
		else{ System.out.println("Failure: Stat2 is not "+stat2+", it is "+equipment.getStat2()); }
		
		if(equipment.getEffect2()==effect2){ System.out.println("Success: Effect2 is "+effect2); }
		else{ System.out.println("Failure: Effect2 is not "+effect2+", it is "+equipment.getEffect2()); }
	}
	
	public static void testEquip(Equipment equipment, Character player, String name, int slot, String stat0, int effect0)
	{
		equipment.equip(player);
		
		if(player.getEquipped()[slot]!=null){
			if(player.getEquipped()[slot].getName()==name){ System.out.println("Success: "+name+" equipped"); }
			else{ System.out.println("Failure: "+name+" not equipped, "+player.getEquipped()[slot].getName()+" equipped"); }
		}
		
		int stat, effect;
		if(stat0.equals("health")){ stat = player.getMaxHealth(); }
		else if(stat0.equals("mana")){ stat = player.getMaxMana(); }
		else if(stat0.equals("strength")){ stat = player.getStrength(); }
		else if(stat0.equals("defense")){ stat = player.getDefense(); }
		else if(stat0.equals("speed")){ stat = player.getSpeed(); }
		else{ System.out.println("Test stat "+stat0+" not found"); return; }
		effect = stat+equipment.getEffect0();
		
		if(stat==effect0){ System.out.println("Success: "+stat0+" effected by "+effect0); }
		else{ System.out.println("Failure: "+stat0+" is not "+effect+", it is "+stat); }
	}
	
	public static void testEquip(Equipment equipment, Character player, 
		String name, int slot, String stat0, int effect0, String stat1, int effect1)
	{
		testEquip(equipment,player,name,slot,stat0,effect0);
		
		int stat, effect;
		if(stat1.equals("health")){ stat = player.getMaxHealth(); }
		else if(stat1.equals("mana")){ stat = player.getMaxMana(); }
		else if(stat1.equals("strength")){ stat = player.getStrength(); }
		else if(stat1.equals("defense")){ stat = player.getDefense(); }
		else if(stat1.equals("speed")){ stat = player.getSpeed(); }
		else{ System.out.println("Test stat "+stat1+" not found"); return; }
		effect = stat+equipment.getEffect1();
		
		if(stat==effect1){ System.out.println("Success: "+stat1+" effected by "+effect1); }
		else{ System.out.println("Failure: "+stat1+" is not "+effect+", it is "+stat); }
	}
	
	public static void testEquip(Equipment equipment, Character player, String name,
		int slot, String stat0, int effect0, String stat1, int effect1, String stat2, int effect2)
	{
		testEquip(equipment,player,name,slot,stat0,effect0,stat1,effect1);
		
		int stat, effect;
		if(stat2.equals("health")){ stat = player.getMaxHealth(); }
		else if(stat2.equals("mana")){ stat = player.getMaxMana(); }
		else if(stat2.equals("strength")){ stat = player.getStrength(); }
		else if(stat2.equals("defense")){ stat = player.getDefense(); }
		else if(stat2.equals("speed")){ stat = player.getSpeed(); }
		else{ System.out.println("Test stat "+stat2+" not found"); return; }
		effect = stat+equipment.getEffect2();
		
		if(stat==effect2){ System.out.println("Success: "+stat2+" effected by "+effect2); }
		else{ System.out.println("Failure: "+stat2+" is not "+effect+", it is "+stat); }
	}
	
	public static void testItem(Item item, String name)
	{
		if(item.getName()==name){ System.out.println("Success: Name is "+name); }
		else{ System.out.println("Failure: Name is not "+name+", it is "+item.getName()); }
	}
	
	public static void testPotion(Potion potion, String name, String stat, int heal)
	{
		testItem(potion,name);
		
		if(potion.getStat()==stat){ System.out.println("Success: Stat is "+stat); }
		else{ System.out.println("Failure: Stat is not "+stat+", it is "+potion.getStat()); }
		
		if(potion.getHeal()==heal){ System.out.println("Success: Heal is "+heal); }
		else{ System.out.println("Failure: Heal is not "+heal+", it is "+potion.getHeal()); }
	}
	
	public static void testStatusPotion(StatusPotion statusPotion, String name, String stat)
	{
		testItem(statusPotion,name);
		
		if(statusPotion.getStat()==stat){ System.out.println("Success: Stat is "+stat); }
		else{ System.out.println("Failure: Stat is not "+stat+", it is "+statusPotion.getStat()); }
	}
	
	public static void testQuestItem(QuestItem questItem, String name, NPC npc)
	{
		testItem(questItem,name);
		
		if(questItem.getNPC()==npc){ System.out.println("Success: NPC is "+npc.getName()); }
		else{ System.out.println("Failure: NPC is not "+npc+", it is "+questItem.getNPC().getName()); }
	}
	
	public static void testMap(Map map, int x, int y)
	{
		if(map.getMapX()==x){ System.out.println("Success: MapX is "+x); }
		else{ System.out.println("Failure: MapX is not "+x+", it is "+map.getMapX()); }
		
		if(map.getMapY()==y){ System.out.println("Success: MapY is "+y); }
		else{ System.out.println("Failure: MapY is not "+y+", it is "+map.getMapY()); }
	}
	
	public static void testMove(Character player, Map map, String move, int x, int y)
	{
		map.move(player, move);
		if(player.getPositionX()==x){ System.out.println("Success: PlayerX is "+x); }
		else{ System.out.println("Failure: PlayerX is not "+x+", it is "+player.getPositionX()); }
		
		if(player.getPositionY()==y){ System.out.println("Success: PlayerY is "+y); }
		else{ System.out.println("Failure: PlayerY is not "+y+", it is "+player.getPositionY()); }
	}
	
	public static void main(String[] args) throws IOException
	{	
		//Character(String name, String role)
		System.out.println("Character Tests");
		Character player0 = new Character("lonk","warrior");
		Character player1 = new Character("bob","mage");
		Character player2 = new Character("zio","thief");
		
		testCharacter(player0,"lonk","warrior","punch","charge","slash"); System.out.println();
		testCharacter(player1,"bob","mage","frost","lightning","fireball"); System.out.println();
		testCharacter(player2,"zio","thief","stun","throw","stab"); System.out.println();
		System.out.println();
		
		//Enemy(String name, String role, int level, int health, int mana, int strength,
		//	int defense, int speed, String attack0, String attack1, String attack2)
		System.out.println("Enemy Tests");
		Enemy enemy0 = new Enemy("Orc","warrior",1,80,150,0,80,60,null,null,null);
		Enemy enemy1 = new Enemy("Elf","mage",1,80,150,0,80,60,null,null,null);
		Enemy enemy2 = new Enemy("Hafling","thief",1,80,150,0,80,60,null,null,null);
		Enemy enemy3 = new Enemy("Dragon","boss",15,500,300,200,200,100,"firespit","roar","lavablast");
		
		testEnemy(enemy0,"Orc","warrior",1,80,150,0,80,60,"punch","charge","slash"); System.out.println();
		testEnemy(enemy1,"Elf","mage",1,80,150,0,80,60,"frost","lightning","fireball"); System.out.println();
		testEnemy(enemy2,"Hafling","thief",1,80,150,0,80,60,"stun","throw","stab"); System.out.println();
		testEnemy(enemy3,"Dragon","boss",15,500,300,200,200,100,"firespit","roar","lavablast"); System.out.println();
		System.out.println();
		
		//NPC(String name, String role, String dialog0, String dialog1,
		//	String dialog2, String dialog3, String dialog4, boolean isEmperor)
		System.out.println("NPC Tests");
		NPC npc0 = new NPC("grand wizard","npc","hello","welcome adventurer","i am here to guide you","start off by finding the magic crystal",null,false);
		NPC npc1 = new NPC("emperor","npc","I'm sorry","you may have found me","but you must have the magic crystal first","come find me again when you do!",null,true);
		
		testNPC(npc0,"grand wizard","hello","welcome adventurer","i am here to guide you","start off by finding the magic crystal",null,false); System.out.println();
		testNPC(npc1,"emperor","I'm sorry","you may have found me","but you must have the magic crystal first","come find me again when you do!",null,true); System.out.println();
		System.out.println();
		
		Equipment equipment0 = new Equipment("test blade","weapon","strength",5);
		Equipment equipment1 = new Equipment("rookie blade","weapon","strength",10,"speed",-2);
		Equipment equipment2 = new Equipment("iron helmet","head","defense",15,"speed",-1,"strength",2);
		Equipment equipment3 = new Equipment("boots of swiftness","boots","speed",20);
		
		System.out.println("Equipment Tests");
		testEquipment(equipment1,"rookie blade","weapon","strength",10,"speed",-2); System.out.println();
		testEquipment(equipment0,"test blade","weapon","strength",5); System.out.println();
		testEquipment(equipment2,"iron helmet","head","defense",15,"speed",-1,"strength",2); System.out.println();
		testEquipment(equipment3,"boots of swiftness","boots","speed",20); System.out.println();
		System.out.println();
		
		System.out.println("Equipment Add Tests");
		equipment0.add(player0); player0.printChest(); System.out.println();
		equipment1.add(player0); player0.printChest(); System.out.println();
		equipment2.add(player0); player0.printChest(); System.out.println();
		equipment3.add(player0); player0.printChest(); System.out.println();
		System.out.println();
		
		System.out.println("Equipment Equip Tests");
		testEquip(equipment0,player0,"test blade",0,"strength",105); System.out.println();
		testEquip(equipment1,player0,"rookie blade",0,"strength",110,"speed",28); System.out.println();
		testEquip(equipment2,player0,"iron helmet",1,"defense",115,"speed",27,"strength",112); System.out.println();
		testEquip(equipment3,player0,"boots of swiftness",4,"speed",47); System.out.println();
		System.out.println();
		
		//Item(String name)
		//Potion(String name, String stat, int heal)
		//StatusPotion(String name, String status)
		//QuestItem(String name, NPC npc)
		System.out.println("Item Tests");
		Item item0 = new Item("misc");
		Potion item1 = new Potion("small health","health",10);
		StatusPotion item2 = new StatusPotion("antidote","poison");
		QuestItem item3 = new QuestItem("crystal",npc1);
		
		testItem(item0,"misc"); System.out.println();
		testPotion(item1,"small health","health",10); System.out.println();
		testStatusPotion(item2,"antidote","poison"); System.out.println();
		testQuestItem(item3,"crystal",npc1); System.out.println();
		System.out.println();
		
		System.out.println("Map Tests");
		Map map0 = new Map(4,5);
		Map map1 = new Map(17,12);
		Map map2 = new Map(20,7);
		
		testMap(map0,4,6); System.out.println();
		testMap(map1,17,12); System.out.println();
		testMap(map2,20,7); System.out.println();
		System.out.println();
		
		map0.printMap(player0);
		map1.printMap(player0);
		map2.printMap(player0);
		
		System.out.println("Map Tests");
		testMove(player0,map0,"up",0,1); System.out.println();
		testMove(player0,map0,"left",1,1); System.out.println();
		testMove(player0,map0,"right",0,1); System.out.println();
		testMove(player0,map0,"down",0,0); System.out.println();
		testMove(player0,map0,"down",0,0); System.out.println();
		testMove(player0,map0,"right",0,0); System.out.println();
		System.out.println();
		
		
		
		/*
		System.out.println("Import Level Test");
		String mapFile = "Level0.txt";
		String enemiesFile = "EnemyObjects.txt";
		String equipmentFile = "EquipmentObjects.txt";
		String potionsFile = "PotionObjects.txt";
		String questItemsFile = "QuestItemObjects.txt";
		String NPCFile = "NPCObjects.txt";
		Level level0 = new Level(player0,mapFile, enemiesFile, equipmentFile, potionsFile, questItemsFile, NPCFile);
		*/
		//Map map = level0.getMap();
		
		//player.printCharacter();
		
		//map.printMap(player);
		//map.checkCollision(player);
		
		/*
		map.move(player,"down");
		map.move(player,"right");
		map.move(player,"up");
		map.move(player,"up");
		map.move(player,"up");
		map.move(player,"left");
		map.move(player,"left");
		map.move(player,"left");
		map.move(player,"left");
		map.move(player,"up");
		map.move(player,"left");
		map.move(player,"left");
		map.move(player,"up");
		map.move(player,"up");
		map.move(player,"left");
		/*/
	}
}
