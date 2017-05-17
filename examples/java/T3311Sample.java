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

public class T3311Sample {

	public static void main(String[] args) throws InterruptedException {
		// ! [Interesting]
		String defaultDev = "/dev/ttyUSB0";

		// if an argument was specified, use it as the device instead
		if (args.length > 0)
			defaultDev = args[0];

		System.out.println("Initializing...");

		// Instantiate an T3311 instance, using MODBUS slave address 1, and
		// default comm parameters (9600, 8, N, 2)
		upm_t3311.T3311 sensor = new upm_t3311.T3311(defaultDev, 1);

		// output the serial number and firmware revision
		System.out.println("Serial Number: " + sensor.getSerialNumber());
		System.out.println("Firmware Revision: " + sensor.getFirmwareMajor() + "." + sensor.getFirmwareMinor());

		// update and print available values every second
		while (true) {
			// update our values from the sensor
			sensor.update();

			// we show both C and F for temperature
			System.out
					.println("Temperature: " + sensor.getTemperature() + " C / " + sensor.getTemperature(true) + " F");

			System.out.println("Humidity: " + sensor.getHumidity() + " %");

			// this value depends on the sensor configuration -- by default
			// it is the dew point temperature
			System.out.println("Computed Value: " + sensor.getComputedValue());

			// with FW revisions > 2.44, extended computed data is available
			if (sensor.extendedDataAvailable()) {
				System.out.println("Dew Point Temperature: " + sensor.getDewPointTemperature() + " C / "
						+ sensor.getDewPointTemperature(true) + " F");

				System.out.println("Absolute Humidity: " + sensor.getAbsoluteHumidity() + " g/m3");

				System.out.println("Specific Humidity: " + sensor.getSpecificHumidity() + " g/kg");

				System.out.println("Mixing Ratio: " + sensor.getMixingRatio() + " g/kg");

				System.out.println("Specific Enthalpy: " + sensor.getSpecificEnthalpy() + " kJ/kg");
			}

			System.out.println();

			Thread.sleep(1000);
		}
		// ! [Interesting]
	}
}
