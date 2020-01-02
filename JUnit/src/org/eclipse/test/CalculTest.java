package org.eclipse.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.eclipse.main.Calcul;
import org.eclipse.main.CalculService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculTest {
	Calcul calcul;
	CalculService calculService= mock(CalculService.class);
	
//	CalculService calculService = new CalculService() {
//	
//		@Override
//		public int carre(int x) {
//			// TODO Auto-generated method stub
//			return x*x;
//		}
//	};

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before All");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After All");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before Each");
		calcul = new Calcul(calculService);

	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After Each");
		calcul = null;
	}

	@Test
	void testSomme() {
		if (calcul.somme(2, 3) != 5) {
			fail("faux pour deux entiers positifs");
		}
		if (calcul.somme(-2, -3) != -5) {
			fail("faux pour deux entiers négatifs");
		}
		if (calcul.somme(-2, 3) != 1) {
			fail("faux pour deux entiers de signe différent");
		}
		if (calcul.somme(0, 3) != 3) {
			fail("faux pour x nul");
		}
		if (calcul.somme(2, 0) != 2) {
			fail("faux pour y nul");
		}
		if (calcul.somme(0, 0) != 0) {
			fail("faux pour x et y nuls");
		}
	}

	@Test
	void testDivision() {
		assertFalse("2entiers positifs", calcul.division(6, 3) == 0);
		assertEquals("2entiers negatifs", 2, calcul.division(-6, -3));
		assertNotNull("2 entiers de signe different", calcul.division(-6, 3));
		assertTrue("entier x nul", calcul.division(0, 3) == 0);
		Throwable e = null;
		try {
			calcul.division(2, 0);
		} catch (Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof ArithmeticException);
		e = null;
		try {
			calcul.division(0, 0);
		} catch (Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof ArithmeticException);

	}

	@Test
	void testSommeCarre() {
		when(calculService.carre(2)).thenReturn(4);
		when(calculService.carre(3)).thenReturn(9);
		assertTrue("calcul exact", calcul.sommeCarre(2, 3) == 13);
		verify(calculService).carre(2);
		verify(calculService).carre(3);
	}

}
