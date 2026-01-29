package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] input) {
        System.out.println("Selection Sort!!!");
        int l = input.length;

        for (int i = 0; i < l; i++) {
            int minimum = i;

            for(int o = i + 1; o < l; o++) {
                if(input[o] < input[minimum]) {
                    minimum = o;
                }
            }
            int temp = input[minimum];
            input[minimum] = input[i];
            input[i] = temp;
        }
    }
}
