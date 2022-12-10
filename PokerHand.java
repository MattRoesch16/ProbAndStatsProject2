import java.util.*;
/**
 * Creates a hand of cards
 *
 * Author: Matthew Roesch
 * Version: 1.0
 * Date: 11/18/22
 */
public class PokerHand
{
    // instance variables - replace the example below with your own
    private Card[] hand;
    private int NumOfCards;
    private int evaluation;
    /**
     * Constructor for objects of class PokerHand
     */
    public PokerHand(int num)
    {
        // initialise instance variables
        NumOfCards = num;
        hand = new Card[NumOfCards];
        evaluation = 0;
    }

    public Card[] drawHand(DeckofCards deck)
    {
        for (int i = 0; i < NumOfCards; i++)
        {
            hand[i] = deck.drawCard();
        }
        return hand;
    }
    
    public int getSize()
    {
        return NumOfCards;
    }
    
    public Card readCard(int i)
    {
        return hand[i];
    }
    
    public void setEval(int i)
    {
        evaluation = i;
    }
    
    public int getEval()
    {
        return evaluation; 
    }
}
