package Lesson2;

public class MyArraySizeException extends RuntimeException {
    int row, column;

    public MyArraySizeException(int row, int column) {
        super("Произошла ошибка заполнения массива. Размер массива должен быть 4х4. Сейчас строк " + row + ", столбцов: " + column);
        this.row = row;
        this.column = column;
    }
}
