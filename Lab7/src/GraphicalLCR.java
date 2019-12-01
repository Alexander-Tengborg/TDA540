import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalLCR extends JFrame {
    private LCRGame lcrGame;

    JPanel mainPanel;

    JPanel playersPanel;
    JPanel dicePanel;
    JPanel actionsPanel;

    GraphicalLCR(LCRGame lcrGame) {
        super("LCR Game");

        this.lcrGame = lcrGame;
        this.setPreferredSize(new Dimension(250, 300));

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        playersPanel = new JPanel();
        dicePanel = new JPanel();
        actionsPanel = new JPanel();


        mainPanel.add(playersPanel, BorderLayout.NORTH);
        mainPanel.add(dicePanel, BorderLayout.CENTER);
        mainPanel.add(actionsPanel, BorderLayout.SOUTH);


        playersPanel.setBorder(BorderFactory.createTitledBorder("Players"));
        dicePanel.setBorder(BorderFactory.createTitledBorder("Dice"));
        actionsPanel.setBorder(BorderFactory.createTitledBorder("Actions"));

        updatePlayersPanel();
        updateDicePanel();

        JLabel actionLabel = new JLabel("Next player: " + this.lcrGame.getCurrentPlayer());

        JButton button1 = new JButton("Next round");
        JButton button2 = new JButton("Exit");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lcrGame.playTurn();

                updatePlayersPanel();
                updateDicePanel();
                updateActionsPanel();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); //Too 'crude'?
            }
        });

        actionsPanel.setLayout(new BorderLayout());

        actionsPanel.add(actionLabel, BorderLayout.NORTH);
        actionsPanel.add(button1, BorderLayout.CENTER);
        actionsPanel.add(button2, BorderLayout.SOUTH);

        this.add(mainPanel);

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    void updatePlayersPanel() {
        playersPanel.removeAll();

        for(Player player : this.lcrGame.getPlayers()) {
            JLabel label = new JLabel(String.format("<html>%s <br>Chips: %d</html>", player.getName(), player.getChips()));

            Color color = (player == this.lcrGame.getCurrentPlayer()) ? new Color(0, 255, 0) : new Color(255, 255, 255);

            label.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
            label.setBackground(color);
            label.setOpaque(true);

            playersPanel.add(label);
        }

        playersPanel.updateUI();
    }

    void updateDicePanel() {
        dicePanel.removeAll();

        //lcrGame.playTurn();
        if(this.lcrGame.getDice() != null) { //TODO temporary
            for(Die die : this.lcrGame.getDice()) {
                JLabel label = new JLabel(die.toString());
                dicePanel.add(label);
            }
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
