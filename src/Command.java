public class Command
{
	public Command(Character player, Map map, String command)
	{
		if(command.equals("up")){ map.move(player,"up"); }
		else if(command.equals("left")){ map.move(player,"left"); }
		else if(command.equals("down")){ map.move(player,"down"); }
		else if(command.equals("right")){ map.move(player,"right"); }
		else if(command.equals("character")){ player.printCharacter(); }
		else if(command.equals("inventory")){ player.printInventory(); }
		else if(command.equals("equipped")){ player.printEquipped(); }
		else if(command.equals("chest")){ player.printChest(); }
		else if(command.equals("attacks")){ player.printAttacks(); }
		else{ System.out.println("Error: Command not valid"); }
	}
}

