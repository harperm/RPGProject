//Derek Chaplin  (chaplind@wit.edu)
//Mallory Harper (harperm@wit.edu)

import java.io.IOException;
import java.util.Scanner;

public class RPGDemo
{
	public static void main(String[] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		String role;
		String name;
		
		System.out.print("Enter Name: ");
		name = keyboard.next();
		System.out.println();
		
		while(true){
			System.out.println("Roles: Warrior, Mage, Thief");
			System.out.print("Enter Role: ");
			role = keyboard.next();
			role.toLowerCase();
			if(role.equals("warrior")||role.equals("mage")||role.equals("thief")){ break; }
			else{ System.out.println("Error: Incorrect Role\n"); }
		}
		
		String mapFile = "Level0.txt";
		String enemiesFile = "EnemyObjects.txt";
		String equipmentFile = "EquipmentObjects.txt";
		String potionsFile = "PotionObjects.txt";
		String questItemsFile = "QuestItemObjects.txt";
		String NPCFile = "NPCObjects.txt";
		
		Character player = new Character(name,role);
		Level level0 = new Level(player, mapFile, enemiesFile, equipmentFile, potionsFile, questItemsFile, NPCFile);
		Map map = level0.getMap();
		
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
		
		keyboard.close();
	}
}