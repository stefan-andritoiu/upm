#pragma once

namespace upm
{
  class iHumidity
  {
  public:
    virtual ~iHumidity() {}
    virtual float getHumidity() = 0;
  };
}