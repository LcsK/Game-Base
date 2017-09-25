/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.Color;

/**
 *
 * @author lucas
 */
public class Player extends Character {
    private boolean left;
    private boolean right;
    
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    public Player(int x, int y, int w, int h)
    {
        super(x,y,w,h);
        setLeft(false);
        setRight(false);
    }
    public Player(int x, int y, int w, int h, int health)
    {
        super(x,y,w,h,health);
        setLeft(false);
        setRight(false);
    }
    public Player(int x, int y, int w, int h, int health, Color color)
    {
        super(x,y,w,h,color);
        setLeft(false);
        setRight(false);
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
    
    @Override
    public Bullet shoot()
    {
        Bullet b = new Bullet((int)getX()+getW()/2, getY()-8, 5, 8, -3, Color.BLUE);
        b.getTargets().add(Enemy.class);
        return b;
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Getters and Setters ">
    public boolean getLeft()
    {
        return this.left;
    }
    public void setLeft(boolean left)
    {
        this.left= left;
    }
    public boolean getRight()
    {
        return this.right;
    }
    public void setRight(boolean right)
    {
        this.right = right;
    }
    //</editor-fold>
}