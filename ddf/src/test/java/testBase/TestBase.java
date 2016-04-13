package testBase;

import org.junit.Rule;
import org.junit.rules.TestName;

public class TestBase {
	@Rule public TestName name = new TestName();
}
