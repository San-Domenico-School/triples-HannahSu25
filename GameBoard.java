import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game Board for Triples
 * 
 * @Hannah 
 * @version (a version number or a date)
 */

public class GameBoard extends World
{
    private final int NUM_CARDS_IN_DECK = 27;    
    public GameBoard()
    {   
        super(430, 600, 1, false);
        prepareScene();
    }
    
    public void prepareScene()
    {
        Dealer dealer = new Dealer(NUM_CARDS_IN_DECK);
        Player player = new Player(dealer);
        addObject(dealer, -30, -30);
        addObject(player, -30, -30);

    }
}