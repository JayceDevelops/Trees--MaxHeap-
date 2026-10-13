public class App {
    public static void main(String[] args) throws Exception {
        MaxHeap test = new MaxHeap(10);
        int[] elements = { 52, 69, 22, 10, 29, 86, 82, 29, 39, 29, 23, 66, 18};

        for (int t : elements){
            test.insert(t);
        }

        System.out.println(test);

        while(test.size() != 0){
            System.out.print(test.remove() + " ");
        }
    }
}
