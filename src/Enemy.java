public class Enemy extends Character
{
	public Enemy(String name, String role, int level, int health, 
				int mana, int strength, int defense, int speed, 
				String status, String attack0, String attack1, String attack2)
	{
		super(name, role);
		setName(name);
		setRole(role);
		setLevel(level);
		setHealth(health);
		setMaxHealth(health);
		setMana(mana);
		setMaxMana(mana);
		setStrength(strength);
		setDefense(defense);
		setSpeed(speed);
		setStatus(status);
		String[] attacks = {attack0,attack1,attack2};
		
		//if all attacks are null, default adds the base role attacks to the enemy
		if(attacks[0]!=null && attacks[1]!=null && attacks[2]!=null){ setAttacks(attacks); }
	}
}
