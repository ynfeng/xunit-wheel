package com.github.ynfeng.xunitwheel;

public class MethodResult {
    private final String methodName;
    private Throwable failedCause;

    private MethodResult(String methodName) {
        this.methodName = methodName;
    }

    public MethodResult(String methodName, Throwable failedCause) {
        this.methodName = methodName;
        this.failedCause = failedCause;
    }

    public static MethodResult success(String name) {
        return new MethodResult(name);
    }

    public static MethodResult failed(String name, Throwable cause) {
        return new MethodResult(name, cause);
    }

    public String methodName() {
        return methodName;
    }

    public boolean isSuccess() {
        return failedCause == null;
    }

    public Throwable failedCause() {
        return failedCause;
    }
}
