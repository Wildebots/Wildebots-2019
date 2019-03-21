package frc.team4902.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team4902.robot.subsystems.DriveSystem;

public class Robot extends TimedRobot { 

    public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();

    private static Robot INSTANCE;

    public Robot() {
		INSTANCE = this;
    }
    
    @Override 
    public void robotInit() { 
        Robot.INSTANCE = this;

        DriveSystem.getInstance();

        UsbCamera cam = CameraServer.getInstance().startAutomaticCapture(0);
		
		cam.setResolution(640, 480);
		
        cam.setFPS(30);

        UsbCamera cam_2 = CameraServer.getInstance().startAutomaticCapture(1);

        cam_2.setResolution(640, 480);

        cam_2.setFPS(30);
        
        Input.initializeInputs();
    } 

    @Override 
    public void teleopInit() { } 

    @Override
    public void disabledInit() {
        super.disabledInit();
    }

    @Override 
    public void disabledPeriodic() { 
    
    } 

    @Override 
    public void teleopPeriodic() { 
        Scheduler.getInstance().run();
    } 

    public static Robot getInstance() {
		return INSTANCE;
	}
} 
