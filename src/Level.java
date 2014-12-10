import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Level
{	
	private Map map;
	
	public Level(String mapName, String charactersFile, String equipmentFile) throws FileNotFoundException, IOException
	{
		this.map = importMap(mapName);
		//importCharacters(charactersFile);
		//importEquipment(equipmentFile);
	}
	
	public void setMap(Map newMap){ this.map = newMap; }
	
	public Map getMap(){ return this.map; }
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Character player = new Character("lonk","warrior");
		String mapFile = "FinalMap2.txt";
		String charactersFile = "CharacterObjects.txt";
		String equipmentFile = "EquipmentObjects.txt";
		Level level0 = new Level(mapFile, charactersFile, equipmentFile);
		
		Map map = level0.map;
		map.printMap(player);
	}
	
	public Map importMap(String file) throws FileNotFoundException, IOException
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
	
	public void importCharacters(String charactersFile) throws FileNotFoundException, IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader("CharacterObjects.txt"));
		String line = null;
		while((line = reader.readLine()) != null){
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
		  
			Enemy temp = new Enemy(T.get(0),T.get(1),Integer.parseInt(T.get(2)),Integer.parseInt(T.get(3)),
					Integer.parseInt(T.get(4)),Integer.parseInt(T.get(5)),Integer.parseInt(T.get(6)),
					Integer.parseInt(T.get(7)),T.get(8),T.get(9),T.get(10),T.get(11));
		  
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
	
	public void importEquipment(String equipmentFile) throws FileNotFoundException, IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader("EquipmentObjects.txt"));
		String line1 = null;
		while((line1 = reader.readLine()) != null){
			ArrayList<String> T1 = new ArrayList<String>();
		  
			while(true){
				if(line1.indexOf(",") == -1){ //at the end of the string
					T1.add(line1.substring(0, line1.length()));
					break;
			    }else{
			    	T1.add(line1.substring(0, line1.indexOf(",")));
			    	line1 = line1.substring(line1.indexOf(",") + 1, line1.length());
			    }
	      	}
			
			Equipment temp = new Equipment(T1.get(0), T1.get(1), T1.get(2), Integer.parseInt(T1.get(3)));
			  
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
}
