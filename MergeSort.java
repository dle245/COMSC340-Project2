//MergeSort.java
//Author: Connor Mulberry
//COMSC 340
//Project 2

public class MergeSort {

public static void main(String[] args) {
    int [] S = {6,3,1,14,2,13,5,9,8,4};
    int n = 10;
    MergeSort(n, S);
    System.out.println(S.toString());
}

static void MergeSort (int n, int [] S) {
    if (n > 1) {
        final int h = (n/2);
        int size = h;
        int m = n-h;
        int[] U = new int[h];
        int[] V = new int[m];
            for(int i = 0; i < h; i++) {
                U[i] = S[i];
            }
            for(int i = 0; i < m; i++) {
                V[i] = S[h+1];
            }
        MergeSort(h, U);
        MergeSort(m, V);
        merge(h, m, U, V, S);
    }
}

static void merge (int h, int m, final int[] U, final int[] V, int[] S) {
   
   //index values
    int i = 1;
    int j = 1;
    int k = 1;

    while(i <= h && j <= m) {
        if(U[i] < V[j]) {
            S[k] = U[i];
            i++;
        }
        else {
            S[k] = V[j];
            j++;
        }
        k++;
    }

    if (i>h) {
        while (i > h) { 
            S[k] = V[j];
            j++;
            k++;
        }
    } else {
        while (i <= h) {
            U[i] = S[k];
            i++;
            k++;
        }

    }
}
}
