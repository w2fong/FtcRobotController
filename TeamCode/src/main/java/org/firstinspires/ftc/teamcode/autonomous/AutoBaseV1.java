public abstract class AutoBase extends LinearOpMode {
    protected RobotHardware hw = new RobotHardware();
    protected Drivetrain drivetrain;

    @Override
    public void runOpMode() {
        hw.init(hardwareMap);
        drivetrain = new Drivetrain(hw);

        waitForStart();
        execute();
    }

    protected abstract void execute();
}