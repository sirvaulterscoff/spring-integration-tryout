package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.core.MessageSource;

/**
 * @author pobedenniy.alexey
 * @since 24.02.2015
 */
@Configuration
public class MultipleInboundMessageSource {

	@Bean(name = "inboundMessageSource")
	public MessageSource createCompoundMessageSource() {

	}
}
