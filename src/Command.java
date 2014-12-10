public class Command
{
	public Command(Character player, Map map, String command)
	{
		if(command.equals("up")){ 
			map.move(player,"up"); 
		}
		else if(command.equalsIgnoreCase("left")){ 
			map.move(player,"left"); 
		}
		else if(command.equalsIgnoreCase("down")){ 
			map.move(player,"down");
		}
		else if(command.equalsIgnoreCase("right")){ 
			map.move(player,"right");
		}
		else if(command.equalsIgnoreCase("character")){ 
			player.printCharacter();
		}
		else if(command.equalsIgnoreCase("inventory")){ 
			player.printInventory();
		}
		else if(command.equalsIgnoreCase("equipped")){ 
			player.printEquipped();
		}
		else if(command.equalsIgnoreCase("chest")){ 
			player.printChest();
		}
		else if(command.equalsIgnoreCase("attacks")){ 
			player.printAttacks(); 
		}
		else{ System.out.println("Error: Command not valid"); }
	}
}

