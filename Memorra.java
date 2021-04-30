class Memorra implements Creature 
{
	private int attack, defense, speed, health;
    private int[] stats;
    
  public Memorra()
  {
  	attack = 70;
    defense = 65;
    speed = 60;
    health = 80;
  
  	stats = new int[] {health,attack,defense,speed};
  	
  }

  public String getName()
  {
  	return "Memorra";
  }
  public String getDescription()
  {
     return"3 foot 5 inch air guy ";
  }
  
  public Ability[] getAbility()
  { 
  	  Ability[] abilities = new Ability[4];
      Ability blow = new Ability("Blow","attack","Blows in the opponent's face and deals damage",
      "none");
      blow.setDamage(attack);
      Ability windyWinds = new Ability("WindyWinds","debuff defense","Knocks opponent of their feet","Decrease Opponent defense");
      Ability swiftly = new Ability("Swiftly","attack","Memorra rushes the opponent and attacks","none");
      swiftly.setDamage(attack);
      Ability slurp = new Ability("Slurp", "super attack","Super ability, Memorrra slurps the life out of the opponent dealing big damage",
      "none");
      slurp.setDamage(2);
      
      abilities[0] = blow;
      abilities[1] = windyWinds;
      abilities[2] = swiftly;
      abilities[3] = slurp;
      return abilities;
  }
  

  

  public int[] getStats()
  {
    
    
    return stats;
  }
  
}

