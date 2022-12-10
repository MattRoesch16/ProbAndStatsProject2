import java.util.*;
/**
 * Contains the win conditions for the games.
 *
 * Author: Matthew Roesch
 * Version: 1.0
 * Date: 11/18/22
 */
public class PokerGame
{
    // instance variables - replace the example below with your own
    //private PokerHand board;
    private PokerHand player;
    private DeckofCards deck;

    /**
     * Constructor for objects of class PokerGame
     */
    public PokerGame(int numofplayers, int numofcardsinhand)
    {
        // initialise instance variables
        deck = new DeckofCards();
        player = new PokerHand(numofcardsinhand);
    }

    public DeckofCards getDeck()
    {
        return deck;
    }
    
    public PokerHand getPlayer()
    {
        return player;
    }
    
    public void checkPair (PokerHand player)
    {
        // put your code here
        for (int i = 0; i < player.getSize(); i++)
        {
            for (int j = i + 1; j < player.getSize(); j++)
            {
                if (player.readCard(i).getNum() == player.readCard(j).getNum())
                {
                    player.setEval(1);
                }
            }
        }
    }
    
    public void checkThree (PokerHand player)
    {
        for (int k = 0; k < player.getSize(); k++)
        {
            for (int i = k + 1; i < player.getSize(); i++)
            {
                for (int j = i + 1; j < player.getSize(); j++)
                {
                    if (player.readCard(i).getNum() == player.readCard(j).getNum() && player.readCard(k).getNum() == player.readCard(i).getNum())
                    {
                        player.setEval(3);
                    }
                }
            }
        }
    }
    
    public void checkFour (PokerHand player)
    {
        for (int l = 0; l < player.getSize(); l++)
        {
            for (int k = l + 1; k < player.getSize(); k++)
            {
                for (int i = k + 1; i < player.getSize(); i++)
                {
                    for (int j = i + 1; j < player.getSize(); j++)
                    {
                        if (player.readCard(i).getNum() == player.readCard(j).getNum() && player.readCard(k).getNum() == player.readCard(i).getNum())
                        {
                            player.setEval(7);
                        }
                    }
                }
            }       
        }
    }
    
    public void checkFlush (PokerHand player)
    {
        int count = 0;
        int tempcount = count;
        String suit = player.readCard(0).getSuit();
        if (player.getSize() <= 5)
        {
            for (int i = 0; i < player.getSize(); i++)
            {
                if (player.readCard(i).getSuit().equals(suit))
                {
                    count ++;
                }
            }
        }
        else
        {
            for (int i = 0; i < 4; i++)
            {
                if(i == 0)
                {
                    suit = "Heart";
                }
                else
                {
                    if (i == 1)
                    {
                        suit = "Diamond";
                    }
                    else
                    {
                        if (i == 2)
                        {
                            suit = "Club";
                        }
                        else
                        {
                            suit=  "Spade";
                        }
                    }
                }
                for (int j = 0; j < player.getSize(); j++)
                {
                    if (player.readCard(i).getSuit().equals(suit))
                    {
                        tempcount ++;
                    }
                }
                if (tempcount > count)
                {
                    count = tempcount;
                }
            }
        }
        if (count >= 5)
        {
            player.setEval(5);
        }
    }
    
    public void checkFullHouse (PokerHand player)
    {
        int previousEval = player.getEval();
        int num = 0;
        this.checkThree(player);
        if (player.getEval() == 3)
        {
            for (int k = 0; k < player.getSize(); k++)
            {
                for (int i = k + 1; i < player.getSize(); i++)
                {
                    for (int j = i + 1; j < player.getSize(); j++)
                    {
                        if (player.readCard(i).getNum() == player.readCard(j).getNum() && player.readCard(k).getNum() == player.readCard(i).getNum())
                        {
                            num = player.readCard(i).getNum();
                        }
                    }
                }
            }
            for (int i = 0; i < player.getSize(); i++)
            {
                for (int j = i + 1; j < player.getSize(); j++)
                {
                    if (player.readCard(i).getNum() == player.readCard(j).getNum())
                    {
                        if (player.readCard(i).getNum() != num)
                        {
                            player.setEval(6);
                        }
                    }
                }
            }
        }
        else
        {
            player.setEval(previousEval);
        }
    }
    
    public void check2Pair (PokerHand player)
    {
        int prevEval = player.getEval();
        int num = 0;
        this.checkPair(player);
        if(player.getEval() == 1)
        {
            for (int i = 0; i < player.getSize(); i++)
            {
                for (int j = i + 1; j < player.getSize(); j++)
                {
                    if (player.readCard(i).getNum() == player.readCard(j).getNum())
                    {
                        num = player.readCard(i).getNum();
                    }
                }
            }
            for (int i = 0; i < player.getSize(); i++)
            {
                for (int j = i + 1; j < player.getSize(); j++)
                {
                    if (player.readCard(i).getNum() == player.readCard(j).getNum())
                    {
                        if (player.readCard(i).getNum() != num)
                        {
                            player.setEval(3);
                        }
                    }
                }
            }
        }
        else
        {
            player.setEval(prevEval);
        }
    }
    
    public void checkStraight (PokerHand player)
    {
        for(int i = 0; i < player.getSize(); i++)
        {
            for (int j = 0; j < player.getSize(); j++)
            {
                for (int k = 0; k < player.getSize(); k++)
                {
                    for (int l = 0; l < player.getSize(); l++)
                    {
                        for (int m = 0; m < player.getSize(); m++)
                        {
                            if (player.readCard(j).getNum() == 1 + player.readCard(i).getNum() && player.readCard(k).getNum() == 1 + player.readCard(j).getNum() && player.readCard(l).getNum() == 1 + player.readCard(k).getNum() && player.readCard(m).getNum() == 1 + player.readCard(l).getNum())
                            {
                                player.setEval(4);
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void checkStraightFlush (PokerHand player)
    {
        int prevEval = player.getEval();
        this.checkFlush(player);
        int tempEval = player.getEval();
        if (tempEval == 5)
        {
            this.checkStraight(player);
            if (player.getEval() == 4)
            {
                player.setEval(8);
            }
            else
            {
                player.setEval(prevEval);
            }
        }
    }
    
    public void checkRoyalFlush (PokerHand player)
    {
        if (player.getEval() == 8)
        {
            boolean ten = false;
            boolean jack = false;
            boolean queen = false;
            boolean king = false;
            boolean ace = false;
            for (int i = 0; i < player.getSize(); i++)
            {
                if (player.readCard(i).getNum() == 10)
                {
                    ten = true;
                }
                if (player.readCard(i).getNum() == 11)
                {
                    jack = true;
                }
                if (player.readCard(i).getNum() == 12)
                {
                    queen = true;
                }
                if (player.readCard(i).getNum() == 13)
                {
                    king = true;
                }
                if (player.readCard(i).getNum() == 14)
                {
                    ace = true;
                }
            }
            if (ten == true && jack == true && queen == true && king == true && ace == true)
            {
                player.setEval(9);
            }
        }
    }
}
