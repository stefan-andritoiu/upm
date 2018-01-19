%module javaupm_mma7660
%include "../upm.i"
%include "cpointer.i"
%include "typemaps.i"
%include "arrays_java.i";
%include "../java_buffer.i"
%include "../upm_javastdvector.i"

%typemap(javaimports) SWIGTYPE %{
import java.util.AbstractList;
import java.lang.Float;
import java.lang.Integer;
%}

%typemap(javaout) upm::BMA250E {
    return new $&javaclassname($jnicall, true);
}
%typemap(javaout) std::vector<float> {
    return (AbstractList<Float>)(new $&javaclassname($jnicall, true));
}
%typemap(javaout) std::vector<int> {
    return (AbstractList<Integer>)(new $&javaclassname($jnicall, true));
}
%typemap(jstype) std::vector<float> "AbstractList<Float>"
%typemap(jstype) std::vector<int> "AbstractList<Integer>"

%template(floatVector) std::vector<float>;
%template(intVector) std::vector<int>;

%ignore getRawValues(int *, int *, int *);
%ignore getAcceleration(float *, float *, float *);
%{
#include "mma7660.hpp"
#include "mma7660_regs.h"
%}
%include "mma7660_regs.h"
%include "mma7660.hpp"

%ignore installISR(int , void *, void *);

JAVA_ADD_INSTALLISR_PIN(upm::MMA7660)
JAVA_JNI_LOADLIBRARY(javaupm_mma7660)
