/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.objet.WoE;

/**
 * Is an element in the world, randomly generated by the system.
 * and can only be picked up by the Archer and can be used by the player to attack.
 * @author wuzilong
 * @author Zou Kang
 */
public class Fleche extends Objet {
    /**
     * Used to indicate on the OOCUPIED table that the position is occupied by Fleche
     */
    private final int type = 2;
    /**
     * Injuries caused by Fleche
     */
    private int dommage = 4;




    public Fleche(Fleche f) {
        super(f);
        dommage = f.getDommage();
    }

    public Fleche() {
        setPos(World.createPoints(type));
    }

    //在最开始初始化 Archer 的时候有 10 只 Fleche，防止其在地图上占位置
    public Fleche(Boolean i) {
    }

    /**
     * used for charge the world.
     *
     * @param type
     * @param dommage
     * @param life
     * @param state
     * @param x
     * @param y
     */
    public Fleche(int type, int dommage, int life, int state, int x, int y) {
        setType(type);
        setDommage(dommage);
        setLife(life);
        setState(state);
        setPos(new Point2D(x, y));
    }


    public int getDommage() {
        return dommage;
    }

    public void setDommage(int dommage) {
        this.dommage = dommage;
    }

    public int getType() {
        return type;
    }

    public void affiche() {
        System.out.printf("Fleche : ");
        super.affiche();
    }


    @Override
    public String toString() {
        return "Fleche " + type + " " + dommage + " " + getLife() + " " + getState() + " " + getPos().getX() + " " + getPos().getY() + '\n';
    }
}
