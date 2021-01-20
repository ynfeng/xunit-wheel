package com.github.ynfeng.xunitwheel.runner;

import static com.github.ynfeng.xunitwheel.Assertions.assertEquals;

import com.github.ynfeng.xunitwheel.TestCase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestSuiteRunnerTest extends TestCase {
    private ByteArrayOutputStream out;

    public TestSuiteRunnerTest() {
        registerTestMethod("should_run", this::should_run);
    }

    @Override
    public void setup() {
        out = new ByteArrayOutputStream();
        TestResultPrinter.redirectOutputStream(new PrintStream(out));
    }

    @Override
    public void tearDown() {
        TestResultPrinter.redirectOutputStream(System.out);
    }

    public void should_run() {
        try {
            TestRunner.main(new String[] {"com.github.ynfeng.xunitwheel.runner.TestableTestSuite"});
        } catch (Throwable ignored) {
        }

        String expectOutput = "Running com.github.ynfeng.xunitwheel.SingleTestMethodTestCase\n" +
            "\u001B[38;5;84mTests\u001B[0m run: 1, Failures: 0\n" +
            "Running com.github.ynfeng.xunitwheel.BrokenTestCase\n" +
            "\u001B[38;5;196mTests\u001B[0m run: 1, Failures: 1\n";
        assertEquals(expectOutput, out.toString());
    }

    public static void main(String[] args) throws Throwable {
        new TestSuiteRunnerTest().run().reportAnyFailed();
    }
}
