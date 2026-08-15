package com.restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * Custom JPanel representing a modern card with rounded corners and subtle border outline.
 */
public class CardPanel extends JPanel {
    private final Color bgColor;
    private final Color borderColor;

    public CardPanel(Color bgColor, Color borderColor) {
        this.bgColor = bgColor;
        this.borderColor = borderColor;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        // Fill card body
        g2.setColor(bgColor);
        g2.fill(new RoundRectangle2D.Float(0, 0, width - 1, height - 1, 16, 16));

        // Draw subtle rounded border
        if (borderColor != null) {
            g2.setColor(borderColor);
            g2.setStroke(new BasicStroke(1.2f));
            g2.draw(new RoundRectangle2D.Float(0, 0, width - 1, height - 1, 16, 16));
        }

        g2.dispose();
        super.paintComponent(g);
    }
}
