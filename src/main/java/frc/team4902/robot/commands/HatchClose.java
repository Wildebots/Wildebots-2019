package frc.team4902.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4902.robot.subsystems.HatchSystem;

public class HatchClose extends Command {
    public HatchClose(){
        requires(HatchSystem.getInstance());
    }

    @Override
    protected void initialize(){
        setTimeout(1.0);
        HatchSystem.getInstance().close();
    }

    @Override
	protected boolean isFinished() {
	    return isTimedOut();
	}
}