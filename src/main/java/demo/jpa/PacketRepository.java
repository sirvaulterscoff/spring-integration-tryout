package demo.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author pobedenniy.alexey
 * @since 25.02.2015
 */
@Repository
public interface PacketRepository extends JpaRepository<Packet, Long> {
}
