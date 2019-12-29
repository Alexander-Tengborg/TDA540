import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

//TODO Cant center the HealthBar
public class Monster extends JPanel {
    private int health;

    private Position position;
    private Position lastPosition;
    private Position targetPosition;

    JLabel healthLabel;
    HealthBar healthBar;

    Monster(int health, Position position, Position targetPosition) {
        this.health = health;
        this.position = this.lastPosition = position;
        this.targetPosition = targetPosition;
        //this.setBackground(Color.magenta);
        this.setLayout(new BorderLayout());

        String fileName = (Math.random() > 0.5) ? "icons/monster3.gif" : "icons/monster.gif";
        JLabel monsterIcon = getIconLabel(fileName);
        this.add(monsterIcon, BorderLayout.NORTH);

        healthBar = new HealthBar(health);
        this.add(healthBar, BorderLayout.SOUTH);
    }

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

    public void takeDamage(int damage) {
        if(health - damage < 0) {
            health = 0;
        } else {
            health -= damage;
        }
        healthBar.setHealth(health);

        if(health - damage <= 0) {
            //TODO KILL MONSTER
        }
    }

    ArrayList<Position> getAvailableMoves(boolean[][] passables) {
        int curRow = position.getRow();
        int curCol = position.getCol();

        ArrayList<Position> positions = new ArrayList<>();

        for(int row = position.getRow() - 1; row <= (position.getRow() + 1); row++) {
            if(row < 0 || row > (passables.length - 1)) continue;
            for(int col = position.getCol() - 1; col <= (position.getCol() + 1); col++) {
                if(col < 0 || col > (passables[row].length - 1) || (col == curCol && row == curRow)) continue;
                if(curCol != col && curRow != row) continue;

                Position pos = new Position(col, row); //TODO change Position(...) to Position(row, col)
                if(passables[row][col] && !lastPosition.equals(pos)) {
                    positions.add(pos);
                }
            }
        }
        return positions;
    }

    Position getNextPos(boolean[][] passables) {
        ArrayList<Position> availableMoves = getAvailableMoves(passables);

        if(availableMoves.size() == 0) return null;

        int index = new Random().nextInt(availableMoves.size());

        return availableMoves.get(index);
    }

    void setPos(Position pos) {
        lastPosition = position;
        position = pos;
    }

    boolean atTargetPosition() {
        return position.equals(targetPosition);
    }
}

/*
    private JPanel buildMonsterPanel(int monsterHealth) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());

        JLabel monsterIcon = getIconLabel("icons/monster10.gif");
        panel.add(monsterIcon, BorderLayout.CENTER);

        JLabel healthLabel = new JLabel(Integer.toString(monsterHealth));
        healthLabel.setFont(new Font("Serif", Font.BOLD, 10));
        panel.add(healthLabel, BorderLayout.SOUTH);

        return panel;
    }*/