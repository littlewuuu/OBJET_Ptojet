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
public class Lapin extends Monstre {

    private final int type = 8;

    public Lapin(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    public Lapin(Lapin m) {
        super(m);
    }

    public Lapin() {
        super();
        setType(8);
    }

    public Lapin(Point2D p) {
        super(p);
    }

    public Lapin(int type6, int vie6, int degatt6, int ptpar, int pageatt, int pageapr, int direction, int x, int y) {
        setPtVie(vie6);
        setType(type6);
        setDegAtt(degatt6);
        setPtPar(ptpar);
        setPageAtt(pageatt);
        setPagePar(pageapr);
        setDirection(direction);
        setPos(new Point2D(x, y));
    }

    @Override
    public int getType() {
        return type;
    }

    public void affiche() {
        System.out.println("Lapin:");
        super.affiche();
    }

    @Override
    public String toString() {
        return "Lapin " + type + " " + getPtVie() + " " + getDegAtt() + " " + getPtPar() + " " + getPageAtt() + " " + getPagePar() + " " + getDirection() + " " + getPos().getX() + " " + getPos().getY() + '\n';
    }
}
