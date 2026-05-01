package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import java.lang.reflect.Array;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import java.util.ArrayList;
import java.util.Collections;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class StateBasedMachine {

	public enum RESET_CODES {
		MOTOR,
		SERVO,
		OTHER
	}

	// stateBasedMachineObject
	private class SBM_O {
		private HardwareDevice device;
		private double finishTime;
		private RESET_CODES resetCode;

		public SBM_O(HardwareDevice device, double finishTime, RESET_CODES resetCode) {
			this.device = device;
			this.finishTime = finishTime;
			this.resetCode = resetCode;
		}
	}

	// stateBasedMachineObjects
	private ArrayList<SBM_O> SBMO = new ArrayList<>();


	// Used by other files to add objects and their timers to the SBM checklist
	public void AddSBM(HardwareDevice object, double finishTime, RESET_CODES resetCode) {
		SBMO.add(new SBM_O(object, finishTime, resetCode));
	}
	
	public void checkSBM(double runtime) {
		ArrayList<SBM_O> removed = new ArrayList<>();
		//go through all objects in SBMO
		// foreach loop
		for (SBM_O object : SBMO) {
			// if the current time is past the object's finish time 
			if (object.finishTime <= runtime) {

				// This is where the doing happens after the timer expires. 


				// possibly change this to switch statement
				if (object.device instanceof DcMotor) {
					DcMotor temp = (DcMotor) object.device;
					temp.setPower(0.0d);
				} else if (object.device instanceof Servo){
					Servo temp = (Servo) object.device;
					temp.setPosition(0.0d);
				}
				removed.add(object);
			}
		}
		for (SBM_O e : removed){
			SBMO.remove(e);
		}
	}
}
