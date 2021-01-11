package com.github.ynfeng.xunitwheel;

@SuppressWarnings("serial")
public class XunitwheelAssertionError extends Error {
    public XunitwheelAssertionError(String msg) {
        super(msg);
    }

    public XunitwheelAssertionError() {
    }
}
