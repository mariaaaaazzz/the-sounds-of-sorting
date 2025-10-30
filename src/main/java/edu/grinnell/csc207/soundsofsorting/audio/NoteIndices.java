package edu.grinnell.csc207.soundsofsorting.audio;

import java.util.Arrays;
import java.util.Collections;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
    private Integer[] notes;

    private boolean[] highlighted;

    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        initializeAndShuffle(n);
    }
    
    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size.  The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        if (n <= 0) {
            this.notes = new Integer[0];
            this.highlighted = new boolean[0];
            return;
        }

        this.notes = new Integer[n];
        for (int i = 0; i < n; i++) {
            this.notes[i] = i;
        }

        for (int i = n - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            int temp = this.notes[i];
            this.notes[i] = this.notes[j];
            this.notes[j] = temp;
        }

        this.highlighted = new boolean[n];
        Arrays.fill(this.highlighted, false);
    }
    
    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() { 
        return this.notes;
    }
    
    /**
     * Highlights the given index of the note array
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        if (index < 0 || index >= this.highlighted.length) {
            return; 
        }
        this.highlighted[index] = true;
    }
    
    
    /**
     * @param index the index to check
     * @return true if the given index is highlighted
     */
    public boolean isHighlighted(int index) {
        if (index < 0 || index >= this.highlighted.length) {
            return false;
        }
        // so that we could check it later
        return this.highlighted[index];
    }

    
    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
       Arrays.fill(this.highlighted, false);
    }
}
