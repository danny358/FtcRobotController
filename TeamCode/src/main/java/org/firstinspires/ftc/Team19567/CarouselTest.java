package org.firstinspires.ftc.Team19567;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="Carousel Test", group="Iterative Opmode")
public class CarouselTest extends OpMode{
    private DcMotor carouselLeft = null;
    private DcMotor carouselRight = null;
    private Mechanisms mechanisms = null;
    private final ElapsedTime carouselTime = new ElapsedTime();
    public int milliAccelerate = 800;
    public int milliMax = 1300;
    public double initPower = 0.6;
    public double accPower = initPower;
    public int accCoefficient = 2000;


    @Override
    public void init() {
        carouselLeft = hardwareMap.get(DcMotor.class, "carouselLeft");
        carouselRight = hardwareMap.get(DcMotor.class,"carouselRight");
        mechanisms = new Mechanisms(hardwareMap,telemetry);
        telemetry.update();
    }

    @Override
    public void init_loop() {
        telemetry.addData("Status", "Awaiting Start");
        telemetry.update();
    }
    @Override
    public void start() {
        telemetry.addData("Status", "Started");
        telemetry.update();
        carouselTime.reset();
    }

    @Override
    public void loop() {

        if(gamepad2.right_trigger > 0 || gamepad1.dpad_right || gamepad1.dpad_left)
        {
            carouselTime.reset();
            if(carouselTime.milliseconds() <= milliAccelerate) mechanisms.rotateCarousel(initPower);
            if(carouselTime.milliseconds() >= milliAccelerate && carouselTime.milliseconds() <= milliMax) {
                accPower +=  carouselTime.milliseconds()/accCoefficient;
                mechanisms.rotateCarousel(accPower);
            }
            else mechanisms.rotateCarousel(1);
        }

        /*
        if(gamepad2.right_trigger > 0 || gamepad1.dpad_right || gamepad1.dpad_left)
        {
            carouselTime.reset();
            if(carouselTime.milliseconds() <= milliCarousel) mechanisms.rotateCarousel(initPower);
            else mechanisms.rotateCarousel(Range.clip(Math.pow(2 , (carouselTime.milliseconds() - expStartPoint/expCoefficient) + initPower)),initPower, finalPower);

        }
         */


        telemetry.addData("Status", "Looping");
        telemetry.addData("Time till acceleration ", milliAccelerate + " Milliseconds");
        telemetry.addData("Initial Carousel Speed ", initPower);
        telemetry.addData("Acceleration", accPower);
        telemetry.addData("Acceleration Coefficient", accCoefficient);
        telemetry.update();

    }
    @Override
    public void stop() {
        telemetry.addData("Status", "Stopped");
        telemetry.update();
    }
}
