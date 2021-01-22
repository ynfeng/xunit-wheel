package com.github.ynfeng.xunitwheel.utils;

import static com.github.ynfeng.xunitwheel.assertion.Assertions.assertThat;
import static com.github.ynfeng.xunitwheel.assertion.Assertions.isEquals;

import com.github.ynfeng.xunitwheel.AllTest;
import com.github.ynfeng.xunitwheel.annotation.AnnotationTestCaseScannerTest;
import com.github.ynfeng.xunitwheel.annotation.Test;
import java.util.List;

public class ClassScannerTest {

    @Test
    public void should_scan_files() {
        List<Class<?>> classes = new ClassScanner().scan("com.github.ynfeng.xunitwheel");

        assertThat(!classes.isEmpty(), isEquals(true));
        assertThat(classes.contains(AllTest.class), isEquals(true));
        assertThat(classes.contains(AnnotationTestCaseScannerTest.class), isEquals(true));
        assertThat(classes.contains(ClassScannerTest.class), isEquals(true));
    }
}
