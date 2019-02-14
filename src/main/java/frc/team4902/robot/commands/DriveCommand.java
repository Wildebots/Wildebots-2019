package frc.team4902.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4902.robot.Input;
import frc.team4902.robot.subsystems.DriveSystem;

public class DriveCommand extends Command {

    public DriveCommand() {
		  requires(DriveSystem.getInstance());
    }
    
    @Override
    protected void execute() {
      if (Input.getDriveType()) {
          DriveSystem.getInstance().getDrive().arcadeDrive(-Input.primaryXBox.getLeftY(), Input.primaryXBox.getLeftX() * 0.72);
      } 
      else { 
        DriveSystem.getInstance().getDrive().tankDrive(-Input.primaryXBox.getLeftY(), -Input.primaryXBox.getRightY());
			}
    }

    @Override
	  protected boolean isFinished() {
	    return false;
	  }
}