package com.restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * Custom JPanel representing a modern card with rounded corners and subtle border outline.
 */
public class CardPanel extends JPanel {
    private final Color borderColor;

    public CardPanel() {
        this(Color.WHITE, Color.GRAY);
    }

    public CardPanel(Color bgColor, Color borderColor) {
        setBackground(bgColor);
        this.borderColor = borderColor;
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
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        // Fill card body
        g2.setColor(getBackground());
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
