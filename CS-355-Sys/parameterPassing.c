#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void swap(int x,int y);
void swap2(int *x, int *y);
void swap3(char str[]);

int main(int argc, char *argv[]){
    int x,y;
    x = 10;
    y = 20;
    printf("ORIGINAL: x:%d | y:%d\n",x,y);

    swap(x,y);
    printf("Swap1: x:%d | y:%d\n",x,y);
    // NO SWAPPING OCCURED IN ABOVE
    swap2(&x,&y);
    printf("Swap2: x:%d | y:%d\n",x,y);
    // Swapping Occurs above

    char str[15] = "Hi im a string";
    printf("Before: %s\n",str);
    swap3(str);
    printf("After: %s\n",str);

}

void swap(int x,int y){
    // in this method x and y are local variables so no changes happen
    // contains its own memory
    int temp = x;
    x = y;
    y = temp;
}

void swap2(int *x,int *y){
    // Reference passing (impacts the main memory that it is pointing to)
    int temp = *x;
    *x = *y;
    *y = temp;
}

void swap3(char str[]){
    // since array is just a pointer the changes made to the array changes will change
    strcpy(str, "Hello World");
}