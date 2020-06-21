package Lesson2;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int row;
        int column;
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите размер двумерного строкового массива размером 4х4. Кол-вол строк и столбоц в массиве:");
        row = sc.nextInt();
        column = sc.nextInt();

        String[][] myArray = new String[row][column];
        try {
            fillArr(myArray, sc, row, column);
            System.out.println("Сумма массива: " + sumArr(myArray, row, column));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static void fillArr(String[][] array, Scanner sc, int row, int column) {
        if (row != 4 || column != 4) throw new MyArraySizeException(row, column);
        System.out.println("Заполняем массив:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println("Строка: " + i + " столбец: " + j);
                array[i][j] = sc.next();
            }
        }
        printArr(array);
        sumArr(array, row, column);
    }

    private static int sumArr(String[][] array, int row, int column) {
        int sum = 0;
        int[][] arrayInt = new int[row][column];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    arrayInt[i][j] = Integer.parseInt(array[i][j]);
                    sum += arrayInt[i][j];
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        printArrInt(arrayInt);
        return sum;
    }

    private static void printArr(String[][] array) {
        for (String[] strings : array) {
            for (String string : strings) {
                System.out.print(" " + string);
            }
            System.out.println();
        }
    }

    private static void printArrInt(int[][] array) {
        System.out.println("Получился массив целых чисел:");
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(" " + anInt);
            }
            System.out.println();
        }
    }
}