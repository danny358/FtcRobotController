import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DistanceSensor;
public class james extends LinearOpMode
{

    boolean highLevel = false;                  // used to prevent multiple level-based rumbles.

    Gamepad.RumbleEffect BoxSecured;
    Gamepad.RumbleEffect endgamerumble;
    ElapsedTime runtime = new ElapsedTime();    // How endgame time is determined.

    final double END_GAME = 90;
    final double HALF_TIME = 60.0;


    @Override
    public void runOpMode()
    {
        // Example 1. a)   start by creating a three-pulse rumble sequence: right, LEFT, LEFT
        endgamerumble = new Gamepad.RumbleEffect.Builder()
                .addStep(0.0, 1.0, 500)  //  Rumble right motor 100% for 500 mSec
                .addStep(0.0, 0.0, 300)  //  Pause for 300 mSec
                .addStep(1.0, 0.0, 250)  //  Rumble left motor 100% for 250 mSec
                .addStep(0.0, 0.0, 250)  //  Pause for 250 mSec
                .addStep(1.0, 0.0, 250)  //  Rumble left motor 100% for 250 mSec
                .build();

        BoxSecured = new Gamepad.RumbleEffect.Builder()
                .addStep(0.0, 1.0, 1000)  //  Rumble right motor 100% for one whole seconds

                .build();



        waitForStart();
        runtime.reset();    // Start game timer.


            if ((runtime.seconds() > END_GAME))   {
            gamepad1.runRumbleEffect(endgamerumble);

        }

        if((runtime.milliseconds() >= 85000 && runtime.milliseconds() <= 90000) || (runtime.milliseconds() >= 115000))
        {
            gamepad1.runRumbleEffect(BoxSecured);

        }
        else {
            gamepad1.stopRumble();
        }
    }
}