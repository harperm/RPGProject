import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Level
{	
	private Character player;
	private Map map;
	
	public Level(Character player, String mapName, String enemiesFile, String equipmentFile,
			String potionsFile, String questItemsFile, String NPCFile) throws IOException
	{
		this.player = player;
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
		String questItemsFile = "QuestItemObjects.txt";
		String NPCFile = "NPCObjects.txt";
		Level level0 = new Level(player, mapFile, enemiesFile, equipmentFile, potionsFile, questItemsFile, NPCFile);
		
		Map map = level0.map;
		map.printMap(player);
	}
	
	public Map importMap(String file) throws IOException
	{
		BufferedReader count = new BufferedReader(new FileReader(file));
		int x; int y = 1;
		
		x = count.readLine().length();
		while(count.readLine()!=null){ y++; }
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
		
		for(int i=0;i<T.size();i++){
			if(T.get(i).equals("null")){
				T.set(i,null);
			}else if(T.get(i).equals("")){
				
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
	        		  Integer.parseInt(T.get(7)),T.get(8),T.get(9),T.get(10));

		  
			Random n = new Random();
			int posX = n.nextInt(this.map.getMapX());
			int posY = n.nextInt(this.map.getMapY());
			place(temp,posX,posY);
		}
		reader.close();
	}

	public void importNPCs(String NPCFile) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(NPCFile));
		String line = null;
		while((line = reader.readLine()) != null){
			ArrayList<String> T = readConstructor(line);
		   
			NPC temp  = new NPC(T.get(0), "npc" ,T.get(1), T.get(2),
				T.get(3),T.get(4),T.get(5), Boolean.parseBoolean(T.get(6)));
			
		    int posX=Integer.parseInt(T.get(7));
		    int posY=Integer.parseInt(T.get(8));
		    
		    place(temp,posX,posY);
		}
		reader.close();
	}
	
	public void importEquipment(String equipmentFile) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(equipmentFile));
		String line = null;
		while((line = reader.readLine()) != null){
			ArrayList<String> T = readConstructor(line);
			
			Equipment temp = new Equipment(T.get(0),T.get(1),T.get(2),Integer.parseInt(T.get(3)));
			  
			int posX=Integer.parseInt(T.get(4));
			int posY=Integer.parseInt(T.get(5));
			 
			place(temp,posX,posY);
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
		  
			Random n = new Random();
			
			int posX = n.nextInt(21);
			int posY = n.nextInt(11);
			
			place(temp,posX,posY);
			System.out.println(posX+","+posY);
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
			
			int posX = Integer.parseInt(T.get(2));	
			int posY = Integer.parseInt(T.get(3));	
			place(temp,posX,posY);
		}
		reader.close();
	}
	
	public void place(Object object, int x, int y)
	{
		while(true){
			if(this.map.validPosition(this.player,x,y) == true){ 
				this.map.place(object, x, y); 
			}
			break;
		}
	}
}
