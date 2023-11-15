package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        StringListServiceImpl arrayList = new StringListServiceImpl();

        arrayList.add("firstElement");
        arrayList.add("secondElement");
        arrayList.add("three");
        arrayList.add("four");
        arrayList.add(0,"newValue");
//        arrayList.add(-1,"new");
//        arrayList.set(1, "second");
        arrayList.remove("three");
        arrayList.remove(1);
//        arrayList.remove("three");
//        System.out.println(arrayList.contains("firstElement"));
//        System.out.println(arrayList.indexOf("firstElement"));
//        System.out.println(arrayList.lastIndexOf("firstElement"));
//        System.out.println(arrayList.get(0));
//        System.out.println(arrayList.size());
//        System.out.println(arrayList.isEmpty());
//        arrayList.clear();
        System.out.println(Arrays.stream(arrayList.toArray()).collect(Collectors.joining(", ")));
    }
}