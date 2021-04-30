public interface Creature 
{
  String getName();
  String getDescription();
  
  // ability 1, ability 2, ability 3, super
 
  int[] getStats();
  // health,attack,defense,speed,
  Ability[] getAbility();
}
