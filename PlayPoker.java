/**
 * Gets the stats for the poker games
 *
 * @author Matthew Roesch
 * @version 1.0
 */
public class PlayPoker
{
    public PlayPoker ()
    {
        //
    }
    
    public void playGame (int iterations)
    {
        PokerGame game = new PokerGame (1, 5);
        int NoWin = 0;
        int PairWin = 0;
        int TwoPairWin = 0;
        int ThreeWin = 0;
        int StraightWin = 0;
        int FlushWin = 0;
        int FullHouseWin = 0;
        int FourWin = 0;
        int StraightFlushWin = 0;
        int RoyalFlushWin = 0;        
        for (int i = 0; i < iterations; i ++)
        {
            game.getDeck().shuffleDeck();
            game.getPlayer().drawHand(game.getDeck());
            game.checkPair(game.getPlayer());
            game.check2Pair(game.getPlayer());
            game.checkThree(game.getPlayer());
            game.checkStraight(game.getPlayer());
            game.checkFlush(game.getPlayer());
            game.checkFullHouse(game.getPlayer());
            game.checkFour(game.getPlayer());
            game.checkStraightFlush(game.getPlayer());
            game.checkRoyalFlush(game.getPlayer());
            if (game.getPlayer().getEval() == 0)
            {
                NoWin ++;   
            }
            if (game.getPlayer().getEval() == 1)
            {
                PairWin ++;   
            }
            if (game.getPlayer().getEval() == 2)
            {
                TwoPairWin ++;   
            }
            if (game.getPlayer().getEval() == 3)
            {
                ThreeWin ++;   
            }
            if (game.getPlayer().getEval() == 4)
            {
                StraightWin ++;   
            }
            if (game.getPlayer().getEval() == 5)
            {
                FlushWin ++;   
            }
            if (game.getPlayer().getEval() == 6)
            {
                FullHouseWin ++;   
            }
            if (game.getPlayer().getEval() == 7)
            {
                FourWin ++;   
            }
            if (game.getPlayer().getEval() == 8)
            {
                StraightFlushWin ++;   
            }
            if (game.getPlayer().getEval() == 9)
            {
                RoyalFlushWin ++;   
            }
        }
        double NoWinRate = NoWin/iterations;
        double PairWinRate = PairWin/iterations;
        double TwoPairWinRate = TwoPairWin/iterations;
        double ThreeWinRate = ThreeWin/iterations;
        double StraightWinRate = StraightWin/iterations;
        double FlushWinRate = FlushWin/iterations;
        double FullHouseWinRate = FullHouseWin/iterations;
        double FourWinRate = FourWin/iterations;
        double StraightFlushWinRate = StraightFlushWin/iterations;
        double RoyalFlushWinRate = RoyalFlushWin/iterations;
        System.out.println ("NoWinRate: " + NoWinRate);
        System.out.println ("PairWinRate: " + PairWinRate);
        System.out.println ("TwoPairWinRate: " + TwoPairWinRate);
        System.out.println ("ThreeWinRate: " + ThreeWinRate);
        System.out.println ("StraigtWinRate: " + StraightWinRate);
        System.out.println ("FlushWinRate: " + FlushWinRate);
        System.out.println ("FullHouseWinRate: " + FullHouseWinRate);
        System.out.println ("FourWinRate: " + FourWinRate);
        System.out.println ("StraightFlushWinRate: " + StraightFlushWinRate);
        System.out.println ("RoyalFlushWinRate: " + RoyalFlushWinRate);
    }
}
