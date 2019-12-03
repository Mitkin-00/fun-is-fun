public class Pakuri
{
    //Sets the species and stat variables and makes a constructor that initializes all variables
    private String pspecies;
    private int attack, defense, speed;
    public Pakuri(String species)
    {
       pspecies = species;
       attack = ((species.length() *7) + 9);
       defense = ((species.length() * 5) + 17);
       speed = ((species.length() * 6) + 13);


    }
//  Gets the species name
    public String getSpecies()
    {
        return pspecies;

    }
//  Gets the attack stat
    public int getAttack()
    {
        return attack;

    }
//  Gets the defense stat
    public int getDefense()
    {
        return defense;

    }
//  Gets the speed stat
    public int getSpeed()
    {
        return speed;

    }
//  Sets the attack, but is never used because there is no reason to set an attack outside of the constructor and evolve?
    public void setAttack(int newAttack)
    {
        attack = newAttack;

    }
//  Increases stat values when called
    public void evolve()
    {
        attack *= 2;
        defense *= 4;
        speed *= 3;

    }
}
