%module javaupm_lis3dh
%include "../upm.i"
%include "typemaps.i"
%include "../upm_vectortypes.i"
%include "../upm_javastdvector.i"

%{
    #include "lis3dh.hpp"
    #include "lis3dh_defs.h"
%}
%include "lis3dh_defs.h"
%include "lis3dh.hpp"

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

%template(floatVector) std::vector<float>;

%ignore getAccelerometer(float *, float *, float *);

%ignore installISR(LIS3DH_INTERRUPT_PINS_T , int , mraa::Edge , void *, void* );

%define INTERRUPT LIS3DH_INTERRUPT_PINS_T
%enddef
JAVA_ADD_INSTALLISR_INTERRUPT(upm::LIS3DH)

JAVA_JNI_LOADLIBRARY(javaupm_lis3dh)
