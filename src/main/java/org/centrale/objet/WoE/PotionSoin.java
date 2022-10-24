/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.objet.WoE;

/**
 * @author wuzilong
 * @author Zou Kang
 */
public class PotionSoin extends Objet implements Utilisable {
    /**
     * Used to indicate on the OOCUPIED table that the position is occupied by PotionSoin
     */
    private final int type = 4;
    /**
     * The number of life points that can be restored by the PotionSoin.
     */
    private int recover = 5;

    public PotionSoin() {
        super();
        setPos(World.createPoints(type));
    }

    public PotionSoin(PotionSoin p) {
        super(p);
        this.recover = p.recover;
    }

    public PotionSoin(int recouver, int life, int valeur) {
        super(life, valeur);
        this.recover = recouver;
    }

    public PotionSoin(int type4, int recover4, int life4, int state4, int x4, int y4) {
        setType(type4);
        setRecover(recover4);
        setLife(life4);
        setState(state4);
        setPos(new Point2D(x4, y4));
    }

    /**
     * Recovery of life value.
     *
     * @param c Target of recovery
     */
    public void Guerir(Creature c) {
        c.setPtVie(c.getPtVie() + recover);
    }

    public int getRecover() {
        return recover;
    }

    public void setRecover(int recover) {
        this.recover = recover;
    }

    public void affiche() {
        System.out.printf("PotionSoin : ");
        super.affiche();
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "PotionSoin " + type + " " + recover + " " + getLife() + " " + getState() + " " + getPos().getX() + " " + getPos().getY() + '\n';
    }
}
