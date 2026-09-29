// Base class representing a generic animal in the zoo
// This class will be extended by specific animal types e.g. Lion, Shark, Eagle
public abstract class Animal
{

    // Common attributes shared by all animals
    private String name;
    private int age;
    private String colour;
    private double weight;



    // Constructor below


    // Constructor used to initialise an Animal object with its basic attributes e.g. name, age, colour and weight
    public Animal(String name, int age, String colour, double weight)
    {
        this.name = name;
        this.age = age;
        this.colour = colour;
        this.weight = weight;
    }


    // Getters Are below


    // Returns the animal's name
    public String getName()
    {
        return name;
    }

    // Returns the animal's colour
    public String getColour()
    {
        return colour;
    }

    // Returns the animal's age
    public int getAge()
    {
        return age;
    }

    // Returns the animal's weight
    public double getWeight()
    {
        return weight;
    }


    // Setters are below


    // Updates the animal's name
    public void setName(String name)
    {
        this.name = name;
    }

    // Updates the animal's age
    public void setAge(int age)
    {
        this.age = age;
    }

    // Updates the animal's colour
    public void setColour(String colour)
    {
        this.colour = colour;
    }

    // Updates the animal's weight
    public void setWeight(double weight)
    {
        this.weight = weight;
    }


    // Method are below


    // Generic sound method will be overridden by subclasses Example of polymorphism
    // This is an abstract method to ensure that all subclasses Lion, Shark, Eagle will need provide their own version


    public  abstract String makeSound();

    //  Below Returns a formatted string containing the animal's details This will be used later when displaying animal information

    public String toString()
    {
        return "Name: " + name + ", Age: " + age + ", Colour: " + colour + ", Weight: " + weight;
    }
}