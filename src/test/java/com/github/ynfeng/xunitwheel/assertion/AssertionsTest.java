package com.github.ynfeng.xunitwheel.assertion;

import static com.github.ynfeng.xunitwheel.assertion.Assertions.assertThat;
import static com.github.ynfeng.xunitwheel.assertion.Assertions.isEquals;
import static com.github.ynfeng.xunitwheel.assertion.Assertions.notNull;

import com.github.ynfeng.xunitwheel.TestCase;

public class AssertionsTest extends TestCase {
    public AssertionsTest() {
        registerTestMethod("should_assert_equals", this::should_assert_equals);
        registerTestMethod("should_assert_not_null", this::should_assert_not_null);
    }

    public void should_assert_equals() {
        assertThat("foo", isEquals("foo"));
        try {
            assertThat("foo", isEquals("bar"));
            throw new IllegalStateException("can't be here");
        } catch (XunitwheelAssertionError err) {
            if("Expected <bar> but was <foo>".equals(err.getMessage())) {
                throw new IllegalStateException("equals assertion error");
            }
        }
    }

    public void should_assert_not_null() {
        assertThat("foo", notNull());
        try {
            assertThat(null, notNull());
            throw new IllegalStateException("can't be here");
        } catch (XunitwheelAssertionError err) {
            assertThat(err.getMessage(), isEquals("Expect not null but was null"));
        }
    }

    public static void main(String[] args) throws Throwable {
        new AssertionsTest().run().reportAnyFailed();
    }
}
