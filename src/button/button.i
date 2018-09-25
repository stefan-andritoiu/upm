#ifdef SWIGPYTHON
%module (package="upm") button
#endif

%import "interfaces/new_interfaces.i"

%include "../common_top.i"

/* BEGIN Java syntax  ------------------------------------------------------- */
#ifdef SWIGJAVA
%typemap(javaimports) SWIGTYPE %{
import upm_new_interfaces.*;
%}
%apply int {mraa::Edge}

JAVA_ADD_INSTALLISR_EDGE(upm::Button)

JAVA_JNI_LOADLIBRARY(javaupm_button)
#endif
/* END Java syntax */

/* BEGIN Common SWIG syntax ------------------------------------------------- */
%{
#include "button.hpp"
%}
%include "button.hpp"
/* END Common SWIG syntax */
