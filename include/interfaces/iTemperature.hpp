#pragma once

namespace upm
{
  enum TemperatureType
  {
    Celsius = 0,
    Fahrenheit = 1,
    Kelvin = 2,
    custom
  };

  class iTemperature
  {
  public:
    virtual ~iTemperature() {}
    virtual float getTemperature() = 0;
    static float convertTo(TemperatureType type) { return 0.0f; }
  };
}