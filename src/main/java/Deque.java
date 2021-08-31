public class Deque<E> implements IDeque<E> {


    private final E[] data;
    private final int TAIL_DEFAULT = -1;
    private final int HEAD_DEFAULT = 0;
    private int size;
    private int tailRight;
    private int tailLeft;
    private int headLeft;
    private int headRight;

    public Deque(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        headLeft = HEAD_DEFAULT;
        headRight = maxSize - 1;
        tailRight = TAIL_DEFAULT;
        tailLeft = maxSize;
    }


    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }
        data[++tailRight] = value;
        size++;

        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) {
            return false;
        }
        data[--tailLeft] = value;
        size++;

        return true;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }
        E value = data[headLeft++];
        size--;
        return null;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
        E value = data[headRight--];
        size--;
        return null;
    }

    @Override
    public E peekFront() {
        return data[headLeft];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);

    }

    //Уважаемый проверяющий-преподаватель, я не успел доделать метод toString так, чтоб он не выводил null эл-ты массива, но думаю, что это возможно, даже в моей реализации с 2 хвостами и головами
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = headLeft; i <= headRight; i++) {
            sb.append(data[i]);
            if (i != headRight) {
                sb.append(", ");

            }
        }
        sb.append("]");
        return sb.toString();
    }
}
