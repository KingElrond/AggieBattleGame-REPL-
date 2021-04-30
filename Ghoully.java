class Ghoully implements Creature 
{
	private int attack, defense, speed, health;
    private int[] stats;
    
  public Ghoully()
  {
  	attack = 75;
    defense = 70;
    speed = 60;
    health = 70;
  
  	stats = new int[]{health, attack, defense, speed};
  	
  }

  public String getName()
  {
  	return "Ghoully";
  }
  public String getDescription()
  {
     return "A haunting entity whistles in the wind.";
  }
  
  public Ability[] getAbility()
  {

	  	Ability[] abilities = new Ability[4];
      	Ability darkPulse = new Ability("Dark Pulse","Attack",
      	"Sends out a dark pulse across the air that does blunt physical damage.","none");
      	darkPulse.setDamage(attack);

		Ability shadowBall = new Ability("Shadow Ball","Attack",
        "Sends a ball of energy that does damage","none"); 
		shadowBall.setDamage(attack);

		Ability hypnosis = new Ability("Hypnosis","Debuff turn",
		"Hypnotizes the enemy and makes them lose one turns","Lose one turn");

		Ability dreamEater = new Ability("Dream Eater","super Attack",
        "Enters the opponent’s dreams and does physical damage in the real world." 
        + " 2x the damage when the opponent is under hypnosis.","none");
		dreamEater.setDamage(2);
        
        abilities[0] = darkPulse;
        abilities[1] = shadowBall;
        abilities[2] = hypnosis;
        abilities[3] = dreamEater;


     
      return abilities;
  }

  

  public int[] getStats()
  {
    return stats;
  }
  
}



