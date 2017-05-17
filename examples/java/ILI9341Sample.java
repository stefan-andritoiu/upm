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

public class ILI9341Sample {

	public static void main(String[] args) throws InterruptedException {
		// ! [Interesting]

		// Pins (Edison)
		// CS_LCD GP44 (MRAA 31)
		// CS_SD GP43 (MRAA 38) unused
		// DC GP12 (MRAA 20)
		// RESEST GP13 (MRAA 14)
		upm_ili9341.ILI9341 lcd = new upm_ili9341.ILI9341(31, 38, 20, 14);

		// Fill the screen with a solid color
		lcd.fillScreen(lcd.color565((short) 0, (short) 40, (short) 16));

		// Draw some shapes
		lcd.drawFastVLine((short) 10, (short) 10, (short) 100, upm_ili9341.javaupm_ili9341Constants.ILI9341_RED);
		lcd.drawFastHLine((short) 20, (short) 10, (short) 50, upm_ili9341.javaupm_ili9341Constants.ILI9341_CYAN);
		lcd.drawLine((short) 160, (short) 30, (short) 200, (short) 60,
				upm_ili9341.javaupm_ili9341Constants.ILI9341_GREEN);
		lcd.fillRect((short) 20, (short) 30, (short) 75, (short) 60,
				upm_ili9341.javaupm_ili9341Constants.ILI9341_ORANGE);
		lcd.drawCircle((short) 70, (short) 50, (short) 20, upm_ili9341.javaupm_ili9341Constants.ILI9341_PURPLE);
		lcd.fillCircle((short) 120, (short) 50, (short) 20, upm_ili9341.javaupm_ili9341Constants.ILI9341_PURPLE);
		lcd.drawTriangle((short) 50, (short) 100, (short) 10, (short) 140, (short) 90, (short) 140,
				upm_ili9341.javaupm_ili9341Constants.ILI9341_YELLOW);
		lcd.fillTriangle((short) 150, (short) 100, (short) 110, (short) 140, (short) 190, (short) 140,
				upm_ili9341.javaupm_ili9341Constants.ILI9341_YELLOW);
		lcd.drawRoundRect((short) 20, (short) 150, (short) 50, (short) 30, (short) 10,
				upm_ili9341.javaupm_ili9341Constants.ILI9341_RED);
		lcd.drawRoundRect((short) 130, (short) 150, (short) 50, (short) 30, (short) 10,
				upm_ili9341.javaupm_ili9341Constants.ILI9341_RED);
		lcd.fillRoundRect((short) 75, (short) 150, (short) 50, (short) 30, (short) 10,
				upm_ili9341.javaupm_ili9341Constants.ILI9341_RED);

		// Write some text
		lcd.setCursor((short) 0, (short) 200);
		lcd.setTextColor(upm_ili9341.javaupm_ili9341Constants.ILI9341_LIGHTGREY);
		lcd.setTextWrap(true);
		lcd.setTextSize((short) 1);
		lcd.print("Text 1\n");
		lcd.setTextSize((short) 2);
		lcd.print("Text 2\n");
		lcd.setTextSize((short) 3);
		lcd.print("Text 3\n");
		lcd.setTextSize((short) 4);
		lcd.print("Text 4\n");

		// Test screen rotation
		for (short r = 0; r < 4; r++) {
			lcd.setRotation(r);
			lcd.fillRect((short) 0, (short) 0, (short) 5, (short) 5,
					upm_ili9341.javaupm_ili9341Constants.ILI9341_WHITE);
			Thread.sleep(1000);
		}

		// Invert colors, wait, then revert back
		lcd.invertDisplay(true);
		Thread.sleep(2000);
		lcd.invertDisplay(false);

		// ! [Interesting]
	}
}