
public class Equiment {
	
	private String name;
	private String type;
	private String size;
	private String equipped[] = new String [5];
	private String chest[] = new String [5];
	private String stat;
	private String stat1;
	private String stat2;
	private int effect;
	private int effect1;
	private int effect2;

	
	
	//----------------------------------
	//constructors
	
	public Equiment(String name,String type, String stat, int effect){
		this.name= name;
		this.type= type;
		this.stat= stat;
		this.effect= 0;
	}
	
	public Equiment(String name, String type, String stat, int effect, String stat1, int effect1){
		this.name= name;
		this.type= type;
		this.stat= stat;
		this.effect= 1;
		this.stat1=stat1;		
		this.effect1= 2;
	}
	
	public Equiment(String name, String type, String stat, int effect, String stat1, int effect1, String stat2, int effect2){
		this.name= name;
		this.type= type;
		this.stat= stat;
		this.stat1= stat1;
		this.stat2= stat2;
		this.effect=1;
		this.effect1=2;
		this.effect2=3;
	}
	
	
		//-----------------------------------
		//set statements
		public void setName(String newName){ 
			this.name = newName; 
		}
		
		public void setType(String newType){
			this.type= newType;
		}
		
		public void setSize(String newSize){
			this.size= newSize;
		}
		
		public void setEquipped(String[] newEquipped){
			this.equipped= newEquipped;
		}
		
		public void setChest(String[] newChest){
			this.chest= newChest;
		}
		
		public void setStat(String newStat){
			this.stat= newStat;
		}
		
		public void setStat1(String newStat1){
			this.stat1= newStat1;
		}
		
		public void setStat2(String newStat2){
			this.stat2= newStat2;
		}
			
		public void setEffect(int newEffect){
			this.effect= newEffect;
		}
		
		public void setEffect1(int newEffect1){
			this.effect1= newEffect1;
		}
		
		public void setEffect2(int newEffect2){
			this.effect2= newEffect2;
		}
		

		//-----------------------------------
		// get statements
		public String getName(){
			return name; 
			}
		
		public String getType(){
			return type;
		}
		
		public String getSize(){
			return size;
		}
		
		public String[] getEquipped(){
			return equipped;
		}
		
		public String[] getChest(){
			return chest;
		}
		
		public String getStat(){
			return stat;
		}
		
		public String getStat1(){
			return stat1;
		}
		
		public String getStat2(){
			return stat2;
		}
			
		public int getEffect(){
			return effect;
		}
		
		public int getEffect1(){
			return effect1;
		}
		
		public int getEffect2(){
			return effect2;
		}
		

		//----------------------------------
		//Effects players overall Stats
		public void printCharacter()
		{
			System.out.println("Name: "+this.getName());
			System.out.println("Type: "+this.getType());
			System.out.println("Size: "+this.getSize());
			System.out.println("Stat 1: "+this.getStat());
			System.out.println("Effect 1: "+this.getEffect());
			System.out.println("Stat 2: "+this.getStat1());
			System.out.println("Effect 2: "+this.getEffect1());
			System.out.println("Stat 3: "+this.getStat2());
			System.out.println("Effect 3: "+this.getEffect2());
		}
 
		//-----------------------------------
		//Keep/remove equipment
		void equiped(){
			
		}
		
		void unequiped(){
			
		}

	}

