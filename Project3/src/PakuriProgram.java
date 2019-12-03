import java.util.Scanner;

public class PakuriProgram
{
    public static void main (String args[])
    {
        //this is a comment cool
        // starts the pakudex and asks for the capacity of the pakudex
        Scanner scan = new Scanner(System.in);
        String in = "";
        int capacity = 0;
        int input = 0;
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        while (capacity == 0)
        {
            //runs a try-catch to keep exceptions from being thrown when a non-int gets passed in. Also checks for ints less than 1
            try
            {
                System.out.print("Enter max capacity of the Pakudex: ");
                in = scan.next();
                capacity = Integer.parseInt(in);
                if (capacity < 1)
                {
                    System.out.println("Please enter a valid size.");
                    capacity = 0;
                }
            }
            catch (Exception e)
            {
                System.out.println("Please enter a valid size.");
                capacity = 0;
            }

        }
        Pakudex paku = new Pakudex(capacity);
        System.out.println("The Pakudex can hold " + capacity + " species of Pakuri.");
//      The main body of the code is run in the following loop
        while(input != 6)
        {
            // runs a similar try-catch to the previous to make sure a valid input is passed in
            input = 0;
            while(input == 0)
            {
                try
                {
                    System.out.println(" \nPakudex Main Menu \n----------------- \n1. List Pakuri \n2. Show Pakuri \n3. Add Pakuri \n4. Evolve Pakuri \n5. Sort Pakuri \n6. Exit ");
                    System.out.print("\nWhat would you like to do? ");
                    in = scan.next();
                    input = Integer.parseInt(in);
                    if (input < 1 || input > 6)
                    {
                        System.out.println("Unrecognized menu selection!");
                        input = 0;
                    }
                }
                catch (Exception e)
                {
                    System.out.println("Unrecognized menu selection!");
                    input = 0;
                }
            }
//          Prints out a list of species in pakudex if they exist, otherwise lets user know they cant do that
            if (input == 1)
            {
                String[] temp = paku.getSpeciesArray();
                if (temp == null)
                {
                    System.out.println("No Pakuri in Pakudex yet!");
                }
                else
                {
                    System.out.println("Pakuri In Pakudex:");
                    int num = 1;
                    for (String str : temp)
                    {
                        System.out.println(num + ". " + str);
                        num++;
                    }
                }

            }
            // Displays the stats of a pakuri if it exists in the pakudex
            else if(input == 2)
            {
                System.out.print("Enter the name of the species to display: ");
                String name = scan.next();
                String[] temp = paku.getSpeciesArray();
                boolean m = false;
                for(int i = 0; i < paku.getSize(); i++)
                {
                    if (name.equals(temp[i]))
                    {
                        int[] tempNum = paku.getStats(name);
                        System.out.println("\nSpecies: " + name + "\nAttack: " + tempNum[0] + "\nDefense: " + tempNum[1] + "\nSpeed: " + tempNum[2]);
                        m = true;
                    }
                }
                if (m == false)
                {
                    System.out.println("Error: No such Pakuri!");
                }
            }
            // adds pakuri
            else if (input == 3)
            {
//              checks if pakudex is full, prints an error if it is
                if (paku.getSize() == paku.getCapacity())
                {
                    System.out.println("Error: Pakudex is full! ");
                }
                // adds pakuri as long as it is not a duplicate
                else
                {
                    System.out.print("Enter the name of the species to add: ");
                    String name = scan.next();
                    boolean success = paku.addPakuri(name);
                    if (!success)
                    {
                        System.out.println("Error: Pakudex already contains this species!");
                    }
                    else
                    {
                        System.out.println("Pakuri species " + name + " successfully added!");
                    }
                }
            }
            // Evolves a pakuri if it exists
            else if(input == 4)
            {
                System.out.print("Enter the name of the species to evolve: ");
                String name = scan.next();
                if(!paku.evolveSpecies(name))
                {
                    System.out.println("Error: No such Pakuri!");
                }
                else
                {
                    System.out.println(name + " has evolved!");
                }

            }
            // sorts the pakuri in the pakudex
            else if(input == 5)
            {
                paku.sortPakuri();
                System.out.println("Pakuri have been sorted!");

            }
        }
        // prints exit statement
        if (input == 6)
        {
            System.out.println("Thanks for using Pakudex! Bye!");
        }


    }

}
