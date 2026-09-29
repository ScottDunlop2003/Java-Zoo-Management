import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest
{
    @Test
    public void testLionMakeSound()
    {
        Lion lion = new Lion("Simba", 5, "Golden", 190.5, 30.0);

        String expected = "Roar! I am Simba, a 5 year old Golden lion.";
        String actual = lion.makeSound();

        assertEquals(expected, actual);
    }

    @Test
    public void testSharkMakeSound()
    {
        Shark shark = new Shark("Bruce", 8, "Grey", 300.0, 25.0);

        String expected = "Chomp! I am Bruce, a 8 year old Grey shark.";
        String actual = shark.makeSound();

        assertEquals(expected, actual);
    }

    @Test
    public void testEagleMakeSound()
    {
        Eagle eagle = new Eagle("Aquila", 4, "Brown", 12.5, 2.1);

        String expected = "Squawk! I am Aquila, a 4 year old Brown Eagle.";
        String actual = eagle.makeSound();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetterAndSetter()
    {
        Lion lion = new Lion("Simba", 5, "Golden", 190.5, 30.0);

        lion.setName("Leo");
        lion.setAge(6);
        lion.setColour("Brown");
        lion.setWeight(200.0);

        assertEquals("Leo", lion.getName());
        assertEquals(6, lion.getAge());
        assertEquals("Brown", lion.getColour());
        assertEquals(200.0, lion.getWeight());
    }

    @Test
    public void testLionSpecificAttribute()
    {
        Lion lion = new Lion("Simba", 5, "Golden", 190.5, 30.0);

        lion.setManeSize(35.0);

        assertEquals(35.0, lion.getManeSize());
    }

    @Test
    public void testSharkSpecificAttribute()
    {
        Shark shark = new Shark("Bruce", 8, "Grey", 300.0, 25.0);

        shark.setSwimSpeed(30.0);

        assertEquals(30.0, shark.getSwimSpeed());
    }

    @Test
    public void testEagleSpecificAttribute()
    {
        Eagle eagle = new Eagle("Aquila", 4, "Brown", 12.5, 2.1);

        eagle.setWingSpan(2.5);

        assertEquals(2.5, eagle.getWingSpan());
    }
}