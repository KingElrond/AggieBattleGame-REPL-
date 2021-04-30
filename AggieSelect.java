import java.util.Scanner;
import java.util.ArrayList;


class AggieSelect 
{
  private Scanner kb;
  private ArrayList<Creature> agg;
  private Creature a1,a2,a3,a4,a5,a6,a7,a8;
  
   public AggieSelect()
   {
     agg = new ArrayList<>();
     a1 = new MedinaSaur();  
     a2 = new Ghoully();
     a3 = new CharChimp();
     a4 = new DreamReaper();
     a5 = new Aquados();
     a6 = new Finality();
     a7 = new Iceguin();
     a8 = new Memorra();
     kb = new Scanner(System.in);
     
     agg.add(a1);
     agg.add(a2);
     agg.add(a3);
     agg.add(a4);
     agg.add(a5);
     agg.add(a6);
     agg.add(a7);
     agg.add(a8);
     selectionLoop();
     
   }
  
   private void displayAggieList()
   {
     System.out.println("Type the Aggie number to view the profile");
     System.out.println("Here are the available Aggies: ");
       for(int c = 0; c < agg.size(); c++)
       {
         System.out.println((c+1)+") "+ agg.get(c).getName());
       }
     System.out.println();
     
   }
  
   private void selectionLoop()
   {
     boolean stop = false;
     while(!stop)
     {
       displayAggieList();
       System.out.println("Press 100 when ready to pick your aggie and 69 to close program");
       System.out.println("View Aggie # ");
       String choice = kb.nextLine();
       System.out.println();
       if(choice.trim().equals("100"))
       {
         stop = true;
       }
       else if(choice.trim().equals("1"))
         aggieIntroduction(a1);
       else if(choice.trim().equals("2"))
         aggieIntroduction(a2);
       else if(choice.trim().equals("3"))
         aggieIntroduction(a3);
       else if(choice.trim().equals("4"))
         aggieIntroduction(a4);
       else if(choice.trim().equals("5"))
         aggieIntroduction(a5);
       else if(choice.trim().equals("6"))
         aggieIntroduction(a6);
        else if(choice.trim().equals("7"))
         aggieIntroduction(a7);
        else if(choice.trim().equals("8"))
         aggieIntroduction(a8);
       else
         System.out.println("*** INVALID INPUT ***\n");
       
     }
   }
  
  
   private void aggieIntroduction(Creature a)
   {
     System.out.println("Aggie Name: " + a.getName());
     Ability[] abilities = a.getAbility();
     int[] stats = a.getStats();
     System.out.println(a.getDescription());
     System.out.println("Statistics: ");
     System.out.println("Health \t" + stats[0]);
     System.out.println("Attack \t"+stats[1]);
     System.out.println("Defense "+stats[2]);
     System.out.println("Speed \t"+stats[3]);
     
     System.out.println("\nAbilities");
     for(Ability b : abilities)
     {
       System.out.println("Name: " + b.getName());
       System.out.println("Ability type: "+b.getType());
       System.out.println("Description: " + b.getDescription());
       System.out.println("Condition: " + b.getCondition());
       System.out.println();
     }
       
   }
}
