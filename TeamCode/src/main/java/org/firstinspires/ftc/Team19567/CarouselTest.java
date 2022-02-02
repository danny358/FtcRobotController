package org.firstinspires.ftc.Team19567;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name="Carousel Test", group="Iterative Opmode")
public class CarouselTest extends OpMode{
    private DcMotor carouselLeft = null;
    private DcMotor carouselRight = null;
    private Mechanisms mechanisms = null;
    private final ElapsedTime carouselTime = new ElapsedTime();
    private int milliCarousel = 2000;
    private double initPower = 0.7;
    private double finalPower = 1;


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

        if(gamepad2.right_trigger > 0 || gamepad1.dpad_right || gamepad1.dpad_left){
            carouselTime.reset();
            if(carouselTime.milliseconds() <= milliCarousel) mechanisms.rotateCarousel(initPower);
            else mechanisms.rotateCarousel(finalPower);
        }

        if(gamepad1.right_trigger > 0){
            milliCarousel += 200;
        }
        else if(gamepad1.right_bumper){
            milliCarousel -= 200;
        }

        else if(gamepad1.left_trigger > 0){
            initPower += 0.05;
        }

        else if(gamepad1.left_bumper){
            initPower -= 0.05;
        }

        else if(gamepad2.dpad_down){
            finalPower -= 0.05;
        }

        telemetry.addData("Status", "Looping");
        telemetry.addData("Carousel Runtime ", milliCarousel + " Milliseconds");
        telemetry.addData("Initial Carousel Speed ", initPower);
        telemetry.addData("Final Carousel Speed ", finalPower);
        telemetry.update();

    }
    @Override
    public void stop() {
        telemetry.addData("Status", "Stopped");
        telemetry.update();
    }
}
