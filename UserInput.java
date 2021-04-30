import java.util.Scanner;


class UserInput 
{
    private Scanner kb;
    
  public UserInput()
  {
    kb = new Scanner(System.in);
  }
  
  public String getAggie()
  {
    String move = "";
    boolean valid = false;
    while(!valid)
    {
      System.out.println("Press 1,2,3,4,5,6,7, or 8");
      move = kb.nextLine();
      
    if(move.equals("69"))
      {
          java.lang.System.exit(0);
          return null;
          
      }else if(move.equals("1") || move.equals("2") || move.equals("3") || move.equals("4") || move.equals("5") || move.equals("6")|| move.equals("7")|| move.equals("8"))
    {    
        valid = true;
    }else
        System.out.println("*** INVALID INPUT ***");
    }
    return move;
  }
  
  
  public String getMove()
  {
    String move = "";
    boolean valid = false;
    while(!valid)
    {
      System.out.println("Press 1,2,3 or 4");
      move = kb.nextLine();
      
    if(move.equals("6"))
      {
          java.lang.System.exit(0);
          return null;
          
      }else if(move.equals("1") || move.equals("2") || move.equals("3") || move.equals("4"))
    {    
        valid = true;
    }else
        System.out.println("*** INVALID INPUT ***");
    }
    return move;
  }
  
  
  
  
}