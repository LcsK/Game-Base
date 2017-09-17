/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.Graphics;

/**
 *
 * @author lucas
 */
public class Enemy extends Entities {
    private int health;
    
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    public Enemy(int x, int y, int w, int h)
    {
        super(x,y,w,h);
        setHealth(1);
    }
    public Enemy(int x, int y, int w, int h, int health)
    {
        super(x,y,w,h);
        setHealth(health);
    }
    //</editor-fold>
    
    @Override
    public void draw() {
        getCurrentGraphic().setColor(getColor());
        getCurrentGraphic().fillRect(getX(), getY(), getW(), getH());
    }
    
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
