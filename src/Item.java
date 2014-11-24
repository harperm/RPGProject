public class Item
{
	private String name;
	private String stat;
	private int heal;
	private String status;
	private NPC npc;
	private int count;
	
	//stat potions
	public Item(String name, String stat, int heal)
	{
		this.name = name;
		this.stat = stat;
		this.heal = heal;
		this.count = count;
	}
	
	//status potions
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
	
	public Item(String name){
		this.name = name;
	}
	
	public void setName(String newName){ this.name = newName; }
	public void setStat(String newStat){ this.stat = newStat; }
	public void setHeal(int newHeal){ this.heal = newHeal; }
	public void setStatus(String newStatus){ this.status = newStatus; }
	
	public String getName(){ return this.name; }
	public String getStat(){ return this.stat; }
	public int getHeal(){ return this.heal; }
	public String getStatus(){ return this.status; }
	
	public void use(Character player, Item item)
	{
		for(int i=0;i<player.getInventory().length;i++){
			if(player.getInventory().equals(item.getName())){
				player.setItemCount(player.getItemCount()[i]-1, i);
			}
		}
	}
}
