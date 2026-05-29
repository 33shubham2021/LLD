package concurrency.merge_sort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    List<Integer> list;
    ExecutorService es;
    public Sorter(List<Integer> list, ExecutorService es) {
        this.list = list;
        this.es = es;
    }


    @Override
    public List<Integer> call() throws Exception {
        if (this.list.size() <= 1){
            return this.list;
        }
        int size = this.list.size();
        int mid = size / 2;
        List<Integer> left = this.list.subList(0, mid);
        List<Integer> right = this.list.subList(mid, this.list.size());

        Sorter leftSortingTask = new Sorter(left, this.es);
        Sorter rightSortingTask = new Sorter(right, this.es);

        Future<List<Integer>> sortedLeftArrayFuture = es.submit(leftSortingTask);
        Future<List<Integer>> sortedRightArrayFuture =  es.submit(rightSortingTask);

        List<Integer> sortedLeftArray = sortedLeftArrayFuture.get();
        List<Integer> sortedRightArray = sortedRightArrayFuture.get();

        int i= 0;
        int j = 0;

        List<Integer> sortedArray = new ArrayList<>();
        while (i < sortedLeftArray.size() && j < sortedRightArray.size()) {
            if (sortedLeftArray.get(i) <= sortedRightArray.get(j)) {
                sortedArray.add(sortedLeftArray.get(i));
                i += 1;
            } else {
                sortedArray.add(sortedRightArray.get(j));
                j += 1;
            }
        }

        while (i < sortedLeftArray.size()) {
            sortedArray.add(sortedLeftArray.get(i));
            i += 1;
        }

        while (j < sortedRightArray.size()) {
            sortedArray.add(sortedRightArray.get(j));
            j += 1;
        }

        return sortedArray;
    }
}
