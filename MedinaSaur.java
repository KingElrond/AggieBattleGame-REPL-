class MedinaSaur implements Creature 
{
	private int attack, defense, speed, health;
    private int[] stats;
    
  public MedinaSaur()
  {
  	attack = 65;
    defense = 70;
    speed = 60;
    health = 80;
  
  	stats = new int[] {health,attack,defense,speed};
  	
  }

  public String getName()
  {
  	return "Medina Saur";
  }
  public String getDescription()
  {
     return"5 foot 4 inch fire dragon";
  }
  
  public Ability[] getAbility()
  { //String name, String type, String Description, String condition
  	  Ability[] abilities = new Ability[4];
      Ability tailWhip = new Ability("Tail Whip","attack","blunt force attack, Medina Saur spins around and whip the opponent with its tail",
      "none");
      tailWhip.setDamage(attack);
      Ability redBull = new Ability("redBull","sbuff speed","shotgunning a redbull","20");
      Ability fireBreath = new Ability("Fire Breath","attack","Medina Saur channels the fire pit in his stomach and blows out a cone of fire","none");
      fireBreath.setDamage(attack);
      Ability stomp = new Ability("stomp", "super attack","Super ability, Medina Saur flies up in the air at the speed of sound and lands on top of the oponent crushing it",
      "none");
      stomp.setDamage(2);
      
      abilities[0] = tailWhip;
      abilities[1] = redBull;
      abilities[2] = fireBreath;
      abilities[3] = stomp;
      return abilities;
  }
  

  

  public int[] getStats()
  {
    // health,attack,defense,speed
    
    return stats;
  }
  
}