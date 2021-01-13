package com.github.ynfeng.xunitwheel;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MethodResult)) {
            return false;
        }
        MethodResult that = (MethodResult) o;
        return methodName.equals(that.methodName) && Objects.equals(failedCause, that.failedCause);
    }

    @Override
    public int hashCode() {
        return Objects.hash(methodName, failedCause);
    }
}
