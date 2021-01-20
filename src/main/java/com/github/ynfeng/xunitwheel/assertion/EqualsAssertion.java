package com.github.ynfeng.xunitwheel.assertion;

public class EqualsAssertion<T> implements Assertion<T> {
    private final T expect;

    public EqualsAssertion(T expect) {
        this.expect = expect;
    }

    @Override
    public AssertResult doAssert(T actual) {
        if (!expect.equals(actual)) {
            return AssertResult.notMatch("Expected <%s> but was <%s>", expect, actual);
        }
        return AssertResult.match();
    }
}
