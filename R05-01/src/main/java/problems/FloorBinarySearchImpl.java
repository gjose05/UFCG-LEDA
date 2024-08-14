package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

    @Override
    public Integer floor(Integer[] array, Integer x) {
        if (array.length > 0){
            quickSortMedianOfThree(array, 0, array.length-1);
            if (x > array[0]){
                int floorIndex = binarySearch(array, 0, array.length-1, x);
                return array[floorIndex];
            }
        }
        return null;

    }

    private void quickSortMedianOfThree(Integer[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {

            findPivot(array, leftIndex, rightIndex);
            Util.swap(array, rightIndex/2, rightIndex-1);

            int pivotIndex = partition(array, leftIndex, rightIndex);

            quickSortMedianOfThree(array, leftIndex, pivotIndex - 1);
            quickSortMedianOfThree(array, pivotIndex + 1, rightIndex);
        }
    }

    private int partition(Integer[] array, int leftIndex, int rightIndex) {
        Integer pivot = array[leftIndex];
        int countIndex = leftIndex;
        
        for (int j = countIndex + 1; j <= rightIndex; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                countIndex++;
                Util.swap(array, countIndex, j);
            }
        }

        Util.swap(array, leftIndex, countIndex);
        return countIndex;
    }

    private void findPivot(Integer[] array, int leftIndex, int rightIndex) {
        int highest = leftIndex;
        int secondHighest = rightIndex/2;

        if(array[secondHighest].compareTo(array[highest]) >= 0){
            highest = secondHighest;
            secondHighest = leftIndex;
        }
        if(array[rightIndex].compareTo(array[highest]) >= 0){
            secondHighest = highest;
            highest = rightIndex;
        }

        Util.swap(array, rightIndex, highest);
        Util.swap(array, rightIndex/2, secondHighest);
    }

    private int binarySearch(Integer[] array,int leftIndex, int rightIndex, int x){
        if (leftIndex < rightIndex){    
            int middle = (leftIndex + rightIndex)/2;
            if (x == array[middle]) {
                return middle;
            }
            else if (x > array[middle]){
                return binarySearch(array, middle+1, rightIndex, x);
            }
            else if (x < array[middle])
                return binarySearch(array, leftIndex, middle-1, x);
        }
        return 0;
    }
}