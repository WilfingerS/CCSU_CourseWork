#include <stdio.h>
int main(void){ /* Loops are exactly like java */
    int c,j;
    for (c = 0; c<5; c++){
        for (j = c; j>0; j--){
            printf("*");
        }
        printf("\n");
    }
}
