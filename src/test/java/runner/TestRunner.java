package runner;


import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.testng.annotations.Test;

public class TestRunner {

    @Test
    void runScenario() {
        Results results = Runner.path("classpath:KarateFeatureFiles/")
                .tags("@smoke")
                .outputJunitXml(true).parallel(1);
    }
}
