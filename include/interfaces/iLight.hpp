#pragma once

namespace upm
{
    class iLight
    {
    public:
        virtual ~iLight() {}
        virtual float getLuminance() = 0;
    };
}