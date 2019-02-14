package frc.team4902.robot.subsystems; 

import frc.team4902.robot.Ports;
import frc.team4902.robot.commands.DriveCommand; 
import frc.team4902.robot.Robot;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem; 
import edu.wpi.first.wpilibj.drive.DifferentialDrive; 

/* 
 The drive system controls the motors responsible for driving the robot 
 Interacts with move commands and any additional commands that 
 affect movement 
 */ 
public class DriveSystem extends Subsystem {

    private static final DriveSystem INSTANCE = new DriveSystem();

    private final PWMVictorSPX leftSide = new PWMVictorSPX(Ports.DriveTrainLeftSide.PORT), 
            rightSide = new PWMVictorSPX(Ports.DriveTrainRightSide.PORT);

    private final DifferentialDrive drive = new DifferentialDrive(leftSide, rightSide);

    public DriveSystem(){
        super();
    }

    public static DriveSystem getInstance() {
		return INSTANCE;
	}

    public void stop(){
        drive.tankDrive(0, 0);
    }

    public DifferentialDrive getDrive(){
        return drive;
    }

    public void initDefaultCommand() {
		setDefaultCommand(new DriveCommand());
    }
    
    public void setSpeed(double lspeed, double rspeed) {
		drive.tankDrive(lspeed, rspeed);
	}
	
	public void setSpeed(double speed) {
		drive.tankDrive(speed, speed);
	}
}