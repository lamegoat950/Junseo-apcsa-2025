package sorting;

public class InsertionSort implements Sorter {

    public void sort(int[] input) {
        System.out.println("Insertion Sort!!!");
        int n = input.length; // holds length of input

        for(int l = 1; l < n; l++) { // 1st loop for leftmost number
        int temp = input[l];
           int i = l - 1;

           while(i >=0 && input[i] > temp){ //2nd loop to change value with leftmost value if input > temp
            input[i+1] = input[i];
            i = i -1;
           }
           input[i+1] = temp;
            }
        }
    }
