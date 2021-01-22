package com.github.ynfeng.xunitwheel;

import com.github.ynfeng.xunitwheel.assertion.XunitwheelAssertionError;

public final class Assertions {

    private Assertions() {
    }

    public static void assertEquals(Object actual, Object excepted) {
        if (!excepted.equals(actual)) {
            throw new XunitwheelAssertionError(String.format("Expected <%s> but <%s>", excepted, actual));
        }
    }
}
