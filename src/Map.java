import java.io.*;

public class Map
{
	private int mapX;
	private int mapY;
	private int[][] intMap;
	private char[][] charMap;
	private String[][] stringMap;
	private Item[][]  itemMap;
	private Equipment[][] equipmentMap;
	private Enemy[][] enemyMap;
	private NPC[][] NPCMap;

	public void importMap(String file) throws FileNotFoundException, IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = "";

		char [][] newMap = new char[mapY][mapX];
		for(int i = 0; i < mapY; i++){ 
			line = reader.readLine();
			for(int j = 0; j < mapX; j++){
				if (line.length() >= 2){
					newMap[i][j] = line.charAt(j);
				}
			}
		}

		setCharMap(newMap);
		reader.close();
	}

	public void printMap(Character player)
	{
		String map = "";
		for(int i=0;i<mapX;i++){
			map += "##";
		}
		map += "###\n";

		for(int i=0;i<mapY;i++){
			map += "#";

			for(int j=0;j<mapX;j++){
				map+= '|';
				if(player.getPositionX()==j&&player.getPositionY()==i){
					map += "P";
				}else if(getCharMap()[i][j]!=' '){
					map+= getCharMap()[i][j];
				}else{
					map += " ";
				}
			}
			map += "|#\n";

			for(int j=mapX-1;j>=0;j--){
				map += "##";
			}
			map += "###\n";
		}
		System.out.println();

		System.out.println(map);
	}

	public Map(int mapX, int mapY)
	{
		this.mapX = mapX;
		this.mapY = mapY;
		this.charMap = new char[mapX][mapY];
		this.stringMap = new String[mapX][mapY];
		this.itemMap = new Item[mapX][mapY];
		this.equipmentMap = new Equipment[mapX][mapY];
		this.enemyMap = new Enemy[this.mapX][this.mapY];
		this.NPCMap = new NPC[mapX][mapY];
	}

	public void setMapX(int newMapX){ this.mapX = newMapX; }
	public void setMapY(int newMapY){ this.mapY = newMapY; }
	public void setCharMap(char newCharMap[][]){ this.charMap = newCharMap; }
	public void setStringMap(String newStringMap[][]){ this.stringMap = newStringMap; }
	public void setItemMap(Item[][] newItemMap){ this.itemMap = newItemMap; }
	public void setEquipmentMap(Equipment[][] newEquipmentMap){ this.equipmentMap = newEquipmentMap; }
	public void setEnemyMap(Enemy newEnemyMap[][]){ this.enemyMap = newEnemyMap; }
	public void setNPCMap(NPC newNPCMap[][]){ this.NPCMap = newNPCMap; }

	public int getMapX(){ return this.mapX; }
	public int getMapY(){ return this.mapY; }
	public int[][] getIntMap(){ return this.intMap; }
	public char[][] getCharMap(){ return this.charMap; }
	public String[][] getStringMap(){ return this.stringMap; }
	public Item[][] getItemMap(){ return this.itemMap; }
	public Equipment[][] getEquipmentMap(){ return this.equipmentMap; }
	public Enemy[][] getEnemyMap(){ return this.enemyMap; }
	public NPC[][] getNPCMap(){ return this.NPCMap; }

	public boolean validPosition(int x, int y)
	{ 
		if(charMap[x][y] == '/' || charMap[x][y] == '~')
		{
			return false;  
		}
		else
		{
			return true;
		}
	}





	public void place(Object object, int x, int y)
	{
		if(object instanceof String){
			this.stringMap[x][y] = (String)object;
		}else if(object instanceof Enemy){
			this.enemyMap[x][y] = (Enemy)object;
		}else if(object instanceof NPC){
			this.NPCMap[x][y] = (NPC)object;
		}else if(object instanceof Character){
			((Character) object).setPositionX(x);
			((Character) object).setPositionY(y);
		}else if(object instanceof Equipment){
			this.equipmentMap[x][y] = (Equipment)object;
		}else if(object instanceof Item){
			this.itemMap[x][y] = (Item)object;
		}
	}

	public void checkCollision(Character player)
	{
		int x = player.getPositionX();
		int y = player.getPositionY();
		System.out.println("("+x+","+y+")");
		System.out.println();






		if(this.stringMap[x][y]!=null){
			System.out.println(this.stringMap[x][y]);
			System.out.println();
		}


		if(this.enemyMap[x][y]!=null){
			System.out.println("A "+this.enemyMap[x][y].getRole()+" "+this.enemyMap[x][y].getName()+" has appeared!");
			System.out.println();

			new Combat(player,this.enemyMap[x][y]);
			this.enemyMap[x][y]=null;

			printMap(player);
			System.out.println("("+x+","+y+")");
			System.out.println();
		}

		if(this.NPCMap[x][y]!=null){
			for(int i=0;i<this.NPCMap[x][y].getDialogs().length;i++){
				if(this.NPCMap[x][y].getDialogs()[i]!=null){
					System.out.println(this.NPCMap[x][y].getName()+": "+this.NPCMap[x][y].getDialogs()[i]);
				}
			}
			System.out.println();
		}

		if(this.itemMap[x][y]!=null){
			System.out.println("You found a "+this.itemMap[x][y].getName());
			this.itemMap[x][y].add(player);
			this.itemMap[x][y]=null;
			System.out.println();
		}

		if(this.equipmentMap[x][y]!=null){
			System.out.println("You found the "+this.equipmentMap[x][y].getName());
			this.equipmentMap[x][y].add(player);
			this.equipmentMap[x][y]=null;
			System.out.println();
		}
	}

	public void move(Character player, String move)
	{
		int currPosY = player.getPositionY();
		int currPosX = player.getPositionX();
		if(move.equals("down")&&currPosY+1<=mapY-1){// && checkPlayerMove("down", currPosX, currPosY)){
			player.setPositionY(currPosY+1);
		}else if(move.equals("right")&&currPosX+1<=mapX-1){// && checkPlayerMove("right", currPosX, currPosY)){
			player.setPositionX(currPosX+1);
		}else if(move.equals("up")&&currPosY-1>=0 ){// && checkPlayerMove("up", currPosX, currPosY)){
			player.setPositionY(currPosY-1);
		}else if(move.equals("left")&&currPosX-1>=0 ){// && checkPlayerMove("left", currPosX, currPosY)){
			player.setPositionX(currPosX-1);
		}else{
			System.out.println("Error: Cannot move "+move+" from here");
			System.out.println();
			return;
		}
		printMap(player);
		checkCollision(player);

	}

	/*public boolean checkPlayerMove(String move, int y, int x){
		if(move.equals("left") && (charMap[x-1][y] == '/' || charMap[x-1][y] == '~')){	
			return false;	//change +1
		}
		if(move.equals("right") && (charMap[x+1][y] == '/' || charMap[x+1][y] == '~')){	
			return false;	 // change to -1
		}
		if(move.equals("up") && (charMap[x][y-1] == '/' || charMap[x][y-1] == '~')){	
			return false;	
		}
		if(move.equals("down") && (charMap[x][y+1] == '/' || charMap[x][y+1] == '~')){
			return false;
		}
		else
			return true;
	}*/
}
