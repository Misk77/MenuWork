import java.util.Random;

public class Monsters {
//Instance variables
	int initiative;
	int health;
	int baseAttack;
	int avoidance;
	String monsterType;
	boolean deas = false;

	Random rand;

	public Monsters(String monsterType) {
		// TODO Auto-generated constructor stub
		rand = new Random();

		if (monsterType.equals("Giant Spider")) {
			this.initiative = 7;
			this.health = 1;
			this.baseAttack = 2;
			this.avoidance = 3;
			this.monsterType = monsterType;
		}

		else if (monsterType.equals("Skeleton")) {

			this.initiative = 4;
			this.health = 2;
			this.baseAttack = 3;
			this.avoidance = 3;
			this.monsterType = monsterType;
		} else if (monsterType.equals("Orc")) {
			this.initiative = 6;
			this.health = 3;
			this.baseAttack = 4;
			this.avoidance = 4;
			this.monsterType = monsterType;
		} else if (monsterType.equals("Troll")) {
			this.initiative = 2;
			this.health = 4;
			this.baseAttack = 7;
			this.avoidance = 2;
			this.monsterType = monsterType;
		}

	}// End Monsters

	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getBaseAttack() {
		return baseAttack;
	}

	public void setBaseAttack(int baseAttack) {
		this.baseAttack = baseAttack;
	}

	public int getAvoidance() {
		return avoidance;
	}

	public void setAvoidance(int avoidance) {
		this.avoidance = avoidance;
	}

	public String getMonsterType() {
		return monsterType;
	}

	public void setMonsterType(String monsterType) {
		this.monsterType = monsterType;
	}

	public boolean isDeas() {
		return deas;
	}

	public void setDeas(boolean deas) {
		this.deas = deas;
	}

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

	@Override
	public String toString() {
		return "Monsters [initiative=" + initiative + ", health=" + health + ", baseAttack=" + baseAttack
				+ ", avoidance=" + avoidance + ", monsterType=" + monsterType + ", deas=" + deas + ", rand=" + rand
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
