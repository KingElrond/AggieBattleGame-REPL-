
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
       AggieTurnClass at = new AggieTurnClass(sm1,sm2,a1Abilities,a2Abilities);
      //
       
       while(sm1.getHP() > 0 && sm2.getHP() > 0)
       {
           at.AggieTurn(sm1,sm2,attacker,defender);
           attacker = second;
           defender = first;
         
         if(sm1.getHP() <= 0 && sm2.getHP() <=0)
         {
           break;
         }
           at.AggieTurn(sm2,sm1,attacker,defender);
           attacker = first;
           defender = second;
          
         
       }
       if((sm1.getHP() > 0 && sm1.returnCreature().equals(a1)) || (sm2.getHP() > 0 && sm2.returnCreature().equals(a1)))
       {
         System.out.println("Player 1 wins");
       } else{
         System.out.println("Player 2 wins");
       }
         
       
     }
  
  
  
  
  
}


  //debugger at https://onlinegdb.com/H1AfwzwDO