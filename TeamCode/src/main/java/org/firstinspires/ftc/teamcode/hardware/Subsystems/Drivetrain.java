public class Drivetrain {
    private RobotHardware hw;

    public Drivetrain(RobotHardware hw) {
        this.hw = hw;
    }

    public void drive(double leftPower, double rightPower) {
        hw.leftDrive.setPower(leftPower);
        hw.rightDrive.setPower(rightPower);
    }

    public void stop() {
        drive(0, 0);
    }
}