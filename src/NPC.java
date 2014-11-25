public class NPC extends Character
{

	public NPC(String name, String role, int positionX, int positionY, String dialog0, String dialog1,
				String dialog2, String dialog3, String dialog4)
	{
		super(name, role, positionX, positionY);
		this.setName(name);
		this.setRole(role);
		this.setPositionX(positionX);
		this.setPositionY(positionY);
		String dialogs[] = {dialog0,dialog1,dialog2,dialog3,dialog4};
		this.setDialogs(dialogs);
	}
}
