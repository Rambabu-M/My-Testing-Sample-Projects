package Runner;

import org.junit.jupiter.api.BeforeAll;
import com.intuit.karate.junit5.Karate;

public class TestRunner {

	@Karate.Test
    Karate sampleTestRunnerMethod() {
        //return Karate.run("classpath:FeatureFiles/sample.feature");
		return Karate.run("classpath:FeatureFiles/signatureCreation.feature");
    }
	
	@BeforeAll
	public static void before() {
		if (System.getProperty("karate.env") == null) {
	        System.setProperty("karate.env", "admin");
	    }
		
	}
}
