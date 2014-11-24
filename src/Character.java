public class Character
{
	private String name, role;
	private int level, experience;
	private int health, maxHealth;
	private int mana, maxMana;
	private int strength, defense, speed;
	private String status;
	private Equipment equipped[] = new Equipment[7];
	private Equipment chest[] = new Equipment[15];
	private Item inventory[] = new Item[30];
	private int itemCount[] = new int[30];
	private String attacks[] = new String[3];
	private String dialogs[] = new String[5];
	private int money;
	
	//player
	public Character(String name, String role)
	{
		this.name = name;
		this.role = role;
		this.level = 1;
		this.experience = 0;
		this.maxHealth = 100;
		this.health = this.maxHealth;
		
		if(role.equals("warrior")){
			this.maxMana = 0;
			this.strength = 100;
			this.defense = 100;
			this.speed = 30;
			this.attacks[0] = "slash";
			this.attacks[1] = "charge";
			this.attacks[2] = "punch";
		}
		
		if(role.equals("mage")){
			this.maxMana = 300;
			this.strength = 100;
			this.defense = 60;
			this.speed = 60;
			this.attacks[0] = "fireball";
			this.attacks[1] = "frost";
			this.attacks[2] = "lightning";
		}
		
		if(role.equals("thief")){
			this.maxMana = 0;
			this.strength = 80;
			this.defense = 60;
			this.speed = 100;
			this.attacks[0] = "stab";
			this.attacks[1] = "stun";
			this.attacks[2] = "throw";
		}
		
		this.mana = maxMana;
		this.status = null;
		this.money = 0;
	}
	
	//setters
	public void setName(String newName){ this.name = newName; }
	public void setRole(String newRole){ this.role = newRole; }
	public void setLevel(int newLevel){ this.level = newLevel; }
	public void setExperience(int newExperience){ this.experience = newExperience; }
	public void setHealth(int newHealth){ this.health = newHealth; }
	public void setMaxHealth(int newMaxHealth){ this.maxHealth = newMaxHealth; }
	public void setMana(int newMana){ this.mana = newMana; }
	public void setMaxMana(int newMaxMana){ this.maxMana = newMaxMana; }
	public void setStrength(int newStrength){ this.strength = newStrength; }
	public void setDefense(int newDefense){ this.defense = newDefense; }
	public void setSpeed(int newSpeed){ this.speed = newSpeed; }
	public void setStatus(String newStatus){ this.status = newStatus; }
	public void setEquipped(Equipment[] newEquipped){ this.equipped = newEquipped; }
	public void setEquippedItem(Equipment newEquippedItem, int i){ this.equipped[i] = newEquippedItem; }
	public void setChest(Equipment[] newChest){ this.chest= newChest; }
	public void setInventory(Item[] newInventory){ this.inventory = newInventory; }
	public void setInventoryItem(Item newInventoryItem, int i){ this.inventory[i] = newInventoryItem; }
	public void setItemCount(int newItemCount, int i){ this.itemCount[i] = newItemCount; }
	public void setAttacks(String[] newAttacks){ this.attacks = newAttacks; }
	public void setDialogs(String [] newDialogs){ this.dialogs = newDialogs; }
	public void setMoney(int newMoney){ this.money = newMoney; }
	
	//getters
	public String getName(){ return this.name; }
	public String getRole(){ return this.role; }
	public int getLevel(){ return this.level; }
	public int getExperience(){ return this.experience; }
	public int getHealth(){ return this.health; }
	public int getMaxHealth(){ return this.maxHealth; }
	public int getMana(){ return this.mana; }
	public int getMaxMana(){ return this.maxMana; }
	public int getStrength(){ return this.strength; }
	public int getDefense(){ return this.defense; }
	public int getSpeed(){ return this.speed; }
	public String getStatus(){ return this.status; }
	public Equipment[] getEquipped(){ return this.equipped; }
	public Equipment[] getChest(){ return this.chest; }
	public Item[] getInventory(){ return this.inventory; }
	public int[] getItemCount(){ return this.itemCount; }
	public String[] getAttacks(){ return this.attacks; }
	public String[] getDialogs(){ return this.dialogs; }
	public int getMoney(){ return this.money; }
	
	public void printCharacter()
	{
		System.out.println("Name: "+this.getName());
		System.out.println("Role: "+this.getRole());
		System.out.println("Level: "+this.getLevel());
		System.out.println("Experience: "+this.getExperience());
		System.out.println("Health: "+this.getHealth());
		System.out.println("Max Health: "+this.getMaxHealth());
		System.out.println("Mana: "+this.getMana());
		System.out.println("Max Mana: "+this.getMaxMana());
		System.out.println("Strength: "+this.getStrength());
		System.out.println("Defense: "+this.getDefense());
		System.out.println("Speed: "+this.getSpeed());
		System.out.println("Status: "+this.getStatus());
		for(int i=0;i<this.getInventory().length;i++){
			if(this.getInventory()[i]!=null){
				System.out.println("Inventory"+i+": "+this.getInventory()[i].getName());
			}
		}
		for(int i=0;i<this.getEquipped().length;i++){
			if(this.getEquipped()[i]!=null){
				System.out.println("Equipment"+i+": "+this.getEquipped()[i].getName());
			}
		}
		for(int i=0;i<this.getAttacks().length;i++){
			if(this.getAttacks()[i]!=null){
				System.out.println("Attack"+i+": "+this.getAttacks()[i]+" ");
			}
		}
		for(int i=0;i<this.getDialogs().length;i++){
			if(this.getDialogs()[i]!=null){
				System.out.println("Dialog"+i+": "+this.getDialogs()[i]+" ");
			}
		}
		System.out.println("Money: "+this.getMoney());
		System.out.println();
		System.out.println();
	}
	
	
	
	
}

