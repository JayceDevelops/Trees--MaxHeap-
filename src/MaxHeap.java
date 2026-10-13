

public class MaxHeap {
    private int[] heap;
    private int size; 

    public MaxHeap() {
        this(512);
    }

    public MaxHeap(int cap) {
        this.heap = new int[cap];
    }

    // Helpers
    private int parent(int j){
        return (j - 1) / 2; 
    }

    private int left(int j){
        return 2 * j + 1;
    }

    private int right(int j){
        return 2 * j + 2;
    }
    
    private boolean hasLeft(int j){
        return left(j) < size;
    }

    private boolean hasRight(int j){
        return right(j) < size;
    }

    private void swap(int left, int right){
        int temp = heap[left];
        heap[left] = heap[right];
        heap[right] = temp;
    }

    public void insert(int element){

        if (size == heap.length - 1){
            int[] newHeap = new int[heap.length * 2];
            for (int i = 0; i < heap.length; i++){
                newHeap[i] = heap[i];
            }

            heap = newHeap;
        }

        heap[size] = element;

        trickleUp(size);
        size++;
    }

    private void trickleUp(int j){
        while(j > 0){
            int p = parent(j);
            if(heap[j] < heap[p]){
                break;
            }

            swap(j, p);
            j = p;
        }

    }

    public int remove(){
        if (size == 0){
            return -1;
        }

        int temp = heap[0];

        heap[0] = heap[--size];
        trickleDown(0);

        return temp;
    }

    private void trickleDown(int j){
        while (hasLeft(j)){
            int left = left(j);
            int greater = left;

            if (hasRight(j)){
                int right = right(j);
                if (heap[left] < heap[right]){
                    greater = right;
                }
            }

            if(heap[greater] < heap[j]){
                break;
            }

            swap(j, greater);

            j = greater;
        }
    }

    public int peek(){
        return heap[0];
    }

    public int size(){
        return size;
    }

    @Override 
    public String toString(){
        String str = "";

        for (int i = 0; i < size; i++){
            str += "[" + heap[i] + "]";
        }

        return str;
    }
}
