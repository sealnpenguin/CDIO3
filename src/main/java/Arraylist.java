/*
Hvis man har brug for lidt oplæsning til templates så kig nedenstående link
reference brugt: https://www.geeksforgeeks.org/generics-in-java/
 */

public class Arraylist<T> {
    public int size, current;
    private T[]  arr;
    //constructor to initialise array of 1 element.
    public Arraylist()
    {
        arr = (T[])new Object[1];
        size = 1;
        current = 0;
    }
    // Function to add element to the back of the array
    // we multiply the size of the array everytime it has reached the limit.
    public void add(T data) {
        if (size == current) {
            T[] newarr =(T[])new Object[1 + size];

            //setting old array elements into new array
            for (int i = 0; i < size; i++) {
                newarr[i] = arr[i];
            }
            size += 1;
            arr = newarr;
        }
        //arr = new int[newarr.length];
        //arr = newarr;
        arr[current] = data;
        current++;
    }
    //returns whatever there's in the given index
    T atIndex(int index)
    {
        if (index < current)
        {
            return arr[index];
        }
        else
        {
            return null;
        }
    }
    // add element into whatever index
    void addAt(int index, T data)
    {
        if (index == size) {
            add(data);
        }
        else {
            arr[index] = data;
        }
    }
    //print the entire array
    void print()
    {
        for (int i = 0; i < current; i++)
        {
            System.out.print(arr[i]);
        }
        System.out.println(" ");
    }
    //decrease the array by x elements
    void decrease(int itteration) {
        //deletes the whole array except index 0
        if (itteration > current) {
            current = 1;
        }
        //decreases the array by x elements.
        else {
            for (int i = 0; i < itteration; i++) {
                current--;
            }
        }
    }
}
