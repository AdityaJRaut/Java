public class Max2DArray {
    public static void main(String[] args) {
        int arr[][] = { { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 90 } };
        int max = 0;
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {
                max = arr[i][0];
                if (arr[i][j] > max) {
                    max = arr[i][j];

                }

            }
            System.out.println("Row " + (i + 1) + "max Number is " + max);
        }
    }

}
