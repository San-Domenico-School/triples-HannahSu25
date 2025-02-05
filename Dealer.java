import greenfoot.*; 
import java.util.ArrayList;

/**
 * dealer for Triples
 * 
 * @Alicia  
 * @Jan 18
 */

public class Dealer extends Actor  
{
    private Deck deck;
    private ArrayList<Card> cardsOnBoard;
    private ArrayList<Integer> selectedCardsIndex;
    private Card[] cardsSelected;
    private int numCardsInDeck;
    private int triplesRemaining;

    public Dealer(int numCardsInDeck)
    {
        this.numCardsInDeck = numCardsInDeck;
        this.triplesRemaining = numCardsInDeck/3;
        this.deck = new Deck(numCardsInDeck);
        this.cardsOnBoard = new ArrayList<>();
        cardsSelected = new Card[3];
    }
    
    public void addedToWorld(World world) 
    {
        dealBoard();
        setUI();
    }

    public void dealBoard() 
    {
        Greenfoot.playSound("shuffle.wav");
        
        for (int y = 45; y <= 450; y += 72) 
        {
            for (int x = 80; x <= 400; x += 135) 
            {
                getWorld().addObject(deck.getTopCard(), x, y);
                numCardsInDeck--;
            }
        }
    }

    public void setUI() 
    {
        Integer score = Scorekeeper.getScore();
        Integer numCardsRemaining = numCardsInDeck;
        getWorld().showText(score.toString(), 312, 506);
        getWorld().showText(numCardsRemaining.toString(), 312, 471);
    }
    
    private boolean checkShape()
    {
        return (cardsSelected[0].getShape() == cardsSelected[1].getShape() 
                && cardsSelected[1].getShape() == cardsSelected[2].getShape())
            || (cardsSelected[0].getShape() != cardsSelected[1].getShape() 
                && cardsSelected[1].getShape() != cardsSelected[2].getShape());
    }
    
    private boolean checkColor()
    {
        return (cardsSelected[0].getColor() == cardsSelected[1].getColor() 
                && cardsSelected[1].getColor() == cardsSelected[2].getColor())
            || (cardsSelected[0].getColor() != cardsSelected[1].getColor() 
                && cardsSelected[1].getColor() != cardsSelected[2].getColor());
    }
    
    private boolean checkNumberOfShapes()
    {
        return (cardsSelected[0].getNumberOfShapes() == cardsSelected[1].getNumberOfShapes() 
                && cardsSelected[1].getNumberOfShapes() == cardsSelected[2].getNumberOfShapes())
            || (cardsSelected[0].getNumberOfShapes() != cardsSelected[1].getNumberOfShapes() 
                && cardsSelected[1].getNumberOfShapes() != cardsSelected[2].getNumberOfShapes());
    }
    
    private boolean checkShading()
    {
        return (cardsSelected[0].getShading() == cardsSelected[1].getShading() 
                && cardsSelected[1].getShading() == cardsSelected[2].getShading())
            || (cardsSelected[0].getShading() != cardsSelected[1].getShading() 
                && cardsSelected[1].getShading() != cardsSelected[2].getShading());
    }

    public boolean isTriple(Card[] cards)
    {        
        if(checkShape() && checkColor() && checkNumberOfShapes() && checkShading())
        {
            return true;
        }
        else
            return false;
    }
    
    public void checkIfTriple(Card[] cards) 
    {
        if(isTriple(cards))
        {
            actionIfTriple(cards);
        }
        else
        {
            Animations.wobble(cardsSelected);
        }
        
    }

    public void actionIfTriple(Card[] card) 
    {
        int[][] cardsLocation = new int[3][2];
        
        for(int i = 0; i < 3; i++)
        {
            cardsLocation[i][0] = card[i].getX();
            cardsLocation[i][1] = card[i].getY();
        }
        
        Animations.slideAndTurn(cardsSelected);

        for(int i = 0; i < 3; i++)
        {
            if (numCardsInDeck != 0)

            {
                getWorld().addObject(deck.getTopCard(),cardsLocation[i][0], cardsLocation[i][1]);
                numCardsInDeck--;
            }
        }
        
        triplesRemaining--;
        Scorekeeper.updateScore();
        setUI();
        endGame();
    }
    
    public void endGame() 
    {
        if (triplesRemaining == 0) 
        {
            getWorld().addObject(new YouWin(),222,300);
            Greenfoot.stop();
        }
    }
    
    public void setCardsSelected(ArrayList<Card> cardsOnBoard, Card[] cardsSelected, ArrayList<Integer> selectedCardsIndex)
    {
        this.cardsOnBoard = cardsOnBoard;
        this.selectedCardsIndex = selectedCardsIndex;
        this.cardsSelected = cardsSelected;
        checkIfTriple(cardsSelected);
    }
}
