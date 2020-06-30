package Lesson5;

import java.util.Arrays;

public class Main {
    private static final int array_size = 10000000;
    private static float[] array = new float[array_size];
    private static final int number_threads = 4;
    private static final int array_number = array_size / number_threads;

    private void firstArr() {

        //заполняем массив единицами
        Arrays.fill(array, 1f);

        //засекаем время выполнения операции
        long a = System.currentTimeMillis();

        for (int i = 0; i < array_size; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        //считаем время окончания заполнения массива
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения первого метода: "+ (end - a) + " секунд.");
    }

    private void secondArr() {
        Thread[] threads = new Thread[number_threads];

        //заполняем массив единицами
        Arrays.fill(array, 1);

        //засекаем время выполнения операции
        long a = System.currentTimeMillis();

        //делим массив на массивы
        float[][] newArr = new float[number_threads][array_number];
        for (int i = 0; i < number_threads; i++) {
            System.arraycopy(array, i * array_number, newArr[i], 0, array_number);
        }
        //засекаем время на разделение массива
        long split = System.currentTimeMillis();
        System.out.println("Время разделения массива: "+ (split - a) + " секунд.");

        //делаем вычисления в 4х потоках, ждем окончания вычисления
        for(int i = 0; i < number_threads; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> calSecondArr(newArr, finalI));
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //считаем время на заполнение массива
        long concat = System.currentTimeMillis();

        //соединим оба массива в один
        for (int i = 0; i < number_threads; i++) {
            System.arraycopy(newArr[i], 0, array, i* array_number, array_number);
        }
        //считаем время окончания объединения
        long end = System.currentTimeMillis();
        System.out.println("Время объединения массива: "+ (end - concat) + " секунд.");
        System.out.println("Время выполнения второго метода: "+ (end - a) + " секунд.");
    }

    private void calSecondArr(float[][] arr, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < array_number; i++) {
            arr[n][i] = (float) (arr[n][i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения "+(n+1)+"-го потока: "+ (end - start) + " секунд.");
    }

    public static void main(String[] args) {
        Main threads = new Main();
        threads.firstArr();
        threads.secondArr();
    }
}
