class MyLongArray {
    int size;
    private long a[];
    int currentIndex;

    MyLongArray(int size) {
        this.size=size;
        a = new long[size];
    }

    public int find(long searchKey) {
        for (int i = 0; i < size; i++) {
            if (a[i] == searchKey) {
                return i;
            }
        }
        return -1; // Move this line outside of the loop
    }

    void insert(long value) {
        if (currentIndex < size) { // Change a.length to size
            a[currentIndex] = value;
            currentIndex++;
        } else
            System.out.println("Array is full");
    }

    public long getElem(int index) {
        if (index >= 0 && index < size) // Change a.length to size
            return a[index];
        else
            return -1;
    }

    public boolean delete(long value) {
        int index = find(value);
        if (index != -1) {
            for (int i = index; i < currentIndex - 1; i++) {
                a[i] = a[i + 1];
            }
            currentIndex--;
            return true;
        }
        return false;
    }

    public void deleteAtIndex(int index) {
        if (index >= 0 && index < currentIndex) {
            for (int i = index; i < currentIndex - 1; i++) {
                a[i] = a[i + 1];
            }
            currentIndex--;
        } else {
            System.out.println("Invalid index");
        }
    }

    public void insert(int index, long value) {
        if (currentIndex < size && index >= 0 && index <= currentIndex) { // Change a.length to size
            for (int i = currentIndex; i > index; i--) {
                a[i] = a[i - 1];
            }
            a[index] = value;
            currentIndex++;
        } else {
            System.out.println("Invalid index or array is full so cannot insert");
        }
    }

    public void display() {
        for (int i = 0; i < currentIndex; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        MyLongArray arr = new MyLongArray(10); // Creating an object of class MyLongArray

        arr.insert(44);
        arr.insert(67);
        arr.insert(32);
        arr.insert(24);
        arr.insert(98);

        arr.display(); // Displaying the array

        System.out.println("Index of 67: " + arr.find(67));
        System.out.println("Index of 5: " + arr.find(5));

        arr.delete(24); // Delete element of value 24
        arr.display();

        arr.insert(2, 11); // Insert element 11 at Index 2
        arr.display();

        arr.deleteAtIndex(1); // Delete value at index 1
        arr.display();
    }
}