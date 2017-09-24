/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author lucas
 */
public abstract class Entities {
    protected int x, y, w, h, sx, sy;
    protected Color color;
    protected static Graphics currentGraphic;
    protected Rectangle rectangle;
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    public Entities(int x, int y, int w, int h)
    {
        setX(x);
        setY(y);
        setW(w);
        setH(h);
        setSx(1);
        setSy(1);
        setRectangle(new Rectangle(x, y, w, h));
        setColor(Color.BLACK);
    }
    public Entities(int x, int y, int w, int h, int sx, int sy)
    {
        this(x,y,w,h);
        setSx(sx);
        setSy(sy);
    }
    public Entities(int x, int y, int w, int h, Color color)
    {
        this(x,y,w,h);
        setColor(color);
    }
    public Entities(int x, int y, int w, int h, int sx, int sy, Color color)
    {
        this(x,y,w,h,color);
        setSx(sx);
        setSy(sy);
    }
    //</editor-fold>
    
    public abstract void draw();
    public abstract boolean move(int width, int height);
    public boolean hascollision(Entities e)
    {
        if(this.getClass().equals(e.getClass()))
            return false;
        else
            return getRectangle().intersects(e.getRectangle());
    }
    
    public static void screenUpdate(Graphics g, int width, int height)
    {
        setCurrentGraphic(g);
        getCurrentGraphic().setColor(Color.WHITE);
        getCurrentGraphic().fillRect(0, 0, width, height);
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Getters and Setters ">
    public static Graphics getCurrentGraphic()
    {
        return Entities.currentGraphic;
    }
    private static void setCurrentGraphic(Graphics currentGraphic)
    {
        Entities.currentGraphic = currentGraphic;
    }
    public int getX()
    {
        return this.x;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public int getY()
    {
        return this.y;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public int getW()
    {
        return this.w;
    }
    public void setW(int w)
    {
        this.w = w;
    }
    public int getH()
    {
        return this.h;
    }
    public void setH(int h)
    {
        this.h = h;
    }
    public int getSx()
    {
        return this.sx;
    }
    public void setSx(int sx)
    {
        this.sx = sx;
    }
    public int getSy()
    {
        return this.sy;
    }
    public void setSy(int sy)
    {
        this.sy = sy;
    }
    public Color getColor()
    {
        return this.color;
    }
    public void setColor(Color color)
    {
        this.color = color;
    }
    public Rectangle getRectangle()
    {
        return this.rectangle;
    }
    private void setRectangle(Rectangle rectangle)
    {
        this.rectangle = rectangle;
    }
    //</editor-fold>
}
