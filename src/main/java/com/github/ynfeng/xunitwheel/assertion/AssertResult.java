package com.github.ynfeng.xunitwheel.assertion;

import java.util.function.Function;

public class AssertResult {
    public static final String EMPTY_MSG = "";
    private final boolean match;
    private final String msg;

    private AssertResult(String msg, boolean match) {
        this.msg = msg;
        this.match = match;
    }

    public static AssertResult notMatch(String format, Object... args) {
        return new AssertResult(String.format(format, args), false);
    }

    public static AssertResult match() {
        return new AssertResult(EMPTY_MSG, true);
    }

    public void reportIfNotMatch(Function<String, XunitwheelAssertionError> errorFunction) throws XunitwheelAssertionError {
        if (!match) {
            throw errorFunction.apply(msg);
        }
    }
}
