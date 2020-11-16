import java.util.Arrays;

public class Arraylist {
    public int size, current;
    public int[] arr, newarr;
    //constructor to initialise array of 1 element.
    public Arraylist()
    {
        int[] arr = new int[1];
        size = 1;
        current = 0;
    }
    // Function to add element to the back of the array
    // we multiply the size of the array everytime it has reached the limit.
    public void add(int data) {
        if (size == current) {
            int[] newarr = new int[1 + size];

            //setting old array elemtns into new array
            for (int i = 0; i < size; i++) {
                newarr[i] = arr[i];
            }
        }
        arr = new int[newarr.length];
        arr = newarr;
        arr[current] = data;
        current++;
    }
    int atIndex(int index)
    {
        if (index < current)
        {
            return arr[index];
        }
        else
        {
            return 93486;
        }
    }

}
