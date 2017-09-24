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
public abstract class Character extends Entities {
    private int health;
    
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    public Character(int x, int y, int w, int h)
    {
        super(x,y,w,h);
        setHealth(1);
    }
    public Character(int x, int y, int w, int h, int sx, int sy)
    {
        super(x,y,w,h,sx,sy);
        setHealth(1);
    }
    public Character(int x, int y, int w, int h, Color color)
    {
        super(x,y,w,h,color);
        setHealth(1);
    }
    public Character(int x, int y, int w, int h, int sx, int sy, Color color)
    {
        super(x,y,w,h,sx,sy,color);
        setHealth(1);
    }
    public Character(int x, int y, int w, int h, int health)
    {
        super(x,y,w,h);
        setHealth(health);
    }
    public Character(int x, int y, int w, int h, int sx, int sy, int health)
    {
        super(x,y,w,h,sx,sy);
        setHealth(health);
    }
    public Character(int x, int y, int w, int h, Color color, int health)
    {
        super(x,y,w,h,color);
        setHealth(health);
    }
    public Character(int x, int y, int w, int h, int sx, int sy, Color color, int health)
    {
        super(x,y,w,h,sx,sy,color);
        setHealth(health);
    }
     //</editor-fold>
    
    @Override
    public void draw() {
        getCurrentGraphic().setColor(getColor());
        getCurrentGraphic().fillRect(getX(), getY(), getW(), getH());
    }
    
    public abstract Bullet shoot();
    
    //<editor-fold defaultstate="collapsed" desc=" Getters and Setters ">
    public int getHealth()
    {
        return this.health;
    }
    public void setHealth(int health)
    {
        this.health = health;
    }
    //</editor-fold>
}
