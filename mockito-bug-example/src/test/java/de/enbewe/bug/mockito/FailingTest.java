package de.enbewe.bug.mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

@TestMethodOrder(OrderAnnotation.class)
class FailingTest {

	@Test
	@Order(1)
	void testThingsFirst() {
		try (MockedConstruction<SubClass> mocked = Mockito.mockConstruction(SubClass.class)) {
			System.out.println("Running testCreateStuff");
		}
	}

	@Test
	@Order(2)
	void testThingsSecond() {
		try (MockedConstruction<SuperClass> constructionMock = Mockito.mockConstruction(SuperClass.class)) {
			System.out.println("Running testOtherValue");
			SubClass testee = new SubClass();
			assertTrue(testee.isOtherValue());
		}
	}
}
