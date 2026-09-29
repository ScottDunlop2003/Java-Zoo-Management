// Eagle class represents a specific type of Animal It extends the Animal base class and implements the Flyable interface

public class Eagle extends Animal implements Flyable
{

    // Extra variable specific to Eagle (unique attribute)
    private double wingSpan;


    // Constructors are below


    // Constructor used to initialise both common Animal attributes and Eagle-specific data
    public Eagle(String name, int age, String colour, double weight, double wingSpan)
    {
        super(name, age, colour, weight); // Call parent being the Animal constructor
        this.wingSpan = wingSpan;
    }


    // Getters and Setters are below


    // Returns the eagle's wing span
    public double getWingSpan()
    {
        return wingSpan;
    }

    // Updates the eagle's wing span
    public void setWingSpan(double wingSpan)
    {
        this.wingSpan = wingSpan;
    }


    // Overridden Methods are below


    // Overrides the makeSound() method from the Animal class examples of polymorphism

    @Override
    public String makeSound()
    {
        return "Squawk! I am " + getName() + ", a " + getAge() + " year old " + getColour() + " Eagle.";
    }


    //  Flyable Interface methods are below


    // Implements the fly behaviour seen in the Flyable interface
    @Override
    public void fly()
    {
        System.out.println(getName() + " is flying with a wingspan of " + wingSpan + " meters.");
    }

    // Implements the wing health check seen in the Flyable interface
    @Override
    public void performWingCheck()
    {
        System.out.println("Performing wing health check for " + getName() + ".");
    }


    // Overrides toString() to include Eagle-specific data
    @Override
    public String toString()
    {
        return super.toString() + ", Wing Span: " + wingSpan;
    }
}