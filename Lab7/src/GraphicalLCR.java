import javax.swing.*;
import java.awt.*;

public class GraphicalLCR extends JFrame {
    private LCRGame lcrGame;

    JPanel mainPanel;

    JPanel playersPanel;
    JPanel dicePanel;
    JPanel actionsPanel;

    JLabel actionLabel;
    JButton nextButton;

    GraphicalLCR(LCRGame lcrGame) {
        super("LCR Game");

        this.lcrGame = lcrGame;
        this.setPreferredSize(new Dimension(300, 350)); // add width/height as arguments

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        playersPanel = new JPanel();
        dicePanel = new JPanel();
        actionsPanel = new JPanel();

        actionsPanel.setLayout(new BorderLayout());

        mainPanel.add(playersPanel, BorderLayout.NORTH);
        mainPanel.add(dicePanel, BorderLayout.CENTER);
        mainPanel.add(actionsPanel, BorderLayout.SOUTH);

        playersPanel.setBorder(BorderFactory.createTitledBorder("Players"));
        dicePanel.setBorder(BorderFactory.createTitledBorder("Dice"));
        actionsPanel.setBorder(BorderFactory.createTitledBorder("Actions"));

        updatePlayersPanel();

        actionLabel = new JLabel("Next player: " + this.lcrGame.getCurrentPlayer());

        nextButton = new JButton("Next round");
        JButton exitButton = new JButton("Exit");

        nextButton.addActionListener(e -> {
            lcrGame.playTurn();

            updatePlayersPanel();
            updateDicePanel();
            updateActionsPanel();

            repaint();
        });

        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        actionsPanel.add(actionLabel, BorderLayout.NORTH);
        actionsPanel.add(nextButton, BorderLayout.CENTER);
        actionsPanel.add(exitButton, BorderLayout.SOUTH);

        this.add(mainPanel);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    void updatePlayersPanel() {
        playersPanel.removeAll();

        for(Player player : this.lcrGame.getPlayers()) {
            JLabel label = new JLabel(String.format("<html>%s <br>Chips: %d</html>", player.getName(), player.getChips()));

            Color color = (player == this.lcrGame.getCurrentPlayer()) ? Color.GREEN : Color.WHITE;

            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            label.setBackground(color);
            label.setOpaque(true);

            playersPanel.add(label);
        }
    }

    void updateDicePanel() {
        dicePanel.removeAll();

        for(Die die : this.lcrGame.getDice()) {
            JLabel label = new JLabel(die.toString());
            dicePanel.add(label);
        }
    }

    void updateActionsPanel() {
        String actionText;

        if(lcrGame.hasWinner) {
            nextButton = (JButton) actionsPanel.getComponent(1);
            nextButton.setEnabled(false);

            actionText = "Game over! Winner is " + lcrGame.getWinner();
        } else {
            actionText = "Next player: " + this.lcrGame.getCurrentPlayer();
        }

        actionLabel.setText(actionText);
    }

    public static void main(String[] args) {
        String[] playerNames = new String[] {"Bodil", "Åke", "Ylva"};
        LCRGame lcrGame = new LCRGame(playerNames);

        GraphicalLCR lcr = new GraphicalLCR(lcrGame);
    }
}
