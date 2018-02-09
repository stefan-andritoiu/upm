%module javaupm_lis2ds12
%include "../upm.i"
%include "typemaps.i"
%include "../upm_javastdvector.i"
%include "../upm_vectortypes.i"

%{
    #include "lis2ds12.hpp"
    #include "lis2ds12_defs.h"
%}
%include "lis2ds12_defs.h"
%include "lis2ds12.hpp"

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

#%ignore installISR(LIS2DS12_INTERRUPT_PINS_T , int ,  mraa::Edge, void *, void *);

%define INTERRUPT LIS2DS12_INTERRUPT_PINS_T
%enddef
JAVA_ADD_INSTALLISR_INTERRUPT(upm::LIS2DS12)

JAVA_JNI_LOADLIBRARY(javaupm_lis2ds12)
