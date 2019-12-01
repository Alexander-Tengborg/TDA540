import javax.swing.*;
import java.net.URL;

public class Tower extends JLabel { //use JPanel instead?
    private int damage;
    private double range;

    private Position position;

    Tower(int damage, double range, Position position) {
        super(buildTowerLabel());

        this.damage = damage;
        this.range = range;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public boolean canShootMonster(Monster monster) {
        double xDistance = Math.abs(monster.getPosition().getCol() - position.getCol()); //TODO naming
        double yDistance = Math.abs(monster.getPosition().getRow() - position.getRow());//TODO naming
        double distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
        //System.out.println(String.format("x: %f, y: %f", xDistance, yDistance));
        //System.out.println(distance <= range);
        return (distance <= range);
    }

    public void shootMonster(Monster monster) {
        if(canShootMonster(monster) && monster.getHealth() > 0) monster.takeDamage(damage);
    }

    private static ImageIcon buildTowerLabel() {
        return getIconLabel("icons/tower-icon2.png");
    }

    private static ImageIcon getIconLabel(String fileName) {
        URL url = Tower.class.getResource(fileName);
        ImageIcon ii = new ImageIcon(url);
        return ii;
    }
}
