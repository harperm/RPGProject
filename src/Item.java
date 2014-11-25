public class Item
{
	private String name;
	private String stat;
	private int heal;
	private String status;
	private NPC npc;
	
	//restore potions
	public Item(String name, String stat, int heal)
	{
		this.name = name;
		this.stat = stat;
		this.heal = heal;
	}
	
	//cure item
	public Item(String name, String status)
	{
		this.name = name;
		this.status = status;
	}
	
	//quest item
	public Item(String name, NPC npc){
		this.name = name;
		this.npc = npc;
	}
	
	//misc item
	public Item(String name){
		this.name = name;
	}
	
	//setters
	public void setName(String newName){ this.name = newName; }
	public void setStat(String newStat){ this.stat = newStat; }
	public void setHeal(int newHeal){ this.heal = newHeal; }
	public void setStatus(String newStatus){ this.status = newStatus; }
	
	//getters
	public String getName(){ return this.name; }
	public String getStat(){ return this.stat; }
	public int getHeal(){ return this.heal; }
	public String getStatus(){ return this.status; }
	
	public void add(Character player)
	{
		for(int i=0;i<player.getInventory().length;i++){
			if(player.getInventory()[i]==null){
				player.setInventoryItem(this, i);
				player.setItemCount(1, i);
				
				System.out.println(player.getInventory()[i].getName()+" added");
				System.out.print("You have "+player.getItemCount()[i]+" "+this.name);
				if(player.getItemCount()[i]>1){ System.out.println("s"); }
				System.out.println();
				break;
			}else{
				if(player.getInventory()[i].getName().equals(this.name)){
					player.setItemCount(player.getItemCount()[i]+1, i);
					
					System.out.println(player.getInventory()[i].getName()+" added");
					System.out.print("You have "+player.getItemCount()[i]+" "+this.name);
					if(player.getItemCount()[i]>1){ System.out.println("s"); }
					System.out.println();
					break;
				}
			}
			
			if(i==player.getInventory().length && player.getInventory()[i]==null){
				System.out.println("Sorry, there is no room for that");
				System.out.println();
			}
		}
	}
	
	public void use(Character player)
	{
		for(int i=0;i<player.getInventory().length;i++){
			if(!player.getInventory()[i].getName().equals(this.name) && i==player.getInventory().length-1){
				System.out.println("Item not found");
				System.out.println();
				break;
			}else if(player.getInventory()[i]!=null){
				if(player.getInventory()[i].getName().equals(this.name)){
					if(this.npc==null){
						player.setItemCount(player.getItemCount()[i]-1, i);

						if(player.getItemCount()[i]==0){
							player.setInventoryItem(null, i);
						}
						
						if(this.stat!=null){
							restore(player,this.stat,this.heal,i);
							System.out.println();
							break;
						}else{
							restore(player,this.status,i);
							System.out.println();
							break;
						}
					}else{
						System.out.println("Error: This is a quest item");
						System.out.println();
						break;
					}
				}
			}
		}
	}
	
	public void restore(Character player, String stat, int heal, int i)
	{
		if(stat=="health"){
			int newHealth = player.getHealth()+heal;
			if(newHealth<=player.getMaxHealth()){
				player.setHealth(newHealth);
			}else if(player.getHealth()==player.getMaxHealth()){
				player.setItemCount(player.getItemCount()[i]+1, i);
				System.out.println("Error: Health is full");
			}else{
				player.setHealth(player.getMaxHealth());
				System.out.println(this.name+" used");
				System.out.println(stat+" restored: "+heal);
			}
		}else if(stat=="mana"){
			int newMana = player.getMana()+heal;
			if(newMana<=player.getMaxMana()){
				player.setMana(newMana);
			}else if(player.getMana()==player.getMaxMana()){
				player.setItemCount(player.getItemCount()[i]+1, i);
				System.out.println("Error: Mana is full");
			}else{
				player.setMana(player.getMaxMana());
				System.out.println(this.name+" used");
				System.out.println(stat+" restored: "+heal);
			}
		}
		
		System.out.print(player.getItemCount()[i]+" "+this.name);
		if(player.getItemCount()[i]>1){ System.out.print("s"); }
		System.out.println(" left");
	}
	
	public void restore(Character player, String status, int i)
	{
		if(player.getStatus()!=null){
			player.setStatus(null);
		}else{
			System.out.println("Error: No status ailment");
			player.setItemCount(player.getItemCount()[i]+1, i);
		}
	}
	
	public void printItem()
	{
		System.out.println("Name: "+this.name);
		System.out.println("Stat: "+this.stat);
		System.out.println("Heals: "+this.heal);
		System.out.println("Status: "+this.status);
		System.out.println("NPC: "+this.npc);
		System.out.println();
		System.out.println();
	}
}
