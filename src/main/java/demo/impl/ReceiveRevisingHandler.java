package demo.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author pobedenniy.alexey
 * @since 23.02.2015
 */
@Component
public class ReceiveRevisingHandler {

	protected static final Logger log = LoggerFactory.getLogger(ReceiveRevisingHandler.class);

	@Transactional(propagation = Propagation.REQUIRED)
	@ServiceActivator(inputChannel = "applyRevising")
	public void handle(byte[] file) {
		System.out.println("Received revising " + file);
	}
}
