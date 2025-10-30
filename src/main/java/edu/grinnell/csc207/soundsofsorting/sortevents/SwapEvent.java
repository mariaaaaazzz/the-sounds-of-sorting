package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T>{
    private int index1;
    private int index2;

    public SwapEvent(int i, int j) {
    this.index1 = i;
    this.index2 = j;
    }

    public void apply(T[] arr){
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public List<Integer> getAffectedIndices(){
        List<Integer> list = new ArrayList<>();
        list.add(index1);
        list.add(index2);
        return list;
    }

    public boolean isEmphasized(){
        return true;
    }

}
