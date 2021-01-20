package com.github.ynfeng.xunitwheel.assertion;

public interface Assertion<T> {
    AssertResult doAssert(T actual);
}
