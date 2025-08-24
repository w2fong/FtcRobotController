@Autonomous(name="AutoLeft")
public class AutoLeft extends AutoBase {
    @Override
    protected void execute() {
        drivetrain.drive(0.5, 0.5);
        sleep(1000);
        drivetrain.stop();
        // add arm/servo moves here
    }
}