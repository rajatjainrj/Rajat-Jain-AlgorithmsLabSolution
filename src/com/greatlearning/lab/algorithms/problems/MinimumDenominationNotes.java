package com.greatlearning.lab.algorithms.problems;

import com.greatlearning.lab.algorithms.utils.MergeSort;

import java.util.Scanner;

/**
 * @author rajatjain on - 19-12-2021
 * @project labAlgorithms
 */
public class MinimumDenominationNotes {

    private final Scanner scanner;

    private int noOfCurrencyDenominations;
    private int[] currencyDenominations;
    int minimumDenominationNote;

    public MinimumDenominationNotes() {
        this.scanner = new Scanner(System.in);
    }

    private void inputCurrencyDenominations() {
        System.out.println("Enter the size of currency denominations - ");
        noOfCurrencyDenominations = scanner.nextInt();

        currencyDenominations = new int[noOfCurrencyDenominations];

        for (int i = 0; i < noOfCurrencyDenominations; i++) {
            System.out.println("Please enter " + (i + 1) + " note denomination - ");
            currencyDenominations[i] = scanner.nextInt();
        }
    }

    private int inputAmountToPay() {
        System.out.println("Enter the amount you want to pay - ");
        return scanner.nextInt();
    }

    private void findMinimumDenominationNotes(int amountToPay) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sortDescending(currencyDenominations, 0, noOfCurrencyDenominations - 1);
//        System.out.println("Descending Sorted Currency Denominations - " + Arrays.toString(currencyDenominations));
        minimumDenominationNote = currencyDenominations[currencyDenominations.length - 1];
        System.out.println("Your payment approach in order to give min no of notes will be - ");
        int remainderAmount = printMinimumDenominations(amountToPay);
        while (remainderAmount > 0) {
            remainderAmount = printMinimumDenominations(remainderAmount);
        }

    }

    // Returns remaining amount to pay
    private int printMinimumDenominations(int amountToPay) {
        int remainderAmount;
        int maxDenomination = minimumDenominationNote;
        for (int i = 0; i < noOfCurrencyDenominations; i++) {
            if (currencyDenominations[i] < amountToPay) {
                maxDenomination = currencyDenominations[i];
                break;
            }
        }
        int noOfNotes = 0;
        if (minimumDenominationNote > amountToPay) {
            noOfNotes++;
            remainderAmount = 0;
        } else {
            noOfNotes = amountToPay / maxDenomination;
            remainderAmount = amountToPay % maxDenomination;
        }
        System.out.println(maxDenomination + ":" + noOfNotes);
        return remainderAmount;
    }

    public static void main(String[] args) {
        MinimumDenominationNotes minimumDenominationNotes = new MinimumDenominationNotes();
        minimumDenominationNotes.inputCurrencyDenominations();

        int amountToPay = minimumDenominationNotes.inputAmountToPay();

        minimumDenominationNotes.findMinimumDenominationNotes(amountToPay);
    }

}
