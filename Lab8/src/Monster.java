import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

/*
 * A class..
 */
public class Monster extends JPanel {
    private int health;

    private Position position;
    private Position lastPosition;
    private Position targetPosition;

    HealthBar healthBar;

    /*
     * Initialises all variables and adds the correct layout
     */
    Monster(int health, Position position, Position targetPosition) {
        this.health = health;
        this.position = this.lastPosition = position;
        this.targetPosition = targetPosition;
        this.setLayout(new BorderLayout());

        String fileName = (Math.random() > 0.5) ? "icons/monster3.gif" : "icons/monster.gif";
        JLabel monsterIcon = getIconLabel(fileName);
        this.add(monsterIcon, BorderLayout.NORTH);

        healthBar = new HealthBar(health);
        this.add(healthBar, BorderLayout.SOUTH);
    }

    /*
     * Returns a JLabel with an image, whose filepath is given as an argument
     */
    private JLabel getIconLabel(String fileName) {
        URL url = this.getClass().getResource(fileName);
        ImageIcon ii = new ImageIcon(url);
        return new JLabel(ii);
    }

    public Position getPosition() {
        return position;
    }

    public int getHealth() {
        return health;
    }

    /*
     * Damages the monster
     *
     * After:
     *  Damages the monster and updates the health bar OR damages the monster and deletes it.
     */
    public void takeDamage(int damage) {
        if(health - damage <= 0) {
            health = 0;
        } else {
            health -= damage;
            healthBar.setHealth(health);
        }
    }

    /*
     * Gets all the available moves for the monster
     * (Available moves are moves that are both passable and not to the last position that the monster was at)
     *
     * After:
     *  Returns all available moves as an ArrayList
     */
    ArrayList<Position> getAvailableMoves(boolean[][] passables) {
        int curRow = position.getRow();
        int curCol = position.getCol();

        ArrayList<Position> positions = new ArrayList<>();

        for(int row = position.getRow() - 1; row <= (position.getRow() + 1); row++) {
            if(row < 0 || row > (passables.length - 1)) continue;
            for(int col = position.getCol() - 1; col <= (position.getCol() + 1); col++) {
                if(col < 0 || col > (passables[row].length - 1) || (col == curCol && row == curRow)) continue;
                if(curCol != col && curRow != row) continue;

                Position pos = new Position(col, row);
                if(passables[row][col] && !lastPosition.equals(pos)) {
                    positions.add(pos);
                }
            }
        }
        return positions;
    }

    /*
     * Gets all available moves and then selects a random one
     *
     * After:
     *  Returns the monster's next move.
     */
    Position getNextPos(boolean[][] passables) {
        ArrayList<Position> availableMoves = getAvailableMoves(passables);

        if(availableMoves.size() == 0) return null;

        int index = new Random().nextInt(availableMoves.size());

        return availableMoves.get(index);
    }

    /*
     * Sets the monster's last position to its current position and then sets its current position to a new position.
     */
    void setPos(Position pos) {
        lastPosition = position;
        position = pos;
    }

    /*
     * Checks if the monster is at its target position.
     *
     * After:
     *  Returns true if the monster is at its target position, and false if it isn't.
     */
    boolean atTargetPosition() {
        return position.equals(targetPosition);
    }
}