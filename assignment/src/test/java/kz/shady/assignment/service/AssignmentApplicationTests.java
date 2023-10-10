package kz.shady.assignment.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AssignmentApplicationTests {
	@Test
	void testGenerateCodeOverflow() {
		CodeGenerator generator = new CodeGenerator();

		assert(generator.generateCode("z9z9z9z9z9").equals("a0a0a0a0a0a0"));
	}
	@Test
	void testGenerateCodeOverflow2() {
		CodeGenerator generator = new CodeGenerator();

		assert(generator.generateCode("z9z9z9z9z9z9").equals("a0a0a0a0a0a0a0"));
	}


}
