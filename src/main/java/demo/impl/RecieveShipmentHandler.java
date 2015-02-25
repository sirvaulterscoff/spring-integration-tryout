package demo.impl;

import demo.jpa.Packet;
import demo.jpa.PacketRepository;
import demo.jpa.PacketType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.UUID;

/**
 * @author pobedenniy.alexey
 * @since 23.02.2015
 */
@Component
public class RecieveShipmentHandler {
	@Autowired
	PacketRepository repository;

	@Transactional(propagation = Propagation.REQUIRED)
	@ServiceActivator(inputChannel = "putShipment")
	public void receiveShipmont(byte[] f, @Header(value = "fullPath", required = true)String fileName) {
		Packet p = new Packet();
		p.setContent(f);
		p.setFileName(fileName);
		p.setGuid(UUID.randomUUID());
		p.setType(PacketType.PACKET);
		repository.save(p);
	}
}
