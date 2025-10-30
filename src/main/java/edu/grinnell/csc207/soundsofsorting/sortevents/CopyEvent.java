package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T>{
    private final int destinationIndex;
    private final T value;

    public CopyEvent(int destinationIndex, T value) {
        this.destinationIndex = destinationIndex;
        this.value = value;
    }

    public void apply(T[] arr){
        arr[destinationIndex] = value;
    }

    public List<Integer> getAffectedIndices(){
        return List.of(destinationIndex);
    }

    public boolean isEmphasized(){
        return true;
    }


}
