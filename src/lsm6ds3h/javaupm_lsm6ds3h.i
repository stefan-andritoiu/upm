%module javaupm_lsm6ds3h
%include "../upm.i"
%include "typemaps.i"
%include "../upm_javastdvector.i"
%include "../upm_vectortypes.i"

%typemap(javaimports) SWIGTYPE %{
import java.util.AbstractList;
import java.lang.Float;
%}

%typemap(javaout) SWIGTYPE {
    return new $&javaclassname($jnicall, true);
}
%typemap(javaout) std::vector<float> {
    return (AbstractList<Float>)(new $&javaclassname($jnicall, true));
}
%typemap(jstype) std::vector<float> "AbstractList<Float>"

%ignore getAccelerometer(float *, float *, float *);
%ignore getGyroscope(float *, float *, float *);

%{
    #include "lsm6ds3h_defs.h"
    #include "lsm6ds3h.hpp"
%}
%include "lsm6ds3h_defs.h"
%include "lsm6ds3h.hpp"

%ignore installISR(LSM6DS3H_INTERRUPT_PINS_T , int ,  mraa::Edge ,  void *, void *);

%define INTERRUPT LSM6DS3H_INTERRUPT_PINS_T
%enddef
JAVA_ADD_INSTALLISR_INTERRUPT(upm::LSM6DS3H)

JAVA_JNI_LOADLIBRARY(javaupm_lsm6ds3h)
