package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T> implements SortEvent<T> {
    private final int index1;
    private final int index2;


    public CompareEvent(int i, int j) {
        this.index1 = i;
        this.index2 = j;
    }
    
    public void apply(T[] arr){
        return;
    }

    public List<Integer> getAffectedIndices(){
        List<Integer> list = new ArrayList<>();
        list.add(index1);
        list.add(index2);
        return list;
    }

    public boolean isEmphasized(){
        return false;
    }


}
