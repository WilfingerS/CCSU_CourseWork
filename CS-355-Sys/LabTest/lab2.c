#include <stdio.h>

int main(void){
    printf("Enter 10 integer numbers, one number at a time\n");
    int count = 0, oddCount = 0, inputNum;
    while (count < 10) {
        printf("enter a number: ");
        scanf("%d",&inputNum);
        if(inputNum%2 == 1){
            oddCount++;
        }
        count++;
    }
    printf("you entered %d odd numbers\n",oddCount);
    return 0;
}