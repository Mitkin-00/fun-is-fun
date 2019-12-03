import java.util.Arrays;
import java.util.Comparator;

public class Pakudex
{
    //Creates variables and default constructor and other constructor, where capacity of Pakudex is set
    private int capacity;
    private int size = 0;
    private Pakuri[] pakuri;

    public Pakudex()
    {
        capacity = 20;
        pakuri = new Pakuri[capacity];
    }

    public Pakudex(int capacity)
    {
        this.capacity = capacity;
        pakuri = new Pakuri[capacity];
    }
//  Gets the amount of pakuri in pakudex
    public int getSize()
    {
        return size;
    }
//  gets the amount of pakuri that can be stored
    public int getCapacity()
    {
        return capacity;
    }
//  makes and returns a String array with the species name, returns null if no pakuri in pakudex
    public String[] getSpeciesArray()
    {
        if (pakuri[0] == null)
        {
            return null;
        }

        String[] names = new String[size];
        for (int i = 0; i < size; i++)
        {
            names[i] = pakuri[i].getSpecies();
        }
        return names;
    }
// makes and returns an int array with stats of input species, returns null if species is not in pakudex
    public int[] getStats(String species)
    {
        int[] stats = new int[3];
        for (int i = 0; i < size; i++)
        {
            if (pakuri[i].getSpecies().equals(species))
            {
                stats[0] = pakuri[i].getAttack();
                stats[1] = pakuri[i].getDefense();
                stats[2] = pakuri[i].getSpeed();
                return stats;
            }
        }
        return null;
    }
//  sorts the pakuri in the pakudex using an insertion sort
    public void sortPakuri()
    {
        Pakuri temp;
        for (int i = 1; i < size;i++)
        {
            for (int j = i; j > 0; j--)
            {
                if (pakuri[j].getSpecies().compareTo(pakuri[j-1].getSpecies()) <0)
                {
                    temp = pakuri[j];
                    pakuri[j] = pakuri[j-1];
                    pakuri[j-1] = temp;
                }
            }
        }
    }
//  adds pakuri to the pakudex if the pakudex is not full and pakuri is not already in pakudex
    public boolean addPakuri (String species)
    {

        if (size  > capacity)
        {
            return false;
        }
        else
        {
            for (int i = 0; i < size; i++)
            {
                if (pakuri[i].getSpecies().equals(species))
                {
                    return false;
                }
            }
            Pakuri pak = new Pakuri(species);
            pakuri[size] = pak;
            size++;
        }
        return true;
    }
//  evolves pakuri if it exists in the pakudex
    public boolean evolveSpecies(String species)
    {
        for (int i = 0; i < size; i++)
        {
            if(pakuri[i].getSpecies().equals(species))
            {
                pakuri[i].evolve();
                return true;
            }
        }
        return false;
    }

}
