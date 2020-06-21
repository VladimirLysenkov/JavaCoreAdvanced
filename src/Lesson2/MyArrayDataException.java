package Lesson2;

public class MyArrayDataException extends RuntimeException {
    int i, j;

    public MyArrayDataException(int i, int j) {
        super("Произошла ошибка при суммировании элементов массива. Смотри на строку " + i + ", столбец: " + j);
        this.i = i;
        this.j = j;
    }
}
