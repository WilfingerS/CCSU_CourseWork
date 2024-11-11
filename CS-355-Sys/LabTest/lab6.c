// mywho
#include <stdio.h>
#include <utmpx.h>
#include <time.h>

int main(){
    struct utmpx *n; // read entries from utmpx file
    setutxent(); // start reading utmpx file entries
    while((n=getutxent())!= NULL){
        if (n->ut_type == USER_PROCESS){ // Check if entry is a user proccess
            printf("%-9s\t",n->ut_user);
            // print username
            // -9s left justifies username within 9 char field
        }
        printf("%-12s\n",n->ut_line);
        // print tty or pts
    }
    endutxent();
    return 0;
}