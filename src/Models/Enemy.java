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
public class Enemy extends Character {
    
    
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
    public boolean move(int width, int height)
    {
        setX(getX() + getSx());
        getRectangle().x = getX();
        return true;
    }
}
