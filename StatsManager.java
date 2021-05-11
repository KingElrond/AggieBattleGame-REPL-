
class StatsManager 
{
   private int hp, atk,def,sp,energy;
  
   public StatsManager(Creature one)
   {
     //hp,atk,def,sp in the array
     int[] a = one.getStats();
    
     hp = a[0];
     atk = a[1];
     def = a[2];
     sp = a[3];
     energy = 0;
    
     hp *= 10;
   }
  
  	public void updateHP(int modifier)
    {
      hp += modifier;
    }
  
 
  
  	public int getHP()
    {
      return hp;
    }
  
  
  
  	public void updateEnergy(int modifier)
    {
      energy += modifier;
    }
  
    public int getEnergy()
    {
      return energy;
    }
  
     
  	public int getAttack()
    {
      return atk;
    }
  
    public void setAttack(int m)
    {
      // handles both buff and debuff, just make m pos/neg
      atk += m;
    }
   
  
    public int getDefense()
    {
      return def;
    } 
  
    public void setDefense(int d)
    {
      def += d;
    }
  
    public int getSpeed()
    {
      return sp;
    }
  
    public void setSpeed(int s)
    {
      sp += s;
    }
   
}

