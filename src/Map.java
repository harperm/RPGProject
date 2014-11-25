public class Map
{
	private int[][] intMap = new int[5][5];
	private String[][] stringMap = new String[5][5];
	private Item[][]  itemMap = new Item[5][5];
	private Equipment[][] equipmentMap = new Equipment[5][5];
	private Character[][] characterMap = new Character[5][5];
	
	public void setIntMap(int newIntMap[][]){ this.intMap = newIntMap; }
	public void setStringMap(String newStringMap[][]){ this.stringMap = newStringMap; }
	public void setItemMap(Item[][] newItemMap){ this.itemMap = newItemMap; }
	public void setEquipmentMap(Equipment[][] newEquipmentMap){ this.equipmentMap = newEquipmentMap; }
	public void setCharaterMap(Character newCharacterMap[][]){ this.characterMap = newCharacterMap; }
	
	public int[][] getIntMap(){ return this.intMap; }
	public String[][] getStringMap(){ return this.stringMap; }
	public Item[][] getItemMap(){ return this.itemMap; }
	public Equipment[][] getEquipmentMap(){ return this.equipmentMap; }
	public Character[][] getCharacterMap(){ return this.characterMap; }
	
	public void printMap()
	{
		
	}
}
