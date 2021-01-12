package com.github.ynfeng.xunitwheel;

public class MethodResult {
    private final String methodName;
    private Throwable exception;

    private MethodResult(String methodName) {
        this.methodName = methodName;
    }

    public MethodResult(String methodName, Throwable exception) {
        this.methodName = methodName;
        this.exception = exception;
    }

    public static MethodResult success(String name) {
        return new MethodResult(name);
    }

    public static MethodResult failed(String name, Throwable t) {
        return new MethodResult(name, t);
    }

    public String methodName() {
        return methodName;
    }

    public boolean isSuccess() {
        return exception == null;
    }

    public Throwable exception() {
        return exception;
    }
}
