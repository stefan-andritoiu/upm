#pragma once

namespace upm
{
/**
* @brief Interface for Motion Sensors
*/
  class iMotion
  {
  public:
    virtual ~iMotion() {}
    virtual bool motionDetected() = 0;
  };
}