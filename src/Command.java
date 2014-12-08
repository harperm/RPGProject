public class Command
{
	public Command(Character player, Map map, String command, String option)
	{
		if(command.equals("move")){
			if(option.equals("up")){ move(player,map,"up"); }
			else if(option.equals("left")){ move(player,map,"left"); }
			else if(option.equals("down")){ move(player,map,"down"); }
			else if(option.equals("right")){ move(player,map,"right"); }
			else{ System.out.println("Error: Option not valid"); }
		}else if(command.equals("inventory")){
			System.out.println("Inventory:");
			for(int i=0;i<player.getInventory().length;i++){
				if(player.getInventory()[i]!=null){
					System.out.println(i+". "+player.getInventory()[i].getName()+" ("+player.getItemCount()[i]+")");
				}
			}
		}
		
		else{ System.out.println("Error: Command not valid"); }
	}
	
	public static void move(Character player, Map map, String move)
	{
		int currPosY = player.getPositionY();
		int currPosX = player.getPositionX();
		
		if(move.equals("down")&&currPosY+1<=map.getMapY()-1){
			player.setPositionY(currPosY+1);
			map.printMap(player);
			map.checkCollision(player);
		}else if(move.equals("right")&&currPosX+1<=map.getMapX()-1){
			player.setPositionX(currPosX+1);
			map.printMap(player);
			map.checkCollision(player);
		}else if(move.equals("up")&&currPosY-1>=0){
			player.setPositionY(currPosY-1);
			map.printMap(player);
			map.checkCollision(player);
		}else if(move.equals("left")&&currPosX-1>=0){
			player.setPositionX(currPosX-1);
			map.printMap(player);
			map.checkCollision(player);
		}else{
			System.out.println("Error: Cannot move there");
			//map.printMap(player);
		}
	}
}
