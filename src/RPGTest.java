//Derek Chaplin  (chaplind@wit.edu)
//Mallory Harper (harperm@wit.edu)

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
		
		Character player = new Character("lonk","warrior");
		Level level0 = new Level(player,mapFile, enemiesFile, equipmentFile, potionsFile, questItemsFile, NPCFile);

		Map map = level0.getMap();
		
		//Character player1 = new Character("bob","mage");
		//Character player2 = new Character("zio","thief");
		
		player.printCharacter();
		
		map.printMap(player);
		map.checkCollision(player);
		
		//*
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
		
		
		//*/
		
		keyboard.close();
	}
}
