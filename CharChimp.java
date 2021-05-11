class CharChimp implements Creature 
{
	private int attack, defense, speed, health;
    private int[] stats;
    
  public CharChimp()
  {
  	attack = 100;
    defense = 60;
    speed = 40;
    health = 75;
  
    stats = new int[] {health,attack,defense,speed};
  	
  }

  public String getName()
  {
  	return "CharChimp";
  }
  public String getDescription()
  {
     return"A Monkey on fire, what more could you want.";
  }
  
  public Ability[] getAbility()
  { //String name, String type, String Description, String condition
  	  Ability[] abilities = new Ability[4];
      Ability brute = new Ability("brute","buff attack","puffs out chest","increase atk");
      Ability kick = new Ability("Kick","attack","Kick opposing opponent","none");
      kick.setDamage(attack);
      Ability burn = new Ability("Burn","debuff turn","Sets opponent on fire, opponent loses turn","lose 1 turn");
      Ability firetail = new Ability("fireTail","super attack","Sets own tail on fire and hits opponent with it for double damage","decrease hp 10");
      firetail.setDamage(attack * 2);
      
      abilities[0]=brute;
      abilities[1]=kick;
      abilities[2]=burn;
      abilities[3]=firetail;
      
      return abilities;
  }
  // ability 1, ability 2, ability 3, super

  

  public int[] getStats()
  {
    // health,attack,defense,speed
    return stats;
  }
  
}

