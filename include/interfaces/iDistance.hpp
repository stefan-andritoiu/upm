#pragma once

namespace upm
{
    class iDistance
    {
    public:
        virtual ~iDistance() {}
        virtual int getDistance() = 0;
    };
}