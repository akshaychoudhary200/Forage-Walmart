import java.util.ArrayList;

public class Heap {
    void heapify(ArrayList<Integer> arr, int currIndx) {
        int size = arr.size();
        int leftChildIndx = 2 * currIndx + 1;
        int righChildIndx = 2 * currIndx + 2;
        int largeElemIndx = currIndx;
        
        if(leftChildIndx < size && arr.get(leftChildIndx) > arr.get(largeElemIndx)) {
            largeElemIndx = leftChildIndx;
        }
        if(righChildIndx < size && arr.get(righChildIndx) > arr.get(largeElemIndx)) {
            largeElemIndx = righChildIndx;
        }

        if(largeElemIndx != currIndx) {
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
            for(int i = (size/2)-1; i >= 0; i--) {
                heapify(arr, i);
            }
        }
    }

    public void delete(ArrayList<Integer> arr, int num) {
        int size = arr.size();
        int numIndx;
        if (arr.isEmpty()) {
            return;
        } else {     
            for (numIndx = 0; numIndx < size; numIndx++) {
                if(num == arr.get(numIndx)) break;
            }
        }
        int temp = arr.get(numIndx);
        arr.set(numIndx, arr.get(size-1));
        arr.set(size-1, temp);
        arr.remove(size-1);
        for(int i = (size/2)-1; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    public void print(ArrayList<Integer> arr) {
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i)+" ");
            
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
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
    }
}