package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import java.util.ArrayList;
import java.util.Collections;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import javafx.util.pair;
import com.qualcomm.robotcore.util.ElapsedTime;

public class StateBasedMachine {
	//Operation list are the objects currently active
	private String[] object;
	//Time list is the time in miliseconds when the corresponding object needs to be turned off
	private String[] time;
	private String[] resetType;
	private int[] resetState;

	public void AddSBM(String object, int length, int runtime, String Type, int State) {
		
	}
	
	public void checkSBM(int runtime) {
		for (int i = 0; i=operations.length; i++) {
			if (time[i]>runtime) {
				if (resetType[i]="Motor") {
					object[i].setPower(resetState[i]);
				}
			}
		}
	}
}
