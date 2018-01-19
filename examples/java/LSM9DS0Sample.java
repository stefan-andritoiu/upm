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

import java.util.AbstractList;
import java.lang.Float;

public class LSM9DS0Sample {

	public static void main(String[] args) throws InterruptedException {
		// ! [Interesting

		// Instantiate an LSM9DS0 using default parameters (bus 1, gyro addr 6b,
		// xm addr 1d)

		upm_lsm9ds0.LSM9DS0 sensor = new upm_lsm9ds0.LSM9DS0();

		sensor.init();

		while (true) {
			sensor.update();

			AbstractList<Float> accel = sensor.getAccelerometer();
			System.out.println("Accelerometer: ");
			System.out.println("AX: " + accel.get(0) + "; AY: " + accel.get(1) + "; AZ: " + accel.get(2));

			AbstractList<Float> gyro = sensor.getGyroscope();
			System.out.println("Gyroscope: ");
			System.out.println("GX: " + gyro.get(0) + "; GY: " + gyro.get(1) + "; GZ: " + gyro.get(2));

			AbstractList<Float> magnet = sensor.getMagnetometer();
			System.out.println("Magnetometer: ");
			System.out.println("MX: " + magnet.get(0) + "; MY: " + magnet.get(1) + "; MZ: " + magnet.get(2));

			System.out.println("Temperature: " + sensor.getTemperature());

			Thread.sleep(500);
		}

		// ! [Interesting]
	}
}
