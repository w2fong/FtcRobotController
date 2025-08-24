package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "First_Teleop")
public class LinearTeleop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        //Initialization Code Goes Here
        DcMotor motorOne;
        motorOne = hardwareMap.get(DcMotor.class, deviceName: "motor_one");
        //Motor Example
        //motorOne.setDirection(DcMotorSimple.Direction.FORWARD);
        //motorOne.setDirection(DcMotorSimple.Direction.REVERSE);
        //motorOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BREAK);
        //motorOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        //motorOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //motorOne.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //motorOne.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        /*
        * DcMotorEx can be use for FlyWheel with function for Velocity, etc.
         */
        DcMotorEx motorTwo;
        motorTwo = hardwareMap.get(DcMotorEx.class, deviceName: "motor_two");

        Servo servoOne;
        servoOne = hardwareMap.get(Servo.class, deviceName: "servo_one");
        //Servo Examples:
        //servoOne.setPosition(0.5);        //set to initialize position
        servoOne.setPosition(0.5);          //set to initialize position
        servoOne.scaleRange(0.2, 0.8);      //user define new bound instead of 0-1

        /*
         * CRServo can be use for servo with function for Power, etc.
         */
        CRServo servoTwo;
        servoTwo = hardwareMap.get(CRServo.class, deviceName: "servo_two");

        //Controller
        boolean isPressed;
        double joystick;
        boolean isDown = true;
        boolean lastCycle = false, currCycle = false;

        waitForStart();  //Wait for program to start

        /*
        * Loop is very fast, in milli-seconds
         */
        while(opModeIsActive()) {
            //motorOne.setPower(-1);        //[-1, 1]
            //motorOne.setPower(0.5);       //[-1, 1]
            //motorOne.setPower(1);         //[-1, 1]
            //motorTwo.setVelocity(150);

            //servoOne.setPosition(0.5);      //[0-1], set during run mode
            //servoOne.getPosition();
            //servoTwo.setPower(1);

            //gamepad1                      //Controller-1
            //gamepad2                      //Controller-2
            if(gamepad1.a) {
                servoOne.setPosition(1);
            }
            if(gamepad1.b) {
                servoOne.setPosition(0);
            }
            //joystick = gamepad1.left_stick_x;
            //joystick = gamepad1.left_stick_y;
            //joystick = gamepad1.left_stick_y * -1;        //Reversing control

            //motorOne.setMode(gamepad1.left_stick_x);        //Controlling motor
            //motorTwo.setMode(gamepad1.left_stick_y * -1);   //
            isPressed = gamepad1.right_trigger > 0.05;
            if(isPressed) {
                //servoOne.setPosition(0.55);
                servoOne.setPosition(60);
            }
            /*
            if(gamepad1.a) {
                isDown = !isDown;
                if(isDown){
                    servoOne.setPosition(0);
                }else{
                    servoOne.setPosition(1);
                }
            }
            */
            lastCycle = currCycle;
            currCycle = gamepad1.a;
            if(currCycle && !lastCycle) {
                isDown = !isDown;
                if(isDown){
                    servoOne.setPosition(0);
                }else{
                    servoOne.setPosition(1);
                }
            }
        }
    }
}
