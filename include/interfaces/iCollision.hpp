#pragma once

namespace upm
{
    class iCollision
    {
    public:
        virtual ~iCollision();
        virtual bool isColliding() = 0;
    };
}