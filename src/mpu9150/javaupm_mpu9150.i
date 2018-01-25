%module javaupm_mpu9150
%include "../upm.i"
%include "typemaps.i"
%include "arrays_java.i"
%include "../java_buffer.i"
%include "../upm_javastdvector.i"

%{
#include "mpu60x0.hpp"
#include "mpu9150.hpp"
%}

%typemap(javaimports) SWIGTYPE %{
import java.util.AbstractList;
import java.lang.Float;
%}

%typemap(javaout) upm::MPU60X0 {
    return new $&javaclassname($jnicall, true);
}
%typemap(javaout) std::vector<float> {
    return (AbstractList<Float>)(new $&javaclassname($jnicall, true));
}
%typemap(jstype) std::vector<float> "AbstractList<Float>"

%template(floatVector) std::vector<float>;

%ignore getAccelerometer(float *, float *, float *);
%ignore getGyroscope(float *, float *, float *);
%ignore getMagnetometer(float *, float *, float *);

%include "mpu60x0.hpp"
%include "mpu9150.hpp"

%define GETTER get_gpioIRQ()
%enddef

JAVA_ADD_INSTALLISR_GPIO(upm::MPU60X0)

JAVA_JNI_LOADLIBRARY(javaupm_mpu9150)
