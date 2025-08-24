public class RobotHardware {
    public DcMotor leftDrive, rightDrive;
    public Servo claw;
    public IMU imu;

    public void init(HardwareMap hwMap) {
        leftDrive = hwMap.get(DcMotor.class, "left_drive");
        rightDrive = hwMap.get(DcMotor.class, "right_drive");
        claw = hwMap.get(Servo.class, "claw");
        imu = hwMap.get(IMU.class, "imu");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
    }
}