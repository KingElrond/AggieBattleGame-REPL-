
class StatsManager 
{
   private int hp, atk,def,sp,energy;
   private String name;
  
   public StatsManager(Creature one)
   {
     //hp,atk,def,sp in the array
     int[] a = one.getStats();
    name = one.getName();
     hp = a[0]*10;
     atk = a[1];
     def = a[2];
     sp = a[3];
    
   }
  
  	public void updateHP(int modifier)
    {
      hp += modifier;
      System.out.println("updated hp");
      System.out.println("New HP: " + hp);
    }
  
  public void updateATK(int modifier)
  {
      atk += modifier;
      System.out.println("updated atk");
      System.out.println("New atk: " + atk);
  }

  public void updateDEF(int modifier)
  {
      def += modifier;
      System.out.println("updated def");
      System.out.println("New def: " + def);
  }
  
public void updateSPD(int modifier)
  {
      sp += modifier;
      System.out.println("updated speed");
      System.out.println("New speed: " + sp);
  }
  

  	public int getHP()
    {
      return hp;
    }
  
  	public void updateEnergy(int modifier)
    {
      energy += modifier;
    }
  
  	public int getAttack()
    {
      return atk;
    }
   
    public int getDefense()
    {
      return def;
    } 
  
    public int getSpeed()
    {
      return sp;
    }

    public String getName()
    {
        return name;
    }
   
}