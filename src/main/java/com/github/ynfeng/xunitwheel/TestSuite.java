package com.github.ynfeng.xunitwheel;

public class TestSuite {
    private final TestCases testCases = new TestCases();

    protected void registerTestCase(TestCase testCase) {
        testCases.add(testCase);
    }

    public int numOfTestCase() {
        return testCases.size();
    }

    public TestSuiteResult run() {
        TestSuiteResult result = new TestSuiteResult();
        testCases.run(result);
        return result;
    }
}
