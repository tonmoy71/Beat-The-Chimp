package com.fahad.beatthechimp.model;

import com.fahad.beatthechimp.utility.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by fahad on 3/1/17.
 */

public class Data {

    private int size;
    private List<String> grid = new ArrayList<String>(Collections.nCopies(Constant.Value.GRID_SIZE, "-10"));
    private List<Integer> index = new ArrayList<>(Constant.Value.GRID_SIZE);


    private void initIndex() {
        for (int i = 0; i < index.size(); i++) {
            index.add(i);
        }
    }

    public List<String> getGrid() {
        return grid;
    }

    public Data(int size) {
        this.size = size;
        initIndex();
        initGrid(size);
    }

    private void initGrid(int size) {
        List<String> Value = Arrays.asList("1","2","3","4","5","6","7","8","9","10");
        index = RandomList(Constant.Value.GRID_SIZE);

        for (int i = 0; i < Value.size(); i++) {
            grid.set(index.get(i), Value.get(i));
        }

    }


    public List<Integer> RandomList(int sz) {
        List<Integer> list = new ArrayList<Integer>(sz);
        List<Integer> store = new ArrayList<Integer>(sz);
        for (int i = 1; i <= sz; i++) {
            list.add(i);
        }

        Random random = new Random();
        while (list.size() > 0) {
            int index = random.nextInt(list.size());
            store.add(list.remove(index));
        }
        return store;
    }
}
