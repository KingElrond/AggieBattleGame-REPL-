class Attack
{
  private StatsManager sm1,sm2;
  public Attack(StatsManager sm3, StatsManager sm4)
  {
    sm1 = sm3;
    sm2 = sm4;
  }
  public boolean getHit(Creature attacker,Creature defender)
     {
       boolean hit = false;
       double dodge = 0;
       //attacker hit chance out of 100%
       double hitChance = (int)(100 * Math.random() + 1);
       if(attacker.getName().equals(sm1.getName()))
       {
         dodge = .40 * sm2.getSpeed();
         
       }
       else
       {
         dodge = .40 * sm1.getSpeed();
       }
       
       if(hitChance >= dodge)
         hit = true;
       System.out.println("****");
       System.out.println("hitChance: " + hitChance + " dodge: " + dodge);
       System.out.println("Hit :" + hit);
       System.out.println("****\n");
       
       return hit;
     }
  
  	 public int getDamage(Creature attacker, Creature defender)
     {
        int damage = 0;
        int mitigate = 0;
        if(attacker.getName().equals(sm1.getName()))
        {
          damage = (int)(sm1.getAttack() * Math.random() + (sm1.getAttack()*.30));
          mitigate = (int)(sm2.getDefense() * Math.random() + 1);
          //attack damage - mitigation
          System.out.println("damage: " + damage + " mitigation: " + mitigate);
          damage = damage - mitigate;
          sm1.updateEnergy(25);
        }
       
       else
       {
          damage = (int)(sm2.getAttack() * Math.random() + (sm2.getAttack() * .30));
          mitigate = (int)(sm1.getDefense() * Math.random() + 1);
          //attack damage - mitigation
          System.out.println("damage: " + damage + " mitigation: " + mitigate);
          damage = damage - mitigate;
          sm2.updateEnergy(25);
       }
       if(damage < 5)
         damage = 5;
       
       System.out.println("Damage: " + damage);
       System.out.println();
       return damage;
     }


}