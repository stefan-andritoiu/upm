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

public class HWXPXXSample {

	public static void main(String[] args) throws InterruptedException {
		// ! [Interesting]

		String defaultDev = "/dev/ttyUSB0";

		// if an argument was specified, use it as the device instead
		if (args.length > 0)
			defaultDev = args[0];

		System.out.println("Using device " + defaultDev);
		System.out.println("Initializing...");

		// Instantiate an HWXPXX instance, using MODBUS slave address 3, and
		// default comm parameters (19200, 8, N, 2)
		upm_hwxpxx.HWXPXX sensor = new upm_hwxpxx.HWXPXX(defaultDev, 3);

		// output the Slave ID (manufacturer, model, serno)
		System.out.println("Slave ID: " + sensor.getSlaveID());

		// stored temperature and humidity offsets
		System.out.println("Temperature Offset: " + sensor.getTemperatureOffset());
		System.out.println("Humidity Offset: " + sensor.getHumidityOffset());

		// update and print available values every second
		while (true) {
			// update our values from the sensor
			sensor.update();

			// we show both C and F for temperature
			System.out
					.println("Temperature: " + sensor.getTemperature() + " C / " + sensor.getTemperature(true) + " F");

			System.out.println("Humidity: " + sensor.getHumidity() + " %");

			System.out.println("Slider: " + sensor.getSlider() + " %");

			System.out.println("Override Switch Status: " + sensor.getOverrideSwitchStatus());

			Thread.sleep(1000);
		}
		// ! [Interesting]
	}
}
