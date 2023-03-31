//InsertionSort.Java
//Insertion Sort Using Arrays
//COMSC 340
//An algorithm that performs an Insertion Sort through Arrays

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class InsertionSort {

	public static void main(String[] args) { //A test run of the implemented program
		
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

    int[] a = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
        a[i] = list.get(i);
    }
        
        int [] a = {11,10,9,4,6}; //A starter array
		int [] b = shiftArray(a); //Shifting the array so that insertion sort works
		long begin = System.nanoTime();
		insertionSort(a.length, b); //Performing the insertion sort
		long end = System.nanoTime();
		long time = end - begin;
		System.out.println(Arrays.toString(b)); //Printing the results
		System.out.println("Insertion Sort took " + time + " nano seconds to run");
		
	}
	
	static int[] shiftArray (int [] S) { //A method that shifts the array so that Insertion Sort works
		int a[] = new int[S.length+1];
		for (int i = 1; i <= a.length-1; i++) {
			a[i] = S[i-1];
		}
		return a;
	}
	
	static void insertionSort (int n, int[] S) { //The Insertion Sort program, assumes that the array is indexed from 1 to n
		int x;
		for (int i = 2; i<= n; i++) {
			x = S[i];
			int j = i-1;
			while (j > 0 && S[j] > x) {
				S[j + 1] = S[j];
				j--;
			}
			S[j + 1] = x;
		}
	}
}
