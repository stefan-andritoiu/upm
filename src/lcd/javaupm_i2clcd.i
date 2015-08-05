%module javaupm_i2clcd
%include "../upm.i"
%include "stdint.i"
%include "typemaps.i"

%apply uint8_t *OUTPUT { uint8_t *data };

%include "ssd.h"
%{
    #include "ssd.h"
%}

%include "i2clcd.h"
%{
    #include "i2clcd.h"
%}

%include "jhd1313m1.h"
%{
    #include "jhd1313m1.h"
%}

%include "lcm1602.h"
%{
    #include "lcm1602.h"
%}

%include "ssd1327.h"
%{
    #include "ssd1327.h"
%}

%include "ssd1308.h"
%{
    #include "ssd1308.h"
%}