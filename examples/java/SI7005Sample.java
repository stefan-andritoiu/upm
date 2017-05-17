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

public class SI7005Sample {

	public static void main(String[] args) throws InterruptedException {
		// ! [Interesting]

		final int EDISON_I2C_BUS = 1;
		final int EDISON_GPIO_SI7005_CS = 20;

		upm_si7005.SI7005 sensor = new upm_si7005.SI7005(EDISON_I2C_BUS, EDISON_GPIO_SI7005_CS);
		while (true) {
			int temperature = sensor.getTemperatureCelsius();
			int humidity = sensor.getHumidityRelative();
			System.out.println("Temperature = " + temperature + "C");
			System.out.println("Humidity    = " + humidity + "%");
			Thread.sleep(1000);
		}
		// ! [Interesting]
	}
}