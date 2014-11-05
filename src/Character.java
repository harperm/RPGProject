public class Character
{
	private String name, role;
	private int level, experience;
	private int health, maxHealth;
	private int mana, maxMana;
	private int strength, defense, speed;
	private String status;
	private String attack0, attack1, attack2;
	private String attacks[] = new String[3];
	private String dialog[] = new String[5];
	
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
	public void setAttacks(String[] newAttacks){ this.attacks = newAttacks; }
	
	//getters
	public String getName(){ return name; }
	public String getRole(){ return role; }
	public int getLevel(){ return level; }
	public int getExperience(){ return experience; }
	public int getHealth(){ return health; }
	public int getMaxHealth(){ return maxHealth; }
	public int getMana(){ return mana; }
	public int getMaxMana(){ return maxMana; }
	public int getStrength(){ return strength; }
	public int getDefense(){ return defense; }
	public int getSpeed(){ return speed; }
	public String getStatus(){ return status; }
	public String[] getAttacks(){ return attacks; }
	
	
	public static void main(String[] args)
	{
		Character test = new Character("link","warrior");
		System.out.println("Name: "+test.name);
		System.out.println("Role: "+test.role);
		System.out.println("Level: "+test.level);
		System.out.println("Experience: "+test.experience);
		System.out.println("Health: "+test.health);
		System.out.println("Max Health: "+test.maxHealth);
		System.out.println("Mana: "+test.mana);
		System.out.println("Max Mana: "+test.maxMana);
		System.out.println("Strength: "+test.strength);
		System.out.println("Defense: "+test.defense);
		System.out.println("Speed: "+test.speed);
		System.out.println("Status: "+test.status);
		System.out.print("Attacks: ");
		for(int i=0;i<test.attacks.length;i++){
			System.out.print(test.attacks[i]+" ");
		}
		
		System.out.println();
		System.out.println();
		
		Enemy test2 = new Enemy("orc","warrior",3,500,150,0,80,60,null,null,null,null);
		System.out.println("Name: "+test2.getName());
		System.out.println("Role: "+test2.getRole());
		System.out.println("Level: "+test2.getLevel());
		System.out.println("Experience: "+test2.getExperience());
		System.out.println("Health: "+test2.getHealth());
		System.out.println("Max Health: "+test2.getMaxHealth());
		System.out.println("Mana: "+test2.getMana());
		System.out.println("Max Mana: "+test2.getMaxMana());
		System.out.println("Strength: "+test2.getStrength());
		System.out.println("Defense: "+test2.getDefense());
		System.out.println("Speed: "+test2.getSpeed());
		System.out.println("Status: "+test2.getStatus());
		System.out.print("Attacks: ");
		for(int i=0;i<test2.getAttacks().length;i++){
			System.out.print(test2.getAttacks()[i]+" ");
		}
	}
}