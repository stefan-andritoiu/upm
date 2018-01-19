%module javaupm_lsm9ds0
%include "../upm.i"
%include "cpointer.i"
%include "typemaps.i"
%include "arrays_java.i";
%include "../java_buffer.i"
%include "../upm_javastdvector.i"

%typemap(javaimports) SWIGTYPE %{
import java.util.AbstractList;
import java.lang.Float;
%}

%typemap(javaout) upm::LSM9DS0 {
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

%{
    #include "lsm9ds0.hpp"
%}

%ignore installISR(LSM6DSL_INTERRUPT_PINS_T , int ,  mraa::Edge ,  void *, void *);

%extend upm::LSM9DS0 {
    installISR(INTERRUPT_PINS_T intr, int gpio, mraa::Edge level,
    			 jobject runnable)
    {
      // delete any existing ISR and GPIO context
      $self->uninstallISR(intr);

      // greate gpio context
      getPin(intr) = new mraa::Gpio(gpio);

      getPin(intr)->dir(mraa::DIR_IN);
      getPin(intr)->isr(level, runnable);

    }
}

%include "lsm9ds0.hpp"

JAVA_JNI_LOADLIBRARY(javaupm_lsm9ds0)
