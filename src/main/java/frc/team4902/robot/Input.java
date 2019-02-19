  package frc.team4902.robot;

import java.util.concurrent.atomic.AtomicBoolean;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team4902.robot.commands.*;

/*
    Creates instance of Xbox controller and defines button mappings
*/

public class Input {
    //Creates instance of xbox controllers for use
    public static final XBoxInput primaryXBox = new XBoxInput(0), secondaryXBox = new XBoxInput(0);

    // true -> arcade ; false -> tank
    private static final AtomicBoolean driveType = new AtomicBoolean(true);

    //Defines Xbox button inputs
    public static final class XBoxInput extends XboxController {
       
        //creates buttons and bumpers
        public final JoystickButton A = new JoystickButton(this, 1), 
                B = new JoystickButton(this, 2),
                X = new JoystickButton(this, 3), 
                Y = new JoystickButton(this, 4),
                leftBumper = new JoystickButton(this, 5), 
                rightBumper = new JoystickButton(this, 6),
                back = new JoystickButton(this, 7), 
								start = new JoystickButton(this, 8);

        
        //constructor
		public XBoxInput(int port) {
			super(port);
		}

        //Methods to get axis and triggers
		public double getLeftX() {
			System.out.println(this.getRawAxis(0));
			return this.getRawAxis(0);
		}

		public double getLeftY() {
			System.out.println(this.getRawAxis(1));
			return this.getRawAxis(1);
		}

		public double getRightX() {
			System.out.println(this.getRawAxis(4));
			return this.getRawAxis(4);
		}

		public double getRightY() {
			System.out.println(this.getRawAxis(5));
			return this.getRawAxis(5);
		}
		
		public double getLeftTrigger() {
			return this.getRawAxis(2);
		}
		
		public double getRightTrigger() {
			return this.getRawAxis(3);
		}

        //returns true if controller is plugged in, false otherwise
		public boolean isPluggedIn() {
			return DriverStation.getInstance().getJoystickIsXbox(getPort());
		}

    }
    

    //Sets drive type to arcade or tank
    public static void setDriveType(boolean mode) {
		driveType.set(mode);
    }
    
    //Returns current drive type
    public static boolean getDriveType() {
		return driveType.get();
	}
    
    //Switches between drive types
	public static void toggleDriveType() {
		Input.setDriveType(!Input.getDriveType());
    }
    
    //Maps buttons to runnable commands
    public static void initializeInputs() {

        //Toggles drive type when X is pressed
		Input.primaryXBox.X.whenPressed(RunnableCommand.create(() -> Input.toggleDriveType()));
		Input.primaryXBox.Y.whenPressed(RunnableCommand.create(() -> new HatchOpen()));
		Input.primaryXBox.A.whenPressed(RunnableCommand.create(() -> new HatchClose()));
	
	}
}