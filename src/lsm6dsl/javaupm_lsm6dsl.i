%module javaupm_lsm6dsl
%include "../upm.i"
%include "typemaps.i"
%include "../upm_javastdvector.i"
%include "../upm_vectortypes.i"

%typemap(javaimports) SWIGTYPE %{
import java.util.AbstractList;
import java.lang.Float;
import java.lang.Short;
%}

%typemap(javaout) SWIGTYPE {
    return new $&javaclassname($jnicall, true);
}
%typemap(javaout) std::vector<float> {
    return (AbstractList<Float>)(new $&javaclassname($jnicall, true));
}
%typemap(jstype) std::vector<float> "AbstractList<Float>"

%{
    #include "lsm6dsl_defs.h"
    #include "lsm6dsl.hpp"
%}
%include "lsm6dsl_defs.h"
%include "lsm6dsl.hpp"

%ignore getAccelerometer(float *, float *, float *);
%ignore getGyroscope(float *, float *, float *);

%ignore installISR(LSM6DSL_INTERRUPT_PINS_T , int ,  mraa::Edge ,  void *, void *);

%define INTERRUPT LSM6DSL_INTERRUPT_PINS_T
%enddef
JAVA_ADD_INSTALLISR_INTERRUPT(upm::LSM6DSL)
JAVA_JNI_LOADLIBRARY(javaupm_lsm6dsl)
