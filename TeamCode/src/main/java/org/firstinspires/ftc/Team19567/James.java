package org.firstinspires.ftc.Team19567;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

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
    private double carouselPower = 0.0;
    private double linearSlidePower = 1.0;
    private double linearSlidePos = 0.0;
    private double releaseServoPos = 0.0;
    private double intakeServoPos = 0.0;
    private boolean preset3 = false;
    private boolean slowmode = false;
    private double acc = 1;
    double x = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
    double angle = Math.hypot(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;

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

        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.FORWARD);
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        intakeDC.setDirection(DcMotor.Direction.REVERSE);
        linearSlideDC.setDirection(DcMotor.Direction.FORWARD);

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

        if(gamepad1.y) isSlowmode = !isSlowmode;
        if(isSlowmode) acc = 0.3;
        else acc = 1.0;
        final double leftFrontSpeed = (r * Math.sin(angleDC) - gamepad1.right_stick_x)*acc; //Using the math explained above, we can obtain the values we want to multiply each wheel by. acc is the variable which controls the overall multiplier of how fast we want to go.
        final double rightFrontSpeed = (r * Math.cos(angleDC) + gamepad1.right_stick_x)*acc;
        final double leftBackSpeed = (r * Math.cos(angleDC) - gamepad1.right_stick_x)*acc;
        final double rightBackSpeed = (r * Math.sin(angleDC) + gamepad1.right_stick_x)*acc;
        //INTAKE
        double intakePower = 0.0;
        if(gamepad2.right_trigger > 0) intakePower = gamepad2.right_trigger;
        if(gamepad1.right_trigger >0) intakePower = gamepad1.right_trigger;
        if(gamepad1.right_bumper || gamepad2.right_bumper) intakePower = -1.0;
        //CAROUSEL
        if(gamepad1.x || gamepad2.x) carouselPower = -0.5;
        else if(gamepad1.a || gamepad2.a) carouselPower = 0.5;
        else carouselPower = 0.0;
        //LINEAR SLIDE
        if(gamepad1.left_trigger > 0) linearSlidePos += gamepad1.left_trigger*5;
        else if(gamepad2.left_trigger > 0) linearSlidePos += gamepad2.left_trigger*5;
        if(gamepad1.left_bumper || gamepad2.left_bumper) {
            if(linearSlidePressDelay.milliseconds() <= 10) linearSlidePos = 0.0;
            else linearSlidePos = Range.clip(linearSlidePos - 10, 0.0, linearSlidePos - 5);
            linearSlidePressDelay.reset();



        telemetry.addData("Status","Looping");
        telemetry.update();
        if(gamepad1.y) slowmode = !slowmode;
        if(slowmode)
        { acc = 0.3;
        else acc = 1.0; }
        double forwardright = (x * angle + gamepad1.right_stick_x)*acc;

        double backwardright = (x * (angle) + gamepad1.right_stick_x)*acc;

        double forwardleft = (x * angle - gamepad1.right_stick_y)*acc;

        double backwardleft = (x * angle - gamepad1.right_stick_y)*acc;

        if(gamepad2.right_trigger > 0)

        if(gamepad1.right_trigger >0)

        if(gamepad1.right_bumper || gamepad2.right_bumper);

    }
    36259
    360.



    @Override
    public void stop() {
        telemetry.addData("Status","Stopped");
        telemetry.update();

    }
}