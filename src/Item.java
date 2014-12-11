public class Item
{
	private String name;
	private String stat;
	private int restore;
	private NPC npc;
	
	//quest item
	public Item(String name, int xVal, int yVal){
		this.name = name;
		//this.npc = npc;
	}
	
	//misc item
	public Item(String name){
		this.name = name;
	}
	
	//setters
	public void setName(String newName){ this.name = newName; }
	public void setStat(String newStat){ this.stat = newStat; }
	public void setHeal(int newRestore){ this.restore = newRestore; }
	public void setNPC(NPC newNPC){ this.npc = newNPC; }
	
	//getters
	public String getName(){ return this.name; }
	public String getStat(){ return this.stat; }
	public int getRestore(){ return this.restore; }
	public NPC getNPC(){ return this.npc; }
	
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
	
	public void printItem()
	{
		System.out.println("Name: "+this.getName());
		System.out.println("Stat: "+this.getStat());
		System.out.println("Restores: "+this.getRestore());
		System.out.println("NPC: "+this.getNPC());
		System.out.println();
		System.out.println();
	}
}
