package com.greatlearning.lab.algorithms.utils;

/**
 * @author rajatjain on - 19-12-2021
 * @project labAlgorithms
 */
public class MergeSort {

    public void sortDescending(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            sortDescending(array, left, mid);
            sortDescending(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int leftArrayLen = mid - left + 1;
        int rightArrayLen = right - mid;

        int[] leftArray = new int[leftArrayLen];
        int[] rightArray = new int[rightArrayLen];

        for (int i = 0; i < leftArrayLen; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < rightArrayLen; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int arrayIndex = left;
        while (i < leftArrayLen && j < rightArrayLen) {
            if (leftArray[i] >= rightArray[j]) {
                array[arrayIndex] = leftArray[i];
                i++;
            } else {
                array[arrayIndex] = rightArray[j];
                j++;
            }
            arrayIndex++;
        }
        while (i < leftArrayLen) {
            array[arrayIndex] = leftArray[i];
            i++;
            arrayIndex++;
        }

        while (j < rightArrayLen) {
            array[arrayIndex] = rightArray[j];
            j++;
            arrayIndex++;
        }
    }

}
