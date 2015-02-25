package demo.start;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * @author svs
 * @since 24.02.2015
 */
@Component
public class TransportInitializer {

	@Autowired
	public void init(ApplicationContext parent) {
		System.out.println("Constructing transport");
		ClassPathXmlApplicationContext main = new ClassPathXmlApplicationContext(new String[]{"DemoApplication-context.xml"}, parent);

		ConfigurableApplicationContext file1 = new ClassPathXmlApplicationContext(new String[]{"file-inbound-context.xml"}, false, main);
		StandardEnvironment env = new StandardEnvironment();
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("dir.in", "/tmp/testin1");
		params.put("poll.freq", 500L);
		params.put("channel.name", "file-in-1");
		env.getPropertySources().addLast(new MapPropertySource("file1", params));
		file1.setEnvironment(env);
		file1.refresh();

		ConfigurableApplicationContext file2 = new ClassPathXmlApplicationContext(new String[]{"file-inbound-context.xml"}, false, main);
		env = new StandardEnvironment();
		params = new HashMap<String, Object>();
		params.put("dir.in", "/tmp/testin2");
		params.put("poll.freq", 500L);
		params.put("channel.name", "file-in-2");
		env.getPropertySources().addLast(new MapPropertySource("file2", params));
		file2.setEnvironment(env);
		file2.refresh();
	}
}
