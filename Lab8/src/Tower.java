import javax.swing.*;
import java.net.URL;
import java.util.Random;

/*
 * If the following demands are met, the tower shoots the monster:
 */
public class Tower extends JLabel {
    private int damage;
    private double range;

    private Position position;

    /*
     * Initialises all the variables, and calls the super method with the towers icon.
     */
    Tower(int damage, double range, Position position) {
        super(buildTowerLabel());

        this.damage = damage;
        this.range = range;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    /*
     * Uses the pythagorean theorem to determine the distance between the tower and the monster.
     *
     * After:
     *  Returns the distance between the distance between the tower and the monster.
     */
    public boolean monsterInRange(Monster monster) {
        double xDistance = Math.abs(monster.getPosition().getCol() - position.getCol());
        double yDistance = Math.abs(monster.getPosition().getRow() - position.getRow());
        double distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
        return (distance <= range);
    }

    /*
     * If the following demands are met, the tower shoots the monster:
     *  The monster is in range of the tower
     *  The monster's health is greater than zero
     *  Randomly generates two numbers (0 and 1). If this number is 0, this demand is met.
     */
    public void shootMonster(Monster monster) {
        if(monsterInRange(monster) && monster.getHealth() > 0 && new Random().nextInt(2) == 0)
            monster.takeDamage(damage);
    }

    /*
     * Returns an image icon, whose filepath is given as an argument
     */
    private static ImageIcon buildTowerLabel() {
        return getIconLabel("icons/tower-icon2.png");
    }

    /*
     * Returns a JLabel with an image, whose filepath is given as an argument
     */
    private static ImageIcon getIconLabel(String fileName) {
        URL url = Tower.class.getResource(fileName);
        ImageIcon ii = new ImageIcon(url);
        return ii;
    }
}
