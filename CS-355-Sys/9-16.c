#include <stdio.h>
#include <math.h>
int main(void) {

    
    /*
    sin(x) = x - x^3/3! + x^5/5!...
    
    int i,j;
    int sub = 1;
    double x = 1.0 ,result = 0.0,val;
    for (i = 1; i <= 5; i = i+2){
        int fact = 1;
        for (j=5; j>=1; j--){ //Factorial Loop
            fact=fact*j;
        }
        sub = sub *-1;
        val = pow(x,i)/fact;
        result = result + (sub*val);
    }
    printf("sin(%0.2f) is %f\n",x,result);

    Taylor Series up to 
    int i,j;
    double x = 0.2, result = 0.0;
    for (i = 0; i<=5; i++){
        int fact = 1;
        for (j=5; j>=1; j--){ //Factorial Loop
            fact=fact*j;
        }
        double num = pow(x,i);
        result = result + pow(num, i)/fact;
    }
    printf("The value of e^%0.2f is %f",x,result);
    */
}