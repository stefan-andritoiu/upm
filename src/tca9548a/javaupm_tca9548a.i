%module javaupm_tca9548a
%include "../upm.i"

%{
    #include "tca9548a.hpp"
%}

%include "tca9548a.hpp"

JAVA_JNI_LOADLIBRARY(javaupm_tca9548a)
