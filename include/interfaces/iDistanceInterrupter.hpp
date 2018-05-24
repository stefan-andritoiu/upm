#pragma once

namespace upm
{
  class iDistanceInterrupter
  {
  public:
    virtual ~iDistanceInterrupter() {}
    virtual bool objectDetected() = 0;
  };
}