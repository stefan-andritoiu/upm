#pragma once

namespace upm
{
  class iMoisture
  {
  public:
    virtual ~iMoisture() {}
    virtual int getMoisture() = 0;
  };
}