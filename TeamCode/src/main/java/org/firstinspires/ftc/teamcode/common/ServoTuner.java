package org.firstinspires.ftc.teamcode.common;

import com.qualcomm.robotcore.hardware.Servo;

public class ServoTuner {
    private Servo servo;
    private double position;

    public ServoTuner(Servo servo, double startPos) {
        this.servo = servo;
        this.position = startPos;
        this.servo.setPosition(startPos);
    }

    public void adjust(double delta) {
        position = Math.max(0.0, Mth.min(1.0, position + delta));
        servo.setPosition(position);
    }

    public double getPosition() {
        return position;
    }

}