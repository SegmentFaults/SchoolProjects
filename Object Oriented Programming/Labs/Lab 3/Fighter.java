
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * @author gentilm5
 *
 */
/**
 * @author Michael
 *
 */
public class Fighter {
	// number generator is used frequently throughout the program, so I found it
	// better to just declare one.
	private static Random numberGenerator = new Random();
	private String name = "";
	private int level = 1;
	private int xp = 0;
	private int strength = 1;
	private int dexterity = 1;
	private int charisma = 1;
	private int battlesWon = 0;
	private int speed = 1;
	private int life = 100;
	private boolean isRunning = false;
	/*
	 * Below are all the custom parameters.
	 */
	private final int[] levelXPAmt = new int[] { 50, 90, 140, 200, 260, 330, 410, 500, 600, 710, 830, 960, 1100, 1250,
			1410, 1580, 1760, 1760, 1760, 1760 };
	private static String[] weaponNames = new String[] { "Boomerang", "Sword", "Axe", "Dagger", "Flail", "Scimitar",
			"Dual Swords" };

	private Weapon currentWeapon;
	private int coins = 0;

	/*
	 * Found it best to create a subclass to work with the weapon idea for my
	 * custom method that we were allowed to create The weapons simply add power
	 * and have a unique identifier from the array of possible names.
	 */
	class Weapon {
		private String name;
		// To be added to the users Strength
		private int weaponStrength;
		
		/**
		 * @see constructor that puts all control in the constructor
		 * @param name
		 * @param power
		 */
		Weapon(String name, int power) {
			this.name = name;
			this.weaponStrength = power;
		}
		/**
		 * @see constructor that puts the name in the hands of the user. 
		 * @param name
		 */
		Weapon(String name) {
			this.name = name;
			weaponStrength = Fighter.numberGenerator.nextInt(5) + 1;
		}
		/**
		 * Weapon constructor that takes no parameters. 
		 */
		Weapon() {
			String[] possibleNames = Fighter.getWeaponNames();
			name = possibleNames[(int) (Fighter.numberGenerator.nextInt(6) + .5)];
			weaponStrength = Fighter.numberGenerator.nextInt(5) + 1;
		}

		/**
		 * @return the name of the weapon
		 */
		public String getWeaponName() {
			return name;
		}

		/**
		 * @param name the name of the weapon to set
		 */
		public void setWeaponName(String name) {
			this.name = name;
		}

		/**
		 * @return the power of the weapon
		 */
		public int getPower() {
			return weaponStrength;
		}

		/**
		 * @param power the power to set
		 */
		public void setPower(int power) {
			this.weaponStrength = power;
		}

	}
	/**
	 * @see basic constructor that allows the user to allocate attributes.
	 * @param name
	 * @param level
	 * @param strength
	 * @param dexterity
	 * @param charisma
	 * @param speed
	 * There are no parameters around the name, so we won't use the set name method.
	 */
	public Fighter(String name, int level, int strength, int dexterity, int charisma, int speed) {
		this(name, level, 0, strength, dexterity, charisma, 0, speed, 100, false);
	}

	/**
	 * 
	 * @param name
	 * @param level
	 * @param xp
	 * @param strength
	 * @param dexterity
	 * @param charisma
	 * @param battlesWon
	 * @param speed
	 * @param life
	 * @param running
	 * @see
	 * Very thourough constructor that allows the main to create everything for
	 * the character except for giving them a weapon (which the character should
	 * have to buy)
	 */
	public Fighter(String name, int level, int xp, int strength, int dexterity, int charisma, int battlesWon, int speed,
			int life, boolean running) {
		this.name = name;
		setLevel(level);
		setStrength(strength);
		setDexterity(dexterity);
		setCharisma(charisma);
		if (level>4)
			setSpeed(speed);
		else
			setSpeed();
		setBattlesWon(battlesWon);
		setLife(life);
		isRunning=running;
	}

	/**
	 * @see Basic constructor that simply allocates attributes based on skill.
	 * @param name
	 * @param level
	 */

	public Fighter(String name, int level) {
		this(name,level,0,level,level,level,0,level/2,100,false);
	}

	/**
	 * @see
	 * If the user is a low level, multiply their current speed by two.
	 * Otherwise, simply set their speed.
	 */

	public void run() {
		if (!isRunning && speed <= 5) {
			speed *= 2;
		} else if (!isRunning) {
			speed = 10;
		}
		// else the user is already running, so their speed should not be
		// increased.
	}

	/**
	 * @see
	 * Set the user's speed back to the default created by the constructor and
	 * cancel out their isRunning variable.
	 */
	public void walk() {
		speed = (level / 2) - 1;
		isRunning = false;
		// else do nothing
	}
	/**
	 * @see
	 * changes the speed to 0 so the fighter stops.
	 */

	public void stop() {
		speed = 0;
	}
	
	/**
	 * @see allow the user to talk to their character
	 * They will get different voicelines depending on charisma, it will also give them experience.
	 */

	public void talk() {
		if (charisma < 5) {
			System.out.println("Please don't hurt me.");
		} else if (charisma < 10) {
			System.out.println("I'm almost not sociallyh awkward.");
		} else if (charisma < 15) {
			System.out.println("I'm the unbeatable!");
		} else {
			System.out.println("I am the greatest ever! No one can beat me!");
		}
		xp += (levelXPAmt[level - 1] * .1);
		checkLevelUp();
		coins += 20;
		// give the user coins if they talk.
	}

	/**
	 * @see
	 * After the user has gained XP, you must check to see if they have leveled
	 * up. checkLevelUp takes the amoount of xp needed to level up, and checks
	 * if it greater than their current level required. If it is greater, then
	 * you increment the level. Take the xp that the user "spent" by leveling
	 * up, and then recursively call itself incase they got a very large amount
	 * of xp.
	 */
	private void checkLevelUp() {
		if (levelXPAmt[level - 1] < xp && level != 20) {
			xp -= levelXPAmt[level - 1];
			level++;
			coins += 100;
			levelUp();
			// give them 100 coins if they level up.
			checkLevelUp();
		}
	}

	/**
	 * @see
	 * Generate a new figher, and go through the stages of fighting. First the
	 * fighters argue with eachother. If one's charisma is significantly higher,
	 * the person with the highest charisma will win. (Resembling the game
	 * fallout, avoiding conflict through secondary skills) If this does not
	 * occur, fight the two characters. If one is significantly better than the
	 * other, the other player is kill or KO. Otherwise, they fight, but nobody
	 * really triumphs. One just takes more damage than the other.
	 * 
	 * 
	 * 
	 * The opponent does not gain XP, as they are a temporary entity.
	 */
	public void fight() {
		int opponentLvl = numberGenerator.nextInt(20);
		Fighter op = new Fighter("Opponent " + battlesWon, opponentLvl);
		/*
		 * Rather than calling the method for "getFightingLevel" multiple times,
		 * they will be assigned variables that are discarded with the method.
		 * There is luck involved with their fighting levels, therefore you
		 * cannot call them multiple times and guarantee the same resultant
		 * values, so they will receive variables.
		 */
		int fl = this.getFightingLevel();
		int ol = op.getFightingLevel();
		if (op.getCharisma() > this.charisma + 5) {
			op.setBattlesWon(op.getBattlesWon() + 1);
			// Opponent talks you out of the fight, therefore you lose.
		} else if (this.charisma > op.getCharisma() + 5) {
			this.battlesWon++;
			this.scaleXP(150);
		}
		// now they fight after they quit arguing

		// this fight is the equivalence of a near draw
		else if (ol > fl && ol < fl + 10) {
			// Opponent would win, although just barely and they would both
			// disengage
			op.setBattlesWon(op.getBattlesWon() + 1);
			op.setLife(op.getLife() - 20);
			this.setLife(this.life - 30);
		} else if (fl > ol && fl < ol + 10) {
			// this fighter would win, although just barely and they would both
			// disengage
			this.battlesWon++;
			this.setLife(this.life - 20);
			op.setLife(op.getLife() - 30);
			this.scaleXP(1000);
		}
		// fight to the death if one is significantly stronger than the other.
		else if (ol > fl) {
			this.battlesWon++;
			this.scaleXP(1000);
		} else if (fl > ol) {
			op.setBattlesWon(op.getBattlesWon() + 1);
		}
		// Get coins for fighting, whether you win or lose
		coins += 500;
	}

	/**
	 * @see
	 * Fighting level is determined by a random number generator as well as the
	 * current Fighter's statistics. Fights must be somewhat randomized, so this
	 * is the way of determining that. Skill is included, but so is randomness.
	 */
	public int getFightingLevel() {
		return (level + strength + dexterity) + (life / 10) + rollLuck();
	}

	/**
	 * @return
	 * Total level can be used in other cases. These are the combat statistics
	 * used without randomness.
	 */
	private int getTotalLevel() {
		return strength + dexterity + charisma;
	}

	/**
	 * @return the random number used. This will be denoted as "luck".
	 */
	private int rollLuck() {
		return numberGenerator.nextInt(6);
	}

	/**
	 * @return the name Simply gives the fighter's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the level Simply sends back the level.
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @return the xp Simply sends back the current XP that the player has. Take
	 *         note, XP is deducted from every level up.
	 */
	public int getXp() {
		return xp;
	}

	/**
	 * @return the strength Simply returns the strength of the figher, as well
	 *         as their item strength (if applicable)
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * @return the dexterity Simply returns the dexterity of the character
	 */
	public int getDexterity() {
		return dexterity;
	}

	/**
	 * @return the charisma Simply returns the charisma, which is a special
	 *         attribute used to talk your way out of a fight.
	 */
	public int getCharisma() {
		return charisma;
	}

	/**
	 * @return the speed Returns the current speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @return the life Returns the current health points of the character
	 */
	public int getLife() {
		return life;
	}

	/**
	 * @return the coins set the amount of coins the user has.
	 */
	public int getCoins() {
		return coins;
	}

	/**
	 * @return the levelXPAmt returns the entire array of XP required to level
	 *         up.
	 */
	public int[] getLevelXPAmt() {
		return levelXPAmt;
	}

	/**
	 * @return the battlesWon Return the numbers your character has won since he
	 *         last died.
	 */
	public int getBattlesWon() {
		return battlesWon;
	}

	/**
	 * @return weaponNames, this just returns the array of Strings of current weapons in the game.
	 */
	public static String[] getWeaponNames() {
		return weaponNames;
	}

	/**
	 * @param name
	 *            the name to set Sets the name of the character, no checks are
	 *            needed. Nothing would be out of bounds.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param xp
	 *            the xp to set Set the current XP the user has to level up.
	 *            Check if they can level up using this information.
	 */
	public void setXp(int xp) {
		this.xp = xp;
		this.checkLevelUp();
	}

	/**
	 * @param strength
	 *            the strength to set Strength may only be between 1 and 20. If
	 *            it was invalid, just use the old number.
	 */
	public void setStrength(int strength) {
		if (strength <= 20 && strength >= 1)
			this.strength = strength;
	}

	/**
	 * @param dexterity
	 *            the dexterity to set Dexterity may only be between 1 and 20.
	 *            If the number passed as a paramter is invalid, use the old
	 *            value.
	 */
	public void setDexterity(int dexterity) {
		if (dexterity <= 20 && dexterity >= 1)
			this.dexterity = dexterity;
	}

	/**
	 * @param charisma
	 *            the charisma to set Charisma may only be between 1 and 20. If
	 *            the number passed as a paramter is invalid, use the old value.
	 */
	public void setCharisma(int charisma) {
		if (charisma <= 20 && charisma >= 1)
			this.charisma = charisma;
	}

	/**
	 * @param battlesWon
	 *            the battlesWon to set Setting the amount of battles where the
	 *            user has triumphed over another. Battles won must be the same
	 *            as or greater than 0
	 */
	public void setBattlesWon(int battlesWon) {
		if (battlesWon >= 0)
			this.battlesWon = battlesWon;
	}

	/**
	 * @param speed
	 *            the speed to set Speed must be between 0-9 Running will not be
	 *            set using this method, as they denote different things Running
	 *            can be ten, although you may not construct a character with
	 *            speed greater than 9
	 */
	public void setSpeed(int speed) {
		if (speed < 10 && speed >= 0) {
			this.speed = speed;
		}
		if (speed>10){
			this.speed=(speed/2)-1;
		}
	}
	/**
	 * @see
	 * 		this allows the class to set the speed depending on their level rather than simply setting it, as it can be complicated.
	 */
	public void setSpeed(){
		if (level>=4)
			speed=level/2-1;
		else
		{
			speed=1;
		}
	}

	/**
	 * @param life
	 *            the life to set Sets the users current life. The user may be
	 *            set with life 0, although the character will be reset as if
	 *            the user has passed in battle. If the user passes a value over
	 *            100, their health will be simply rounded down to 100.
	 */
	public void setLife(int life) {
		if (life <= 100 && life > 0) {
			this.life = life;
		} else if (life <= 0) {
			// killed the fighter. If the figher is dead, reset their life and
			// then set them to level 1, and set all of their variables back to
			// 0;
			this.life = 100;
			this.level = 1;
			this.setSpeed(1);
			this.setBattlesWon(0);
			this.setCharisma(1);
			this.setXp(0);
			this.setStrength(1);
			if (!currentWeapon.equals(null)) {
				currentWeapon = null;
			}
		} else
			this.life = 100;
	}

	/**
	 * @param level
	 *            the level to set Level may only be between 1-20 If that
	 *            paramater is not met, use the old value
	 *            We will check their strength, dexterity to see if they have customly leveled.
	 *            If they have customly leveled, we will take them to the screen to allocate.
	 */
	public void setLevel(int level) {
		boolean skippedLevelandCustom=false;
		if (strength!=level || dexterity!=level)
		{
			skippedLevelandCustom=true;
		}
		if (level <= 20 && level >= 1){
			this.level = level;
			if (skippedLevelandCustom)
				this.levelUp(level);
		}
	}

	/**
	 * @param coins
	 *            the coins to set Set the current amount of coins the user has.
	 *            coins can be negative.
	 */
	public void setCoins(int coins) {
		this.coins = coins;
	}

	/*
	 * This method will allow a user to spend one level on a weapon that will be
	 * generated randomly with specific statistics. This is my custom method #2
	 * 
	 * If the user already has a weapon, adjust their stats accordingly so they
	 * don't double stack weapon power. The second if statement prenvents a
	 * users power from overcapping their strength higher than 20.2 Then it will
	 * give them the weapon and subtract a level from them.
	 * 
	 */
	public void getWeapon() {
		if (!currentWeapon.equals(null)) {
			this.strength -= currentWeapon.getPower();
		}
		currentWeapon = new Weapon();
		if (currentWeapon.getPower() + this.getStrength() > 20) {
			this.setStrength(20);
		} else {
			this.setStrength(currentWeapon.getPower() + this.getStrength());
			level--;
		}
	}

	/*
	 * This method is different than setXP SetXp simply sets the amount of XP
	 * the user currently has. This adds XP to the user rather than recreating
	 * the value.
	 */
	public void scaleXP(int addedXP) {
		this.xp = this.getXp() + addedXP;
		this.checkLevelUp();
	}

	/*
	 * Custom Method #1 This method allows users to manipulate unique character
	 * values. (Strength, dexterity, etc). It createws JOptionPanes for the user
	 * to input the values that they want to change the level of. They may not
	 * increase their current total level, they may only reallocate skill This
	 * will cost 100 coins.
	 * 
	 * I recieved special permission to do this method from Dr. Stephan
	 */
	public void modifyCharacter() {
		if (coins >= 100) {
			coins -= 100;
			boolean didChangeLevelsCorrectly = true;
			int temp[] = new int[] { 1, 1, 1 };
			if (level != 20) {
				this.setLevel(level--);
				do {
					try
					{
						
						temp[0] = Integer.parseInt(
								JOptionPane.showInputDialog("New Strength\nPoints Remaining " + this.getTotalLevel()));
						temp[1] = Integer.parseInt(JOptionPane
								.showInputDialog("New Dexterity\nPoints Remaining " + (this.getTotalLevel() - temp[0])));
						temp[2] = Integer.parseInt(JOptionPane.showInputDialog(
								"New Charisma\nPoints Remaining " + (this.getTotalLevel() - temp[0] - temp[1])));
						if (temp[0] > 20 || temp[0] < 1) {
							JOptionPane.showMessageDialog(null, "You have incorrectly allocated strength points", "Error",
									JOptionPane.ERROR_MESSAGE, null);
							didChangeLevelsCorrectly = false;
						} else if (temp[1] > 20 || temp[1] < 1) {
							JOptionPane.showMessageDialog(null, "You have incorrectly allocated strength points", "Error",
									JOptionPane.ERROR_MESSAGE, null);
							didChangeLevelsCorrectly = false;
						} else if (temp[2] > 20 || temp[2] < 1) {
							JOptionPane.showMessageDialog(null, "You have incorrectly allocated dexterity points", "Error",
									JOptionPane.ERROR_MESSAGE, null);
							didChangeLevelsCorrectly = false;
						} else if (this.getTotalLevel() - temp[0] - temp[1] - temp[2] < 0) {
							JOptionPane.showMessageDialog(null, "You have incorrectly allocated charisma points", "Error",
									JOptionPane.ERROR_MESSAGE, null);
							didChangeLevelsCorrectly = false;
						} else {
							JOptionPane.showMessageDialog(null, "You have correctly allocated points. ", "Success",
									JOptionPane.DEFAULT_OPTION, null);
							this.strength = temp[0];
							this.dexterity = temp[1];
							this.charisma = temp[2];
							didChangeLevelsCorrectly=true;
						}
					}
					catch(Exception e)
					{
						didChangeLevelsCorrectly=false;
					}
				} while (!didChangeLevelsCorrectly);
			}
		} // end if
		else {
			JOptionPane.showMessageDialog(null, "You don't have enough coins", "Failure", JOptionPane.DEFAULT_OPTION,
					null);
		}
	}// end method
	/**
	 * @see
	 * 		actually adjust the stats of a fighter for their leveling.
	 * This method relies on the "set" methods, otherwise it would permit them to level beyond the parameters.
	 */
	private void levelUp() {
		setStrength(strength++);
		setDexterity(dexterity++);
		setCharisma(charisma++);
		setSpeed(level);
	}
	
	/**
	 * @param level dictates what level the person is climbing to. 
	 * setLevel breaks the custom leveling process.
	 * It should only be an admin that does this, so this shouldn't be a problem.
	 * It will send you into the picking your levels automatically so that you may fix your stats
	 * This way it does not break the custom leveling. 
	 * 
	 */
	private void levelUp(int level){
		setStrength(level);
		setDexterity(level);
		setCharisma(level);
		setSpeed(level);
		
		if (this.level!=strength || this.level!=dexterity){
			this.coins+=100;
			this.modifyCharacter();
		}
	}

}// end class
