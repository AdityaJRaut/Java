package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductsMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Products> productList = new ArrayList<Products>();
		System.out.println("Enter no. of products to enter");
		int prodno = sc.nextInt();
		Products product;
		for (int i = 0; i < prodno; i++) {
			product = new Products();
			product.getProductDetails();
			productList.add(product);
		}
		for (Products products : productList) {
			System.out.println(products.toString());
		}
		sc.close();
	}
}
