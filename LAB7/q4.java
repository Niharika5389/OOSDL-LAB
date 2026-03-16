class q4 {
    /* 
     public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    */
    public static <T extends Comparable<T>> void printArray(T[] array) {
        //bubbleSort(array);
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer[] RoomNo = {101,104,231};
        String[] RoomType = {"Deluxe", "Premium", "Deluxe"};
        Double[] Prices = {1500.0,2500.46,1500.0};
        printArray(RoomNo);
        printArray(RoomType);
        printArray(Prices);
    }
}