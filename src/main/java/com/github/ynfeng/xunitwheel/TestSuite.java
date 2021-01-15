package com.github.ynfeng.xunitwheel;

public class TestSuite {
    private final TestCases testCases = new TestCases();
    private final String name;

    public TestSuite(String name) {
        this.name = name;
    }

    protected void registerTestCase(TestCase testCase) {
        testCases.add(testCase);
    }

    public int numOfTestCase() {
        return testCases.size();
    }

    public String name() {
        return name;
    }

    public TestSuiteResult run() {
        TestSuiteResult result = new TestSuiteResult(name);
        testCases.run(result);
        return result;
    }
}
