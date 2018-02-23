package com.suresh.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.suresh.Entitys.Address;
import com.suresh.Entitys.Customers;
import com.suresh.Entitys.Orders;
import com.suresh.Entitys.OrdersProducts;
import com.suresh.Entitys.Products;
import com.suresh.dao.Dao;
import com.suresh.dao.DaoImpl;
import com.suresh.dao.OrdersDao;
import com.suresh.dao.OrdersDaoImpl;
import com.suresh.dao.OrdersProductsDaoImpl;
import com.suresh.dao.ProductDao;
import com.suresh.dao.ProductsDaoImpl;
import com.suresh.exceptions.CustomException;

public class CustomerApp {

	static OrdersProductsDaoImpl ordersProductsimpl = new OrdersProductsDaoImpl();

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Dao customerDao = new DaoImpl();
		ProductDao productsDao = new ProductsDaoImpl();
		OrdersDao ordersDao = new OrdersDaoImpl();
		
		/**************************Creating Products*********************************/
		Products product = new Products();
		product.setDescription("iphone X 128gb");
		product.setName("Apple Iphone");
		product.setPrice(1000);
		productsDao.addProduct(product);

		Products product1 = new Products();
		product1.setDescription("samsung S8 128gb");
		product1.setName("Samsung Phone");
		product1.setPrice(800);
		productsDao.addProduct(product1);
		

		Products product2 = new Products();
		product2.setDescription("google pixel 128gb");
		product2.setName("Google Phone");
		product2.setPrice(900);
		productsDao.addProduct(product2);

		//List<Customers> list = new ArrayList<>();
		/**************************Creating Customers*********************************/
		Customers customer = new Customers("reed","tern","smith@gmail.com","Apple");
		Customers customer2 = new Customers("raj","tarun","raj@gmail.com","Apple");
		Customers customer3 = new Customers("arun","kumar","arun@gmail.com","Amazon");
		
		/**************************Creating Address*********************************/
		Address address = new Address("507 west Street", "irving", "tx", "u.s");
		Address address1 = new Address("609 south Street", "dallas", "tx", "u.s");
		Address address2 = new Address("909 east Street", "chicago", "IL", "u.s");
		
		/**************************setting Address into customers*********************************/
		customer.setAddress(address);
		customer2.setAddress(address1);
		customer3.setAddress(address2);
		
		/**************************Creating Orders List*********************************/
		List<Orders> ordersList = new ArrayList<Orders>();
		
		/**************************Creating first order*********************************/
		Orders orders1 = new Orders();
		orders1.setInvoiceCreationDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-01"));
		orders1.setPaymentDueDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-02"));
		orders1.setDeliveryDueDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-10"));
		orders1.setOrderStatus();
		
		/**************************Creating first order*********************************/
		Orders orders2 = new Orders();
		orders2.setInvoiceCreationDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-11"));
		orders2.setPaymentDueDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-12"));
		orders2.setDeliveryDueDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-18"));
		orders2.setOrderStatus();

		
//
//		System.out.println("********************************************************");
//		System.out.println(productsDao.getAllProducts());
//		System.out.println("********************************************************");
//		System.out.println("Please choose the products that you want to add into your orders " + "Example: Apple ");
		/****************************************************************/
//		System.out.println("enter the Product Id that you want to add into orders ");
//		int id = sc.nextInt();
		/****************************************************************/

//		Products products1 = productsDao.loadProducts(id);
//		System.out.println("please specify the quantity of the product ");
//		int quantity = sc.nextInt();
		
		/**************************creating OrderProduct Object1*********************************/
		OrdersProducts ordersProducts1 = new OrdersProducts();
		/****************************************************************************************/
		ordersProducts1.setQuantity(2);
		ordersProducts1.setOrders(orders1);
		ordersProducts1.setProducts(product1);
		OrdersProducts ordersProducts2 = new OrdersProducts();
		ordersProducts2.setQuantity(1);
		ordersProducts2.setOrders(orders1);
		ordersProducts2.setProducts(product2);
		
		//System.out.println(productsDao.getAllProducts());
		/****************************************************************/
//		System.out.println("enter the Product Id that you want to add into orders ");
//		int id2 = sc.nextInt();
		/****************************************************************/
		//Products products2 = productsDao.loadProducts(id2);
		//ordersProducts1.setProducts(products2);
		/****************************************************************/
		
		/**************************creating OrderProduct Object2*********************************/
		List<OrdersProducts> ordersProductsList = new ArrayList<OrdersProducts>();
		//ordersProductsimpl.addOrdersProducts(ordersProducts1);
		ordersProductsList.add(ordersProducts1);
		ordersProductsList.add(ordersProducts2);
		orders1.setOrdersProducts(ordersProductsList);
		
		OrdersProducts ordersProducts3 = new OrdersProducts();
		/****************************************************************/
		ordersProducts3.setQuantity(4);
		ordersProducts3.setOrders(orders2);
		ordersProducts3.setProducts(product1);
		OrdersProducts ordersProducts4 = new OrdersProducts();
		ordersProducts4.setQuantity(1);
		ordersProducts4.setOrders(orders2);
		ordersProducts4.setProducts(product2);
		ordersProductsList.add(ordersProducts3);
		ordersProductsList.add(ordersProducts4);
		orders1.setOrdersProducts(ordersProductsList);
		
		/**************************Adding Orders to customers *********************************/
		ordersList.add(orders1);
		ordersList.add(orders2);
		customer.setOrders(ordersList);
		customerDao.addCustomer(customer);
		customerDao.addCustomer(customer2);
		customerDao.addCustomer(customer3);
		System.out.println("Orders and Products are sucessfully added");
		
		while (true) {
			System.out.println("=====================================");
			System.out.println("|   Customer MENU SELECTION         |");
			System.out.println("=====================================");
			System.out.println("| Options:                          |");
			System.out.println("1 Display Customer by Id            |");
			System.out.println("2 Display All orders details        |");
			System.out.println("3 Display all products              |");
			System.out.println("4 Delete Customer                   |");
			System.out.println("5 Delete Order                      |");
			System.out.println("6 Fetch All orders b/w range of date|");
			System.out.println("7 Display Total price of a order    |");
			System.out.println("8 EXIT                              |");
			System.out.println("=====================================");
			int operation;
			try {
				operation = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(
						"You pressed an invalid Key!! " + "\nTry Again Running the application. We are quiting!!!");
				break;
			}
			switch (operation) {
			case 1:
				System.out.println("\nYou are now in the Employee Creation Module.");
				displayCustomer(sc, customerDao);
				break;
			case 2:
				 displayAllOrdersDetails(ordersList);
				break;
			case 3:
				DisplayAllProducts(productsDao);
				break;
			case 4:
				deleteCustomer(sc, customerDao);
				break;
			case 5:
				deleteOrder(sc, ordersDao);
				break;
			case 6:
				fetchAllOrderdetails(customer, sc, ordersDao);
				break;
			case 7:
				displaytotalpriceOfOrder( ordersDao, sc);
				break;
			case 8:
				System.exit(0);
				break;
			}
		}

	}

	private static void deleteOrder(Scanner sc,OrdersDao ordersDao) throws CustomException {
		System.out.println("please enter the order  Id ");
		int ordId = sc.nextInt();
		ordersDao.deleteOrder(ordId);
		
	}
	private static void deleteCustomer(Scanner sc,Dao customerDao) throws CustomException {
		System.out.println("please enter the customer  Id ");
		int custId = sc.nextInt();
		customerDao.loadCustomer(custId);
		
	}
	
	private static void DisplayAllProducts(ProductDao productsDao) throws Exception {
		System.out.println(productsDao.getAllProducts());
	}
	private static void displayAllOrdersDetails(List<Orders> ordersList) {
		System.out.println(ordersList);	
	}
	
	private static void displayCustomer(Scanner sc, Dao customerDao) throws CustomException {
		System.out.println("please enter the customer  Id ");
		int custId = sc.nextInt();
		customerDao.loadCustomer(custId);	
	}
	
	
	
		/********************************Fetch Details********************************/
		//fetchdetails(customer, sc, ordersDao);
		/********************************Total Price********************************/
		//totalPrice(ordersDao, ordId);

	private static void displaytotalpriceOfOrder( OrdersDao ordersDao,Scanner sc) {
		System.out.println("please enter the order  Id ");
		int ordId = sc.nextInt();
		int s = ordersDao.setTotalOrderPrice(ordId);
		System.out.println(s);
		
	}

	private static void fetchAllOrderdetails(Customers customer, Scanner sc, OrdersDao ordersDao) throws ParseException {
		List<Orders> orderslist = customer.getOrders();
		System.out.println("Please specify the date range, first Start date in the following format MM/dd/yyyy :");
		String startDate = sc.next();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date startdate = simpleDateFormat.parse(startDate);
		System.out.println("Please specify  end  date in the following format MM/dd/yyyy :");
		String endDate = sc.next();
		//SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(startDate);
		Date enddate = simpleDateFormat.parse(endDate);
		List<Orders> ordersDetails = ordersDao.getOrdersDetailsByRange(startdate, enddate);
		System.out.println("******************************************************");
		for (Orders orders : ordersDetails) {
			System.out.println(orders);
			System.out.println("=========================");
		}
		System.out.println("******************************************************");

	}
	
}
	
	
	
	
	

	/*
	 * private static void createCustomer(Scanner sc, ProductsDaoImpl
	 * productsDao,Dao customerDao) throws Exception { Customers c = null;
	 * 
	 * Products product = new Products();
	 * 
	 * product.setDescription("iphone X 128gb");
	 * 
	 * product.setName("Apple Iphone");
	 * 
	 * product.setPrice(1000);
	 * 
	 * 
	 * List<Customers> list = new ArrayList<>();
	 * System.out.println("Please provide Customer first Name. " +
	 * "Example: John "); String customerFirstName = sc.next();
	 * c.setFirstName(customerFirstName);
	 * System.out.println("Please provide Customer last Name. " +
	 * "Example: smith "); String customerLastName = sc.next();
	 * c.setLastName(customerLastName);
	 * System.out.println("Please provide Customer email " +
	 * "Example: Smith@gmail.com"); String customerEmail = sc.next();
	 * c.setEmail(customerEmail);
	 * System.out.println("Please provide Customer Company name " +
	 * "Example: Apple"); String customerCompany = sc.next();
	 * c.setCompany(customerCompany);
	 * System.out.println("Please provide Customer Company name " +
	 * "Example: Apple"); String customerCompany = sc.next();
	 * 
	 * System.out.println("Do you want to Order any Items " );
	 * 
	 * Orders orders = new Orders();
	 * System.out.println("Please provide any custom message " ); String
	 * customMessage = sc.next(); orders.setCustomMessage(customMessage);
	 * List<Orders> ordersList = new ArrayList<Orders>();
	 * orders.setInvoiceCreationDate( new
	 * SimpleDateFormat("yyyy-MM-dd").parse("2018-03-01"));
	 * 
	 * orders.setPaymentDueDate(new
	 * SimpleDateFormat("yyyy-MM-dd").parse("2018-03-02"));
	 * 
	 * orders.setDeliveryDueDate(new
	 * SimpleDateFormat("yyyy-MM-dd").parse("2018-03-10")); ordersList.add(orders);
	 * c.setOrders(ordersList); customerDao.addCustomer(c);
	 * 
	 * System.out.println(productsDao.getAllProducts());
	 * 
	 * System.out.
	 * println("Please choose the products that you want to add into your orders " +
	 * "Example: Apple ");
	 * 
	 * System.out.println("enter the Product Id that you want to add into orders ");
	 * int id = sc.nextInt(); Products product1 = productsDao.loadProducts(id);
	 * System.out.println("please specify the quantity of the product "); int
	 * quantity = sc.nextInt(); OrdersProducts ordersProducts = new
	 * OrdersProducts(); ordersProducts.setQuantity(quantity); List<OrdersProducts>
	 * ordersProductsList = new ArrayList<OrdersProducts>();
	 * ordersProducts.setOrders(orders); ordersProducts.setProducts(product1);
	 * 
	 * ordersProductsimpl.addOrdersProducts(ordersProducts);
	 * 
	 * //ordersProductsList.add(ordersProducts);
	 * //orders.setOrdersProducts(ordersProductsList);
	 * 
	 * //OrdersProducts ordersProducts = new OrdersProducts();
	 * ordersProducts.setQuantity(2); List<OrdersProducts> ordersProductsList = new
	 * ArrayList<OrdersProducts>(); ordersProductsList.add(ordersProducts);
	 * orders.setOrdersProducts(ordersProductsList);
	 * 
	 * list.add(orders);
	 * 
	 * 
	 * }
	 */

/*
 * try (Scanner sc = new Scanner(System.in);) {
 * System.out.println("Welcome to Customer Management App!! "); while (true) {
 * System.out.println("=================================");
 * System.out.println("|   Customer MENU SELECTION     |");
 * System.out.println("=================================");
 * System.out.println("| Options:                      |");
 * System.out.println("1 create Customer               |");
 * System.out.println("2 Read All Customer Details     |");
 * System.out.println("3 Update Customer   Details     |");
 * System.out.println("4 Delete Customer               |");
 * System.out.println("5 Display Customer By Id        |");
 * System.out.println("6 Add Orders                    |");
 * //System.out.println("7 getHighestSalaryEmployee      |");
 * System.out.println("8 EXIT                          |");
 * System.out.println("================================="); int operation; try {
 * operation = sc.nextInt(); } catch (InputMismatchException e) {
 * System.out.println( "You pressed an invalid Key!! " +
 * "\nTry Again Running the application. We are quiting!!!"); break; } switch
 * (operation) { case 1: createCustomer(sc); break; case 2:
 * readCustomerDetails(); break; case 3: updateCustomer(sc); break; case 4:
 * deleteCustomer(sc); break; case 5: displayCustomerById(sc); break; case 6:
 * sortCustomer(sc); break; case 7: getHighestSalaryCustomer(sc); break; case 8:
 * System.exit(0); break;
 * 
 * } }
 * 
 * } catch (Exception e1) { e1.printStackTrace(); } }
 */
/*
 * Dao customerDao = new DaoImpl(); ProductDao productDao = new
 * ProductsDaoImpl(); OrdersDao ordersDao = new OrdersDaoImpl(); //
 * ***************************************************** Products product = new
 * Products();
 * 
 * product.setDescription("iphone X 128gb");
 * 
 * product.setName("Apple Iphone");
 * 
 * product.setPrice(1000);
 * 
 * 
 * productDao.addProduct(product);
 * 
 * 
 * Products product1 = new Products();
 * 
 * product1.setDescription("samsung S8 128gb");
 * 
 * product1.setName("Samsung Phone");
 * 
 * product1.setPrice(800);
 * 
 * productDao.addProduct(product1);
 * 
 * Products product2 = new Products();
 * 
 * product2.setDescription("google pixel 128gb");
 * 
 * product2.setName("Google Phone");
 * 
 * product2.setPrice(900);
 * 
 * productDao.addProduct(product2);
 * 
 * Customers customer = new Customers("reed","tern","smith@gmail.com","Apple");
 * Orders orders = new Orders(); Orders orders2 = new Orders(); List<Orders>
 * list = new ArrayList<Orders>(); orders.setInvoiceCreationDate( new
 * SimpleDateFormat("yyyy-MM-dd").parse("2018-03-01"));
 * 
 * OrdersProducts ordersProducts = new OrdersProducts();
 * ordersProducts.setQuantity(2); List<OrdersProducts> ordersProductsList = new
 * ArrayList<OrdersProducts>(); ordersProductsList.add(ordersProducts);
 * orders.setOrdersProducts(ordersProductsList);
 * 
 * list.add(orders); //customer.setOrders(list); list.add(orders2);
 * customer.setOrders(list); customerDao.addCustomer(customer);
 * System.out.println(customer.getOrders());
 * 
 * //ordersDao.updateOrder(orders);
 * 
 * Integer custId = customer.getCustIdPk();
 * System.out.println("****************************");
 * System.out.println(customer);
 * System.out.println("****************************");
 * System.out.println(customerDao.loadCustomer(custId));
 * System.out.println("****************************"); Customers customer1 = new
 * Customers("raj","kumar","willsmith@gmail.com","Amazon");
 * customerDao.addCustomer(customer1); customer1.setLastName("terner");
 * customerDao.updateCustomer(customer1); Integer custId1 =
 * customer1.getCustIdPk(); System.out.println("****************************");
 * System.out.println(customerDao.loadCustomer(custId1));
 * System.out.println("****************************");
 * 
 * customerDao.deleteCustomer(custId);
 * System.out.println("****************************");
 * System.out.println(customerDao.loadCustomer(custId));
 * System.out.println("****************************");
 * //System.out.println("test 1\n"+customer+"\n"+customer1);
 * 
 * 
 * //ordersDao.addOrder(orders); Integer orderId = orders.getOrderIdPk();
 * System.out.println(orders);
 * System.out.println(ordersDao.loadOrders(orderId));
 */

// ordersProductsList.add(ordersProducts);
// orders.setOrdersProducts(ordersProductsList);

// OrdersProducts ordersProducts = new OrdersProducts();
/*
 * ordersProducts.setQuantity(2); List<OrdersProducts> ordersProductsList = new
 * ArrayList<OrdersProducts>(); ordersProductsList.add(ordersProducts);
 * orders.setOrdersProducts(ordersProductsList);
 * 
 * list.add(orders);
 */
//Customers c = new Customers();
		/*System.out.println("Please provide Customer first Name. " + "Example: John ");
		String customerFirstName = sc.next();
		c.setFirstName(customerFirstName);
		System.out.println("Please provide Customer last Name. " + "Example: smith ");
		String customerLastName = sc.next();
		c.setLastName(customerLastName);
		System.out.println("Please provide Customer email " + "Example: Smith@gmail.com");
		String customerEmail = sc.next();
		c.setEmail(customerEmail);
		System.out.println("Please provide Customer Company name " + "Example: Apple");
		String customerCompany = sc.next();
		c.setCompany(customerCompany);*/

///****************************************************************/
//OrdersProducts ordersProducts2 = new OrdersProducts();
///****************************************************************/
//ordersProducts2.setQuantity(3);
//ordersProducts2.setOrders(orders2);
//ordersProducts2.setProducts(products1);
//
///****************************************************************/
//ordersProducts2.setProducts(products2);
//ordersProductsimpl.addOrdersProducts(ordersProducts2);
//ordersProductsList.add(ordersProducts2);
//products1.setOrdersProducts(ordersProductsList);
//productsDao.addProduct(product1);