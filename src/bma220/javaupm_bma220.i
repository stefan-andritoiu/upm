%module javaupm_bma220
%include "../upm.i"
%include "cpointer.i"
%include "typemaps.i"
%include "arrays_java.i";
%include "../java_buffer.i"
%include "../upm_javastdvector.i"

%apply int {mraa::Edge};
%apply float *INOUT { float *x, float *y, float *z };

%typemap(javaimports) SWIGTYPE %{
import java.util.AbstractList;
import java.lang.Float;
%}

%typemap(javaout) upm::BMA220 {
    return new $&javaclassname($jnicall, true);
}
%typemap(javaout) std::vector<float> {
    return (AbstractList<Float>)(new $&javaclassname($jnicall, true));
}
%typemap(jstype) std::vector<float> "AbstractList<Float>"

%template(floatVector) std::vector<float>;

%ignore getAccelerometer(float *, float *, float *);

%{
    #include "bma220.hpp"
%}

%include "bma220.hpp"

%define GETTER get_gpioIntr()
%enddef
JAVA_ADD_INSTALLISR_GPIO(upm::BMA220)

%ignore installISR(int, mraa::Edge, void *, void *);

JAVA_JNI_LOADLIBRARY(javaupm_bma220)
