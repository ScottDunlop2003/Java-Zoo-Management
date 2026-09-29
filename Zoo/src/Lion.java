// Lion class represents a specific type of Animal It extends the Animal base class

public class Lion extends Animal
{


    // Extra variable specific to Lion (unique attribute)
    private double maneSize;


    // Constructors are below


    // Constructor used to initialise both common Animal attributes and Lion-specific data
    public Lion(String name, int age, String colour, double weight, double maneSize)
    {
        super(name, age, colour, weight); // Call parent (Animal) constructor
        this.maneSize = maneSize;
    }


    // GETTERS AND SETTERS Getters and Setters are below


    // Returns the lion's mane size
    public double getManeSize()
    {
        return maneSize;
    }

    // Updates the lion's mane size
    public void setManeSize(double maneSize)
    {
        this.maneSize = maneSize;
    }


    // Overridden Methods are below


    // Overrides the makeSound() method from the Animal class examples of polymorphism

    @Override
    public String makeSound()
    {
        return "Roar! I am " + getName() + ", a " + getAge() + " year old " + getColour() + " lion.";
    }



    // Overrides toString() to include Lion-specific data
    @Override
    public String toString()
    {
        return super.toString() + ", Mane Size: " + maneSize;
    }
}