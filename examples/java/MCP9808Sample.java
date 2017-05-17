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

public class MCP9808Sample {

	public static void main(String[] args) throws InterruptedException {
		// ! [Interesting]

		int command;
		upm_mcp9808.MCP9808 temp = new upm_mcp9808.MCP9808(6);

		do {
			System.out.println("1 - read temp \t");
			System.out.println("2 - sleep mode \t");
			System.out.println("3 - wake up");
			System.out.println("4 - set mode to " + (temp.isCelsius() == true ? "Fahrenheit" : "Celsius"));
			System.out.println("5 - show status bits");
			System.out.println("6 - Set Tcrit \t");
			System.out.println("7 - Set Tupper \t");
			System.out.println("8 - Set Tlower ");
			System.out.println("9 - Display monitor temps ");
			System.out.println("10 - Enable alert default\t");
			System.out.println("11 - Enable alert interrupt");
			System.out.println("12 - Clear interrupt \t");
			System.out.println("13 - Clear alert mode");
			System.out.println("14 - Get Hysteresis\t");
			System.out.println("15 - Set Hysteresis");
			System.out.println("16 - Get Resolution\t");
			System.out.println("17 - Set Resolution");
			System.out.println("18 - Get Manufacturer ID");
			System.out.println("19 - Get Device ID");
			System.out.println("-1 - exit");
			System.out.println("Enter a command: ");
			command = Integer.parseInt(System.console().readLine());

			float t;
			switch (command) {
			case 1:
				System.out.println("Temp: " + temp.getTemp() + "° " + (temp.isCelsius() ? "Celsius" : "Fahrenheit"));
				break;
			case 2:
				System.out.println("shutdown sensor (sleep mode)");
				temp.shutDown();
				break;
			case 3:
				System.out.println("wake up sensor");
				temp.shutDown(false);
				break;
			case 4:
				System.out.println("set mode to " + (temp.isCelsius() ? "Fahrenheit" : "Celsius"));
				temp.setMode(!temp.isCelsius());
				break;
			case 5:
				System.out.println("Tcrit = " + temp.isTcrit());
				System.out.println(" Tupper = " + temp.isTupper());
				System.out.println(" Tlower = " + temp.isTlower());
				break;
			case 6:
				System.out.println("enter a value");
				t = Integer.parseInt(System.console().readLine());

				temp.setMonitorReg(temp.CRIT_TEMP, t);
				break;
			case 7:
				System.out.println("enter a value");
				t = Integer.parseInt(System.console().readLine());
				;
				temp.setMonitorReg(temp.UPPER_TEMP, t);
				break;
			case 8:
				System.out.println("enter a value");
				t = Integer.parseInt(System.console().readLine());

				temp.setMonitorReg(temp.LOWER_TEMP, t);
				break;
			case 9:
				System.out.println("tcrit = " + temp.getMonitorReg(temp.CRIT_TEMP));
				System.out.println("tupper = " + temp.getMonitorReg(temp.UPPER_TEMP));
				System.out.println("tlower = " + temp.getMonitorReg(temp.LOWER_TEMP));
				break;
			case 10:
				System.out.println("set alert mode default");
				temp.setAlertMode(temp.ALERTCTRL);
				break;
			case 11:
				System.out.println("set alert mode interrupt");
				temp.setAlertMode(temp.ALERTMODE | temp.ALERTCTRL);
				break;
			case 12:
				temp.clearInterrupt();
				break;
			case 13:
				System.out.println("Clear alerts");
				temp.clearAlertMode();
				break;
			case 14:
				System.out.println("Hysteresis: " + temp.getHysteresis());
				break;
			case 15:
				int u;
				System.out.println("enter 1 to 4");
				u = Integer.parseInt(System.console().readLine());

				switch (u) {
				case 1:
					temp.setHysteresis(temp.HYST_0);
					break;
				case 2:
					temp.setHysteresis(temp.HYST_1_5);
					break;
				case 3:
					temp.setHysteresis(temp.HYST_3_0);
					break;
				case 4:
				default:
					temp.setHysteresis(temp.HYST_6_0);
					break;
				}
				break;
			case 16:
				System.out.println("Resolution: " + temp.getResolution());
				break;
			case 17:
				int v;
				System.out.println("enter 1 to 4");
				v = Integer.parseInt(System.console().readLine());

				switch (v) {
				case 1:
					temp.setResolution(temp.RES_LOW);
					break;
				case 2:
					temp.setResolution(temp.RES_MEDIUM);
					break;
				case 3:
					temp.setResolution(temp.RES_HIGH);
					break;
				case 4:
				default:
					temp.setResolution(temp.RES_PRECISION);
					break;
				}
				break;
			case 18:
				System.out.println("Manufacturer ID: " + std::hex + temp.getManufacturer());
				break;
			case 19:
				System.out.println("Get device ID: " + std::hex + temp.getDevicedId());
				break;
			case -1:
				break;
			default:
				System.out.println("That option is not available. Try again");
				break;
			}

		} while (command != -1);

		// ! [Interesting]
	}
}
