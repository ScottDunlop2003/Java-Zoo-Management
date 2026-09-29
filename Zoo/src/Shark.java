// Shark class represents a specific type of Animal It extends the Animal base class and implements the Swimmable interface
public class Shark extends Animal implements Swimmable
{


    // Extra variable specific to Shark
    private double swimSpeed;


    //  Constructors are below


    // Constructor used to initialise both common Animal attributes and Shark-specific data
    public Shark(String name, int age, String colour, double weight, double swimSpeed)
    {
        super(name, age, colour, weight); // Call parent being the Animal constructor
        this.swimSpeed = swimSpeed;
    }


    // Getters and Setters are below


    // Returns the shark's swim speed
    public double getSwimSpeed()
    {
        return swimSpeed;
    }

    // Updates the shark's swim speed
    public void setSwimSpeed(double swimSpeed)
    {
        this.swimSpeed = swimSpeed;
    }


    // Overridden Methods are below


    // Overrides the makeSound() method from the Animal class example of polymorphism

    @Override
    public String makeSound()
    {
        return "Chomp! I am " + getName() + ", a " + getAge() + " year old " + getColour() + " shark.";
    }


    // Swimmable Interface methods are below


    // Implements the swim behaviour seen in the Swimmable interface
    @Override
    public void swim()
    {
        System.out.println(getName() + " is swimming at " + swimSpeed + " MPH.");
    }

    // Implements the water health check seen in the Swimmable interface
    @Override
    public void performWaterCheck()
    {
        System.out.println("Performing water health check for " + getName() + ".");
    }

    // Overrides toString() to include Shark-specific data
    @Override
    public String toString()
    {
        return super.toString() + ", Swim Speed: " + swimSpeed;
    }
}