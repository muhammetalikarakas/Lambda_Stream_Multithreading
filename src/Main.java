import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		//Sample Lambda Expression without return keyword and body
		
		//if we want to give data type, That is; 
		
		//Addable ad1 = (int a, int b)->(a+b);
		
		Addable ad1 = (a,b) -> (a+b);
		System.out.println(ad1.add(10, 20));
		
		//With return keyword
		Addable ad2 = (int a, int b)->{
			int carp = a * b;
			int toplam = (a + b) + carp;
			return (toplam);
		};
		System.out.println(ad2.add(20, 30));
		
		//Lambda dan sonra paranteze koymak zorunlu değil.
		//Fakat 1 den fazla parametre varsa lambda öncesindeki parametreleri parantez içine alınmalıdır.
		
		Addable ad3 = (a,b) -> a+b;
		
		System.out.println(ad3.add(20, 30));
		
		//FOREACH LOOP
		//FL - Sample 1:
		
		List<String> list = new ArrayList<String>();
		list.add("Berkan");
		list.add("Seren");
		
		//FOREACH Without Lambda Expression 
	
		for (String n : list) {
			System.out.println(n);
		}
		
		//FOREACH LOOP With Lambda Expression
		
		list.forEach(
				(n)->System.out.println(n)
				);
		
		
		//FL - Sample 2:
		System.out.println("EVEN NUMBERS: ");
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(22);
		arrayList.add(7);
		arrayList.add(80);
		arrayList.add(65);
		
		
		//Print even elements with Lambda Expression
		arrayList.forEach(
				(n) -> {
					if (n % 2 == 0) {
						System.out.println(n);
					}
				});
		
		
		//Thread example with lambda
		Runnable runnable = ()->{
			System.out.println("Thread is running...");
		};
		Thread thread = new Thread(runnable);
		thread.start();
		
		
		Sayable sayable = message -> {
			return message;
		};
		System.out.println(sayable.say("Berkan Senger"));
		
		//Comparator, Stream, ForEach examples
		List<Car> cars = new ArrayList<Car>();
		//Adding Cars
		cars.add(new Car(1, "Opel", "Astra", 250000));
		cars.add(new Car(1, "Toyota", "Corolla", 235000));
		cars.add(new Car(1, "Nissan", "Micra", 285000));
		
		Collections.sort(cars,(c1,c2)->{
			return c1.brandName.compareTo(c2.brandName);
		});
		
		Stream<Car> filteredCars = cars.stream().filter(c -> c.price >= 250000);
		
		filteredCars.forEach(
					car -> System.out.println(car.id + " " + car.brandName + " : " + car.price)
				);
		
	}

}
