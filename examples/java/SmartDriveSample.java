/*
 * Author: Stefan Andritoiu <stefan.andritoiu@gmail.com>
 * Copyright (c) 2017 Intel Corporation.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

public class SmartDriveSample {

	public static void main(String[] args) throws InterruptedException {
		// ! [Interesting]

		// Instantiate a SmartDrive connected to /dev/i2c-0 bus, using
		// DefaultAddress
		upm_smartdrive.SmartDrive drive = new upm_smartdrive.SmartDrive(0);

		System.out.println("Battery Voltage before motor run : " + drive.GetBattVoltage());
		// Set motor M1 to run for 120 seconds, with speed of 15RPM, waith for
		// it to finish and then Brake It
		drive.Run_Seconds(upm_smartdrive.javaupm_smartdriveConstants.SmartDrive_Motor_ID_1,
				upm_smartdrive.javaupm_smartdriveConstants.SmartDrive_Dir_Forward, 15, 120, true,
				upm_smartdrive.javaupm_smartdriveConstants.SmartDrive_Action_Brake);
		System.out.println("Battery Voltage after motor run : " + drive.GetBattVoltage());
		// Rotate motor M2 2270 degrees, in reverse sense, with speed of 10RPM,
		// return immediately from function call
		drive.Run_Degrees(upm_smartdrive.javaupm_smartdriveConstants.SmartDrive_Motor_ID_2,
				upm_smartdrive.javaupm_smartdriveConstants.SmartDrive_Dir_Reverse, 10, 2270, false,
				upm_smartdrive.javaupm_smartdriveConstants.SmartDrive_Action_Float);
		// While motor is running, Display its status
		drive.PrintMotorStatus(upm_smartdrive.javaupm_smartdriveConstants.SmartDrive_Motor_ID_2);

		Thread.sleep(2000); // Sleep for 2 seconds
		// Stop motor M2 and then finish program
		drive.StopMotor(upm_smartdrive.javaupm_smartdriveConstants.SmartDrive_Motor_ID_2,
				upm_smartdrive.javaupm_smartdriveConstants.SmartDrive_Action_BrakeHold);

		// ! [Interesting]

		System.out.println("Demo complete. GoodBye");
	}
}
