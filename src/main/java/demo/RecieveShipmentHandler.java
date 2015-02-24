package demo;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

/**
 * @author pobedenniy.alexey
 * @since 23.02.2015
 */
public class RecieveShipmentHandler {

	@Transactional(propagation = Propagation.REQUIRED)
	public void receiveShipmont(byte[] f) {
		throw new RuntimeException("test");
//		System.out.println("Received shipment " + f);
	}
}
