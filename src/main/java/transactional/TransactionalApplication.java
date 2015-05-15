package transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransactionalApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionalApplication.class);
	
    public static void main(String[] args) {
        SpringApplication.run(TransactionalApplication.class, args);
        LOGGER.info("We Ran.");
        Foo foo = new Foo(5, 10);
        LOGGER.info("Current foo: " + foo);
        try {
        	foo.execute();
        } catch (Exception e) {
        	LOGGER.info("Yup, the exception happened.");
        }
        LOGGER.info("Next foo: " + foo);
    }
}
