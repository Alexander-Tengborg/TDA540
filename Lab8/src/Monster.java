import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Map;

//TODO Cant center the HealthBar
public class Monster extends JPanel {
    private int health;
    private Position position;

    JLabel healthLabel;
    HealthBar healthBar;

    Monster(int health, Position position) {
        this.health = health;
        this.position = position;
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

    void getAvailableMoves(Map<Position, JPanel> positionPanels, boolean[][] passables) {

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