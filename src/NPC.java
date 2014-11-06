public class NPC extends Character
{

	public NPC(String name, String role, String dialog0, String dialog1,
				String dialog2, String dialog3, String dialog4)
	{
		super(name, role);
		setName(name);
		String dialogs[] = {dialog0,dialog1,dialog2,dialog3,dialog4};
		setDialogs(dialogs);
	}
}
