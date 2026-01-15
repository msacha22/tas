package tas.view;

import javax.swing.*;
import java.awt.*;

public class AbgerundeterButton extends JButton {

    private final int radius;

    public AbgerundeterButton(String text, int radius) {
        super(text);
        this.radius = radius;
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setMargin(new Insets(10, 18, 10, 18));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color farbe = getBackground();
        if (getModel().isPressed()) farbe = farbe.darker();
        else if (getModel().isRollover()) farbe = farbe.brighter();

        g2.setColor(farbe);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        FontMetrics fm = g2.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;

        g2.setColor(getForeground());
        g2.drawString(getText(), x, y);

        g2.dispose();
    }
}
