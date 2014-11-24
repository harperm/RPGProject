
public class Equiment {
	
	private String name;
	private String type;
	private String size;
	public static String equipped[] = new String [3];
	public static boolean filled = false;
	private String chest[] = new String [15];
	public static int index = 0;
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
		public void printEquipment()
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
		void equip()
		 {
	      if(filled != true)
	       {
	    	equipped[0] = name;
	    	equipped[1] = type;
	    	equipped[2] = size;
	    	
	    	filled = true;
	       }
	      else
	       {
	    	System.out.println("Sorry, there is already something equipped");  
	       }
		 }
		
		void unequip(){
		if(filled = true){
			
			if(index != (chest.length - 3))
			 {
			  chest[index] = equipped[0];
			  chest[index+1]= equipped[1];
			  chest[index+2]= equipped [2];
			  
			  equipped[0]= null;
			  equipped[1]=null;
			  equipped[2]=null;
			
			  filled= false;
			 }
			else{
				System.out.println("Sorry, there is no room in the chest.");
			}
		}
		
		else{
			System.out.println("There is nothing equipped");
		}
		}

	}

