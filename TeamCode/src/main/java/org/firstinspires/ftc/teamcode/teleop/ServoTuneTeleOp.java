// teleop/ServoTuneTeleOp.java
package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.hardware.RobotHardware;
import org.firstinspires.ftc.teamcode.common.ServoTuner;

@TeleOp(name="Servo Tuner")
public class ServoTuneTeleOp extends LinearOpMode {
    private RobotHardware hw = new RobotHardware();
    private ServoTuner clawTuner;

    @Override
    public void runOpMode() {
        hw.init(hardwareMap);
        clawTuner = new ServoTuner(hw.claw, 0.5);  // start in middle

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.dpad_up) clawTuner.adjust(0.01);
            if (gamepad1.dpad_down) clawTuner.adjust(-0.01);

            telemetry.addData("Claw Servo Pos", clawTuner.getPosition());
            telemetry.addLine("Use dpad_up/down to adjust");
            telemetry.update();

            sleep(100);  // debounce
        }
    }
}