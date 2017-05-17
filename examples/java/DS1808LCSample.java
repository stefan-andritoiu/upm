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

public class DS1808LCSample {

	public static void main(String[] args) throws InterruptedException {
		// ! [Interesting]

		final int EDISON_I2C_BUS = 1; // Edison I2C-1
		final int DS1808_GPIO_PWR = 15; // Edison GP165

		upm_ds1808lc.DS1808LC lightController = new upm_ds1808lc.DS1808LC(DS1808_GPIO_PWR, EDISON_I2C_BUS);

		System.out.print("Existing state: ");
		printState(lightController);

		if (args.length == 1) {
			int brightness = Integer.parseInt(args[0]);
			if (brightness > 0) {
				lightController.setPowerOn();
				lightController.setBrightness(brightness);
			} else
				lightController.setPowerOff();
		} else {
			System.out.println("Usage: java DS1808LCSample <brightness>");
			System.out.println("A brightness of zero (or negative value) will turn off light");
		}

		System.out.print("Now: ");
		printState(lightController);

		// ! [Interesting]
	}

	private static void printState(upm_ds1808lc.DS1808LC lightController) {
		if (lightController.isPowered())
			System.out.println("Light is powered, brightness = " + lightController.getBrightness());
		else
			System.out.println("Light is not powered.");
	}
}
