package com.github.ynfeng.xunitwheel;

import static com.github.ynfeng.xunitwheel.Assertions.assertEquals;
import static com.github.ynfeng.xunitwheel.Assertions.fail;

public class AssertionsTest extends TestCase {

    public void should_fail() {
        try {
            fail();
        } catch (XunitwheelAssertionError error) {
            return;
        }
        throw new RuntimeException("can't be here.");
    }

    public void should_not_equals() {
        try {
            assertEquals("a", "b");
            fail();
        } catch (XunitwheelAssertionError error) {
            assertEquals(error.getMessage(), "Expected <a> but <b>");
        }
    }

    public void should_equals() {
        assertEquals("a", "a");
    }

    public static void main(String[] args) {
        AssertionsTest testCase = new AssertionsTest();
        testCase.registerTestMethod("should_fail", testCase::should_fail);
        testCase.registerTestMethod("should_not_equals", testCase::should_not_equals);
        testCase.registerTestMethod("should_equals", testCase::should_equals);
        testCase.run();
    }
}
