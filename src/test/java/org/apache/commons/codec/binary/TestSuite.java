package org.apache.commons.codec.binary;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Base64 测试集")
@SelectClasses({Base64JUnitTest.class})
public class TestSuite {
}