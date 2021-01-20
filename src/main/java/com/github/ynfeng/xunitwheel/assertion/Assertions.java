package com.github.ynfeng.xunitwheel.assertion;

public class Assertions {
    private Assertions() {
    }

    public static <T> void assertThat(T actual, Assertion<T> assertion) {
        assertion.doAssert(actual)
            .reportIfNotMatch(msg -> new XunitwheelAssertionError(msg));
    }

    public static <T> Assertion<T> isEquals(T expect) {
        return new EqualsAssertion<T>(expect);
    }

    public static <T> Assertion<T> notNull() {
        return new NotNullAssertion<T>();
    }
}
