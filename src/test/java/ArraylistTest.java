import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArraylistTest {

    @org.junit.jupiter.api.Test
    void add() {
        Arraylist k = new Arraylist();

        k.add(10);
        for (int i = 0; i < k.size; i++)
        {
            System.out.print(k.atIndex(i));;
        }
        k.add(20);
        for (int i = 0; i < k.size; i++)
        {
            System.out.print(k.atIndex(i));
        }
        k.add(30);
        for (int i = 0; i < k.size; i++)
        {
            System.out.print(k.atIndex(i));
        }

    }
}