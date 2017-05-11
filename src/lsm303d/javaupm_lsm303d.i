%module javaupm_lsm303d
%include "../upm.i"
%include "typemaps.i"
%include "std_vector.i"

%ignore getMagnetometer(float *, float *, float *);
%ignore getAccelerometer(float *, float *, float *);

%template(floatVector) std::vector<float>;

%include "lsm303d_defs.h"
%include "lsm303d.hpp"
%{
    #include "lsm303d.hpp"
%}

%pragma(java) jniclasscode=%{
    static {
        try {
            System.loadLibrary("javaupm_lsm303d");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Native code library failed to load. \n" + e);
            System.exit(1);
        }
    }
%}
