package Runner;

import com.intuit.karate.junit5.Karate;

public class TestRunner {

	@Karate.Test
    Karate sampleTestRunnerMethod() {
        return Karate.run("classpath:FeatureFiles/firstfeaturefile.feature");
    }
}
