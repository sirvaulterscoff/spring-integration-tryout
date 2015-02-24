package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

/**
 * @author pobedenniy.alexey
 * @since 23.02.2015
 */
public class ReceiveTffHandler {
	protected static final Logger log = LoggerFactory.getLogger(ReceiveTffHandler.class);

	@Transactional(propagation = Propagation.REQUIRED)
	public void handle(byte[] f)  {
		System.out.println("Received TFF " + f);
	}
}
