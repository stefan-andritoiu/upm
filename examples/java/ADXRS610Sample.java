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

public class ADXRS610Sample {

	public static void main(String[] args) throws InterruptedException {
		// ! [Interesting]

		// Instantiate a ADXRS610 sensor on analog pin A0 (dataout), and
		// analog A1 (temp out) with an analog reference voltage of
		// 5.0
		upm_adxrs610.ADXRS610 sensor = new upm_adxrs610.ADXRS610(0, 1);

		// set a deadband region around the zero point to report 0.0 (optional)
		sensor.setDeadband(0.015f);

		// Every tenth of a second, sample the ADXRS610 and output it's
		// corresponding temperature and angular velocity

		while (true) {
			float value = sensor.getAngularVelocity();
			System.out.println("Vel (deg/s): " + value);
			value = sensor.getTemperature();
			System.out.println("Temp (C): " + value);
			Thread.sleep(100);
		}

		// ! [Interesting]
	}
}
