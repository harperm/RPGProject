
public class QuestItem extends Item
{

	public QuestItem(String name, NPC npc) {
		super(name);
		
		this.setName(name);
		this.setNPC(npc);
	}
	
	//uses quest item
	public void use(Character player)
	{
		for(int i=0;i<player.getInventory().length;i++){
			if(!player.getInventory()[i].getName().equals(this.getName()) && i==player.getInventory().length-1){
				System.out.println("Item not found");
				System.out.println();
				break;
			}else if(player.getInventory()[i]!=null){
				if(player.getInventory()[i].getName().equals(this.getName())){
					if(player.getName().equals(this.getNPC())){
						player.setItemCount(player.getItemCount()[i]-1, i);
						if(player.getItemCount()[i]==0){
							player.setInventoryItem(null, i);
						}
					}
				}
			}
		}
	}
}
