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
		this.intMap = new int[this.mapX][this.mapY];
		this.stringMap = new String[this.mapX][this.mapY];
		this.itemMap = new Item[this.mapX][this.mapY];
		this.equipmentMap = new Equipment[this.mapX][this.mapY];
		this.enemyMap = new Enemy[this.mapX][this.mapY];
	}
	
	public void setIntMap(int newIntMap[][]){ this.intMap = newIntMap; }
	public void setStringMap(String newStringMap[][]){ this.stringMap = newStringMap; }
	public void setItemMap(Item[][] newItemMap){ this.itemMap = newItemMap; }
	public void setEquipmentMap(Equipment[][] newEquipmentMap){ this.equipmentMap = newEquipmentMap; }
	public void setEnemyMap(Enemy newEnemyMap[][]){ this.enemyMap = newEnemyMap; }
	public void setNPCMap(NPC newNPCMap[][]){ this.NPCMap = newNPCMap; }
	
	public int[][] getIntMap(){ return this.intMap; }
	public String[][] getStringMap(){ return this.stringMap; }
	public Item[][] getItemMap(){ return this.itemMap; }
	public Equipment[][] getEquipmentMap(){ return this.equipmentMap; }
	public Enemy[][] getEnemyMap(){ return this.enemyMap; }
	public NPC[][] getNPCMap(){ return this.NPCMap; }
	
	//currently has a weird ArrayOutOfBounds exception
	public void checkCollision(Character player)
	{
		int x = player.getPositionX();
		int y = player.getPositionY();
		System.out.println(player.getPositionX());
		System.out.println(player.getPositionY());
		
		if(this.stringMap[x][y]!=null){
			System.out.println(this.stringMap[x][y]);
		}
		
		if(this.itemMap[x][y]!=null){
			System.out.println("You found a "+this.itemMap[x][y].getName());
			this.itemMap[x][y].add(player);
		}
		
		if(this.equipmentMap[x][y]!=null){
			System.out.println("You found the "+this.equipmentMap[x][y].getName());
			this.equipmentMap[x][y].add(player);
		}
		
		if(this.enemyMap[x][y]!=null){
			System.out.println("A "+this.enemyMap[x][y].getRole()+" "+this.enemyMap[x][y].getName()+" has appeared!");
			System.out.println();
			
			new Combat(player,this.enemyMap[x][y]);
		}
		
		if(this.NPCMap[x][y]!=null){
			for(int i=0;i<this.NPCMap[x][y].getDialogs().length;i++){
				System.out.println(this.NPCMap[x][y].getDialogs()[i]);
			}
		}
	}
	
	public void printMap()
	{
		
	}
}
