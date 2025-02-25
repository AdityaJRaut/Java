public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        String name = "Aditya";
        System.out.println(name);
        int myNum = 5;
        System.out.println(myNum);
        String firstName = "Aditya "; // where firstName is identifier
        String LastName = "Raut";
        System.out.println(firstName + " " + LastName);
        // calculate area of rectangle
        int length = 10;
        int width = 20;
        int areaOfRectangle = length * width;
        System.out.println("Area Of Rectangle is " + areaOfRectangle);
        char myChar = 66;
        System.out.println(myChar);
        float itemQty = 34.5f;
        float itemCost = 99.9f;
        float totalCost = itemQty * itemCost;
        char currency = '$';
        System.out.println("Total Cost is :" + totalCost + currency);
        System.out.println(firstName.length());
        System.out.println(firstName.indexOf("A"));
        System.out.println(firstName.toUpperCase());
        System.out.println(firstName.concat(LastName));
        System.out.println((int) (Math.random() * 101));
        int values[] = { 10, 2, 50, 5, 99 };
        int max = values[0];
        int min = values[0];
        for (int i : values) {
            if (max < i) {
                max = i;
            }
            if (min > i) {
                min = i;
            }
        }
        System.out.println("Max value in array is " + max + " and min value is " + min);

        int m[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8 } };
        for (int[] row : m) {
            for (int i : row) {
                System.out.println(i);
            }
        }
    }
}