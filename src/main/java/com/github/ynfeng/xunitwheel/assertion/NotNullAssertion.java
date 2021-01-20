package com.github.ynfeng.xunitwheel.assertion;

public class NotNullAssertion<T> implements Assertion<T> {
    public NotNullAssertion() {
    }

    @Override
    public AssertResult doAssert(T actual) {
        if (actual == null) {
            return AssertResult.notMatch("Expect not null but was null");
        }
        return AssertResult.match();
    }
}
