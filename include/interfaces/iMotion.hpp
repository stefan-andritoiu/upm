#pragma once

namespace upm
{
  class iMotion
  {
  public:
    virtual ~iMotion() {}
    virtual bool motionDetected() = 0;
  };
}