public class StatusPotion extends Item
{
	public StatusPotion(String name, String stat) {
		super(name);
		
		this.setName(name);
		this.setStat(stat);
	}
	
	//uses status potion
	public void use(Character player)
	{
		for(int i=0;i<player.getInventory().length;i++){
			if(!player.getInventory()[i].getName().equals(this.getName())
					&& i==player.getInventory().length-1){
				System.out.println("Item not found");
				System.out.println();
				break;
			}else if(player.getInventory()[i]!=null){
				if(player.getInventory()[i].getName().equals(this.getName())){
					if(this.getNPC()==null){
						player.setItemCount(player.getItemCount()[i]-1, i);

						if(player.getItemCount()[i]==0){
							player.setInventoryItem(null, i);
						}
						
						cure(player,this.getStat(),i);
						System.out.println();
						break;
					}
				}
			}
		}
	}
	
	//cures ailment
	public void cure(Character player, String status, int i)
	{
		if(player.getStatus()!=null){
			player.setStatus(null);
		}else{
			System.out.println("Error: No status ailment");
			player.setItemCount(player.getItemCount()[i]+1, i);
		}
	}
}
