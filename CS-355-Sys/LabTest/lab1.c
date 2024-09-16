#include <stdio.h>
int main(void){
    float x,y,result;
    printf("Input 4.5\n");
    scanf("%f",&x);
    printf("Input 3.9\n");
    scanf("%f",&y);
    result = x*y;
    printf("The result of %0.1f*%0.1f is %f",x,y,result);
}