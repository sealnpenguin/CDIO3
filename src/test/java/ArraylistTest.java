import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArraylistTest {

    @org.junit.jupiter.api.Test
    void add() {
        Arraylist <Integer> k = new Arraylist<> ();
        Arraylist <String> s = new Arraylist<>();

        // integer array
        k.add(4);
        k.print();
        k.add(5);
        k.print();
        k.add(6);
        k.print();
        k.add(8);
        System.out.println(k.atIndex(2));
        //expects 420
        System.out.println(k.atIndex(44999));
        k.addAt(3, 25);
        //25 at index 3
        k.print();
        k.decrease(1);
        k.print();
        k.decrease(25);
        k.print();

        // String array
        s.add("zero");
        s.print();
        s.add("first");
        s.print();
        s.add("second");
        s.print();
        s.add("third");
        System.out.println(s.atIndex(2));
        //expects 420
        System.out.println(s.atIndex(44999));
        s.addAt(3, "twenty-five");
        //25 at index 3
        s.print();
        s.decrease(1);
        s.print();
        s.decrease(25);
        s.print();
    }
}