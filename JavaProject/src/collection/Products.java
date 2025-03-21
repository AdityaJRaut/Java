package collection;

import java.util.Scanner;

public class Products {
	Scanner sc = new Scanner(System.in);
	public int id;
	public String title;
	public double price;
	public String description;
	public String category;
	public String image;
	public Rating rating;

	public Products() {
	}

	public Products(int id, String title, double price, String description, String category, String image,
			Rating rating) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.description = description;
		this.category = category;
		this.image = image;
		this.rating = rating;
	}

	public String getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public double getPrice() {
		return price;
	}

	public void getProductDetails() {
		System.out.println("Enter product id");
		this.id = sc.nextInt();
		System.out.println("Enter product title");
		this.title = sc.next();
		System.out.println("Enter product price");
		this.price = sc.nextDouble();
		System.out.println("Enter product description");
		this.description = sc.next();
		System.out.println("Enter category");
		this.category = sc.next();
		System.out.println("Enter image");
		this.image = sc.next();
		this.rating = new Rating();
		if (rating != null) {
			rating.getRating();
		}
	}

	public Rating getRating() {
		return rating;
	}

	public String getTitle() {
		return title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", title=" + title + ", price=" + price + ", description=" + description
				+ ", category=" + category + ", image=" + image + "," + rating + "]";
	}

}