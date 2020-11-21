package Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrTest {

    @Test
    void add() {
    }

    @Test
    void atIndex() {
    }

    @Test
    void addAt() {
    }

    @Test
    void print() {
    }

    @Test
    void decrease() {
    }

    @Test
    void removeAt() {
        DynamicArr<Integer> arr = new DynamicArr<Integer>();
        arr.add(5);
        arr.add(15);
        System.out.println(arr.toString());
        arr.removeAt(2);
        System.out.println(arr.toString());
    }
}