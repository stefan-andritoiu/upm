%module javaupm_h3lis331dl
%include "../upm.i"
%include "cpointer.i"
%include "typemaps.i"
%include "../upm_javastdvector.i"

%ignore i2cContext;

%{
#include "h3lis331dl.hpp"
%}

%ignore getRawXYZ(int *, int *, int *);
%ignore getXYZ(int *, int *, int *);
%ignore getAcceleration(float *, float *, float *);

%typemap(javaimports) SWIGTYPE %{
import java.util.AbstractList;
import java.lang.Float;
import java.lang.Integer;
%}

%typemap(javaimports) SWIGTYPE %{
import java.util.AbstractList;
import java.lang.Float;
%}

%typemap(javaout) upm::H3LIS331DL {
    return new $&javaclassname($jnicall, true);
}
%typemap(javaout) std::vector<float> {
    return (AbstractList<Float>)(new $&javaclassname($jnicall, true));
}
%typemap(jstype) std::vector<float> "AbstractList<Float>"

%template(floatVector) std::vector<float>;

%typemap(javaout) std::vector<int> {
    return (AbstractList<Integer>)(new $&javaclassname($jnicall, true));
}
%typemap(jstype) std::vector<int> "AbstractList<Integer>"

%template(intVector) std::vector<int>;

%include "h3lis331dl.hpp"

JAVA_JNI_LOADLIBRARY(javaupm_h3lis331dl)
