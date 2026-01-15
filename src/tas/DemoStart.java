package tas;

import tas.controller.StartseiteController;
import tas.model.StartseiteModell;
import tas.navigation.NavigationsHandler;
import tas.view.StartseiteView;

import javax.swing.*;

public class DemoStart {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame fenster = new JFrame("TAS – SEW Lernprogramm");
            fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenster.setSize(900, 520);
            fenster.setLocationRelativeTo(null);

            StartseiteModell modell = new StartseiteModell();
            StartseiteView ansicht = new StartseiteView();

            NavigationsHandler navigation = new NavigationsHandler() {
                public void oeffneFrageModus() {
                    JOptionPane.showMessageDialog(fenster, "Frage Modus");
                }
                public void oeffneQuizModus() {
                    JOptionPane.showMessageDialog(fenster, "Quiz Modus");
                }
                public void oeffneSpieleModus() {
                    JOptionPane.showMessageDialog(fenster, "Spiele Modus");
                }
                public void oeffneFragenpoolEditor() {
                    JOptionPane.showMessageDialog(fenster, "Fragenpool-Editor");
                }
            };

            StartseiteController controller =
                    new StartseiteController(modell, ansicht, navigation);

            fenster.setContentPane(controller.getAnsicht());
            fenster.setVisible(true);
        });
    }
}
