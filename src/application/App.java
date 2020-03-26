package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class App {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("Enter client data");
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.print("Enter order data: ");
	
		System.out.println();
		
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int items = sc.nextInt();
		
		for (int i = 0; i < items; i ++) {
			System.out.println("Enter the #" + (i + 1) + " item data: ");
			
			System.out.print("Product name: ");
			sc.nextLine();
			String nameProduct = sc.nextLine();
			
			
			System.out.print("Product price: ");
			double priceProduct = sc.nextDouble();
			
			Product product = new Product(nameProduct, priceProduct);
			
			System.out.print("Quantity: ");
			int quantityProduct = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantityProduct, priceProduct, product);
			
			order.addItem(orderItem);
		}
		
		System.out.println();
		
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);

		sc.close();
	}

}
