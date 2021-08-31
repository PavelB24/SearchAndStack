import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Ищет по заданию, одно пропущенное число. Если пропущено 2 числа, возвращает -1
        int[] arr = {1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 19, 20, 21};
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
        System.out.println(toFind(arr));
        System.out.println(toFind(arr2));
        System.out.println(toFind(arr3));
        Deque<Integer> deque = new Deque<>(6);

        deque.insertLeft(101);
        deque.insertLeft(102);
        deque.insertLeft(103);
        deque.insertLeft(104);
        deque.display();
        deque.removeLeft();
        deque.removeLeft();
        deque.removeLeft();
        deque.removeLeft();
        deque.display();
        deque.removeRight();
        deque.removeRight();
        deque.display();
        deque.insertRight(200);
        deque.insertRight(201);
        deque.display();
        deque.removeRight();
        deque.removeRight();
        deque.display();





    }

    private static int toFind(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int base = 0;
        if (arr.length == 0) {
            return 1;
        }
        while (end >= start) {
            base = (start + end) / 2;
            if (arr[base] == arr[end]) {
                if (arr[base] != base + 1) {
                    return arr[base] - 1;
                } else return arr[base] + 1;
            } else if (arr[base] > base + 1) {
                end = base - 1;
            } else if (arr[base] == base + 1) {
                start = base + 1;
            }
        }
        return -1;
    }
}
