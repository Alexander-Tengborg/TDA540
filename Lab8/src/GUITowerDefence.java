import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.*;

public class GUITowerDefence extends JFrame {

  // A map that assigns a panel to each position in the game
  private final Map<Position, JPanel> positionPanels = new HashMap<>();

  // The size of each position panel
  private static final int POSITION_SIZE = 100;

  // A timer that will automatically advance the game each second.
  private final Timer timer;
  private static final int SPEED = 1000;
  private static final int PAUSE = 3000;

  private int counter = 0;

  // A representation of the complete game
  private TowerDefenceLevel level;

  private Monster monster;
  private ArrayList<Tower> towers = new ArrayList<>();

  public static void main(String[] args) {

    // Change this to try out different levels
    TowerDefenceLevel level = TowerDefenceLevel.buildSpiralLevel();

    // Create the GUI and set it to be visible
    GUITowerDefence gui = new GUITowerDefence(level);
    gui.setVisible(true);

  }

  public GUITowerDefence(TowerDefenceLevel level) {
    this.setTitle("Tower Defence");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.level = level;

    int levelHeight = level.getHeight();
    int levelWidth = level.getWidth();

    this.setSize(levelWidth*POSITION_SIZE, levelHeight*POSITION_SIZE);
    this.setResizable(false);

    // A 'main panel' that contains all other components of the GUI
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(levelHeight, levelWidth));
    this.add(mainPanel);
    for (int row = 0; row < levelHeight; row++) {
      for (int col = 0; col < levelWidth; col++) {
        JPanel positionPanel = new JPanel();
        positionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        Position position = level.getPosition(col, row); //TODO ???????????????????????

        if(level.passable[row][col] == false) {
          positionPanel.setBackground(Color.GREEN);

          positionPanel.setLayout(new BorderLayout(0, 0));

          JButton button = new JButton();

          button.setOpaque(false);
          button.setContentAreaFilled(false);
          button.setBorderPainted(false);

          button.addActionListener(e -> {
            if(positionPanel.getComponents().length > 1) return;

            Tower tower = new Tower(2, 2, position);
            towers.add(tower);
            positionPanel.add(tower);
            revalidate();
          });
          positionPanel.add(button);
        }

        mainPanel.add(positionPanel);

        // Add the panel to the 'positionPanels' map so we can access it
        // later (with positionPanels.get(position)).
        positionPanels.put(position, positionPanel);
      }
    }

    monster = new Monster(50, level.getStartPos(), level.getTargetPos());

    // Start the timer and set it to call the event loop each second
    EventLoop loop = new EventLoop();
    timer = new Timer(SPEED, loop);
    timer.setInitialDelay(PAUSE);
    timer.start();
  }

  // ---------- Event handling --------------------
  class EventLoop implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

      // Here you can implement the logic to advance the game by one step
      // and update the GUI.

      JPanel panel = positionPanels.get(monster.getPosition());

      if(counter == 0) {
        panel.add(monster);
        counter++;
        return;
      }

      for(Tower tower: towers) {
        tower.shootMonster(monster);

        if(monster.getHealth() == 0) {
          setTitle("You won!");
          monster.removeAll();
          timer.stop();
        }
      }

      Position nextMonsterPos = monster.getNextPos(level.passable);

      if(nextMonsterPos != null) {
        panel.removeAll();

        positionPanels.get(nextMonsterPos).add(monster);

        monster.setPos(nextMonsterPos);
      }

      boolean gameOver = monster.atTargetPosition();

      if (gameOver) {
        setTitle("Game over!");
        monster.removeAll();
        timer.stop();
      }

      counter++;

      // These two commands are necessary to properly
      // display all the updated elements of the GUI.
      revalidate();
      repaint();
    }
  }
}
