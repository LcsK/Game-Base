/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.*;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class SpaceInvaders {
    private ArrayList<Entities> entities;
    private boolean enemyColision;
    
    public void move(int width, int height)
    {
        ArrayList<Entities> garbage = new ArrayList<Entities>();
        for( Entities e : getEntities() )
        {
            if(!e.move(width, height))
            {
                if(e.getClass() == Bullet.class)
                {
                    garbage.add(e);
                }
                else if(e.getClass() == Enemy.class)
                {
                    if(getEnemyColision())
                        setEnemyColision(false);
                    setEnemyColision(true);
                    e.setSy(10);
                    e.setSx(0);
                }
            }
            else if(e.getClass() == Bullet.class)
            {
                for( Entities e2 : getEntities())
                {
                    if(e2.hascollision(e2))
                    {
                        garbage.add(e2);
                        garbage.add(e);
                        break;
                    }
                }
            }
        }
        getEntities().removeAll(garbage);
    }
    public void draw(Graphics g, int width, int height)
    {
        Entities.screenUpdate(g, width, height);
        for(Entities e : entities)
        {
            e.draw();
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Getters and Setters ">
    public ArrayList<Entities> getEntities()
    {
        return this.entities;
    }
    public void setEntities(ArrayList<Entities> entities)
    {
        this.entities = entities;
    }
    public boolean getEnemyColision()
    {
        return this.enemyColision;
    }
    public void setEnemyColision(boolean enemyColision)
    {
        this.enemyColision = enemyColision;
    }
    //</editor-fold>
}
