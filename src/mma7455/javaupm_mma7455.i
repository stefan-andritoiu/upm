%module javaupm_mma7455
%include "../upm.i"
%include "typemaps.i"
%include "arrays_java.i";
%include "../java_buffer.i"
%include "../upm_javastdvector.i"

%typemap(javaimports) SWIGTYPE %{
import java.util.AbstractList;
import java.lang.Short;
%}

%typemap(javaout) upm::MMA7455 {
    return new $&javaclassname($jnicall, true);
}
%typemap(javaout) std::vector<short> {
    return (AbstractList<Short>)(new $&javaclassname($jnicall, true));
}
%typemap(jstype) std::vector<short> "AbstractList<Short>"

%template(shortVector) std::vector<short>;

%ignore readData(short *, short *, short *);

%{
#include "mma7455.hpp"
%}
%include "mma7455.hpp"

JAVA_JNI_LOADLIBRARY(javaupm_mma7455)
