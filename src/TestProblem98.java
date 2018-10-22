import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class TestProblem98 extends TestCase
	{
		private char[][] _testBoard;
		Problem98 _dummy = new Problem98();

		@BeforeEach
		public void setUp()
		{
			_testBoard = new char[][] {{'A','B','C','E'},
				   								{'S','F','C','S'},
				   								{'A','D','E','E'} };
		}

		@Test 
		void test1() {System.out.println(_testBoard); assertTrue(_dummy.exists(_testBoard, "A"));}
//		@Test void test2() {assertFalse(exists(_testBoard, "AA"));}
//		@Test void test3() {assertTrue(exists(_testBoard, "AB"));}
//		@Test void test4() {assertTrue(exists(_testBoard, "ABCCE"));}
//		@Test void test5() {assertTrue(exists(_testBoard, "ABCCED"));}
//		@Test void test6() {assertFalse(exists(_testBoard, "SEE"));}
//		@Test void test7() {assertFalse(exists(_testBoard, "ABCB"));}
	}