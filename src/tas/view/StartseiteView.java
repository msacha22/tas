package tas.view;

import javax.swing.*;
import java.awt.*;

public class StartseiteView extends JPanel {

    // Farben
    public static final Color HINTERGRUND = new Color(0xF6E6D3);
    public static final Color BRAUN = new Color(0x5A3A22);

    // Button-Größen
    private static final Dimension KLEIN_BUTTON = new Dimension(220, 48);
    private static final Dimension GROSS_BUTTON = new Dimension(520, 56);

    // UI-Komponenten
    private final JLabel titelLabel =
            new JLabel("", SwingConstants.CENTER);
    private final JLabel sloganLabel =
            new JLabel("", SwingConstants.CENTER);

    private final AbgerundeterButton frageButton =
            new AbgerundeterButton("", 18);
    private final AbgerundeterButton quizButton =
            new AbgerundeterButton("", 18);
    private final AbgerundeterButton spieleButton =
            new AbgerundeterButton("", 18);
    private final AbgerundeterButton editorButton =
            new AbgerundeterButton("", 22);

    public StartseiteView() {

        // ===== Fonts (HIER ist es korrekt) =====
        titelLabel.setFont(view.AppFonts.TITEL);
        sloganLabel.setFont(view.AppFonts.TEXT);

        frageButton.setFont(view.AppFonts.BUTTON);
        quizButton.setFont(view.AppFonts.BUTTON);
        spieleButton.setFont(view.AppFonts.BUTTON);
        editorButton.setFont(view.AppFonts.BUTTON);

        // ===== Farben =====
        setBackground(HINTERGRUND);

        frageButton.setBackground(new Color(0xD9D2C6));
        quizButton.setBackground(new Color(0xD9D2C6));
        spieleButton.setBackground(new Color(0xD9D2C6));
        editorButton.setBackground(BRAUN);

        frageButton.setForeground(Color.BLACK);
        quizButton.setForeground(Color.BLACK);
        spieleButton.setForeground(Color.BLACK);
        editorButton.setForeground(Color.WHITE);

        // ===== Größen =====
        frageButton.setPreferredSize(KLEIN_BUTTON);
        quizButton.setPreferredSize(KLEIN_BUTTON);
        spieleButton.setPreferredSize(KLEIN_BUTTON);
        editorButton.setPreferredSize(GROSS_BUTTON);

        // ===== Layout =====
        setLayout(new GridBagLayout());

        JPanel inhalt = new JPanel(new GridLayout(3, 1, 0, 18));
        inhalt.setOpaque(false);

        inhalt.add(titelPanel());
        inhalt.add(sloganPanel());
        inhalt.add(buttonPanel());

        add(inhalt);
    }

    private JPanel titelPanel() {
        JPanel p = new JPanel(new GridLayout(1, 1));
        p.setOpaque(false);
        p.add(titelLabel);
        return p;
    }

    private JPanel sloganPanel() {
        JPanel p = new JPanel(new GridLayout(1, 1));
        p.setOpaque(false);
        p.add(sloganLabel);
        return p;
    }

    private JPanel buttonPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 0, 14));
        panel.setOpaque(false);

        JPanel obereReihe =
                new JPanel(new FlowLayout(FlowLayout.CENTER, 28, 0));
        obereReihe.setOpaque(false);

        obereReihe.add(frageButton);
        obereReihe.add(quizButton);
        obereReihe.add(spieleButton);

        JPanel untereReihe =
                new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        untereReihe.setOpaque(false);
        untereReihe.add(editorButton);

        panel.add(obereReihe);
        panel.add(untereReihe);

        return panel;
    }

    // ===== Setter (Controller) =====
    public void setTitel(String text) {
        titelLabel.setText(text);
    }

    public void setSlogan(String text) {
        sloganLabel.setText(text);
    }

    // ===== Getter (Controller) =====
    public JButton getFrageButton() {
        return frageButton;
    }

    public JButton getQuizButton() {
        return quizButton;
    }

    public JButton getSpieleButton() {
        return spieleButton;
    }

    public JButton getEditorButton() {
        return editorButton;
    }
}
