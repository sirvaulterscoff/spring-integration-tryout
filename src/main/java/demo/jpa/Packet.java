package demo.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.UUID;

/**
 * @author pobedenniy.alexey
 * @since 25.02.2015
 */
@Entity
public class Packet {
	@Id
	@GeneratedValue
	private Long id;

	@Column
	@Lob
	private byte[] content;
	@Column(nullable = false, updatable = false, unique = true)
	private UUID guid;
	@Column(nullable = false, updatable = false)
	private String fileName;
	@Enumerated
	@Column(nullable = false, updatable = false)
	private PacketType type;

	public Long getId() {
		return id;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public UUID getGuid() {
		return guid;
	}

	public void setGuid(UUID guid) {
		this.guid = guid;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public PacketType getType() {
		return type;
	}

	public void setType(PacketType type) {
		this.type = type;
	}
}
