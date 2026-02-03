package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] input) {
        System.out.println("Selection Sort!!!");
        int l = input.length;

        for (int i = 0; i < l; i++) { //1st look to set lowest value
            int minimum = i;

            for(int o = i + 1; o < l; o++) { // 2nd loop
                if(input[o] < input[minimum]) { // 3rd loop to change value when input is less than minimum
                    minimum = o;
                }
            }
            int temp = input[minimum]; // values change
            input[minimum] = input[i];
            input[i] = temp;
        }
    }
}
