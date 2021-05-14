class DreamReaper implements Creature 
{
	private int attack, defense, speed, health;
    private int[] stats;
    
  public DreamReaper()
  {
  	attack = 70;
    defense = 65;
    speed = 60;
    health = 90;
  
  	stats = new int[] {health,attack,defense,speed};	
  }

  public String getName()
  {
  	return "Dream Reaper";
  }
  public String getDescription()
  {
     return"A minor diety of unknown origins, He will haunt your dreams if you ever cross his path";
  }
  
  public Ability[] getAbility()
  { //String name, String type, String Description, String condition
  	  Ability[] abilities = new Ability[4];
      Ability slash = new Ability("slash","attack","Dream Reaper attacks his opponent with his sickle","none");
      slash.setDamage(attack);
      Ability chaos = new Ability("chaos","buff attack","Dream Repear draws power from the void and corrupts his opponent","none");
      chaos.setDamage(attack*2);
      Ability nightmare = new Ability("nightmare","debuff defense","Dream Reaper weakens his opponent with fear","defense -20");
      nightmare.setDamage(attack);
      Ability heal = new Ability("heal", "super health","Super ability, Dream Reaper gains 50% of remaining health","none");
      
      abilities[0] = slash;
      abilities[1] = chaos;
      abilities[2] = nightmare;
      abilities[3] = heal;
      return abilities;
  }
  public int[] getStats()
  { 
    return stats;
  }
}
