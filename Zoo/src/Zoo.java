import java.util.Scanner;
import java.io.*;


public class Zoo
{

    // Scanner used to read user input from the console
    private Scanner scanner = new Scanner(System.in);

    // Array to store Animal objects in the zoo
    private Animal[] animals;

    // Keeps track of how many animals are currently stored
    private int Animalcount;


    // Constructor to initialise the zoo
    public Zoo()
    {
        animals = new Animal[1000]; // Sets maximum capacity of the zoo
        Animalcount = 0; // Initially, no animals are stored
    }



// Add animal Method is here

    // This method will Add a new animal to the zoo after validating user input
    public void addAnimal()
    {
        // Check if zoo has reached maximum capacity
        if (Animalcount >= animals.length)
        {
            System.out.println("Zoo is full. Cannot add more animals.");
            return;
        }

        // Get validated animal type selection (1–3) The getvalidanimaltype is at the bottom of the zoo class
        int type = getValidAnimalType();


        // Get validated common attributes for all animals using methods then inputting into variables. get valid string, int and double are at the bottom of the zoo class
        String name = getValidString("Enter name: ");
        int age = getValidInt("Enter age: ");
        String colour = getValidString("Enter colour: ");
        double weight = getValidDouble("Enter weight: ");

        // Reference to store the newly created animal object
        Animal newAnimal = null;

        // Create the correct animal type based on user selection e.g. lion, shark or eagle
        if (type == 1)
        {
            double maneSize = getValidDouble("Enter mane size: ");
            newAnimal = new Lion(name, age, colour, weight, maneSize);
        }
        else if (type == 2)
        {
            double swimSpeed = getValidDouble("Enter swim speed: ");
            newAnimal = new Shark(name, age, colour, weight, swimSpeed);
        }
        else if (type == 3)
        {
            double wingSpan = getValidDouble("Enter wing span in inches: ");
            newAnimal = new Eagle(name, age, colour, weight, wingSpan);
        }

        // Store the new animal in the array and increment count
        animals[Animalcount] = newAnimal;
        Animalcount++;

        System.out.println("Animal added successfully!");
    }



// Remove animal Method is here


    // Removes an animal from the zoo by name
    public void removeAnimal()
    {
        // Check if there are no animals to remove
        if (Animalcount == 0)
        {
            System.out.println("No animals to remove.");
            return;
        }

        // Get validated name input
        String name = getValidString("Enter the name of the animal to remove: ");

        boolean found = false;

        // Loop through the array to find the matching animal
        for (int i = 0; i < Animalcount; i++)
        {
            // Compare names ignoring case sensitivity
            if (animals[i] != null && animals[i].getName().equalsIgnoreCase(name))
            {
                // Shift all elements after the removed animal one position to the left
                for (int j = i; j < Animalcount - 1; j++)
                {
                    animals[j] = animals[j + 1];
                }

                // Set last element to null to avoid duplicate reference
                animals[Animalcount - 1] = null;

                // Decrease the count of animals
                Animalcount--;

                System.out.println("Animal removed successfully.");
                found = true;
                break;
            }
        }

        // If no animal was found with that name
        if (!found)
        {
            System.out.println("Animal not found.");
        }
    }

    //Modify animal method is here

    // Allows the user to modify details of an existing animal
    public void modifyAnimal()
    {
        // Check if there are any animals to modify
        if (Animalcount == 0)
        {
            System.out.println("No animals to modify.");
            return;
        }

        // Get validated name of the animal to search for
        String name = getValidString("Enter the name of the animal to modify: ");

        boolean found = false;

        // Loop through the array to find the matching animal
        for (int i = 0; i < Animalcount; i++)
        {
            // Compare names ignoring case sensitivity
            if (animals[i] != null && animals[i].getName().equalsIgnoreCase(name))
            {
                System.out.println("Animal found:");
                System.out.println(animals[i]);

                // Display modification options
                System.out.println("\nWhat would you like to modify?");
                System.out.println("1. Name");
                System.out.println("2. Age");
                System.out.println("3. Colour");
                System.out.println("4. Weight");
                System.out.println("5. Special Attribute");

                // Get validated menu choice
                int choice = getValidInt("Enter choice: ");

                // Modify based on user selection
                if (choice == 1)
                {
                    // Update name using validated input
                    String newName = getValidString("Enter new name: ");
                    animals[i].setName(newName);
                }
                else if (choice == 2)
                {
                    // Update age
                    int newAge = getValidInt("Enter new age: ");
                    animals[i].setAge(newAge);
                }
                else if (choice == 3)
                {
                    // Update colour
                    String newColour = getValidString("Enter new colour: ");
                    animals[i].setColour(newColour);
                }
                else if (choice == 4)
                {
                    // Update weight
                    double newWeight = getValidDouble("Enter new weight: ");
                    animals[i].setWeight(newWeight);
                }
                else if (choice == 5)
                {
                    // Update type-specific attribute using instanceof

                    if (animals[i] instanceof Lion)
                    {
                        double newMane = getValidDouble("Enter new mane size: ");
                        ((Lion) animals[i]).setManeSize(newMane);
                    }
                    else if (animals[i] instanceof Shark)
                    {
                        double newSpeed = getValidDouble("Enter new swim speed: ");
                        ((Shark) animals[i]).setSwimSpeed(newSpeed);
                    }
                    else if (animals[i] instanceof Eagle)
                    {
                        double newWing = getValidDouble("Enter new wing span: ");
                        ((Eagle) animals[i]).setWingSpan(newWing);
                    }
                }
                else
                {
                    // Handle invalid menu choice
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    return;
                }

                System.out.println("Animal updated successfully.");
                found = true;
                break;
            }
        }

        // If no animal with the given name was found
        if (!found)
        {
            System.out.println("Animal not found.");
        }
    }


// View all animal method is here

    // Displays all animals currently stored in the zoo
    public void viewAllAnimals()
    {
        // Check if the zoo is empty
        if (Animalcount == 0)
        {
            System.out.println("No animals in the zoo.");
            return;
        }

        System.out.println("\n=== All Animals ===");

        // Loop through all stored animals
        for (int i = 0; i < Animalcount; i++)
        {
            // Ensure the array element is not null
            if (animals[i] != null)
            {
                // Print animal details using toString() which is in the Animal class
                System.out.println((i + 1) + ". " + animals[i].toString());

                // Call the overridden makeSound() method example of polymorphism
                System.out.println(animals[i].makeSound());
            }
        }
    }


// Search animal method is here

    // Searches for animals in the zoo by name or colour and displays their details
    public void searchAnimal()
    {
        // Check if the zoo is empty
        if (Animalcount == 0)
        {
            System.out.println("No animals in the zoo.");
            return;
        }

        // Display search options to the user
        System.out.println("\nSearch Animal By:");
        System.out.println("1. Name");
        System.out.println("2. Colour");

        int choice;

        // Validate menu choice (must be either 1 or 2)
        while (true)
        {
            choice = getValidInt("Enter choice: ");

            if (choice == 1 || choice == 2)
            {
                break; // Valid input
            }
            else
            {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }

        // Get validated search input for name or colour
        String input = getValidString("Enter search: ");

        boolean found = false;

        // Loop through all animals in the array
        for (int i = 0; i < Animalcount; i++)
        {
            // Ensure current element is not null
            if (animals[i] != null)
            {
                // Below Search by name
                if (choice == 1 && animals[i].getName().equalsIgnoreCase(input))
                {
                    // Display animal details
                    System.out.println(animals[i]);

                    // Call overridden makeSound() method example of polymorphism
                    System.out.println(animals[i].makeSound());

                    found = true;
                }

                // Below Searches by colour
                else if (choice == 2 && animals[i].getColour().equalsIgnoreCase(input))
                {
                    // Display animal details
                    System.out.println(animals[i]);

                    // Call overridden makeSound() method example of polymorphism
                    System.out.println(animals[i].makeSound());

                    found = true;
                }
            }
        }

        // If no matching animal was found
        if (!found)
        {
            System.out.println("No matching animals found.");
        }
    }

// Daily care method is here

    // Performs daily care routines for all animals in the zoo
    public void performDailyCare()
    {
        // Check if there are any animals in the zoo
        if (Animalcount == 0)
        {
            System.out.println("No animals in the zoo.");
            return;
        }

        System.out.println("\n=== Performing Daily Care ===");

        // Loop through all animals
        for (int i = 0; i < Animalcount; i++)
        {
            // Ensure the current array element is not null
            if (animals[i] != null)
            {
                // General care (applies to all animals) is here
                System.out.println("\nCaring for: " + animals[i].getName());
                System.out.println("Feeding " + animals[i].getName());
                System.out.println("General health check completed.");

                // specialized care for swimmable animal only is here
                // Check if the animal implements the Swimmable interface
                if (animals[i] instanceof Swimmable)
                {
                    // Cast the animal to Swimmable to access interface methods
                    Swimmable swimmer = (Swimmable) animals[i];
                    swimmer.swim(); // Perform swimming behaviour
                    swimmer.performWaterCheck(); // Perform water-related health check
                }

                // Specialized care for flyable animals is here
                // Check if the animal implements the Flyable interface
                if (animals[i] instanceof Flyable)
                {
                    // Cast the animal to Flyable to access interface methods
                    Flyable flyer = (Flyable) animals[i];
                    flyer.fly(); // Perform flying behaviour
                    flyer.performWingCheck(); // Perform wing health check
                }
            }
        }
    }

// Report method is here

    // Generates a report showing zoo statistics including animal counts and dominant colour
    public void generateReport()
    {
        // Check if zoo is empty
        if (Animalcount == 0)
        {
            System.out.println("No animals in the zoo.");
            return;
        }

        System.out.println("\n=== Zoo Report ===");
        System.out.println("Zoo Name: Pragmata Zoo");

        // Counters for each animal type
        int lionCount = 0;
        int sharkCount = 0;
        int eagleCount = 0;

        // Arrays to track colours and how often they appear
        String[] colours = new String[1000];
        int[] colourCounts = new int[1000];
        int uniqueColours = 0;

        // Loop through all animals
        for (int i = 0; i < Animalcount; i++)
        {
            if (animals[i] != null)
            {
                // Below Counts the animals types

                if (animals[i] instanceof Lion)
                {
                    lionCount++;
                }
                else if (animals[i] instanceof Shark)
                {
                    sharkCount++;
                }
                else if (animals[i] instanceof Eagle)
                {
                    eagleCount++;
                }

                // Below Tracks the colour frequency

                String colour = animals[i].getColour();
                boolean found = false;

                // Check if colour already exists in the array
                for (int j = 0; j < uniqueColours; j++)
                {
                    if (colours[j].equalsIgnoreCase(colour))
                    {
                        colourCounts[j]++; // Increase count for existing colour
                        found = true;
                        break;
                    }
                }

                // If colour not found, add it to the list
                if (!found)
                {
                    colours[uniqueColours] = colour;
                    colourCounts[uniqueColours] = 1;
                    uniqueColours++;
                }
            }
        }

        // Below finds the dominant colour
        int maxIndex = 0;

        // Compare counts to find the most frequent colour
        for (int i = 1; i < uniqueColours; i++)
        {
            if (colourCounts[i] > colourCounts[maxIndex])
            {
                maxIndex = i;
            }
        }

        // Below displays the report result
        System.out.println("Number of Lions: " + lionCount);
        System.out.println("Number of Sharks: " + sharkCount);
        System.out.println("Number of Eagles: " + eagleCount);

        System.out.println("Dominant Colour: " + colours[maxIndex]);
    }



    // Save to file method is here below


    // Saves zoo details and all valid animal records to text files
    public void saveToFile()
    {
        try
        {
            // Create writers to output data to files
            PrintWriter zooWriter = new PrintWriter("ZooDetails.txt");
            PrintWriter animalWriter = new PrintWriter("AnimalDetails.txt");


            // Save zoo details is below

            // Write basic information about the zoo
            zooWriter.println("Zoo Name: Pragmata Zoo");
            zooWriter.println("Total Animals: " + Animalcount);


            // Save animal details is below

            // Loop through all animals in the array
            for (int i = 0; i < Animalcount; i++)
            {
                // Only save valid (non-null and complete) animal records
                if (animals[i] != null && !animals[i].getName().isEmpty() && !animals[i].getColour().isEmpty())
                {
                    // Below saves the Lion data

                    // Use instanceof to determine the correct subclass e.g. Lion, Shark and Eagle
                    if (animals[i] instanceof Lion)
                    {
                        // Cast to Lion to access specific attributes
                        Lion lion = (Lion) animals[i];

                        // Save data in a comma-separated format
                        animalWriter.println(
                                "Lion," +
                                        lion.getName() + "," +
                                        lion.getAge() + "," +
                                        lion.getColour() + "," +
                                        lion.getWeight() + "," +
                                        lion.getManeSize()
                        );
                    }

                    //  Below saves the shark data
                    else if (animals[i] instanceof Shark)
                    {
                        Shark shark = (Shark) animals[i];

                        animalWriter.println(
                                "Shark," +
                                        shark.getName() + "," +
                                        shark.getAge() + "," +
                                        shark.getColour() + "," +
                                        shark.getWeight() + "," +
                                        shark.getSwimSpeed()
                        );
                    }

                    // Below saves the Eagle data
                    else if (animals[i] instanceof Eagle)
                    {
                        Eagle eagle = (Eagle) animals[i];

                        animalWriter.println(
                                "Eagle," +
                                        eagle.getName() + "," +
                                        eagle.getAge() + "," +
                                        eagle.getColour() + "," +
                                        eagle.getWeight() + "," +
                                        eagle.getWingSpan()
                        );
                    }
                }
            }

            // Close writers
            zooWriter.close();
            animalWriter.close();

            System.out.println("Data saved successfully.");

        }
        catch (IOException e)
        {
            // Handle any file writing errors
            System.out.println("Error saving data.");

        }
    }


// Save to file method is here below


    // Loads animal data from file
    public void loadFromFile()
    {
        try
        {
            // Create file object for reading animal data
            File animalFile = new File("AnimalDetails.txt");

            // Check if file exists before attempting to read
            if (!animalFile.exists())
            {
                System.out.println("No saved animal data found.");
                return;
            }

            // Scanner used to read file line by line
            Scanner fileReader = new Scanner(animalFile);

            // Read each line of the file
            while (fileReader.hasNextLine())
            {
                String line = fileReader.nextLine();

                // Split line into parts using comma
                String[] data = line.split(",");

                // Extract common animal attributes
                String type = data[0];
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String colour = data[3];
                double weight = Double.parseDouble(data[4]);

                Animal animal = null;


                // Below Loads the Lion data

                if (type.equalsIgnoreCase("Lion"))
                {
                    double maneSize = Double.parseDouble(data[5]);

                    // Create new Lion object using file data
                    animal = new Lion(name, age, colour, weight, maneSize);
                }


                // Below Loads the Shark data

                else if (type.equalsIgnoreCase("Shark"))
                {
                    double swimSpeed = Double.parseDouble(data[5]);

                    animal = new Shark(name, age, colour, weight, swimSpeed);
                }


                // // Below Loads the Eagle data

                else if (type.equalsIgnoreCase("Eagle"))
                {
                    double wingSpan = Double.parseDouble(data[5]);

                    animal = new Eagle(name, age, colour, weight, wingSpan);
                }

                // Add reconstructed animal to array
                if (animal != null)
                {
                    animals[Animalcount] = animal;
                    Animalcount++;
                }
            }

            // Close scanner after reading file
            fileReader.close();

            System.out.println("Animal data loaded successfully.");

        }
        catch (FileNotFoundException e)
        {
            // Handles case where file cannot be found
            System.out.println("AnimalDetails.txt not found.");
        }
        catch (Exception e)
        {
            // Handles general runtime errors
            System.out.println("Error loading animal data.");
        }
    }


// Sort Animals is here


    // Allows the user to sort animals by name or age
    public void sortAnimals()
    {
        // Check if there are any animals to sort
        if (Animalcount == 0)
        {
            System.out.println("No animals to sort.");
            return;
        }

        // Display sorting options to the user
        System.out.println("\nSort Animals By:");
        System.out.println("1. Name");
        System.out.println("2. Age");

        int choice;

        // Validate user choice (must be 1 or 2)
        while (true)
        {
            choice = getValidInt("Enter choice: ");

            if (choice == 1 || choice == 2)
            {
                break;
            }
            else
            {
                System.out.println("Invalid choice. Enter 1 or 2.");
            }
        }

        // Sort by name is here

        if (choice == 1)
        {
            for (int i = 0; i < Animalcount - 1; i++) // Outer loop controls number of passes based of the number of animals in the animalcount
            {
                for (int j = 0; j < Animalcount - i - 1; j++) // Inner loop compares adjacent elements
                {
                    // Compare names
                    if (animals[j].getName().compareToIgnoreCase(animals[j + 1].getName()) > 0)
                    {
                        // Swap positions if names are in the wrong order
                        Animal temp = animals[j];
                        animals[j] = animals[j + 1];
                        animals[j + 1] = temp;
                    }
                }
            }

            System.out.println("Animals sorted by name.");
        }

        // sort by age is here

        else if (choice == 2)
        {
            for (int i = 0; i < Animalcount - 1; i++) // Outer loop controls number of passes
            {
                for (int j = 0; j < Animalcount - i - 1; j++) // Inner loop compares adjacent elements
                {
                    // Compare ages
                    if (animals[j].getAge() > animals[j + 1].getAge())
                    {
                        // Swap positions if age is greater than the next
                        Animal temp = animals[j];
                        animals[j] = animals[j + 1];
                        animals[j + 1] = temp;
                    }
                }
            }

            System.out.println("Animals sorted by age.");
        }
    }

    //Validation starts here and below
    public int getValidInt(String message) // Validates and returns a positive number
    {
        int number;

        while (true)
        {
            System.out.print(message);

            if (scanner.hasNextInt()) // Check if the next input is an integer
            {
                number = scanner.nextInt();
                scanner.nextLine();

                if (number > 0)  // Ensure the number is greater than 0
                {
                    return number;
                }
                else
                {
                    System.out.println("Number must be greater than 0.");
                }
            }
            else
            {
                // Handles non-integer input (e.g. text)
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine();
            }
        }
    }
    // Validates and returns a positive decimal number
    public double getValidDouble(String message)
    {
        double number;

        while (true) {
            System.out.print(message);

            if (scanner.hasNextDouble()) // Check if input is a valid double
            {
                number = scanner.nextDouble();
                scanner.nextLine();

                if (number > 0)
                {
                    return number;
                }
                else
                {
                    System.out.println("Number must be greater than 0.");
                }
            }
            else // Handles invalid numeric input
            {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
    // Validates and returns a non-empty string containing only letters and spaces
    public String getValidString(String message)
    {
        String input;

        while (true)
        {
            System.out.print(message);
            input = scanner.nextLine().trim();

            if (input.isEmpty())  // Check for empty input
            {
                System.out.println("Input cannot be blank.");
            }
            else if (!input.matches("[a-zA-Z ]+")) // Check that input only contains letters and spaces
            {
                System.out.println("Invalid input. Only letters are allowed.");
            }
            else
            {
                return input;
            }
        }
    }
    // Validates and returns a correct animal type selection  of 1–3
    public int getValidAnimalType()
    {
        int type;

        while (true)
        {
            System.out.println("\nSelect Animal Type:");
            System.out.println("1. Lion");
            System.out.println("2. Shark");
            System.out.println("3. Eagle");
            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) // Check if input is an integer
            {
                type = scanner.nextInt();
                scanner.nextLine();

                if (type >= 1 && type <= 3) // Ensure input is within valid range
                {
                    return type;
                } else
                {
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }
            } else
            {
                System.out.println("Invalid input. Please enter a number."); // Handles any noninteger input e.g A
                scanner.nextLine();
            }
        }
    }
}