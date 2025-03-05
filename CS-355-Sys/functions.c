#include <stdio.h>
#include <math.h>
#define PI 3.14; //CONSTANT VARIABLE no need for =

//List of Functions (Method 1, This way you dont need to define what the method does before it is called)
int factorial(int x);
double exponent(double x);
//Declare Function (Method 2)
void print(){
    printf("Hello World\n");
} // can omit void in "()" same as saying (void)


int main(void){
    double x;
    printf("Enter the power of exponent e (i.e e^x):\n");
    scanf("%lf",&x);
    printf("e^%.2f is: %f\n",x,exponent(x));
}

double exponent(double x){
    int i = 0;
    double output = 0;
    while (i<=5) {
        output = output + pow(x, i)/factorial(i);
        i++;
    }
    return output;
}

int factorial(int x){
    int i,output = 1; //Declare all variables at the start of the function
    for (i = 1; i<=x; i++){
        output = output * i;
    }
    return output;
}




