package com.github.ynfeng.xunitwheel;

import static com.github.ynfeng.xunitwheel.Assertions.assertEquals;
import static com.github.ynfeng.xunitwheel.Assertions.fail;

import com.github.ynfeng.xunitwheel.assertion.XunitwheelAssertionError;

public class AssertionsTest extends TestCase {

    public AssertionsTest() {
        registerTestMethod("should_fail", this::should_fail);
        registerTestMethod("should_not_equals", this::should_not_equals);
        registerTestMethod("should_equals", this::should_equals);
    }

    public void should_fail() {
        try {
            fail("can not be here.");
        } catch (XunitwheelAssertionError error) {
            return;
        }
        throw new RuntimeException("can't be here.");
    }

    public void should_not_equals() {
        try {
            assertEquals("a", "b");
            fail("can not be here.");
        } catch (XunitwheelAssertionError error) {
            assertEquals(error.getMessage(), "Expected <a> but <b>");
        }
    }

    public void should_equals() {
        assertEquals("a", "a");
    }

    public static void main(String[] args) throws Throwable {
        new AssertionsTest().run().reportAnyFailed();
    }
}
