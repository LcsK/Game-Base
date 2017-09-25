/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lucas
 */
public class SpaceInvaders {
    private ArrayList<Entities> entities;
    ArrayList<Entities> garbage;
    private Player playerPointer;
    private boolean enemyColision;
    private int level;
    private int score;
    private long lastShot;
    
    public SpaceInvaders(int width, int height)
    {
        setScore(0);
        setLevel(1);
        createLevel(width, height);
    }
    public void createLevel(int width, int height)
    {
        setEntities(new ArrayList<Entities>());
        setGarbage(new ArrayList<Entities>());
        int w = (int)(width * 0.1);
        int esp = (int) (width * 0.035);
        for(int i = 0; i < 6; i++)
            for(int j=0; j<getLevel(); j++)
                getEntities().add(new Enemy( w*i + esp*i, w*j + esp*j, w, w, 1, 1, 1, Color.RED));
        
        playerPointer = new Player((int)width/2, (int)height-esp-(w/2), 2*w ,(int) w/2 , 1, Color.BLACK);
        playerPointer.setSx(2);
        getEntities().add(playerPointer);
    }
    
    public void run(Graphics g, int width, int height, boolean leftArrow, boolean rightArrow, boolean space, boolean r)
    {
        if(getEntities().contains(playerPointer) && getEntities().size() != 1)
        {
            playerPointer.setLeft(leftArrow);
            playerPointer.setRight(rightArrow);
            if(space)
                tryShoot();
            move(width, height);
            draw(g, width, height);
        }
        else if(getEntities().contains(playerPointer))
        {
            setLevel(getLevel()+1);
            createLevel(width, height);
        }
        else
        {
            Entities.screenUpdate(g, width, height);
            g.setColor(Color.BLACK);
            g.drawString("Aperte R para recomeçar",50,50);
            if(r)
            {
                level = 0;
                score = 0;
                createLevel(width, height);
            }
                
        }
    }
    private void move(int width, int height)
    {
        ArrayList<Enemy> shooters = new ArrayList<Enemy>();
        Random r = new Random();
        
        boolean auxEnemyColision = false;
        for(Entities e : getEntities())
        {
            if(getEnemyColision() && e.getClass() == Enemy.class)
            {
                int sx = e.getSx();
                e.setSy(Math.abs(sx)*2);
                e.setSx(0);
                e.move(width, height);
                e.setSy(0);
                e.setSx(-sx);
            }
            else if(!e.move(width, height))
            {
                if(e.getClass() == Bullet.class)
                    getGarbage().add(e);
                else if(e.getClass() == Enemy.class)
                    auxEnemyColision = true;
            }
            else if(e.getClass() == Enemy.class)
            {
                if(r.nextInt(500) == 0)
                {
                    shooters.add((Enemy)e);
                }
            }
            if(e.getClass() == Bullet.class)
            {
                hasCollision(e);
            }
        }
        for(Enemy e: shooters)
        {
            getEntities().add(e.shoot());
        }
        setEnemyColision(auxEnemyColision);
        getEntities().removeAll(getGarbage());
        getGarbage().clear();
    }
    private void hasCollision(Entities entity)
    {
        for(Entities e: getEntities())
        {
            if(entity.hasCollision(e))
            {
                getGarbage().add(e);
                getGarbage().add(entity);
                break;
            }
        }
    }
    private void draw(Graphics g, int width, int height)
    {
        Entities.screenUpdate(g, width, height);
        for(Entities e : entities)
        {
            e.draw();
        }
    }
    private void tryShoot()
    {
        long currentTime = System.currentTimeMillis();
        if(currentTime > getLastShot() + 1000)
        {
            setLastShot(currentTime);
            getEntities().add(playerPointer.shoot());
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
    public ArrayList<Entities> getGarbage()
    {
        return this.garbage;
    }
    public void setGarbage(ArrayList<Entities> garbage)
    {
        this.garbage = garbage;
    }
    public Player getPlayerPointer()
    {
        return this.playerPointer;
    }
    public void setPlayerPointer(Player playerPointer)
    {
        this.playerPointer = playerPointer;
    }
    public boolean getEnemyColision()
    {
        return this.enemyColision;
    }
    public void setEnemyColision(boolean enemyColision)
    {
        this.enemyColision = enemyColision;
    }
    public int getLevel()
    {
        return this.level;
    }
    public void setLevel(int level)
    {
        this.level = level;
    }
    public int getScore()
    {
        return this.score;
    }
    public void setScore(int score)
    {
        this.score = score;
    }
    public long getLastShot()
    {
        return this.lastShot;
    }
    public void setLastShot(long lastShot)
    {
        this.lastShot = lastShot;
    }
    //</editor-fold>
}
