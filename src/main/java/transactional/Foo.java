package transactional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Foo {

	private int a;
	private int b;
	
	public Foo() {
		// do nothing on purpose
	}
	
	public Foo(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Transactional(rollbackFor = Exception.class)
	public void execute() throws Exception {
		a += 5;
		b += 10;
		throw new RuntimeException("excepted");
	}

	@Override
	public String toString() {
		return "Foo [a=" + a + ", b=" + b + "]";
	}
	
}
