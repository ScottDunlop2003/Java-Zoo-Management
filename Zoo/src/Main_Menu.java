// Import Scanner class for reading user input
import java.util.Scanner;

// Main_Menu class handles the console interface and user interaction
public class Main_Menu
{
    // Create a single Zoo object to manage all animal data
    static Zoo zoo = new Zoo();

    // Scanner used for reading user input from the console
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        int choice;
        boolean running = true;

        // Load existing animal data from file when program starts
        zoo.loadFromFile();

        // Main program loop runs until user chooses to exit
        while (running)
        {
            displayMenu(); // Show menu options
            choice = getUserChoice(); // Get validated user input


            // Menu option are below


            if (choice == 1)
            {
                // Add a new animal to the zoo
                zoo.addAnimal();
            }
            else if (choice == 2)
            {
                // Remove an animal from the zoo
                zoo.removeAnimal();
            }
            else if (choice == 3)
            {
                // Modify an existing animal's details
                zoo.modifyAnimal();
            }
            else if (choice == 4)
            {
                // Display all animals in the zoo
                zoo.viewAllAnimals();
            }
            else if (choice == 5)
            {
                // Search for animals by name or colour
                zoo.searchAnimal();
            }
            else if (choice == 6)
            {
                // Perform daily care routines for all animals
                zoo.performDailyCare();
            }
            else if (choice == 7)
            {
                // Generate a report of zoo statistics
                zoo.generateReport();
            }
            else if (choice == 8)
            {
                // Save current zoo data to file
                zoo.saveToFile();
            }
            else if (choice == 9)
            {
                zoo.sortAnimals();
            }
            else if (choice == 10)
            {
                // Save data and exit program
                exitProgram();
                running = false;
            }
            else
            {
                // Handle invalid menu choices
                System.out.println("Invalid choice. Please enter a number between 1 and 10.");
            }
        }
    }


    // Menus display is below


    // Displays all available options to the user
    public static void displayMenu()
    {
        System.out.println("\n==== Zoo Management System ====");
        System.out.println("1. Add Animal");
        System.out.println("2. Remove Animal");
        System.out.println("3. Modify Animal");
        System.out.println("4. View All Animals");
        System.out.println("5. Search for Animal");
        System.out.println("6. Perform Daily Care");
        System.out.println("7. Generate Report");
        System.out.println("8. Save To File");
        System.out.println("9. Sort Animals");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");
    }



    // Ensures the user enters a valid integer for menu selection
    public static int getUserChoice()
    {
        // Loop until a valid integer is entered
        while (!scanner.hasNextInt())
        {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Clear invalid input
            System.out.print("Enter your choice: ");
        }

        return scanner.nextInt(); // Return valid integer input
    }


    // Exit program method is here


    // Saves data and displays exit message (not currently used in main loop)
    public static void exitProgram()
    {
        System.out.println("Saving data...");
        zoo.saveToFile();
        System.out.println("Exiting program. Goodbye!");
    }
}
