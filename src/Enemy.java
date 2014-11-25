public class Enemy extends Character
{
	public Enemy(String name, String role, int positionX, int positionY, int level,
				int health, int mana, int strength, int defense, int speed, 
				String status, String attack0, String attack1, String attack2)
	{
		super(name, role, positionX, positionY);
		
		this.setName(name);
		this.setRole(role);
		this.setPositionX(positionX);
		this.setPositionY(positionY);
		this.setLevel(level);
		this.setHealth(health);
		this.setMaxHealth(health);
		this.setMana(mana);
		this.setMaxMana(mana);
		this.setStrength(strength);
		this.setDefense(defense);
		this.setSpeed(speed);
		this.setStatus(status);
		
		//if all attacks are null, default adds the base role attacks to the enemy
		String[] attacks = {attack0,attack1,attack2};
		if(attacks[0]!=null && attacks[1]!=null && attacks[2]!=null){ this.setAttacks(attacks); }
	}
}
