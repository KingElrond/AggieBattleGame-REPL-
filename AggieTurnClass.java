class AggieTurnClass
{
  private Attack ATclass;
  private Ability[] a1Abilities, a2Abilities;
  private StatsManager sm1,sm2;
  public AggieTurnClass(StatsManager s1, StatsManager s2,Ability[] a1ab, Ability[] a2ab)
  {
    ATclass = new Attack(s1,s2);
    a1Abilities = a1ab;
    a2Abilities = a2ab;
    sm1=s1;
    sm2=s2;

  }
  public void AggieTurn(StatsManager atk, StatsManager def,Creature attacker,Creature defender)
      {
        UserInput ui = new UserInput();
         String move = "";
         int moveVal = 0;
        String type = "";

        System.out.println();
            System.out.println(atk.getName() + " What do you want to do?");
           System.out.println("your hp: " +atk.getHP() + " opponent hp: " + def.getHP());
           System.out.println("Your energy: " +atk.getEnergy());
           System.out.println("Attack: " +atk.getAttack() + " Defense: " +atk.getDefense() +
                            " Speed: " +atk.getSpeed());
          for(int c = 0; c < 4; c++)
          { 
            if(sm2.getName().equalsIgnoreCase(atk.getName()))
            {
              System.out.print("Ability " + (c+1) + ") ");
            System.out.println(a2Abilities[c].getName() + "(" + a2Abilities[c].getType()+")");
            }
            else
            {
            System.out.print("Ability " + (c+1) + ") ");
            System.out.println(a1Abilities[c].getName() + "(" + a1Abilities[c].getType()+")");
            }
          }
          move = ui.getMove(atk.getEnergy());    
          // determining ability number and checking the "type" of ability
          type = "";
         moveVal = Integer.parseInt(move);
         if(sm2.getName().equalsIgnoreCase(atk.getName()))
         {
            type = a2Abilities[moveVal-1].getType();
         }
         else
         {
           type = a1Abilities[moveVal-1].getType();
         }

            // if the ability type is attack and so on
            if(type.equalsIgnoreCase("attack"))
            {
                 
                 if(ATclass.getHit(attacker,defender))
                 {
                   int damage = ATclass.getDamage(attacker,defender);
                   def.updateHP(-1*damage);
                 }
            }
                else if(type.equalsIgnoreCase("buff attack"))
            {
            atk.setAttack((int)(atk.getAttack()*.20));
            }
            else if(type.equalsIgnoreCase("buff health"))
            {
            atk.updateHP(20);
            }
            else if(type.equalsIgnoreCase("buff defense"))
            {
              int defense = def.getDefense();
              int deduct = (int)(defense * .15);
             def.setDefense(-1*deduct);
            }
            else if(type.equalsIgnoreCase("buff speed"))
            {
            atk.setSpeed(20);
            }
            else if(type.equalsIgnoreCase("debuff attack"))
            {
              int attack = def.getAttack();
              System.out.println("debuff atk: original atk: " + attack);
              int deduct = (int)(attack*.15);              
             def.setAttack(-1*deduct);
              System.out.println("atk after debuff: " + def.getAttack());
            }
            else if(type.equalsIgnoreCase("debuff defense"))
            {
              int defense = def.getDefense();
              int deduct = (int)(defense*.15);
             def.setDefense(-1*deduct); 
            }
            else if(type.equalsIgnoreCase("debuff speed"))
            {
              int speed = def.getSpeed();
              int deduct = (int)(speed * .15);
             def.setSpeed(-1*deduct);
            }
            else if(type.equalsIgnoreCase("debuff turn"))
            {
              int miss = (int)( 100 * Math.random() + 1);
              System.out.println("miss: " + miss);
              if(miss <= 50)              
                 for(int c = 0; c < 2; c++)
                     AggieTurn(atk,def,attacker,defender);
            }
             else if(type.equalsIgnoreCase("super attack"))
           {
            atk.updateEnergy(-100);
             int satk =atk.getAttack();
            atk.setAttack(satk);
              if(ATclass.getHit(attacker,defender))
                 {
                   int damage = ATclass.getDamage(attacker,defender);
                   def.updateHP(-1*damage);
                  atk.updateEnergy(-25);
                 }
            atk.setAttack(-1*satk);
              
           }
           else if(type.equalsIgnoreCase("super health"))
           {
             int hp =atk.getHP();
            atk.updateHP((int)(hp * 1.50 + .5));
            atk.updateEnergy(-100);
           }
            
              
      }

}