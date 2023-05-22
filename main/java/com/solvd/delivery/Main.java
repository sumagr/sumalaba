package com.solvd.delivery;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.solvd.delivery.exception.DeliveryCalculatorException;
import org.apache.log4j.Logger;

import com.solvd.delivery.enums.DeliveryMode;
import com.solvd.delivery.enums.Distance;
import com.solvd.delivery.enums.Speed;
import com.solvd.delivery.enums.DeliveryPartner;

public class Main {
	static Logger log = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, InstantiationException {
		try {
			// Reflection: Create User object
			Class<?> userClass = Class.forName("com.solvd.delivery.User");
			Constructor<?> userConstructor = userClass.getConstructor(int.class, String.class, String.class);
			Object user = userConstructor.newInstance(123, "John", "john.123@gmail.com");

			// Create itemList using stream operations
			List<Item> itemList = new ArrayList<>();
			itemList.add((Item) createItem("Book", "The Great Gatsby", 9.99, 10));
			itemList.add((Item) createItem("CD", "Abbey Road", 14.99, 9));
			itemList.add((Item) createItem("DVD", "The Godfather", 19.99, 8));

            Address origin = new Address("123 Main St", "Anytown", "CA", "12345");
            Address destination = new Address("456 Oak Ave", "Somecity", "CA", "67890");
            DeliveryCalculator calculator = new DeliveryCalculator(origin, destination);
            calculator.setMode(DeliveryMode.AIR);
            calculator.setPartner(DeliveryPartner.PARTNER_A.getPartnerName());
            calculator.setDistance(Distance.DISTANCE);
            calculator.setSpeed(Speed.EXPRESS);
            calculator.setPackages(itemList);


            double totalCharge = calculator.calculateDeliveryCharge();
            log.info("Delivery charges for your items will be $" + totalCharge);

            // Reflection: Create CreditCard object
            Class<?> creditCardClass = Class.forName("CreditCard");
            Constructor<?> creditCardConstructor = creditCardClass.getConstructor(double.class, String.class, String.class, int.class, double.class);
            Object creditCardPayment = creditCardConstructor.newInstance(totalCharge, "1234-5678-9012-3456", "12/24", 123, 500.0);
            
            // Reflection: Invoke processPayment method using a lambda expression
            Method processPaymentMethod = creditCardClass.getMethod("processPayment");
            Consumer<Object> processPayment = (payment) -> {
                try {
                    processPaymentMethod.invoke(payment);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            };
            processPayment.accept(creditCardPayment);

            // Reflection: Invoke log.info using a lambda expression
            Class<?> logClass = Class.forName("org.apache.log4j.Logger");
            Method getLoggerMethod = logClass.getMethod("getLogger", String.class);
            Object logger = getLoggerMethod.invoke(null, "Main");
            Method infoMethod = logClass.getMethod("info", Object.class);
            Supplier<String> printDetails = () -> "Credit card payment processed.";
            infoMethod.invoke(logger, printDetails.get());
            		
		} catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException
				| InvocationTargetException e) {
			e.printStackTrace();
		} catch (DeliveryCalculatorException e) {
            throw new RuntimeException(e);
        }
    }

	private static Object createItem(String type, String name, double price, int quantity)
			throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException,
			InstantiationException {
		Class<?> itemClass = Class.forName("com.solvd.delivery.Item");
		Constructor<?> itemConstructor = itemClass.getConstructor(String.class, String.class, double.class, double.class);
		return itemConstructor.newInstance(type, name, price, quantity);
	}

}