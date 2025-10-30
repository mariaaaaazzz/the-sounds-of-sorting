package edu.grinnell.csc207.soundsofsorting.rendering;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import edu.grinnell.csc207.soundsofsorting.audio.NoteIndices;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    @SuppressWarnings("unused")
    private NoteIndices notes;
   
    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     * @param notes the note indices 
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }




    /**
     * Draws the current state of the NoteIndices array on the panel.
     * @param g the Graphics object used for drawing
     */
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        Integer[] arr = notes.getNotes();
        int width = getWidth();
        int height = getHeight();
        int n = arr.length;
        if (n == 0) return;

        int barWidth = width / n;
        int maxValue = n - 1;

        for (int i = 0; i < n; i++) {
            int barHeight = (int) ((arr[i] / (double) maxValue) * height);

            int blue = (int) (150 + 100.0 * arr[i] / maxValue);
            int green = (int) (200 - 150.0 * arr[i] / maxValue);
            int red = 50;

            
            if (notes.isHighlighted(i)) {
                g.setColor(new java.awt.Color(30, 144, 255)); 
            } else {
                g.setColor(new java.awt.Color(red, green, blue));
            }

            g.fillRect(i * barWidth, height - barHeight, barWidth - 2, barHeight);
        }
    }
}
