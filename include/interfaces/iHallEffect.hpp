#pragma once

namespace upm
{
  class iHallEffect
  {
  public:
    virtual ~iHallEffect() {}
    virtual bool magnetDetected() = 0;
  };
}