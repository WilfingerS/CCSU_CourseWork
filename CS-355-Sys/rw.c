#include <stdio.h>

int main(){ /* Going over Reading/Writing to a file */
    int x;
    FILE *fp= fopen("./input.txt","r"); /* Opens the file for reading */
    
    fscanf(fp,"%d",&x); /*fscaf : file scanf*/
    printf("%d\n",x);
    fclose(fp); /* close the pointer */
    return 0;
}