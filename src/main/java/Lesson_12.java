public class Lesson_12 {
    static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Ошибка данных
        String[][] incorrectDataArray = {
                {"1", "п", "3", "4"},
                {"5", "6", "о", "8"},
                {"к", "10", "11", "12"},
                {"13", "14", "15", "/и"}
        };

        // Ошибка размера
        String[][] incorrectSizeArray = {
                {"1", "2", "3"},
                {"5", "6", "7"},
                {"9", "10", "11"}
        };

        try {
            System.out.println("Сумма правильного массива: " + sumArrayElements(correctArray));
            System.out.println("Сумма массива с некорректными данными: " + sumArrayElements(incorrectDataArray));
            System.out.println("Сумма массива неправильного размера: " + sumArrayElements(incorrectSizeArray));
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных в массиве: " + e.getMessage());
        }

        try {
            generateArrayIndexOutOfBounds();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    public static int sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4x4, получено " + array.length + " строк");
        }

        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("Массив должен быть размером 4x4, найдена строка длиной " + row.length);
            }
        }

        int sum = 0;
        StringBuilder errors = new StringBuilder(); // Для сбора всех ошибок

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    if (errors.length() > 0) {
                        errors.append(", ");
                    }
                    errors.append("[").append(i).append("][").append(j).append("]='").append(array[i][j]).append("'");
                }
            }
        }

        if (errors.length() > 0) {
            throw new MyArrayDataException("Некорректные данные в ячейках: " + errors.toString());
        }

        return sum;
    }

    public static void generateArrayIndexOutOfBounds() {
        int[] arr = new int[5];
        int value = arr[10];
    }
}
