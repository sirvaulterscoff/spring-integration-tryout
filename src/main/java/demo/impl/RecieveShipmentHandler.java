package demo.impl;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

/**
 * @author pobedenniy.alexey
 * @since 23.02.2015
 */
@Component
public class RecieveShipmentHandler {

	@Transactional(propagation = Propagation.REQUIRED)
	@ServiceActivator(inputChannel = "putShipment")
	public void receiveShipmont(byte[] f) {
		throw new RuntimeException("test");
//		System.out.println("Received shipment " + f);
	}
}
