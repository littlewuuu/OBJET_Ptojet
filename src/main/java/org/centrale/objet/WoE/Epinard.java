package org.centrale.objet.WoE;

public class Epinard extends Nourriture implements Utilisable {
    /**
     * Marker on the map.
     */
    private final int type = 10;
    /**
     * Increase player's degAtt bonus points
     */
    private int bonus = 6;

    public Epinard(int bonus3, int type3, int count3, int state3, int x3, int y3) {
        setBonus(bonus3);
        setType(type3);
        setCount(count3);
        setState(state3);
        setPos(new Point2D(x3, y3));
    }


    Epinard() {
        super();
        setPos(World.createPoints(getType()));
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Epinard " + bonus + " " + type + " " + getCount() + " " + getState() + " " + getPos().getX() + " " + getPos().getY() + '\n';
    }

    public void affiche() {
        System.out.printf("Epinard : ");
        super.affiche();
    }


}
