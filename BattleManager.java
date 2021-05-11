
class BattleManager 
{
    private StatsManager sm1,sm2,smTemp;
    private Creature a1,a2, first,second, attacker, defender;
    private Ability[] a1Abilities, a2Abilities;
    private UserInput ui;
    private String attackerName, defenderName;
    // Ability[] ability 1,2,3, and super goes by name, type, description, condition
  
    public BattleManager(Creature a, Creature b)
    {
       a1 = a;
       a2 = b;
       ui = new UserInput();
       
       sm1 = new StatsManager(a1);
       sm2 = new StatsManager(a2);
       determineOrder();
       sm1 = new StatsManager(first);
       sm2 = new StatsManager(second);
       a1Abilities = first.getAbility();
       a2Abilities = second.getAbility();
       fight();
      
    }
  
  	private void determineOrder()
    {
     if(sm1.getSpeed() > sm2.getSpeed())
      {
        first = a1;
       second = a2;
      }
      else if(sm1.getSpeed() < sm2.getSpeed())
      {
        first = a2;
        second = a1;
      } //if same speed
      else
      {
        int ran = (int)(Math.random() * 2 + 1);
        if(ran == 1)
        {
          first = a1;
          second = a2;
        }
        else
        {
          first = a2;
          second = a1;
        }  
          
      }
      
      
      attacker = first;
      attackerName = first.getName();
      defender = second;
      defenderName = second.getName();
      
    }
  
     public void fight()
     {
      
       
       while(sm1.getHP() > 0 && sm2.getHP() > 0)
       {
           firstAggieTurn();
           attacker = second;
           defender = first;
         
           secondAggieTurn();
           attacker = first;
           defender = second;
          
         
       }
         
       
     }
  
     public boolean getHit()
     {
       boolean hit = false;
       double dodge = 0;
       //attacker hit chance out of 100%
       double hitChance = (int)(100 * Math.random() + 1);
       if(attacker.getName().equals(first.getName()))
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
  
  	 public int getDamage()
     {
        int damage = 0;
        int mitigate = 0;
        if(attacker.getName().equals(first.getName()))
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
  
  
      public void firstAggieTurn()
      {
         String move = "";
         int moveVal = 0;
        String type = "";
        //first Aggie's turn
          System.out.println();
          System.out.println(first.getName() + " What do you want to do?");
          System.out.println("your hp: " + sm1.getHP() + " opponent hp: " + sm2.getHP());
          System.out.println("Your energy: " + sm1.getEnergy());
          System.out.println("Attack: " + sm1.getAttack() + " Defense: " + sm1.getDefense() +
                            " Speed: " + sm1.getSpeed());
          for(int c = 0; c < 4; c++)
          { 
            System.out.print("Ability " + (c+1) + ") ");
            System.out.println(a1Abilities[c].getName() + "(" + a1Abilities[c].getType()+")");
          }
          move = ui.getMove(sm1.getEnergy());    
          // determining ability number and checking the "type" of ability
         
          moveVal = Integer.parseInt(move);
         
            type = a1Abilities[moveVal-1].getType();
            // if the ability type is attack and so on
            if(type.equalsIgnoreCase("attack"))
            {
                 
                 if(getHit())
                 {
                   int damage = getDamage();
                   sm2.updateHP(-1*damage);
                 }
            }
            else if(type.equalsIgnoreCase("buff attack"))
            {
              sm1.setAttack(20);
            }
            else if(type.equalsIgnoreCase("buff defense"))
            {
              sm1.setDefense(20);
            }
            else if(type.equalsIgnoreCase("buff speed"))
            {
              sm1.setSpeed(20);
            }
            else if(type.equalsIgnoreCase("debuff attack"))
            {
              int attack = sm2.getAttack();
              System.out.println("debuff atk: original atk: " + attack);
              int deduct = (int)(attack*.15);   
              System.out.println("deduct: " + deduct);
              sm2.setAttack(-1*deduct);
              System.out.println("atk after debuff: " + sm2.getAttack());
            }
            else if(type.equalsIgnoreCase("debuff defense"))
            {
              int defense = sm2.getDefense();
              int deduct = (int)(defense * .15);
              sm2.setDefense(-1*deduct);
            }
            else if(type.equalsIgnoreCase("debuff speed"))
            {
              int speed = sm2.getSpeed();
              int deduct = (int)(speed * .15);
              sm2.setSpeed(-1*deduct);
            }
            else if(type.equalsIgnoreCase("debuff turn"))
            {
              int miss = (int)( 100 * Math.random() + 1);
              System.out.println("miss: " + miss);
              if(miss <= 50)              
                 for(int c = 0; c < 2; c++)
                     firstAggieTurn();
            }
           else if(type.equalsIgnoreCase("super attack"))
           {
             sm1.updateEnergy(-100);
             int atk = sm1.getAttack();
             sm1.setAttack(atk);
              if(getHit())
                 {
                   int damage = getDamage();
                   sm2.updateHP(-1*damage);
                   sm1.updateEnergy(-25);
                 }
             sm1.setAttack(-1*atk);
             
              
           }
           else if(type.equalsIgnoreCase("super health"))
           {
             int hp = sm1.getHP();
             sm1.updateHP((int)(hp * 1.50 + .5));
             sm1.updateEnergy(-100);
           }
            
      }
  
      public void secondAggieTurn()
      {
         String move = "";
         int moveVal = 0;
        String type = "";
        
         // SECOND AGGIE'S TURN
        System.out.println();
            System.out.println(second.getName() + " What do you want to do?");
           System.out.println("your hp: " + sm2.getHP() + " opponent hp: " + sm1.getHP());
           System.out.println("Your energy: " + sm2.getEnergy());
           System.out.println("Attack: " + sm2.getAttack() + " Defense: " + sm2.getDefense() +
                            " Speed: " + sm2.getSpeed());
          for(int c = 0; c < 4; c++)
          { 
            System.out.print("Ability " + (c+1) + ") ");
            System.out.println(a2Abilities[c].getName() + "(" + a2Abilities[c].getType()+")");
          }
          move = ui.getMove(sm2.getEnergy());    
          // determining ability number and checking the "type" of ability
          type = "";
         moveVal = Integer.parseInt(move);
         
            type = a2Abilities[moveVal-1].getType();
            // if the ability type is attack and so on
            if(type.equalsIgnoreCase("attack"))
            {
                 
                 if(getHit())
                 {
                   int damage = getDamage();
                   sm1.updateHP(-1*damage);
                 }
            }
                else if(type.equalsIgnoreCase("buff attack"))
            {
              sm2.setAttack(20);
            }
            else if(type.equalsIgnoreCase("buff defense"))
            {
              int defense = sm1.getDefense();
              int deduct = (int)(defense * .15);
              sm1.setDefense(-1*deduct);
            }
            else if(type.equalsIgnoreCase("buff speed"))
            {
              sm2.setSpeed(20);
            }
            else if(type.equalsIgnoreCase("debuff attack"))
            {
              int attack = sm1.getAttack();
              System.out.println("debuff atk: original atk: " + attack);
              int deduct = (int)(attack*.15);              
              sm1.setAttack(-1*deduct);
              System.out.println("atk after debuff: " + sm1.getAttack());
            }
            else if(type.equalsIgnoreCase("debuff defense"))
            {
              int defense = sm1.getDefense();
              int deduct = (int)(defense*.15);
             sm1.setDefense(-1*deduct); 
            }
            else if(type.equalsIgnoreCase("debuff speed"))
            {
              int speed = sm1.getSpeed();
              int deduct = (int)(speed * .15);
              sm1.setSpeed(-1*deduct);
            }
            else if(type.equalsIgnoreCase("debuff turn"))
            {
              int miss = (int)( 100 * Math.random() + 1);
              System.out.println("miss: " + miss);
              if(miss <= 50)              
                 for(int c = 0; c < 2; c++)
                     secondAggieTurn();
            }
             else if(type.equalsIgnoreCase("super attack"))
           {
             sm2.updateEnergy(-100);
             int atk = sm2.getAttack();
             sm2.setAttack(atk);
              if(getHit())
                 {
                   int damage = getDamage();
                   sm1.updateHP(-1*damage);
                   sm2.updateEnergy(-25);
                 }
             sm2.setAttack(-1*atk);
              
           }
           else if(type.equalsIgnoreCase("super health"))
           {
             int hp = sm2.getHP();
             sm2.updateHP((int)(hp * 1.50 + .5));
             sm2.updateEnergy(-100);
           }
            
              
      }
  
  
  
  
  
  
}


  //debugger at https://onlinegdb.com/H1AfwzwDO