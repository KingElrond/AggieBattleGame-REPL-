class Main 
{
  public static void main(String[] args) 
  {
    //something
    AggieSelect as = new AggieSelect();
    UserInput ui = new UserInput();
    System.out.println("Player 1 pick your Aggie: ");
    String chosenAggie = ui.getAggie();
    int ags = Integer.parseInt(chosenAggie);
    Creature p1 = new Ghoully(),p2 = new CharChimp();
    
    
     switch (ags) {
  case 1:
     p1 = new MedinaSaur();
     break;
  case 2:
     p1 = new Ghoully();
     break;
  case 3:
    p1 = new CharChimp();
    break;
  case 4:
    p1 = new DreamReaper();
    break;
  case 5:
    p1 = new Aquados();
    break;
  case 6:
   p1 = new Finality();
    break;
  case 7:
    p1 = new Iceguin();
    break;
  case 8:
    p1 = new Memorra();
    break;
     }
    
    System.out.println("Player 2 pick your Aggie: ");
   chosenAggie = ui.getAggie();
    ags = Integer.parseInt(chosenAggie);
    
    switch (ags) {
  case 1:
     p2 = new MedinaSaur();
     break;
  case 2:
     p2 = new Ghoully();
     break;
  case 3:
    p2 = new CharChimp();
    break;
  case 4:
    p2 = new DreamReaper();
    break;
  case 5:
    p2 = new Aquados();
    break;
  case 6:
   p2 = new Finality();
    break;
  case 7:
    p2 = new Iceguin();
    break;
  case 8:
    p2 = new Memorra();
    break;
     }
    
     BattleManager bm = new BattleManager(p1,p2); 
    
    
  }
}