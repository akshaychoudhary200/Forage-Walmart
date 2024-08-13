import java.util.ArrayList;

public class NHeap {
    private final int childrenCount;

    public NHeap(int childrenExponent) {
        this.childrenCount = (int) Math.pow(2, childrenExponent);
    }

    void heapify(ArrayList<Integer> arr, int currIndx) {
        int size = arr.size();
        int largeElemIndx = currIndx;

        for (int i = 1; i <= childrenCount; i++) {
            int childIndx = currIndx * childrenCount + i;
            if (childIndx < size && arr.get(childIndx) > arr.get(largeElemIndx)) {
                largeElemIndx = childIndx;
            }
        }

        if (largeElemIndx != currIndx) {
            int temp = arr.get(largeElemIndx);
            arr.set(largeElemIndx, arr.get(currIndx));
            arr.set(currIndx, temp);
            heapify(arr, largeElemIndx);
        }
    }

    public void insert(ArrayList<Integer> arr, int num) {
        int size = arr.size();
        if (arr.isEmpty()) {
            arr.add(num);
        } else {
            arr.add(num);
            for (int i = (size - 1) / childrenCount; i >= 0; i--) {
                heapify(arr, i);
            }
        }
    }

    public Integer popMax(ArrayList<Integer> arr) {
        if (arr.isEmpty()) {
            return null; 
        }
        int maxElement = arr.get(0);
        int lastElement = arr.remove(arr.size() - 1);
        if (!arr.isEmpty()) {
            arr.set(0, lastElement);
            heapify(arr, 0);
        }
        return maxElement;
    }

    public void delete(ArrayList<Integer> arr, int num) {
        int size = arr.size();
        int numIndx;
        if (arr.isEmpty()) {
            return;
        } else {
            for (numIndx = 0; numIndx < size; numIndx++) {
                if (num == arr.get(numIndx)) break;
            }
        }
        int temp = arr.get(numIndx);
        arr.set(numIndx, arr.get(size - 1));
        arr.set(size - 1, temp);
        arr.remove(size - 1);
        for (int i = (arr.size() - 1) / childrenCount; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    public void print(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NHeap heap = new NHeap(1); 
        ArrayList<Integer> arr = new ArrayList<>();
        heap.insert(arr, 10);
        heap.insert(arr, 40);
        heap.insert(arr, 20);
        heap.insert(arr, 9);
        heap.insert(arr, 5);
        heap.insert(arr, 8);
        heap.print(arr);
        heap.delete(arr, 40);
        heap.print(arr);
        heap.popMax(arr);
        heap.print(arr);
    }
}