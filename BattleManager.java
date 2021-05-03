class BattleManager 
{
    private StatsManager sm1,sm2,smTemp;
    private Creature a1,a2, first,second, attacker, defender;
    private Ability[] a1Abilities, a2Abilities;
    private String[] abTypes;
    private UserInput ui;
    private String attackerName, defenderName,type,cond;
    private boolean skipturn=false,skipturn1=false,condisType;
    private int superInt,moveVal;
    // Ability[] ability 1,2,3, and super goes by name, type, description, condition
  
    public BattleManager(Creature a, Creature b)
    {
       a1 = a;
       a2 = b;
       ui = new UserInput();
       abTypes = new String[] {"attack","buff attack","debuff turn","super Attack","buff hp","sbuff attack","sdebuff defense","sdebuff attack"};
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
       String move = "";
       
       while(sm1.getHP() > 0 && sm2.getHP() > 0)
       {
           
          //first Aggie's turn
            attacker = second;
            defender = first;

         if(sm1.getHP() <= 0 || sm2.getHP() <= 0)
         {
             break;
         }
               
            skipturn1=false;
            // SECOND AGGIE'S TURN
            if(!skipturn)
            {
            System.out.println(second.getName() + " What do you want to do?");
          for(int c = 0; c < 4; c++)
          { 
            System.out.print("Ability " + (c+1) + ") ");
            System.out.println(a2Abilities[c].getName() + "(" + a2Abilities[c].getType()+")");
          }
          move = ui.getMove();    
          // determining ability number and checking the "type" of ability
          type = "";
         moveVal = Integer.parseInt(move);
         
            type = a2Abilities[moveVal-1].getType();
            superInt = a2Abilities[moveVal-1].getAttackDamage();
            cond=a2Abilities[moveVal-1].getCondition();

            //if the cond is a second type of act such as atk and heal, or other
            for(String cTyPe : abTypes)
            {
                if(cond.equalsIgnoreCase(cTyPe))
                {
                    condisType=true;
                }
            }
            
            
            //need code here not sure what though.
            
            boolean shouldrepeat=true;
            int counter = 0;
            while(shouldrepeat)
            {
            if(counter==1)
            {
                type=cond;
            }
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
              if(getHit())
              {
                  int buffamount = getBuffInt();
                  sm2.updateATK(buffamount);
              }
            }
            else if(type.equalsIgnoreCase("debuff turn"))
            {
              if(getHit())
              {
                  skipturn1=true;

              }
            }else if(type.equalsIgnoreCase("super attack"))
            {
                if(getHit())
                {
                    int damage = getSDamage(superInt);
                    sm1.updateHP(-1*damage);
                }
            }else if(type.equalsIgnoreCase("sbuff hp"))
            {
              if(getHit())
              {
                  int buffamount = getSbuff(cond);
                  sm2.updateHP(buffamount*10);
              }
            } else if(type.equalsIgnoreCase("sbuff attack"))
            {
              if(getHit())
              {
                  int buffamount = getSbuff(cond);
                  sm2.updateATK(buffamount);
              }
            } else if(type.equalsIgnoreCase("sdebuff defense"))
            {
              if(getHit())
              {
                  int buffamount = getSbuff(cond);
                  sm1.updateDEF(-1*buffamount);
              }
            } else if(type.equalsIgnoreCase("sdebuff attack"))
            {
              if(getHit())
              {
                  int buffamount = getSbuff(cond);
                  sm1.updateATK(-1*buffamount);
              }
            } else if(type.equalsIgnoreCase("sdebuff speed"))
            {
              if(getHit())
              {
                  int buffamount = getSbuff(cond);
                  sm1.updateSPD(-1*buffamount);
              }
            } else if(type.equalsIgnoreCase("sbuff speed"))
            {
              if(getHit())
              {
                  int buffamount = getSbuff(cond);
                  sm1.updateSPD(buffamount);
              }
            } 

            if(!condisType || cond.equalsIgnoreCase(type))
            {
                shouldrepeat=false;
            }
            counter++;
            }


            }
            attacker = first;
            defender = second;
         
          skipturn=false;

          }
         


          if(sm1.getHP() <= 0)
          {
              System.out.println(sm1.getName() + " has Died");
              System.out.println(sm2.getName() + " has Won");
          }
          if(sm2.getHP() <= 0)
          {
              System.out.println(sm2.getName() + " has Died");
              System.out.println(sm1.getName() + " has Won");
          }
         
       
     }
  
     public boolean getHit()
     {
       boolean hit = false;
       double dodge = 0;
       //attacker hit chacne out of 100%
       double hitChance = (int)(100 * Math.random() + 1);
       if(attacker.getName().equals(first.getName()))
       {
         dodge = .20 * sm2.getSpeed();
         
       }
       else
       {
         dodge = .20 * sm1.getSpeed();
       }
       
       if(hitChance >= dodge)
         hit = true;
       
       System.out.println("Hit :" + hit);
       
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
        }
       
       else
       {
          damage = (int)(sm2.getAttack() * Math.random() + (sm2.getAttack() * .30));
          mitigate = (int)(sm1.getDefense() * Math.random() + 1);
          //attack damage - mitigation
          System.out.println("damage: " + damage + " mitigation: " + mitigate);
          damage = damage - mitigate;
       }
       if(damage < 5)
         damage = 5;
       
       System.out.println("Damage: " + damage);
       return damage;
     }
  
  public int getBuffInt()
     {
        int buff = 0;
        int mitigate = 0;
        if(attacker.getName().equals(first.getName()))
        {
          buff = (int)(sm1.getAttack() * Math.random() + (sm1.getAttack()*.30));
          mitigate = (int)(sm2.getDefense() * Math.random() + 1);
          //attack damage - mitigation
          System.out.println("buff: " + buff + " mitigation: " + mitigate);
          buff =(int) (buff/2);
          buff -= (int)(mitigate/2);
        }
       
       else
       {
          buff = (int)(sm2.getAttack() * Math.random() + (sm2.getAttack()*.30));
          mitigate = (int)(sm1.getDefense() * Math.random() + 1);
          //attack damage - mitigation
          System.out.println("buff: " + buff + " mitigation: " + mitigate);
          buff =(int) (buff/2);
          buff -= (int)(mitigate/2);
       }
       if(buff < 5)
         buff = 5;
       
       System.out.println("buff: " + buff);
       return buff;
     }

     public int getSDamage(int sATK)
     {
        int damage = 0;
        int mitigate = 0;
        if(attacker.getName().equals(first.getName()))
        {
          damage = (int)((sm1.getAttack()*sATK) * Math.random() + ((sm1.getAttack()*sATK)*.30));
          mitigate = (int)(sm2.getDefense() * Math.random() + 1);
          //attack damage - mitigation
          System.out.println("damage: " + damage + " mitigation: " + mitigate);
          damage = damage - mitigate;
        }
       
       else
       {
          damage = (int)((sm2.getAttack()*sATK) * Math.random() + ((sm2.getAttack()*sATK) * .30));
          mitigate = (int)(sm1.getDefense() * Math.random() + 1);
          //attack damage - mitigation
          System.out.println("damage: " + damage + " mitigation: " + mitigate);
          damage = damage - mitigate;
       }
       if(damage < 5)
         damage = 5;
       
       System.out.println("Damage: " + damage);
       return damage;
     }

     public int getSbuff(String Strcond)
     {
         int buffAmount=0;
            buffAmount = Integer.parseInt(Strcond);
         return buffAmount;
     }
  
public void FirstAggieTurn()
{
          System.out.println(first.getName() + " What do you want to do?");
          for(int c = 0; c < 4; c++)
          { 
            System.out.print("Ability " + (c+1) + ") ");
            System.out.println(a1Abilities[c].getName() + "(" + a1Abilities[c].getType()+")");
          }
          move = ui.getMove();    
          // determining ability number and checking the "type" of ability
        type = "";
        superInt = 1;
        moveVal = Integer.parseInt(move);
         cond="";
         cond=a1Abilities[moveVal-1].getCondition();
            type = a1Abilities[moveVal-1].getType();
            superInt = a1Abilities[moveVal-1].getAttackDamage();
            // if the ability type is attack and so on

            //if the cond is a second type of act such as atk and heal, or other
            for(String cTyPe : abTypes)
            {
                if(cond.equalsIgnoreCase(cTyPe))
                {
                    condisType=true;
                }
            }
            
            
            //need code here not sure what though.
            
            boolean shouldrepeat=true;
            int counter = 0;
            while(shouldrepeat)
            {
            if(counter==1)
            {
                type=cond;
            }
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
              if(getHit())
              {
                  int buffamount = getBuffInt();
                  sm1.updateATK(buffamount);
              }
            }
            else if(type.equalsIgnoreCase("debuff turn"))
            {
              if(getHit())
              {
                  skipturn = true;
              }

            } else if(type.equalsIgnoreCase("super attack"))
            {
                int damage = getSDamage(superInt);
                sm2.updateHP(-1*damage);
            } else if(type.equalsIgnoreCase("sbuff hp"))
            {
              if(getHit())
              {
                  int buffamount = getSbuff(cond);
                  sm1.updateHP(buffamount*10);
              }
            } else if(type.equalsIgnoreCase("sbuff attack"))
            {
              if(getHit())
              {
                  int buffamount = getSbuff(cond);
                  sm1.updateATK(buffamount);
              }
            } else if(type.equalsIgnoreCase("sdebuff defense"))
            {
              if(getHit())
              {
                  int buffamount = getSbuff(cond);
                  sm2.updateDEF(-1*buffamount);
              }
            } else if(type.equalsIgnoreCase("sdebuff attack"))
            {
              if(getHit())
              {
                  int buffamount = getSbuff(cond);
                  sm2.updateATK(-1*buffamount);
              }
            } else if(type.equalsIgnoreCase("sdebuff speed"))
            {
              if(getHit())
              {
                  int buffamount = getSbuff(cond);
                  sm2.updateSPD(-1*buffamount);
              }
            } else if(type.equalsIgnoreCase("sbuff speed"))
            {
              if(getHit())
              {
                  int buffamount = getSbuff(cond);
                  sm2.updateSPD(buffamount);
              }
            } 

            if(!condisType || cond.equalsIgnoreCase(type))
            {
                shouldrepeat=false;
            }
            counter++;
            }
          }



}
  //debugger at https://onlinegdb.com/H1AfwzwDO