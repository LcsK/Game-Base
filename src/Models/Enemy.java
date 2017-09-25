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
    public Enemy(int x, int y, int w, int h, int sx)
    {
        super(x,y,w,h);
        setHealth(1);
        setPower(1);
        setSx(sx);
        setSy(0);
    }
    public Enemy(int x, int y, int w, int h, int sx, int health, int power)
    {
        super(x,y,w,h);
        setHealth(health);
        setPower(power);
        setSx(sx);
        setSy(0);
    }
    public Enemy(int x, int y, int w, int h, int sx, int health, int power, Color color)
    {
        super(x,y,w,h,color);
        setHealth(health);
        setPower(power);
        setSx(sx);
        setSy(0);
    }
    //</editor-fold>
    
    @Override
    public boolean move(int width, int height)
    {
        boolean move = true;
        if( getX() + 2*getSx() < 0 || getX() + getW() + 2*getSx() > width )
            move = false;
        setY(getY() + getSy());
        getRectangle().y = getY();
        setX(getX() + getSx());
        getRectangle().x = getX();
        return move;
    }
    
    @Override
    public Bullet shoot()
    {
        Bullet b = new Bullet((int)getX()+getW()/2, getY()+8, 5, 8, 3, Color.GREEN);
        b.getTargets().add(Player.class);
        return b;
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
