package GUI.Arcade;

import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * A non-pixelated image icon!?
 */
public class HQImageIcon extends ImageIcon {
    public HQImageIcon(String path) {
        super(path);
    }

    @Override
    public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        super.paintIcon(c, g, x, y);
    }
}
