import java.util.Scanner;

public class Command
{
	Scanner keyboard = new Scanner(System.in);
	
	public Command(Character player, Map map, String command)
	{
		command.toLowerCase();
		if(command.equals("up")||command.equals("down")||command.equals("right")||
			command.equals("left")){ move(player,map,command); }
		else if(command.equals("me")){ player.printCharacter(); }
		else if(command.equals("inventory")){ player.printInventory(); }
		else if(command.equals("equipped")){ player.printEquipped(); }
		else if(command.equals("chest")){ player.printChest(); }
		else if(command.equals("attacks")){ player.printAttacks(); }
		else if(command.equals("use")){ use(player); }
		else if(command.equals("equip")){ equip(player); }
		else if(command.equals("unequip")){ unequip(player); }
		else{ System.out.println("Error: Command not valid"); }
	}
	
	public void move(Character player, Map map, String move)
	{
		map.move(player,move);
		map.printMap(player);
		map.checkCollision(player);
	}
	
	public void use(Character player)
	{
		int choice = 0;
		int count = 1;
		Item[] inventory = player.getInventory();
		for(int i=0;i<inventory.length;i++){ 
			if(inventory[i]!=null){
				count++;
				System.out.println((i+1)+". "+inventory[i].getName()+" ("+player.getItemCount()[i]+")");
			}
		}
		System.out.println((count)+". Cancel");
		do{
			if(choice>=inventory.length || choice<0){ System.out.println("Error: Item not found"); }
			else if(choice==count){ System.out.println("Cancelled"); return; }
			System.out.print("Enter item number: ");
			choice = keyboard.nextInt();
			System.out.println();
		}while(choice>=count || choice<=0);
		((Potion)player.getInventory()[choice-1]).use(player);
	}
	
	public void equip(Character player)
	{
		int choice = 0;
		int count = 1;
		Equipment[] chest = player.getChest();
		for(int i=0;i<chest.length;i++){ 
			if(chest[i]!=null){
				count++;
				System.out.print((i+1)+". "+chest[i].getName());
				
				for(int j=0;j<player.getEquipped().length;j++){
					if(player.getEquipped()[j]!=null){
						if(player.getEquipped()[j].getName().equals(player.getChest()[i].getName())){
							System.out.print("*");
						}
					}
				}
				System.out.println();
			}
		}
		System.out.println((count)+". Cancel");
		do{
			if(choice>=chest.length || choice<0){ System.out.println("Error: Equipment not found"); }
			else if(choice==count){ System.out.println("Cancelled"); return; }
			System.out.print("Enter equipment number: ");
			choice = keyboard.nextInt();
			System.out.println();
		}while(choice>=count || choice<=0);
		player.getChest()[choice-1].equip(player);		
	}
	
	public void unequip(Character player)
	{
		int choice = 0;
		int count = 1;
		Equipment[] equipped = player.getEquipped();
		for(int i=0;i<equipped.length;i++){ 
			if(equipped[i]!=null){
				count++;
				System.out.println((count-1)+". "+equipped[count-2].getName());
			}
		}
		System.out.println((count)+". Cancel");
		do{
			if(choice>=equipped.length || choice<0){ System.out.println("Error: Equipment not found"); }
			else if(choice==count){ System.out.println("Cancelled"); return; }
			System.out.print("Enter equipment number: ");
			choice = keyboard.nextInt();
			System.out.println();
		}while(choice>=count || choice<=0);
		player.getEquipped()[choice-1].unequip(player);
	}
}

