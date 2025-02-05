import greenfoot.*; 

/**
 * Game Board for Triples
 * 
 * @Hannah Su  
 * @Jan 8
 */

public class Card extends Actor
{
    public enum Shape
    {
        TRIANGLE, SQUARE, CIRCLE, NO_SHAPE
    }
    
    public enum Color
    {
        RED, GREEN, BLUE, NO_COLOR
    }
    
    private Shape shape;
    private Color color;
    private int numberOfShapes,shading;
    private GreenfootImage cardImage, selectedCardImage;
    public boolean isSelected;

    public Card(Shape shape, Color color, int numberOfShapes, int shading, 
                GreenfootImage cardImage, GreenfootImage selectedCardImage)
    {
        this.shape = shape;
        this.color = color;
        this.isSelected = false; 
        this.numberOfShapes = numberOfShapes;
        this.shading = shading;
        this.cardImage = cardImage;
        this.selectedCardImage = selectedCardImage;
        
        setImage(cardImage); 
    }
    
    public Shape getShape() 
    {
        return shape;
    }
    
    public Color getColor() 
    {
        return color;
    }
    
    public int getNumberOfShapes() 
    {
        return numberOfShapes;
    }
    
    public int getShading() 
    {
        return shading;
    }
    
    public GreenfootImage getCardImage() 
    {
        return cardImage;
    }
    
    public GreenfootImage getSelectedCardImage() 
    {
        return selectedCardImage;
    }
    
    public boolean getIsSelected()
    {
        return isSelected;
    }
    
    public void setIsSelected(boolean isSelected)
    {
        this.isSelected = isSelected;
    }
}



