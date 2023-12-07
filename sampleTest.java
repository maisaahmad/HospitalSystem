package com.mycompany.hospitalsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class sampleTest {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\huawei\\Documents\\NetBeansProjects\\HospitalSystem\\sample_data.txt");
        Scanner scan=new Scanner(file);

        ArrayList<String> list=new ArrayList<>();
        int i=0;
        while(scan.hasNext()){
            String name=scan.nextLine();
            list.add(name);
        }

        Scanner in=new Scanner(System.in);
        System.out.println("""
                Choose the method of sorting you want to use:
                1- Merge Sort
                2- Insertion Sort
                """);
        int choice=in.nextInt();
        switch (choice) {
            case 1:
                double start1 = System.currentTimeMillis();
                MergeSort ms = new MergeSort();
                ms.mergeSort(list);
                double end1 = System.currentTimeMillis();
                double elapsed1 = end1 - start1;
                System.out.println("How long it takes to run merge sort: " + elapsed1 + "ms");
                break;
            case 2:
                double start2 = System.currentTimeMillis();
                InsertionSort is = new InsertionSort();
                is.insertionSort(list);
                double end2 = System.currentTimeMillis();
                double elapsed2 = end2 - start2;
                System.out.println("How long it takes to run insertion sort: " + elapsed2 + "ms");
                break;
        }

        System.out.println("""
                Choose the method of searching you want to use:
                1- Linear Search
                2- Binary Search
                """);
        choice=in.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter the name you want to search for: ");
                String junk= in.nextLine();
                String name= in.nextLine();
                double start1 = System.currentTimeMillis();
                if (linearSearch(list,name)!= -1) {
                    System.out.println("Found in the list!");
                } else {
                    System.out.println("Name not found!");
                }
                double end1 = System.currentTimeMillis();
                double elapsed1 = end1 - start1;
                System.out.println("How long it takes to find name using linear search: " + elapsed1 + "ms");
                break;
            case 2:
                System.out.println("Enter the name you want to search for: ");
                junk= in.nextLine();
                name= in.nextLine();
                double start2 = System.currentTimeMillis();
                if (binarySearch(list,name)!= -1) {
                    System.out.println("Found in the list!");
                } else {
                    System.out.println("Name not found!");
                }
                double end2 = System.currentTimeMillis();
                double elapsed2 = end2 - start2;
                System.out.println("How long it takes to find name using binary search: " + elapsed2 + "ms");
                break;
        }
        PrintWriter outputFile=new PrintWriter("C:\\Users\\huawei\\Documents\\NetBeansProjects\\HospitalSystem \\sample data.txt");
        for(i=0;i< list.size();i++){
            outputFile.println(list.get(i));
        }//for
        outputFile.close();//closing the file
    }

    public static int binarySearch(ArrayList<String> list, String target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = target.compareToIgnoreCase(list.get(mid));

            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
    public static int linearSearch(ArrayList<String> list, String target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }
}

class StringComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        return s1.compareToIgnoreCase(s2);
    }
}