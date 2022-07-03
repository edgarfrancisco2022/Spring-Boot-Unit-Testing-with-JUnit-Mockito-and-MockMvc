package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
    }

    @Test
    @DisplayName("Multiply")
    void testMultiply() {
        assertEquals(12, demoUtils.multiply(3, 4), "3*4 must be 12");
    }

    @Test
    @DisplayName("Equals and not equals")
    @Order(1)
    void testEqualsAndNotEquals() {

        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
    }

    @Test
    @DisplayName("Null and not null")
    @Order(0)
    void testNullAndNotNull() {

        String str1 = null;
        String str2 = "luv2code";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }

    @Test
    @DisplayName("Same and not same")
    void testSameAndNotSame() {
        String str = "luv2code";
        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to                     the same object");
        assertNotSame(str, demoUtils.getAcademy(), "Objects should not refer to the same object");
    }

    @Test
    @DisplayName("True and not true")
    void testTrueFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "this should return true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "this should return false");
    }

    @Test
    @DisplayName("Array equals")
    void testArrayEquals() {
        String[] stringArray = {"A", "B", "C"};

        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be                            equal");
    }

    @Test
    @DisplayName("Iterable equals")
    void testIterableEquals() {
        List<String> theList = List.of("luv", "2", "code");

        assertIterableEquals(theList, demoUtils.getAcademyInList(), "lists should be equal");
    }

    @Test
    @DisplayName("Lines match")
    void testLinesMatch() {
        List<String> theList = List.of("luv", "2", "code");

        assertLinesMatch(theList, demoUtils.getAcademyInList(), "Lines should match");
    }

    @Test
    @DisplayName("Throws and does not throw")
    void testThrowsAndDoesNotThrow() {
        assertThrows(Exception.class, () -> {demoUtils.throwException(-1);}, "should throw an                             exception");
        assertDoesNotThrow(() -> {demoUtils.throwException(9);}, "should not throw an                             exception");
    }

    @Test
    @DisplayName("Timeout")
    void testTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {demoUtils.checkTimeout();}, "Method                                    should execute in 3 seconds");
    }

//    @AfterEach
//    void tearDownAfterEach() {
//        System.out.println("@AfterEach execution after each test method\n");
//    }
//
//    @BeforeAll
//    static void setupBeforeEachClass() {
//        System.out.println("@BeforeAll execution before all tests");
//    }
//
//    @AfterAll
//    static void setupAfterEachClass() {
//        System.out.println("@AfterAll execution after all tests");
//    }
}
