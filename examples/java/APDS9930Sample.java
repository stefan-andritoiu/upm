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

public class APDS9930Sample {

	public static void main(String[] args) throws InterruptedException {
		// ! [Interesting]

		upm_apds9930.APDS9930 light_proximity = new upm_apds9930.APDS9930(4);

		// Kernel driver implement sleep 5000-5100us after enable illuminance
		// sensor
		light_proximity.enableIlluminance(true);

		// Kernel driver implement sleep 5000-5100us after enable proximity
		// sensor
		light_proximity.enableProximity(true);

		Thread.sleep(1000);

		while (true) {
			float lux = light_proximity.getAmbient();
			System.out.println("Luminance value is " + lux);
			float proximity = light_proximity.getProximity();
			System.out.println("Proximity value is " + proximity);

			Thread.sleep(1000);
		}

		// ! [Interesting]
	}
}
