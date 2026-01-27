package sorting;

public class InsertionSort implements Sorter {

    public void sort(int[] input) {
        System.out.println("Insertion Sort!!!");
        int n = input.length;

        for(int l = 1; l < n; l++) {
           int temp = input[l];
           int i = l - 1;

           while(i >=0 && input[i] > temp){
            input[i+1] = input[i];
            i = i -1;
           }
           input[i+1] = temp;
            }
        }
    }
