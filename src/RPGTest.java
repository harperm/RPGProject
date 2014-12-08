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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RPGTest
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Scanner keyboard = new Scanner(System.in);

		Map map = new Map(21,11);

		Character player = new Character("lonk","warrior");
		//Character player1 = new Character("bob","mage");
		//Character player2 = new Character("zio","thief");

		Enemy enemy0 = new Enemy("Orc","warrior",1,80,150,0,80,60,null,null,null,null);
		Enemy enemy1 = new Enemy("Elf","mage",1,80,150,0,80,60,null,null,null,null);
		Enemy enemy2 = new Enemy("Hafling","thief",1,80,150,0,80,60,null,null,null,null);
		Enemy enemy3 = new Enemy("Orc","warrior",1,80,150,0,80,60,null,null,null,null);
		Enemy enemy4 = new Enemy("Human","mage",1,80,150,0,80,60,null,null,null,null);
		Enemy enemy5 = new Enemy("Elf","thief",1,80,150,0,80,60,null,null,null,null);

		NPC npc0 = new NPC("grand wizard","npc","hello","welcome, adventurer","i am here to guide you","start of by finding the magic crystal",null);
		NPC npc1 = new NPC("grand wizard", "npc" ,"to complete this quest you must","bring the magic crystal ","to the emperor",null,null);

		Equipment sword0 = new Equipment("rookie blade","weapon","strength",10);
		Equipment sword1 = new Equipment("test blade","weapon","strength",5);

		Potion smallHealth = new Potion("small health potion","health",10);
		Potion smallStamina = new Potion("small stamina potion", "health", 15);
		Potion smallMana = new Potion("small mana potion", "health", 5);

		Item questItem = new Item("magic crystal");

		sword0.equip(player);
		map.place("Welcome to the PRG!",0,0);

		BufferedReader reader = new BufferedReader(new FileReader("FinalMap2.txt"));
		String line = "";

		//11x21
		char [][] newMap = new char[11][21];
		while( line != null)
		{

			for(int i = 0; i < newMap.length; i++)
			{ 
				line = reader.readLine();
				if (line != null)
				{
					for (int j = 0; j < newMap[i].length; j++){
						if (line.length() >= 2){
							newMap[i][j] = line.charAt(j);
						}
					}
				}
				else
					break;
			}

		}

		reader.close();
		player.printCharacter();

		RPGTest.printMap(newMap);



		//map.place(player,0,0);
		//map.place(questItem, 1,1);
		//map.place(enemy0,16,2);
		/*map.place(enemy1,0,1);
		map.place(enemy2,4,4);
		map.place(enemy3,15,5);
		map.place(enemy4,6,7);
		map.place(enemy5,16,8);
		map.place(npc0,1,0);
		map.place(npc1, 1, 1);
		map.place(sword1,0,0);
		map.place(smallHealth,0,0);
		map.place(smallStamina, 10, 4);
		map.place(smallMana, 11, 7);*/

		
		//map.printMap(player);

		//map.checkCollision(player);

		while(true)
		{
			System.out.print("Command: ");
			String command = keyboard.next();
			if(command.equals("exit")){
				break;
			}else{
				String option = keyboard.next();
				System.out.println();
				new Command(player,map,command,option);
			}
		}

		keyboard.close();
		System.out.println();		
		System.out.println("You completed the game!");
		System.out.println("Congradulations!");
	}
	
	public static void printMap(char[][] map){
		for(int i = 0; i < map.length; i++)
		{
			printSeparator();
			System.out.print("#|");
			for(int j = 0; j < map[i].length; j++)
			{
				if (map[i][j] == 'E')
					System.out.print(' ');
				else
					System.out.print(map[i][j]); 
				System.out.print('|'); 
			}
			System.out.println("#");
		}
		printSeparator();
	}
	
	private static void printSeparator(){
		for (int i=0; i<45; i++)
			System.out.print('#');
		System.out.println();
	}
}
