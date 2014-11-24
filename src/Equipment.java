//equipped slots are as follows: weapon, head, chest, legs, boots, ring, ring

public class Equipment
{
	private String name;
	private String type;
	private String size;
	private String stat0;
	private String stat1;
	private String stat2;
	private int effect0;
	private int effect1;
	private int effect2;
	
	//----------------------------------
	//constructors
	
	public Equipment(String name,String type, String stat0, int effect0)
	{
		this.name = name;
		this.type = type;
		this.stat0 = stat0;
		this.effect0 = effect0;
	}
	
	public Equipment(String name, String type, String stat0, int effect0, String stat1, int effect1)
	{
		this.name = name;
		this.type = type;
		this.stat0 = stat0;
		this.effect0 = effect0;
		this.stat1 = stat1;		
		this.effect1 = effect1;
	}
	
	public Equipment(String name, String type, String stat0, int effect0, String stat1, int effect1, String stat2, int effect2)
	{
		this.name = name;
		this.type = type;
		this.stat0 = stat0;
		this.stat1 = stat1;
		this.stat2 = stat2;
		this.effect0 = effect0;
		this.effect1 = effect1;
		this.effect2 = effect2;
	}
	
	
	//-----------------------------------
	//set statements
	public void setName(String newName){ this.name = newName; }
	public void setType(String newType){ this.type= newType; }
	public void setSize(String newSize){ this.size= newSize; }
	public void setStat0(String newStat0){ this.stat0 = newStat0; }
	public void setStat1(String newStat1){ this.stat1= newStat1; }
	public void setStat2(String newStat2){ this.stat2= newStat2; }
	public void setEffect(int newEffect0){ this.effect0= newEffect0; }
	public void setEffect1(int newEffect1){ this.effect1= newEffect1; }
	public void setEffect2(int newEffect2){ this.effect2= newEffect2; }
	
	//-----------------------------------
	// get statements
	public String getName(){ return name; }
	public String getType(){ return type; }
	public String getSize(){ return size; }
	public String getStat0(){ return stat0; }
	public String getStat1(){ return stat1; }
	public String getStat2(){ return stat2; }
	public int getEffect0(){ return effect0; }
	public int getEffect1(){ return effect1; }
	public int getEffect2(){ return effect2; }

	//----------------------------------
	//Effects players overall Stats
	public void printEquipment()
	{
		System.out.println("Name: "+this.getName());
		System.out.println("Type: "+this.getType());
		System.out.println("Size: "+this.getSize());
		System.out.println("Stat 1: "+this.getStat0());
		System.out.println("Effect 1: "+this.getEffect0());
		System.out.println("Stat 2: "+this.getStat1());
		System.out.println("Effect 2: "+this.getEffect1());
		System.out.println("Stat 3: "+this.getStat2());
		System.out.println("Effect 3: "+this.getEffect2());
		System.out.println();
		System.out.println();
	}
	
	//-----------------------------------
	//Keep/remove equipment

    public void equip(Character player)
	{		
		for(int i=0;i<player.getEquipped().length;i++){
			if(player.getEquipped()[i]!=null){
				if(player.getEquipped()[i].getType().equals(this.getType())){
					System.out.println(this.getName()+" not equipped: Slot is full");
					System.out.println();
					break;
				}
			}
			
			if(player.getEquipped()[i]==null){
				player.setEquippedItem(this, i);
				System.out.println(player.getEquipped()[i].getName()+" equipped");
				System.out.println();
				break;
			}
			
			if(i==player.getEquipped().length && player.getEquipped()[i]==null){
				System.out.println("Sorry, there is no room for that");
				System.out.println();
			}
		}
	}
	
	public void unequip(Character player)
	{
		for(int i=0;i<player.getEquipped().length;i++){
			if(player.getEquipped()[i]!=null){
				if(player.getEquipped()[i].getName()==this.getName()){
					player.setEquippedItem(null, i);
					System.out.println(this.getName()+" unequipped");
					break;
				}
			}
		}
	}
}

