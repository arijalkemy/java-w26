public class Bubble {

    public static int[] bubble(int[] arr) {


        boolean sorted;
        do{
            sorted = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;

                    sorted = true;
                }
            }
            
        } while(sorted);
    
        return arr;
    }

    public static void main(String[] args) {

        int[] unsorted = { 5, 1, 3, 8, 23, 67, 12, 11, 10 };

        bubble(unsorted);

        for (int i = 0; i < unsorted.length; i++) {
            System.out.print("[" + unsorted[i] + "]");
        }
    }

}
