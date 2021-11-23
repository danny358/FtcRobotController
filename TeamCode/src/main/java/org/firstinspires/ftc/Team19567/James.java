package org.firstinspires.ftc.Team19567;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="JamesOP", group="Iterative Opmode")
public class James extends OpMode {

    private DcMotor leftFront = null;
    private DcMotor leftBack = null;
    private DcMotor rightFront = null;
    private DcMotor rightBack = null;
    private DcMotor intakeDC = null;
    private DcMotor linearSlideDC = null;
    private DcMotor carouselMotor = null;
    private Servo releaseServo = null;

    @Override
    public void init() {
        leftFront = hardwareMap.get(DcMotor.class,"leftFront");
        leftBack = hardwareMap.get(DcMotor.class,"leftBack");
        rightFront = hardwareMap.get(DcMotor.class,"rightFront");
        rightBack = hardwareMap.get(DcMotor.class,"rightBack");
        intakeDC = hardwareMap.get(DcMotor.class,"intakeDC");
        linearSlideDC = hardwareMap.get(DcMotor.class,"linearSlideDC");
        carouselMotor = hardwareMap.get(DcMotor.class,"carouselDC");
        releaseServo = hardwareMap.get(Servo.class,"releaseServo");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    @Override
    public void init_loop() {
        telemetry.addData("Status", "Awaiting Start");
        telemetry.update();
    }

    @Override
    public void start() {
        telemetry.addData("Status","Started");
        telemetry.update();

    }

    @Override
    public void loop() {
        telemetry.addData("Status","Looping");
        telemetry.update();

    }

    @Override
    public void stop() {
        telemetry.addData("Status","Stopped");
        telemetry.update();

    }
}