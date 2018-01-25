%module javaupm_adxl335
%include "../upm.i"
%include "cpointer.i"
%include "typemaps.i"
%include "../upm_javastdvector.i"

%{
    #include "adxl335.hpp"
%}

%ignore values(int *, int *, int *);
%ignore acceleration(float *, float *, float *);

%typemap(javaimports) SWIGTYPE %{
import java.util.AbstractList;
import java.lang.Float;
import java.lang.Integer;
%}

%typemap(javaimports) SWIGTYPE %{
import java.util.AbstractList;
import java.lang.Float;
import java.lang.Integer;
%}

%typemap(javaout) upm::ADXL335 {
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

%include "adxl335.hpp"

JAVA_JNI_LOADLIBRARY(javaupm_adxl335)
