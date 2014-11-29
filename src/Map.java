public class Map
{
	private int mapX;
	private int mapY;
	private int[][] intMap;
	private String[][] stringMap;
	private Item[][]  itemMap;
	private Equipment[][] equipmentMap;
	private Enemy[][] enemyMap;
	private NPC[][] NPCMap;
	
	public Map(int mapX, int mapY)
	{
		this.mapX = mapX;
		this.mapY = mapY;
		this.stringMap = new String[mapX][mapY];
		this.itemMap = new Item[mapX][mapY];
		this.equipmentMap = new Equipment[mapX][mapY];
		this.enemyMap = new Enemy[this.mapX][this.mapY];
		this.NPCMap = new NPC[mapX][mapY];
	}
	
	public void setMapX(int newMapX){ this.mapX = newMapX; }
	public void setMapY(int newMapY){ this.mapY = newMapY; }
	public void setStringMap(String newStringMap[][]){ this.stringMap = newStringMap; }
	public void setItemMap(Item[][] newItemMap){ this.itemMap = newItemMap; }
	public void setEquipmentMap(Equipment[][] newEquipmentMap){ this.equipmentMap = newEquipmentMap; }
	public void setEnemyMap(Enemy newEnemyMap[][]){ this.enemyMap = newEnemyMap; }
	public void setNPCMap(NPC newNPCMap[][]){ this.NPCMap = newNPCMap; }
	
	public int getMapX(){ return this.mapX; }
	public int getMapY(){ return this.mapY; }
	public int[][] getIntMap(){ return this.intMap; }
	public String[][] getStringMap(){ return this.stringMap; }
	public Item[][] getItemMap(){ return this.itemMap; }
	public Equipment[][] getEquipmentMap(){ return this.equipmentMap; }
	public Enemy[][] getEnemyMap(){ return this.enemyMap; }
	public NPC[][] getNPCMap(){ return this.NPCMap; }
	
	public void place(Object object, int x, int y)
	{
		if(object instanceof Enemy){
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
		System.out.println("("+player.getPositionX()+","+player.getPositionY()+")");
		System.out.println();
		
		if(this.stringMap[x][y]!=null){
			System.out.println(this.stringMap[x][y]);
		}
		
		if(this.enemyMap[x][y]!=null){
			System.out.println("A "+this.enemyMap[x][y].getRole()+" "+this.enemyMap[x][y].getName()+" has appeared!");
			System.out.println();
			
			new Combat(player,this.enemyMap[x][y]);
			printMap(player);
		}
		
		if(this.NPCMap[x][y]!=null){
			for(int i=0;i<this.NPCMap[x][y].getDialogs().length;i++){
				if(this.NPCMap[x][y].getDialogs()[i]!=null){
					System.out.println(this.NPCMap[x][y].getDialogs()[i]);
				}
			}
			System.out.println();
		}
		
		if(this.itemMap[x][y]!=null){
			System.out.println("You found a "+this.itemMap[x][y].getName());
			this.itemMap[x][y].add(player);
			System.out.println();
		}
		
		if(this.equipmentMap[x][y]!=null){
			System.out.println("You found the "+this.equipmentMap[x][y].getName());
			this.equipmentMap[x][y].add(player);
		}
	}
	
	public void move(Character player, String move)
	{
		int currPosY = player.getPositionY();
		int currPosX = player.getPositionX();
		
		if(move=="up"&&currPosY+1<=mapY){
			player.setPositionY(currPosY+1);
		}else if(move=="left"&&currPosX+1<=mapX){
			player.setPositionX(currPosX+1);
		}else if(move=="down"&&currPosY-1>=0){
			player.setPositionX(currPosY-1);
		}else if(move=="right"&&currPosX-1>=0){
			player.setPositionX(currPosX-1);
		}else{
			System.out.println("Error: Cannot move there");
			System.out.println();
		}
	}
	
	public void printMap(Character player)
	{
		
		for(int i=mapY-1;i>0;i--){
			System.out.print("###");
		}
		System.out.println("#");
		for(int i=mapY-1;i>=0;i--){
			System.out.print("#");
			for(int j=mapX-1;j>=0;j--){
				if(player.getPositionX()==j&&player.getPositionY()==i){
					System.out.print("|P");
				}else{
					System.out.print("| ");
				}
			}
			System.out.println("|#");
			for(int j=mapX-1;j>=0;j--){
				System.out.print("##");
			}
			System.out.println("###");
		}
	}
}
