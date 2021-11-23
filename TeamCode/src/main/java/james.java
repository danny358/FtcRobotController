package org.firstinspires.ftc.Team19567;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
                import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
w
public class james extends OpMode{
    DcMotor LB;
    DcMotor LF;
    DcMotor RB;
    DcMotor RF;

} 

//Mecanum Drive

public void loop () {
double Up = 0;
double Side = 0;
double Skyblock = 0; //controls pivotting movements //skyblock is temporary just tryna test my power thing lfs lf

Up = -gamepad1.left_stick_y;
Side = gamepad1.left_stick_x;
Skyblock = gamepad1.right_stick_x;

//motor power

RF.setPower(Skyblock + (-Up + Side));
RB.setPower(Skyblock + (-Up - Side));
LF.setPower(Skyblock + (-Up - Side));
LB.setPower(Skyblock + (-Up + Side));
}

@Override

public  void init () {
 LB = hardwareMap.get(DcMotor.class,  "LB");
    LF = hardwareMap.get(DcMotor.class,  "LF");
    RB = hardwareMap.get(DcMotor.class,  "RB");
    RF = hardwareMap.get(DcMotor.class,  "RF");

    RB.setDirection(DcMotorSimple.Direction.REVERSE); //sets R motors to reverse
    RF.setDirection(DcMotorSimple.Direction.REVERSE);
} }


