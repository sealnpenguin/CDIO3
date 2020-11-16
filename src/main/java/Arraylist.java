public class Arraylist {
    int size, current;
    int[] arr, newarr;
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
            int[] newarr = new int[2 * size];
        }
        //setting old array elemtns into new array
        for (int i = 0; i < size; i++) {
            newarr[i] = arr[i];
        }
    }
}
