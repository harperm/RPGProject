public class NPC extends Character
{
	private boolean isEmperor;
	public NPC(String name, String role, String dialog0, String dialog1,
				String dialog2, String dialog3, String dialog4, boolean isEmperorN)
	{
		super(name, role);
		this.setName(name);
		this.setRole(role);
		
		String dialogs[] = {dialog0,dialog1,dialog2,dialog3,dialog4};
		this.setDialogs(dialogs);
		isEmperor = isEmperorN;
	}
	public boolean getIsEmperor(){
		return isEmperor;
	}
	

}
