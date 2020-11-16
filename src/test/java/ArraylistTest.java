import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArraylistTest {

    @org.junit.jupiter.api.Test
    void add() {
        Arraylist k = new Arraylist();

        k.add(4);
        k.print();
        k.add(5);
        k.print();
        k.add(6);
        k.print();

        k.add(8);
        k.atIndex(2);
        //expects 420
        k.atIndex(44999);
        k.addAt(3, 25);
        //25 at index 3
        k.print();
        k.decrease(1);
        k.print();
        k.decrease(25);
        k.print();




    }
}