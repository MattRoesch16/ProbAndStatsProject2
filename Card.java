
/**
 * Creates Card Objects
 *
 * Author: Matthew Roesch
 * Version: 1
 * Date: 11/18/22
 */
public class Card
{
    // instance variables - replace the example below with your own
    private int num;
    private String suit;

    /**
     * Constructor for objects of class Card
     */
    public Card(int x, String type)
    {
        // initialise instance variables
        num = x;
        suit = type;
    }

    public int getNum()
    {
        // put your code here
        return num;
    }
    
    public String getSuit()
    {
        return suit;
    }
        
    public String toString()
    {
        return "" + num + " of " + suit;
    }
}
