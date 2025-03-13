import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AntiPattern {

    // 1 - God Object - класс берет на себя слишком много обязанностей
    // Этот класс и генерирует числа, и сортирует их, и выводит результат.
    private List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        AntiPattern sorter = new AntiPattern();

        sorter.generateNumbers();
        sorter.printNumbers();
        sorter.sortNumbers();
        sorter.softCodeSort(true);
        sorter.printNumbers();
        sorter.findMin();
        sorter.overengineeredSort();
    }

    public void generateNumbers() {
        // 2 - Magic numbers - использование чисел без объяснения их смысла
        // Почему 10 чисел? Почему границы от 0 до 100? Непонятно.
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100));
        }
    }

    public void sortNumbers() {
        // 3 - Reinventing the wheel - реализация своей сортировки вместо использования Collections.sort()
        int n = numbers.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (numbers.get(j) > numbers.get(j + 1)) {
                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }
    }

    public void printNumbers() {
        // 4- Cryptic code - использование непонятных названий переменных
        // Что такое "o" ? Лучше назвать list или sortedNumbers.
        for (Integer o : numbers) {
            System.out.print(o + " ");
        }
        System.out.println();
    }


    // 5 - Copy and Paste Programming - дублирование кода
    // Этот метод повторяет логику generateNumbers, но делает то же самое другим способом.
    // 6 - Hard code - жестко заданные данные вместо гибких решений
    // Здесь массив жестко прописан, вместо того чтобы передавать параметры.
    public void HardNumbers() {
        numbers.clear();
        numbers.add(3);
        numbers.add(1);
        numbers.add(4);
        numbers.add(1);
        numbers.add(5);
        numbers.add(9);
    }

    // 7 - Soft code - чрезмерная гибкость вместо простых решений
    // Мы читаем параметры сортировки из списка, который можно менять, но логика остается той же.
    public void softCodeSort(boolean ascending) {
        int n = numbers.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if ((ascending && numbers.get(j) > numbers.get(j + 1)) ||
                        (!ascending && numbers.get(j) < numbers.get(j + 1))) {
                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }
    }

    // 8 - Lava flow - мертвый код, который уже не нужен, но остался в проекте
    // Этот метод нигде не используется, но остается в коде.
    public void unusedMethod() {
        System.out.println("Я тут просто остался с прошлой версии кода...");
    }

    // 9 - Soap bubble - избыточный код, который делает вид, что сложный и полезный, но на деле не нужен
    // Здесь добавлены лишние проверки и переменные, но они не улучшают работу сортировки.
    public void overengineeredSort() {
        int n = numbers.size();
        boolean sorted = false;
        int pass = 0;

        while (!sorted) {
            sorted = true;
            for (int j = 0; j < n - 1 - pass; j++) {
                if (numbers.get(j) > numbers.get(j + 1)) {
                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                    sorted = false;
                }
            }
            pass++; // Лишняя переменная, которая не дает реального улучшения.
        }
    }


    //10-  Creeping featurism - добавление ненужного функционала
    // Здесь добавлен метод для поиска минимального элемента, который не нужен для сортировки.
    public int findMin() {
        int min = Integer.MAX_VALUE;
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
