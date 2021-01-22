package com.github.ynfeng.xunitwheel.assertion;

import static com.github.ynfeng.xunitwheel.assertion.Assertions.assertThat;
import static com.github.ynfeng.xunitwheel.assertion.Assertions.isEquals;
import static com.github.ynfeng.xunitwheel.assertion.Assertions.notNull;

import com.github.ynfeng.xunitwheel.annotation.Test;

public class AssertionsTest {

    @Test
    public void should_assert_equals() {
        assertThat("foo", isEquals("foo"));
        try {
            assertThat("foo", isEquals("bar"));
            throw new IllegalStateException("can't be here");
        } catch (XunitwheelAssertionError err) {
            if (!"Expected <bar> but was <foo>".equals(err.getMessage())) {
                throw new IllegalStateException("equals assertion error");
            }
        }
    }

    @Test
    public void should_assert_not_null() {
        assertThat("foo", notNull());
        try {
            assertThat(null, notNull());
            throw new IllegalStateException("can't be here");
        } catch (XunitwheelAssertionError err) {
            assertThat(err.getMessage(), isEquals("Expect not null but was null"));
        }
    }
}
