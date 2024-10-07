#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

/*
    Shortcut: %s
    for(int i = 0; i < 10; i++){
        scanf("%c",&x[i]);
    }

    for(int i = 0; i < 10; i++){
        printf("%c",x[i]);
    }
    printf("\n");
*/

int main(){
    /*  name of array is x
        x has 10 cells, continuous val (adjacent);
        size of char = 1byte
        size of int = 4bytes
    */
    char x[10]; //arrays are pointers
    char y[10];

    printf("%lu\n",sizeof(x[0])); // returns side of character
    printf("Enter a string: ");
    scanf("%s",x);
    printf("%s\n",x);
    printf("%c\n",*x); // prints x[0]
    printf("%c\n",*(x+3)); // prints x[1]
    printf("%c\n",*x - 32); // 32 away is capitals in ascii code
    
    /*
    Copying ( strcpy(*destination,*source) <string.h>)
    for (int i = 0;i < strlen(x);i++){
        *(y+i) = *(x+i);
        // y[i] = x[i];
    }
    */
    strcpy(y,x);
    printf("%s\n",y);

    /* comparing */
    char z[10] = "apple";
    char t[10] = {'a','p','p','l','e'}; // another form of initialization
    bool flag=true;
    if (strlen(z) == strlen(t)){
        for (int i = 0; i < strlen(x); i++){
            if(x[i] != y[i]){
                flag = false;
                break;
            }
        }
    }
    printf("%s == %s : %d\n",z,t,flag);
    //(strcmp(x,y)==0);

    return 0;
     
}