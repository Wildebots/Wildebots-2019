package frc.team4902.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team4902.robot.Ports;

public class HatchSystem extends Subsystem {
	//Defines Instance of Hatch System
	private static final HatchSystem INSTANCE = new HatchSystem();
	//Defines Hatch Encoder
	public final PWMVictorSPX Motor = new PWMVictorSPX(Ports.HatchMotor.PORT);
	
	@Override
	protected void initDefaultCommand() {}
	
	private HatchSystem() {
		super();
	}

	public static HatchSystem getInstance() {
		return INSTANCE;
	}
	
	public void setSpeed(double speed) {
			Motor.set(speed);
    }
    
    public void open(){
        Motor.set(1.0);
    }

    public void close(){
        Motor.set(-1.0);
    }
}