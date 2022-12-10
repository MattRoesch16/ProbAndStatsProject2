import java.util.*;
/**
 * Creates a deck of Cards
 *
 * Author: Matthew Roesch
 * Version: 1.0
 * Date: 11/18/22
 */
public class DeckofCards
{
    // instance variables - replace the example below with your own
    private int numOfCards;
    private Card[] deck;
    private int index;
    /**
     * Constructor for objects of class DeckofCards
     */
    public DeckofCards()
    {
        // initialise instance variables
        numOfCards = 52;
        deck = new Card[numOfCards];
        index = 0;
        for (int x = 0; x < numOfCards; x++)
        {
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; i < 13; j++)
                {
                    if(i == 0)
                    {
                        deck[x] = new Card(j + 1, "Heart");
                    }
                    else
                    {
                        if (i == 1)
                        {
                            deck[x] = new Card(j + 1, "Diamond");
                        }
                        else
                        {
                            if (i == 2)
                            {
                                deck[x] = new Card(j + 1, "Club");
                            }
                            else
                            {
                                deck[x] = new Card(j + 1, "Spade");
                            }
                        }
                    }
                }
            }
        }
    }

    public void shuffleDeck()
    {
        Card[] shuffled = new Card[numOfCards];
        Random rnd = new Random();
        for (int i = 0; i < numOfCards; i++)
        {
            int j = rnd.nextInt(52);
            while (shuffled[j] != null)
            {
                index = rnd.nextInt(52);
            }
            shuffled[index] = deck[i];
        }
        deck = shuffled;
        index = 0;
    }
    
    public Card drawCard()
    {
        Card drawn = deck[index];
        index++;
        return drawn;
    }
    
    public int getIndex()
    {
        return index;
    }
    
    public void updateIndex()
    {
        index++;
    }
    
}
