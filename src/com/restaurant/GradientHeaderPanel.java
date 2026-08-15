package com.restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * Custom JPanel with smooth linear gradient background and rounded corners.
 */
public class GradientHeaderPanel extends JPanel {
    private final Color startColor;
    private final Color endColor;

    public GradientHeaderPanel(Color startColor, Color endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        GradientPaint gradient = new GradientPaint(0, 0, startColor, width, 0, endColor);
        g2.setPaint(gradient);
        g2.fill(new RoundRectangle2D.Float(0, 0, width, height, 16, 16));

        g2.dispose();
        super.paintComponent(g);
    }
}
