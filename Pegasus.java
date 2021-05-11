class Pegasus implements Creature 
{
	private int attack, defense, speed, health;
    private int[] stats;
    
  public Pegasus()
  {
  	attack = 70;
    defense = 70;
    speed = 50;
    health = 80;
  
  	stats = new int [] {health,attack,defense,speed};
   // getAbility();
  	
  }

  public String getName()
  {
  	return "Pegasus";
  }
  public String getDescription()
  {
     return " Not what you think!! \n 8'2'' tall aggie weighing 482lbs " ;
  }
  
  public Ability[] getAbility()
  { //String name, String type, String Description, String condition
  	  Ability[] abilities = new Ability[4];
      Ability waterBeam = new Ability("water Beam","attack","shooting another aggie with high pressure water","none");
     waterBeam.setDamage(attack);
Ability kick = new Ability("phychic ","debuff turn","get into the opponent aggie's mind and create confusion which can lead the opponent aggie to lose attack ","none");
      kick.setDamage(attack);

      Ability speedyDragon= new Ability("Speedy Dragon","buff attack","buffing to prevent from getting attack and attack in retaliation","Increase speed and decreasing the opponent aggie's defence by 15"); 
  speedyDragon.setDamage(attack);
     
 
      Ability powerHeal = new Ability("power heal", "defense", "heal fully", "opponent lose one turn");
 
     
       abilities[0] = waterBeam;
      abilities[1] = kick;
      abilities[2] = speedyDragon;
      abilities[3] = powerHeal;
  
      
      return abilities;
  }
  // ability 1, ability 2, ability 3, super

  

  public int[] getStats()
  {
    // health,attack,defense,speed
    
    return stats;
  }
  
}



