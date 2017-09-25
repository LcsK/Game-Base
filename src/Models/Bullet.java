/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class Bullet extends Entities{
    private ArrayList<Class> targets;
    
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    public Bullet(int x, int y, int w, int h, int sy)
    {
        super(x,y,w,h,0,sy);
        setTargets(new ArrayList<Class>());
    }
    public Bullet(int x, int y, int w, int h, int sy, Color color)
    {
        super(x,y,w,h,0,sy,color);
        setTargets(new ArrayList<Class>());
    }
    //</editor-fold>
    
    @Override
    public void draw() {
        getCurrentGraphic().setColor(getColor());
        getCurrentGraphic().fillRect(getX(), getY(), getW(), getH());
    }
    @Override
    public boolean move(int width, int height)
    {
        if( getY()+getH()+getSy() < 0 || getY() + getSy() > height )
            return false;
        setY(getY() + getSy());
        getRectangle().y = getY();
        return true;
    }
    @Override
    public boolean hasCollision(Entities e)
    {
        if(!getTargets().contains(e.getClass()))
            return false;
        else
            return getRectangle().intersects(e.getRectangle());
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Getters and Setters ">
    public ArrayList<Class> getTargets()
    {
        return this.targets;
    }
    private void setTargets(ArrayList<Class> targets)
    {
        this.targets = targets;
    }
    //</editor-fold>
}
