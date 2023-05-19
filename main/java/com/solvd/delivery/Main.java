package com.solvd.delivery;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.apache.log4j.Logger;

import com.solvd.delivery.enums.DeliveryMode;
import com.solvd.delivery.enums.Distance;
import com.solvd.delivery.enums.Speed;

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
			List<Object> itemList = new ArrayList<>();
			itemList.add(createItem("Book", "The Great Gatsby", 9.99, 10));
			itemList.add(createItem("CD", "Abbey Road", 14.99, 9));
			itemList.add(createItem("DVD", "The Godfather", 19.99, 8));

			// Reflection: Create Address objects
            Class<?> addressClass = Class.forName("com.solvd.delivery.Address");
            Constructor<?> addressConstructor = addressClass.getConstructor(String.class, String.class, String.class, String.class);
            Object origin = addressConstructor.newInstance("123 Main St", "Anytown", "CA", "12345");
            Object destination = addressConstructor.newInstance("456 Oak Ave", "Somecity", "CA", "67890");

            // Reflection: Create DeliveryCalculator object
            Class<?> calculatorClass = Class.forName("com.solvd.delivery.DeliveryCalculator");
            Constructor<?> calculatorConstructor = calculatorClass.getConstructor(Address.class, Address.class);
            Object calculator = calculatorConstructor.newInstance(origin, destination);

            // Reflection: Set mode using setMode method
            Method setModeMethod = calculatorClass.getMethod("setMode", DeliveryMode.class);
            Object modeEnum = Enum.valueOf((Class<Enum>) Class.forName("com.solvd.delivery.enums.DeliveryMode"), "AIR");
            setModeMethod.invoke(calculator, modeEnum);

            Method setPartnerMethod = calculatorClass.getMethod("setPartner", DeliveryPartner.class);
            Enum<?> deliveryPartner = Enum.valueOf((Class<? extends Enum>) Class.forName("com.solvd.delivery.enums.DeliveryPartner"), "PARTNER_A");
            setPartnerMethod.invoke(calculator, deliveryPartner);

            Method setDistanceMethod = calculatorClass.getMethod("setDistance", Distance.class);
            Enum<?> distance = Enum.valueOf((Class<? extends Enum>) Class.forName("com.solvd.delivery.enums.Distance"), "DISTANCE");
            setDistanceMethod.invoke(calculator, distance);

            Method setSpeedMethod = calculatorClass.getMethod("setSpeed", Speed.class);
            Enum<?> speed = Enum.valueOf((Class<? extends Enum>) Class.forName("com.solvd.delivery.enums.Speed"), "EXPRESS");
            setSpeedMethod.invoke(calculator, speed);

            Method setPackagesMethod = calculatorClass.getMethod("setPackages", List.class);
            setPackagesMethod.invoke(calculator, itemList);

            // Reflection: Invoke calculateDeliveryCharge method
            Method calculateDeliveryChargeMethod = calculatorClass.getMethod("calculateDeliveryCharge");
            double totalCharge = (double) calculateDeliveryChargeMethod.invoke(calculator);

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