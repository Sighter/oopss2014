import org.junit.runner.*;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        JUnitCore.main(
            "oop.ue03.tests.FileReaderWriterTest",
            "oop.ue03.tests.RepeaterTest"
        );
    }
}