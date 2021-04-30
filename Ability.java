class Ability 
{
  String name,type,description,condition;
  int damage, creatureSpeed;
  public Ability(String name, String type, String description, String condition)
  {
    this.name = name;
    this.type = type;
    this.description = description;
    this.condition = condition;
  }
  
  public void setDamage(int d)
  {
    damage = d;
  }
  
  public int getAttackDamage()
  {
    return damage;
  }
  
  public void increaseSpeed(int baseSpeed)
  {
    
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public String getType()
  {
    return type;
  }
  
  public String getCondition()
  {
    return condition;
  }
  
}