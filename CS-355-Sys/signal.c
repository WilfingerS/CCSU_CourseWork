#include <stdio.h>
#include <signal.h>

void f(int);
int main() {
    int i;

    signal(SIGINT,f); // Handler for the signal
    for(i=0; i<5;i++){ // do something else (thread)
        printf("Hello\n");
        sleep(1);
    }
    return 0;
}

void f(int signum){
    printf("\nOUCH!\n"); // is called when
}
