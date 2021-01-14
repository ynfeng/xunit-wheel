package com.github.ynfeng.xunitwheel;

public final class Assertions {

    private Assertions() {
    }

    public static void assertEquals(Object excepted, Object actual) {
        if (!excepted.equals(actual)) {
            throw new XunitwheelAssertionError(String.format("Expected <%s> but <%s>", excepted, actual));
        }
    }

    public static void fail(String msg) {
        throw new XunitwheelAssertionError(msg);
    }
}
