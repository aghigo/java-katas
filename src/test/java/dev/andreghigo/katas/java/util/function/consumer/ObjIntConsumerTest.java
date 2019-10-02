package dev.andreghigo.katas.java.util.function.consumer;

import java.util.function.ObjIntConsumer;

import org.junit.Test;

/**
 * Unit tests of {@link ObjIntConsumer}
 * 
 * @author andreghigo
 *
 */
public class ObjIntConsumerTest {
	/**
	 * The ObjIntConsumer represents an operation that accepts an object-valued and int-valued argument, 
	 * and returns no result. This is the (reference, int) specialization of BiConsumer. The functional
	 * method of the ObjIntConsumer is:
	 * 
	 * <p> void accept(T t, int value)
	 * 
	 */
	@Test
	public void accept() {
		ObjIntConsumer<Integer> objIntConsumer = (o, i) -> System.out.println(o + i);
		objIntConsumer.accept(new Integer(1), 2);	
	}
}
