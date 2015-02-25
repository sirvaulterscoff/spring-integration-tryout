package demo.impl;

import demo.jpa.Packet;
import demo.jpa.PacketRepository;
import demo.jpa.PacketType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author pobedenniy.alexey
 * @since 23.02.2015
 */
@Component
public class ReceiveTffHandler {
	@Autowired
	PacketRepository repository;

	@Transactional(propagation = Propagation.REQUIRED)
	@ServiceActivator(inputChannel = "putTFF")
	public void handle(byte[] f, @Header(value = "fullPath", required = true)String fileName) throws InterruptedException {
		System.out.println("Received TFF " + f);
		Packet p = new Packet();
		p.setType(PacketType.TFF);
		p.setGuid(UUID.randomUUID());
		p.setFileName(fileName);
		p.setContent(f);
		repository.save(p);
	}
}
