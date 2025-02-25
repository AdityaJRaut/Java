public class MaxArray2D {

	public static void main(String[] args) {
		int sum = 0, max = 0, min = 0, maxRow = 0;
		int interSum = 0;
		int matrix[][] = { { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 90 } };
		max = matrix[0][0];
		min = matrix[0][0];
		for (int i = 0; i < matrix.length; i++) {
			interSum = 0;

			for (int j = 0; j < matrix[i].length; j++) {
				maxRow = matrix[i][0];
				sum += matrix[i][j];
				interSum += matrix[i][j];
				if (matrix[i][j] > max) {
					max = matrix[i][j];
				}
				if (matrix[i][j] < min) {
					min = matrix[i][j];
				}
				if (matrix[i][j] > maxRow) {
					maxRow = matrix[i][j];
				}

			}
			System.out.println("Row " + (i + 1) + " Max value is " + maxRow);
			System.out.println("Sum of " + (i + 1) + " row is " + interSum);

		}
		System.out.println("Sum of array is " + sum);
		System.out.println("Max of array is " + max);
		System.out.println("Min of array is " + min);

	}

}
