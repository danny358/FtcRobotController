package org.firstinspires.ftc.Team19567;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name="JAMES", group="Iterative Opmode")
public class james extends OpMode {
    private DcMotor leftBack = null;
    private DcMotor leftFront = null;
    private DcMotor rightBack = null;
    private DcMotor rightFront = null;

    @Override
    public void init() {
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
    }

    @Override
    public void start() {
        telemetry.addData("status","Started" );
        telemetry.update();
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE); //sets R motors to reverse IF we need... and I dont know about the L motors
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    public void init_loop() {
        telemetry.addData("status","init_loop" );
        telemetry.update();
    }

    @Override
    public void loop() {
        double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
        double RA = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;

        // caculates the amount of power we need in motors...

        final double L1 = (r * Math.sin(RA) - gamepad1.right_stick_x);
        final double R1 = (r * Math.cos(RA) + gamepad1.right_stick_x);
        final double L2 = (r * Math.cos(RA) - gamepad1.right_stick_x);
        final double R2 = (r * Math.sin(RA) + gamepad1.right_stick_x);

        leftFront.setPower(L1);
        rightFront.setPower(R1);
        leftBack.setPower(L2);
        rightBack.setPower(R2);
    }

    @Override
    public void stop() {
        telemetry.addData("status", "stopped");
        telemetry.update();
    }
}