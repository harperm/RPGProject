
public class Equiment {
	
	private String name;
	private String type;
	private String size;
	private String equipped[] = new String [5];
	private String chest[] = new String [5];
	
	
	//----------------------------------
	//constructors
	
	public Equiment(String name,String type, String stat, int effect){
		this.name= name;
		this.type= type;	
	}
	
	public Equiment(String name, String type, String stat1, int effect1, String stat2, int effect2){
		this.name= name;
		this.type= type;		
	}
	
	public Equiment(String name, String type, String stat1, int effect1, String stat2, int effect2, String stat3, int effect3){
		this.name= name;
		this.type= type;		
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
		
		//-----------------------------------
		void equiped(){
			
		}
		
		void unequiped(){
			
		}

	}

