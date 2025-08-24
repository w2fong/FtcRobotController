@TeleOp(name="DriverControlled")
public class DriverControlled extends LinearOpMode {
    private RobotHardware hw = new RobotHardware();
    private Drivetrain drivetrain;

    @Override
    public void runOpMode() {
        hw.init(hardwareMap);
        drivetrain = new Drivetrain(hw);

        waitForStart();

        while (opModeIsActive()) {
            double left = -gamepad1.left_stick_y;
            double right = -gamepad1.right_stick_y;
            drivetrain.drive(left, right);
        }
    }
}