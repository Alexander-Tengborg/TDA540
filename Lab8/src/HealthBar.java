import javax.swing.*;
import java.awt.*;

/*
 * A simple health bar for the monster, that represents the amount of health the monster has.
 */
public class HealthBar extends JPanel {
    private int maxHealth;
    private int health;

    private static final int HEALTHBAR_HEIGHT = 10;
    private static final int HEALTHBAR_WIDTH = 75;

    HealthBar(int maxHealth) {
        this.maxHealth = this.health = maxHealth;
    }

    /*
     * Draws the health bar
     */
    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(0, 0, HEALTHBAR_WIDTH, HEALTHBAR_HEIGHT);

        int healthWidth = (health*HEALTHBAR_WIDTH/maxHealth);
        g.setColor(new Color(29, 158, 47));
        g.fillRect(0, 0, healthWidth, HEALTHBAR_HEIGHT);

        String hpText = String.format("%d/%d", health, maxHealth);
        g.setColor(Color.BLACK);
        g.drawString(hpText, 22, 10);
    }

    /*
     * Changes the current health
     *
     * after:
     *  New health value for the class' health variable
     *  Redraws the health bar
     */
    public void setHealth(int health) {
        if(health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }

        repaint();
    }
}
