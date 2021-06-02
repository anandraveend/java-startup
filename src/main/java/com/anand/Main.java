package com.anand;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] i = IntStream.range(100,200).map(x->new Random().nextInt(x)).toArray();

        //Convert to boxed list
        List<Integer> arr = Arrays.stream(i).boxed().collect(Collectors.toList());

        //Extract sorted and uniq
        List<Integer> uniq = Arrays.stream(i).sorted().distinct().boxed().collect(Collectors.toList());

        //Reverse sort
        arr.sort(Comparator.reverseOrder());

        System.out.println(Arrays.stream(i).mapToObj(Integer::valueOf).collect(Collectors.toList()));
        System.out.println(arr);
        System.out.println(uniq);

        //Anonymous class
        Comparator eg = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };


//        List<Integer> test = Arrays.asList(1,13,3,4,64,5,2,3,4,5).subList(0,9);
        List<Long> test = new ArrayList();
        List<Long> ltest = new LinkedList();
        long size = 1000000;
        timer("start");
        for(long ii=1;ii<=size ; ii++){
            test.add(ii);
        }
        test.remove(100000);
        test.set(99999,1L);
        test.remove(Integer.valueOf(100000));
        test.sort(Comparator.reverseOrder());
        System.out.println("Array List:" + timer("end"));


        timer("start");
        for(long ii=1;ii<= size; ii++){
            ltest.add(ii);
        }
        ltest.remove(100000);
        test.set(99999,1L);
        ltest.remove(Integer.valueOf(100000));
        ltest.sort(Comparator.reverseOrder());
        System.out.println("Linked List :" + timer("end"));

        Set<String> lhs = new LinkedHashSet<String>();

    }
    private static long timeStart;
    private static long timeEnd;
    private static long timer(String phase){
        switch(phase){
            case "start":
                timeStart=System.currentTimeMillis();
                timeEnd = timeStart;
                break;
            case "end":
                timeEnd = System.currentTimeMillis();

        }
        return timeEnd-timeStart;
    }
}
