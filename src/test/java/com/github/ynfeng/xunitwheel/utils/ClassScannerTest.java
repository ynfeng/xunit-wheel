package com.github.ynfeng.xunitwheel.utils;

import static com.github.ynfeng.xunitwheel.assertion.Assertions.assertThat;
import static com.github.ynfeng.xunitwheel.assertion.Assertions.isEquals;

import com.github.ynfeng.xunitwheel.AllTest;
import com.github.ynfeng.xunitwheel.TestCase;
import com.github.ynfeng.xunitwheel.annotation.AnnotationTestCaseScannerTest;
import java.util.List;

public class ClassScannerTest extends TestCase {
    public ClassScannerTest() {
        registerTestMethod("should_scan_files", this::should_scan_files);
    }

    public void should_scan_files() {
        List<Class<?>> classes = new ClassScanner().scan("com.github.ynfeng.xunitwheel");

        assertThat(!classes.isEmpty(), isEquals(true));
        assertThat(classes.contains(AllTest.class), isEquals(true));
        assertThat(classes.contains(AnnotationTestCaseScannerTest.class), isEquals(true));
        assertThat(classes.contains(ClassScannerTest.class), isEquals(true));
    }

    public static void main(String[] args) throws Throwable {
        new ClassScannerTest().run().reportAnyFailed();
    }
}
