package org.firstinspires.ftc.Team19567;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


public class james extends OpMode {
    DcMotor LB;
    DcMotor LF;
    DcMotor RB;
    DcMotor RF;


//Mecanum Drive

    @Override

    public void loop() {
        double Up = -gamepad1.left_stick_y;
        double Side = gamepad1.left_stick_x;
        double pivot = gamepad1.right_stick_x; //controls pivotting movements

        double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
        double RA = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;

        // caculates the amount of power we need in motors...

        final double LS1 = (r * Math.sin(RA) - gamepad1.right_stick_x);
        final double RS1 = (r * Math.cos(RA) + gamepad1.right_stick_x);
        final double LS2 = (r * Math.cos(RA) - gamepad1.right_stick_x);
        final double RS2 = (r * Math.sin(RA) + gamepad1.right_stick_x);


//commented out not-needed segments

//RF.setPower(Skyblock + (-Up + Side));
//RB.setPower(Skyblock + (-Up - Side));
//LF.setPower(Skyblock + (-Up - Side));
//LB.setPower(Skyblock + (-Up + Side));
    }

    @Override

    public void init() {
        LB = hardwareMap.get(DcMotor.class, "LB");
        LF = hardwareMap.get(DcMotor.class, "LF");
        RB = hardwareMap.get(DcMotor.class, "RB");
        RF = hardwareMap.get(DcMotor.class, "RF");


}
    @Override

    public void start () {
        telemetry.update();
        RB.setDirection(DcMotorSimple.Direction.REVERSE); //sets R motors to reverse IF we need... and I dont know about the L motors
        RF.setDirection(DcMotorSimple.Direction.REVERSE);
    }
}



