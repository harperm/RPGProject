import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Level
{	
	private Map map;
	
	public Level(String mapName, String enemiesFile, String equipmentFile,
			String potionsFile, String questItemsFile, String NPCFile) throws IOException
	{
		this.map = importMap(mapName);
		importEnemies(enemiesFile);
		importNPCs(NPCFile);
		importEquipment(equipmentFile);
		importPotions(potionsFile);
		importQuestItems(questItemsFile);
	}
	
	public void setMap(Map newMap){ this.map = newMap; }
	
	public Map getMap(){ return this.map; }
	
	public static void main(String[] args) throws IOException
	{
		Character player = new Character("lonk","warrior");
		String mapFile = "Level0.txt";
		String enemiesFile = "EnemyObjects.txt";
		String equipmentFile = "EquipmentObjects.txt";
		String potionsFile = "PotionObjects.txt";
		String questItemsFile = "ItemQuestObjects.txt";
		String NPCFile = "NPCObjects.txt";
		Level level0 = new Level(mapFile, enemiesFile, equipmentFile, potionsFile, questItemsFile, NPCFile);
		
		Map map = level0.map;
		map.printMap(player);
	}
	
	public Map importMap(String file) throws IOException
	{
		BufferedReader count = new BufferedReader(new FileReader(file));
		int x; int y = 1;
		
		x = count.readLine().length();
		while(count.readLine()!=null){ y++; }
		System.out.println(x+","+y);
		count.close();
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = "";
		
		Map map = new Map(x,y);
		
		char [][] newMap = new char[map.getMapY()][map.getMapX()];
		for(int i = 0; i < map.getMapY(); i++){ 
			line = reader.readLine();
			for(int j = 0; j < map.getMapX(); j++){
				if (line.length() >= 2){
					newMap[i][j] = line.charAt(j);
				}
			}
		}
		
		flipChar(newMap);
		map.setCharMap(newMap);
		reader.close();
		return map;
	}
	
	public void flipChar(char[][] map)
    {
    	int mapY = map.length;
    	int mapX = map[0].length;
    	
        //flips verticlly
        for(int i=0;i<mapY;i++){
            for(int j=0;j<mapX/2;j++){
            	char temp = map[i][j];
            	map[i][j] = map[i][mapX-j-1];
            	map[i][mapX-j-1] = temp;
            }
        }
        
        //flips horizontally
        for(int i=0;i<mapX;i++){
            for(int j=0;j<mapY/2;j++){
            	char temp = map[j][i];
            	map[j][i] = map[mapY-j-1][i];
            	map[mapY-j-1][i] = temp;
            }
        }
    }
	
	public ArrayList<String> readConstructor(String line)
	{
		ArrayList<String> T = new ArrayList<String>();
		while(true){
			if(line.indexOf(",") == -1){ //at the end of the string
				T.add(line.substring(0, line.length()));
				break;
			}else{
				T.add(line.substring(0, line.indexOf(",")));
				line = line.substring(line.indexOf(",") + 1, line.length());
			}
		}
		
		return T;
	}
	
	public void importEnemies(String enemiesFile) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(enemiesFile));
		String line = null;
		while((line = reader.readLine()) != null){
			ArrayList<String> T = readConstructor(line);
		  
	        Enemy temp = new Enemy(T.get(0),T.get(1),Integer.parseInt(T.get(2)),Integer.parseInt(T.get(3)),
	        		  Integer.parseInt(T.get(4)),Integer.parseInt(T.get(5)),Integer.parseInt(T.get(6)),
	        		  Integer.parseInt(T.get(7)),null,null,null,null);

		  
			Random n = new Random();
			while(true){
				int posX = n.nextInt(this.map.getMapX());
				int posY = n.nextInt(this.map.getMapY());
		  
				if(this.map.validPosition(posX,posY) == true){
					this.map.place(temp, posX, posY);
					System.out.println("Enemy: ");
					System.out.println("x: " + posX + "  y: " + posY); // used only to see where the enemys actually are 
					break;
				}
			}
		}
		reader.close();
	}

	public void importNPCs(String NPCFile) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(NPCFile));
		String line = null;
		while((line = reader.readLine()) != null){
			ArrayList<String> T = readConstructor(line);
		   
			NPC temp  = new NPC(T.get(0), T.get(1),T.get(2), T.get(3),T.get(4),T.get(5), null, false);
		    NPC temp1 = new NPC(T.get(6), T.get(7),T.get(8), T.get(9),T.get(10),T.get(11), null, false);
		    NPC temp2 = new NPC(T.get(12), T.get(13),T.get(14), T.get(15),T.get(16),T.get(17), null, true);
		     
		    int posX= 5,posX1=4, posX2=10;  //10
		    int posY=0,posY1=1, posY2= 7;	//7
		  
		    if(map.validPosition(posX,posY) == true){
		    	map.place(temp, posX, posY);
		    	map.place(temp1, posX1, posY1);
		    	map.place(temp2, posX2, posY2);
		    	System.out.println("NPC: ");
		    	System.out.println("x: " + posX + "  y: " + posY); // used only to see where NPC actually are placed
		    	break;
		    }
		}
		reader.close();
	}
	
	public void importEquipment(String equipmentFile) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(equipmentFile));
		String line = null;
		while((line = reader.readLine()) != null){
			ArrayList<String> T = readConstructor(line);
			
			Equipment temp = new Equipment(T.get(0), T.get(1), T.get(2), Integer.parseInt(T.get(3)));
			  
			Random n1 = new Random();
			while(true){ 
				int posX = n1.nextInt(this.map.getMapX());
			    int posY = n1.nextInt(this.map.getMapY());
			  
			    if(this.map.validPosition(posX,posY) == true){
			    	this.map.place(temp, posX, posY);
			    	System.out.println("Equipment: ");
			    	System.out.println("x: " + posX + "  y: " + posY);
			    	// used only to see where the equipment actually are 
			    	break;
			    }
			}
		}
		reader.close();
	}
	
	public void importPotions(String potionsFile) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(potionsFile));
		String line = null;
		while((line = reader.readLine()) != null){
			ArrayList<String> T = readConstructor(line);
		    
			Potion temp = new Potion(T.get(0), T.get(1), Integer.parseInt(T.get(2)));
		  
			Random n2 = new Random();
			while(true){ 
				int posX = n2.nextInt(21);
				int posY = n2.nextInt(11);
				
			    if(map.validPosition(posX,posY) == true){
			    	map.place(temp, posX, posY);
			    	System.out.println("Potion: ");
			    	System.out.println("x: " + posX + "  y: " + posY); // used only to see where potions actually are placed
			    	break;
			    }
			}
		}
		reader.close();
	}
	
	public void importQuestItems(String questItemsFile) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(questItemsFile));
		String line = null;
		while((line = reader.readLine()) != null){
			ArrayList<String> T = readConstructor(line);
			
			Item temp = new Item(T.get(0));
	     
			int posX = 13;	//13
			int posY = 7;	//7
		    if(map.validPosition(posX,posY) == true){
		    	map.place(temp, posX, posY);
		    	System.out.println("Crystal: ");
		    	System.out.println("x: " + posX + "  y: " + posY); // used only to see where the cyrstal is actually placed
		    	break;
		    }
		}
		reader.close();
	}
}
