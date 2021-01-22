package com.github.ynfeng.xunitwheel.utils;

import static com.github.ynfeng.xunitwheel.Assertions.assertEquals;

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

        assertEquals(!classes.isEmpty(), true);
        assertEquals(classes.contains(AllTest.class), true);
        assertEquals(classes.contains(AnnotationTestCaseScannerTest.class), true);
        assertEquals(classes.contains(ClassScannerTest.class), true);
    }

    public static void main(String[] args) throws Throwable {
        new ClassScannerTest().run().reportAnyFailed();
    }
}
