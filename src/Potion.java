public class Potion extends Item
{
	public Potion(String name, String stat, int heal) {
		super(name);
		
		this.setName(name);
		this.setStat(stat);
		this.setHeal(heal);
	}
	
	//uses potion
	public void use(Character player)
	{
		for(int i=0;i<player.getInventory().length;i++){
			//
			if(!player.getInventory()[i].getName().equals(this.getName()) && i==player.getInventory().length-1){
				System.out.println("Item not found");
				System.out.println();
				break;
			}
			
			//checks for which inven inventory slot
			if(player.getInventory()[i]!=null
				&& player.getInventory()[i].getName().equals(this.getName())){
					//decreases item count by one
					player.setItemCount(player.getItemCount()[i]-1, i);
					
					//takes item out of inventory if count is zero
					if(player.getItemCount()[i]==0){
						player.setInventoryItem(null, i);
					}
					
					//restores
					restore(player,this.getStat(),this.getRestore(),i);
					System.out.println();
					break;
			}
		}
	}
	
	//restores base stat
	public void restore(Character player, String stat, int restore, int i)
	{
		//checks restore type
		if(stat=="health"){
			int newHealth = player.getHealth()+restore;
			
			//checks if potion is used or not based on current stat
			if(newHealth<player.getMaxHealth()){
				player.setHealth(newHealth);
			}else if(player.getHealth()==player.getMaxHealth()){
				player.setItemCount(player.getItemCount()[i]+1, i);
				System.out.println("Error: Health is full");
			}else{
				player.setHealth(player.getMaxHealth());
				System.out.println(this.getName()+" used");
				System.out.println(stat+" restored: "+restore);
			}
		}else if(stat=="mana"){
			int newMana = player.getMana()+restore;
			if(newMana<=player.getMaxMana()){
				player.setMana(newMana);
			}else if(player.getMana()==player.getMaxMana()){
				player.setItemCount(player.getItemCount()[i]+1, i);
				System.out.println("Error: Mana is full");
			}else{
				player.setMana(player.getMaxMana());
				System.out.println(this.getName()+" used");
				System.out.println(stat+" restored: "+restore);
			}
		}
		
		System.out.print(player.getItemCount()[i]+" "+this.getName());
		if(player.getItemCount()[i]>1){ System.out.print("s"); }
		System.out.println(" left");
	}
}
