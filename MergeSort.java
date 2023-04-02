//Mergesort.java
//Author: Connor Mulberry
//COMSC 340
//Project 2

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MergeSort {
    static int comparisons;

public static void main(String[] args) {

    ArrayList<Integer> list = new ArrayList<Integer>();

    //Your test file
    String fileName = "random5k.txt";

    try {
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    int[] S = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
        S[i] = list.get(i);
    }
    int n = S.length;
    long start = System.nanoTime();
    MergeSort(n, S);
    long finish = System.nanoTime();
    long elapsed = finish-start;
    System.out.println(Arrays.toString(S));
    System.out.println("Time: " + elapsed + " nanoseconds");
    System.out.println("Comparisons: " + comparisons);
    
}
 
static void MergeSort (int n, int [] S) {
    if (n > 1) {
        comparisons++;
        final int h = (n/2);
        int m = n-h;
        int[] U = new int[h];
        int[] V = new int[m];
            for(int i = 0; i < h; i++) {
                comparisons++;
                U[i] = S[i];
            }
            for(int i = 0; i < m; i++) {
                comparisons++;
                V[i] = S[h+i];
            }
        MergeSort(h, U);
        MergeSort(m, V);
        merge(h, m, U, V, S);
    }
}

static void merge (int h, int m, final int[] U, final int[] V, int[] S) {
   //index values
    int i = 0;
    int j = 0;
    int k = 0;

    while(i < h && j < m) {
        comparisons++;
        comparisons++;
        if(U[i] < V[j]) {
            comparisons++;
            S[k] = U[i];
            i++;
        }
        else {
            S[k] = V[j];
            j++;
        }
        k++;
    }
    if (i >= h) {
        comparisons++;
        for (int x = j; x < m; x++) {
            comparisons++;
            S[k] = V[x];
            k++;
        }
    } else {
        for (int x = i; x < h; x++) {
            comparisons++;
            S[k] = U[x];
            k++;
        }
    }
}
}

