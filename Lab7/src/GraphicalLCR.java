import javax.swing.*;
import java.awt.*;

public class GraphicalLCR extends JFrame {
    private LCRGame lcrGame;

    JPanel mainPanel;

    JPanel playersPanel;
    JPanel dicePanel;
    JPanel actionsPanel;

    GraphicalLCR(LCRGame lcrGame) {
        super("LCR Game");

        this.lcrGame = lcrGame;
        this.setPreferredSize(new Dimension(300, 350));

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

        JLabel actionLabel = new JLabel("Next player: " + this.lcrGame.getCurrentPlayer());

        JButton nextButton = new JButton("Next round");
        JButton exitButton = new JButton("Exit");

        nextButton.addActionListener(e -> {
            lcrGame.playTurn();

            updatePlayersPanel();
            updateDicePanel();
            updateActionsPanel();
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

        playersPanel.updateUI();
    }

    void updateDicePanel() {
        dicePanel.removeAll();

        for(Die die : this.lcrGame.getDice()) {
            JLabel label = new JLabel(die.toString());
            dicePanel.add(label);
        }

        dicePanel.updateUI();
    }

    void updateActionsPanel() {
        JLabel label = (JLabel) actionsPanel.getComponent(0);

        String actionText;

        if(lcrGame.hasWinner) {
            JButton button = (JButton) actionsPanel.getComponent(1);
            button.setEnabled(false);

            actionText = "Game over! Winner is " + lcrGame.getWinner();
        } else {
            actionText = "Next player: " + this.lcrGame.getCurrentPlayer();
        }

        label.setText(actionText);
    }

    public static void main(String[] args) {
        String[] playerNames = new String[] {"Bodil", "Åke", "Ylva"};
        LCRGame lcrGame = new LCRGame(playerNames);

        GraphicalLCR lcr = new GraphicalLCR(lcrGame);
    }
}
