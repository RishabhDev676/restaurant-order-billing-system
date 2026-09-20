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

    public GradientHeaderPanel() {
        this(Color.WHITE, Color.GRAY);
    }

    public GradientHeaderPanel(Color startColor, Color endColor) {
        this.startColor = new Color(startColor.getRed(), startColor.getGreen(), startColor.getBlue(), 215);
        this.endColor = new Color(endColor.getRed(), endColor.getGreen(), endColor.getBlue(), 215);
        setOpaque(false);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
