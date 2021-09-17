package LambdaFunction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberPlaylist {
	public static void main(String[]args) {
		List <Integer> myNumberList = new ArrayList<Integer>();
		for(int i=0;i<5;i++) myNumberList.add(i);
		
		//METHOD1---ITERATROR
		Iterator <Integer>itr = myNumberList.iterator();
		while(itr.hasNext()) {
			Integer i = itr.next();;
			System.out.println("Method1:: Iterator: "+i);
		}
		
		//METHOD2 ---TRAVERSING WITH CONSUMER
		class MyConsumer implements Consumer<Integer>{
			@Override
			public void accept(Integer t) {
				System.out.println("Method2:: Consumer: "+t);
			}
		}
		MyConsumer action = new MyConsumer();
		myNumberList.forEach(action);
		
		//METHOD3---TRAVERSING WITH ANANYMOUS CONSUMER INTERFACE IMPLEMENTATION
		myNumberList.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println("Method3:: for each ananymous class value: "+t);
			}
		});
		
		//METHOD4::EXPLICIT LAMBDA FUNCTION
		Consumer<Integer> myListAction = (n-> {
			System.out.println("Method4:: explicit lambda function value: "+n);
		});
		myNumberList.forEach(myListAction);
		
		//METHOD5:: IMPLICIT LAMBDA FUNCTION
		myNumberList.forEach(n-> {
			System.out.println("Method5:: implicit lambda function value: "+n);
		});
		
		//Method6::IMPLICIT LAMBDA FUNCTION TO PRINT DOUBLE VALUE
//		Function<Integer,Double> toDoubleFunction = n->n.doubleValue();
//		myNumberList.forEach(n->{
//			System.out.println("Method6:: for each lambda double value: "+toDoubleFunction.apply(n));
//		});
		
		List <Double>doubleArrayList = new ArrayList<>();
		Function<Integer,Double> toDoubleFunction = n->n.doubleValue();
		Predicate<Integer> isEvenFunction = n -> n>0 && n%2 == 0;
		List <Double>evenList = new ArrayList<>();
		myNumberList.forEach(n->{
			doubleArrayList.add(toDoubleFunction.apply(n));
			doubleArrayList.forEach(n1 -> {
				if(isEvenFunction.test(n1.intValue()))
					evenList.add(n1);
			});
			
		});
		System.out.println(evenList);;
		
		//method-7
		Predicate<Integer> isEvenFunction1 = n -> n>0 && n%2 == 0;
		myNumberList.forEach(n-> {
			System.out.println("Method 7: for each value of: "+n+
					" check for Even: "+isEvenFunction.test(n));
		});
		
		//Method8: Processing Stream
		myNumberList.stream().forEach(n->{
			System.out.println("Method 8: Stream for each value : "+n);
		});
		
		//Method:9 Process the stream, apply operation and store result
		List<Double> doubleList = myNumberList.stream().
				filter(isEvenFunction)
				.peek(n->System.out.println("Peek number: " +n))
				.map(toDoubleFunction)
				.collect(Collectors.toList());
		System.out.println("Printing double list:"+doubleList );
		
		//METHOD10: LISTING THE FIRST EVEN
		Integer first = myNumberList.stream().filter(isEvenFunction1)
				.peek(n->System.out.println("Peek number: " +n))
				.findFirst()
				.orElse(null);
		System.out.println("First even: " +first);
		
		//METHOD 11: MINIMUM EVEN NUMBERS
		Integer min = myNumberList.stream()
				.filter(isEvenFunction1)
				.min((n1,n2)->n1-n2)
				.orElse(null);
		System.out.println("min even number: " + min);
		
		//METHOD 12: MINIMUM EVEN NUMBERS
				Integer max = myNumberList.stream()
						.filter(isEvenFunction1)
						.max(Comparator.comparing(Integer::intValue))
						.orElse(null);
				System.out.println("min even number: " +max);
	}
}
