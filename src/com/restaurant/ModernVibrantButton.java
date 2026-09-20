package com.restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

/**
 * Custom JButton with smooth anti-aliased rounded rectangle, hover transitions, and press state.
 */
public class ModernVibrantButton extends JButton {
    private final Color baseColor;
    private final Color hoverColor;
    private final Color pressedColor;
    private boolean isHovered = false;
    private boolean isPressed = false;

    public ModernVibrantButton() {
        this("Button", new Color(59, 130, 246));
    }

    public ModernVibrantButton(String text, Color baseColor) {
        super(text);
        this.baseColor = baseColor;
        this.hoverColor = brighten(baseColor, 0.15f);
        this.pressedColor = darken(baseColor, 0.15f);

        setFont(new Font("Segoe UI", Font.BOLD, 14));
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
        setPreferredSize(new Dimension(160, 42));
        setAlignmentX(Component.LEFT_ALIGNMENT);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                isPressed = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isPressed = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color renderColor = baseColor;
        if (isPressed) {
            renderColor = pressedColor;
        } else if (isHovered) {
            renderColor = hoverColor;
        }

        int width = getWidth();
        int height = getHeight();

        // Draw button shadow on hover
        if (isHovered && !isPressed) {
            g2.setColor(new Color(0, 0, 0, 30));
            g2.fill(new RoundRectangle2D.Float(2, 4, width - 4, height - 4, 12, 12));
        }

        // Draw button background
        g2.setColor(renderColor);
        g2.fill(new RoundRectangle2D.Float(0, 0, width, height - (isHovered ? 2 : 0), 12, 12));

        // Draw button text
        FontMetrics fm = g2.getFontMetrics(getFont());
        Rectangle textBounds = fm.getStringBounds(getText(), g2).getBounds();
        int x = (width - textBounds.width) / 2;
        int y = (height - textBounds.height) / 2 + fm.getAscent() - 2;

        g2.setFont(getFont());
        g2.setColor(getForeground());
        g2.drawString(getText(), x, y);

        g2.dispose();
    }

    private static Color brighten(Color color, float fraction) {
        int r = Math.min(255, (int) (color.getRed() + (255 - color.getRed()) * fraction));
        int g = Math.min(255, (int) (color.getGreen() + (255 - color.getGreen()) * fraction));
        int b = Math.min(255, (int) (color.getBlue() + (255 - color.getBlue()) * fraction));
        return new Color(r, g, b);
    }

    private static Color darken(Color color, float fraction) {
        int r = Math.max(0, (int) (color.getRed() * (1 - fraction)));
        int g = Math.max(0, (int) (color.getGreen() * (1 - fraction)));
        int b = Math.max(0, (int) (color.getBlue() * (1 - fraction)));
        return new Color(r, g, b);
    }
}
