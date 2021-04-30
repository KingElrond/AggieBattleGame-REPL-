
class Finality implements Creature 
{
 private int attack, defense, speed, health;
    private int[] stats;
    
  public Finality()
  {
    attack = 125;
    defense = 15;
    speed = 75;
    health = 60;
  
  	//stats = {health,attack,defense,speed};
    
  	stats = new int[] {health,attack,defense,speed};
  }

  public String getName()
  {
  	return "Finality";
  }
  public String getDescription()
  {
     return"A existence far beyond any measurable scale.\nA nano virus created by a singular knight of the pre crisis to aid his King.\nThe One entrusted malice to be the sole reasoning for it’s objective.\nAs the vessel for finality series 00001 it is beyond all forms of logic and measure.\nThe power is an allusion as it’s true form exist in on a outerversal plain.";
  }
  
  public Ability[] getAbility()
  { //String name, String type, String Description, String condition
  	 Ability[] abilities = new Ability[4];
      Ability end= new Ability("End","attack","Slashing at the speed of light.","none");
     end.setDamage(attack);

      Ability lacerate = new Ability("Lacerate","sDebuff attack"," Inserts slashing nano inside the opponent to break them.","20"); 
	  

      Ability  overpower= new Ability("OverPower","super attack","Attacks with two times the effort","Attacks with 2x the dmg"); 
   overpower.setDamage(2);

Ability Super = new Ability ("Soul Slash","super attack","Slashes through opponents soul","none"); 
      Super.setDamage(3);

      abilities[0] = end;
      abilities[1] = lacerate;
      abilities[2] = overpower;
      abilities[3] = Super;

      return abilities;
  }
  // ability 1, ability 2, ability 3, super

  

  public int[] getStats()
  {
    // health,attack,defense,speed
    
    return stats;
  }
  
}

