import javax.swing.*;
import java.awt.*;

//TODO Cant center the HealthBar in the Monster JFrame
public class Projectile extends JPanel {
    //private static final int HEALTHBAR_HEIGHT = 10;
    //private static final int HEALTHBAR_WIDTH = 76;

    Projectile() {
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.PINK);
        g.fillRect(0, 0, 10, 40);
    }
}
