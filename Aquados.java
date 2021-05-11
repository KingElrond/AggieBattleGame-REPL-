


class Aquados implements Creature 
{
	private int attack, defense, speed, health;
    private int[] stats;
    
  public Aquados()
  {
  	attack = 75;
    defense = 60;
    speed = 65;
    health = 75;
  
  	stats = new int[] {health,attack,defense,speed};
  	
  }

  public String getName()
  {
  	return "Aquados";
  }
  public String getDescription()
  {
     return"a 10 foot long water-shooting dragon that emerged from the depths of the deepest ocean";
  }
  
  public Ability[] getAbility()
  { //String name, String type, String Description, String condition
  	  Ability[] abilities = new Ability[4];
      Ability waterCannon = new Ability("Water cannon","attack","Aquados shoots a high-pressured blast of water at the opponent",
      "none");
      waterCannon.setDamage(attack);
      Ability suffocate = new Ability("Suffocate","debuff turn","Opponent is drowning in water","Opponent loses a turn to catch its breath");
      Ability chomp = new Ability("Chomp","attack","Aquados takes a bite out of its opponent","none");
      chomp.setDamage(attack);
      Ability iceBeam = new Ability("Ice Beam", "attack","Super ability, Aquados generates three tons of ice and shoots it in a continuous beam at the opponent, severely damaging it",
      "none");
      iceBeam.setDamage(attack * 3);
      
      abilities[0] = waterCannon;
      abilities[1] = suffocate;
      abilities[2] = chomp;
      abilities[3] = iceBeam;
      return abilities;
  }
  

  

  public int[] getStats()
  {
    // health,attack,defense,speed
    
    return stats;
  }
  
}