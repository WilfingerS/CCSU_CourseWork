#include <stdio.h>
void memAddressEx1();

int main(){
    memAddressEx1();
    return 0;
}

void memAddressEx1(){
    int *p; // No memory created
    int n; // memory created
    int q; // memory created

    p = &n; // p points to n
    *p = 30; // n = 4
    p = &q; // p points to n

    printf("The address of p is %p\n",p);
    printf("The address of n is %p\n",&n);
    printf("The address of q is %p\n",&q);
}