#pragma once

namespace upm
{
  class iPressure
  {
  public:
    virtual ~iPressure() {}
    virtual float getPressure() = 0;
  };
}