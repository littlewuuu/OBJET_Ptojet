/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.objet.WoE;

import java.util.Random;
import java.util.Vector;

/**
 * Is a character type in the world, the player chooses this type,
 * can pick up fleche , potionSoin and Epinard,
 * can not pick up Epee.
 * This class implements the Combattant interface and can fight.
 * Random movement at regular intervals.
 * @author wuzilong
 * @author Zou Kang
 */
public class Archer extends Personnage implements Combattant {

    /**
     * Marker on the map.
     */
    final private int type = 5;

    /**
     * Store the picked up fleche.
     */
    private Vector<Fleche> fleches = new Vector<>();





    /**
     * Initial an Archer without parameter
     */
    public Archer() {
        super();
        setType(5);
        for (int i = 0; i < 10; i++) {
            fleches.add(new Fleche(true));
        }
    }

    public Archer(int type9, String name9, int distattmax9, int vie9, int degatt9, int ptpar9, int pageatt9, int pageapr9, int direction9, int x9, int y9) {
        setType(type9);
        setNom(name9);
        setDistAttMax(distattmax9);
        setPtVie(vie9);
        setDegAtt(degatt9);
        setPtPar(ptpar9);
        setPageAtt(pageatt9);
        setPagePar(pageapr9);
        setDirection(direction9);
        setPos(new Point2D(x9, y9));
    }

    /**
     * Initialize Archer with name
     *
     * @param name name of Archer
     */
    public Archer(String name) {
        super(name);
        setType(5);

    }

    /**
     * initialize with position
     *
     * @param p position, Class of Point2D
     */
    public Archer(Point2D p) {
        super(p);
    }

    @Override
    public int getType() {
        return type;
    }

    /**
     * Realisation of long-range attacks using arrows.
     *
     * @return fleche that currently used arrows.
     */
    public Fleche useFleche() {
        if (fleches.size() == 0) {
            System.out.print("you have no fleche in your bag");
            return null;
        }
        Fleche fleche = fleches.get(fleches.size() - 1);
        fleches.removeElementAt(fleches.size() - 1);
        return fleche;
    }

    /**
     * Attack a creature according to the position of the target.
     * If the distance is 1, then it is melee, otherwise it is long range.
     * For each type of combat, we have a certain probability that the attack will fail,
     * and if it fails, there is no damage. After a successful attack. The target object has
     * a certain chance to succeed in defense, and if it succeeds, the damage is cut.
     *
     * @param c Target creature of the attack.
     */
    public void combattre(Creature c) {
        Random generateRandom = new Random();
        int randatt = generateRandom.nextInt(100) + 1;
        int randdef = generateRandom.nextInt(100) + 1;
        double distance = Point2D.distance(this.getPos().getX(), this.getPos().getY(), c.getPos().getX(), c.getPos().getY());
        if (distance == 1) { // combat contact
            if (randatt > c.getPageAtt()) {//rate
            } else {//reussie
                if (randdef > c.getPagePar()) { //Failure to defend
                    c.setPtVie(c.getPtVie() - this.getDegAtt());
                    System.out.println("ptVie" + c.getPtVie());
                } else {//successfully
                    c.setPtVie(c.getPtVie() - this.getDegAtt() + c.getPtPar());
                }
            }
        } else if (distance > 1 && distance < this.getDistAttMax()) { //combat a distance through Fleche
            if (fleches.size() > 0) {
                int randdis = generateRandom.nextInt(100) + 1;
                if (randdis > c.getPageAtt()) {
                    Joueur.setNbFleche(Joueur.getNbFleche() - 1); //Fleche will be lost even if not hit
                    //************为了显示箭的移动轨迹，没写完
                    Fleche fleche = useFleche();

                } else {
                    c.setPtVie(c.getPtVie() - fleches.lastElement().getDommage());
                    //***********为了显示箭的移动轨迹，没写完
                    Fleche fleche = useFleche();
                    Joueur.setNbFleche(Joueur.getNbFleche() - 1);
                }
            } else {
                System.out.println("There is no Fleche in your bag!");
            }
        }
    }

    /**
     * Print information of archer.
     */
    public void affiche() {
        System.out.println("Archer: ");
        System.out.print("nbFleche=" + fleches.size() + " ");
        super.affiche();
    }

    /**
     * Return Archer-owned fleche
     * @return
     */
    public Vector<Fleche> getFleches() {
        return fleches;
    }



    @Override
    public String toString() {
        return "Archer " + type + " " + getNom() + " " + getDistAttMax() + " " + getPtVie() + " " + getDegAtt() + " " + getPtPar() + " " + getPageAtt() + " " + getPagePar() + " " + getDirection() + " " + getPos().getX() + " " + getPos().getY() + '\n';
    }
}
