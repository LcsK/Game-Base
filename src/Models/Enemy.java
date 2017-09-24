/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author lucas
 */
public class Enemy extends Character {
    private int power;
    
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    public Enemy(int x, int y, int w, int h)
    {
        super(x,y,w,h);
        setHealth(1);
        setPower(1);
    }
    public Enemy(int x, int y, int w, int h, int health, int power)
    {
        super(x,y,w,h);
        setHealth(health);
        setPower(power);
    }
    public Enemy(int x, int y, int w, int h, int health, int power, Color color)
    {
        super(x,y,w,h,color);
        setHealth(health);
        setPower(power);
    }
    //</editor-fold>
    
    @Override
    public boolean move(int width, int height)
    {
        if( getX() + getSx() < 0 || getX() + getW() + getSx() > height )
            return false;
        setY(getY() + getSy());
        getRectangle().y = getY();
        setX(getX() + getSx());
        getRectangle().x = getX();
        return true;
    }
    
    @Override
    public Bullet shoot()
    {
        return new Bullet(getX()+getW()/2, getY(), 5, 5, 3);
    }
    //<editor-fold defaultstate="collapsed" desc=" Getters and Setters ">
    public int getPower()
    {
        return this.power;
    }
    public void setPower(int power)
    {
        this.power = power;
    }
    //</editor-fold>
}
