//Derek Chaplin  (chaplind@wit.edu)
//Mallory Harper (harperm@wit.edu)

/*
 * Characters:
 * Character(name,role)
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

import java.io.*;
import java.util.*;

public class RPGTest
{
	public static void main(String[] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);

		String mapFile = "Level0.txt";
		String enemiesFile = "EnemyObjects.txt";
		String equipmentFile = "EquipmentObjects.txt";
		String potionsFile = "PotionObjects.txt";
		String questItemsFile = "ItemQuestObjects.txt";
		String NPCFile = "NPCObjects.txt";
		Level level0 = new Level(mapFile, enemiesFile, equipmentFile, potionsFile, questItemsFile, NPCFile);

		Map map = level0.getMap();
		Character player = new Character("lonk","warrior");
		//Character player1 = new Character("bob","mage");
		//Character player2 = new Character("zio","thief");

		/*
		 // Placed these randomly through an imported text file 
		Enemy enemy0 = new Enemy("Orc","warrior",1,80,150,0,80,60,null,null,null,null);
		Enemy enemy1 = new Enemy("Elf","mage",1,80,150,0,80,60,null,null,null,null);
		Enemy enemy2 = new Enemy("Hafling","thief",1,80,150,0,80,60,null,null,null,null);
		Enemy enemy3 = new Enemy("Orc","warrior",1,80,150,0,80,60,null,null,null,null);
		Enemy enemy4 = new Enemy("Human","mage",1,80,150,0,80,60,null,null,null,null);
		Enemy enemy5 = new Enemy("Elf","thief",1,80,150,0,80,60,null,null,null,null);
		
		* Place in through imported text file
		NPC npc0 = new NPC("grand wizard","npc","hello","welcome, adventurer","i am here to guide you","start of by finding the magic crystal",null);
		NPC npc1 = new NPC("grand wizard", "npc" ,"to complete this quest you must","bring the magic crystal ","to the emperor",null,null);
		NPC npc2 = new NPC("emperor", "npc","You found me!","and you have the magic cyrstal",null,null,null);
		
		// Placed these randomly through an imported text file
		Equipment sword0 = new Equipment("rookie blade","weapon","strength",10);
		Equipment sword1 = new Equipment("test blade","weapon","strength",5);
		Equipment sword2 = new Equipment("ironforge blade","weapon","strength",20);
		Equipment helm0 = new Equipment("bronze helmet","head","defese",5);
		Equipment helm1 = new Equipment("iron helmet","head","defese",15);
		
		* Placed these randomly through an imported text file
		Potion smallHealth = new Potion("small health potion","health",10);
		Potion smallStamina = new Potion("small stamina potion", "health", 15);
		Potion smallMana = new Potion("small mana potion", "mana", 5);
		
		* Placed in through imported text fie
		Item questItem = new Item("magic crystal", npc2);
		
		map.place("Welcome to the RPG!",0,0);
		map.place(player,0,0);
		map.place(questItem, 1,1);
		map.place(enemy0,16,2);
		map.place(enemy1,0,1);
		map.place(enemy2,4,4);
		map.place(enemy3,15,5);
		map.place(enemy4,6,7);
		map.place(enemy5,16,8);
		map.place(npc0,1,0);
		map.place(npc1, 1, 1);
		map.place(npc2, 19, 10);
		map.place(npc2, 5, 1);
		map.place(sword1,0,0);
		map.place(smallHealth,0,0);
		map.place(smallStamina, 10, 4);
		map.place(smallMana, 11, 7);
		*/
		
		
		player.printCharacter();
		
		//String file = "FinalMap2.txt";
		//map.importMap(file);
		map.printMap(player);
		
		map.checkCollision(player);
		
	
		
		while(true)
		{
			System.out.print("Command: ");
			String command = keyboard.next();
			if(command.equals("exit")){
				break;
			}else{
				System.out.println();
				new Command(player,map,command);
			}
		}
		
		
		/*
		map.move(player, "up");
		map.move(player, "left");
		map.move(player, "right");
		map.move(player, "down");
		map.move(player, "down");
		map.move(player, "right");
		map.move(player, "right");
		map.move(player, "right");
		map.move(player, "down");
		map.move(player, "up");
		map.move(player, "left");
		map.move(player, "down");
		map.move(player, "right");
		map.move(player, "right");
		map.move(player, "down");
		*/
		
		keyboard.close();
		
		/*
		System.out.println();		
		System.out.println("You completed the game!");
		System.out.println("Congradulations!");
		*/
	}
}
