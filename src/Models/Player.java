/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author lucas
 */
public class Player extends Character {
    private static boolean left;
    private static boolean right;
    
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    public Player(int x, int y, int w, int h)
    {
        super(x,y,w,h);
    }
    public Player(int x, int y, int w, int h, int health)
    {
        super(x,y,w,h,health);
    }
    //</editor-fold>
    
    @Override
    public boolean move(int width, int height)
    {
        if(right && getX() + getW() < width)
        {
            setX(getX() + getSx());
            getRectangle().x = getX();
            return true;
        }
        else if(left && getX() > 0)
        {
            setX(getX() - getSx());
            getRectangle().x = getX();
            return true;
        }
        return false;
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Getters and Setters ">
    public static boolean getLeft()
    {
        return Player.left;
    }
    public static void setLeft(boolean left)
    {
        Player.left= left;
    }
    public static boolean getRight()
    {
        return Player.right;
    }
    public static void setRight(boolean right)
    {
        Player.right = right;
    }
    //</editor-fold>
}