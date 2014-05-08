import org.junit.runner.*;
import org.junit.runner.notification.Failure;

public class Test {

    public static void main(String[] args) {
        JUnitCore.main(
            "oop.ue02.tests.TimeAbleTest",
            "oop.ue02.tests.FuelStationTest",
            "oop.ue02.tests.SimulationTest"
        );
    }
}