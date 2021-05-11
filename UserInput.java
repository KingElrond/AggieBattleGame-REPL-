import java.util.Scanner;


class UserInput 
{
    private Scanner kb;
    
  public UserInput()
  {
    kb = new Scanner(System.in);
  }
  
  public String getMove(int energy)
  {
    String move = "";
    boolean valid = false;
    while(!valid)
    {
      System.out.println("Your energy is: " + energy);
      System.out.println("Press 1,2,3 or 4");
      move = kb.nextLine();
      
      if(move.equals("1") || move.equals("2") || move.equals("3") || move.equals("4"))
        valid = true;
      else
        System.out.println("*** INVALID INPUT ***");
      
      if(energy < 100 && move.equals("4"))
      {
        valid = false;
        System.out.println("You don't have enough energy for this");
      }
      
    }
    return move;
  }
  
  
  
  
}
