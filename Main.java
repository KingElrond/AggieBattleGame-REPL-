
class Main 
{
  public static void main(String[] args) 
  {
    
    AggieSelect as = new AggieSelect();
    Creature a = as.selectYourAggie();
    System.out.println("selected: " + a.getName());
    System.out.println("\nPlayer 2");
    as.selectionLoop(); 
    Creature b = as.selectYourAggie();
    BattleManager bm = new BattleManager(a,b); 
  }
}