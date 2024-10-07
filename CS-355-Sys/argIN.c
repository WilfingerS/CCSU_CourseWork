#include <stdio.h>
#include <sys/types.h>

/* Functions */
void printArgs(int x, char *args[]);
void myCat(int x,char *ch[]);
/* try creating cat > test.txt */
int main(int argc, char *argv[]){
    printArgs(argc,argv);
}
void printArgs(int argc, char *args[]){
    /* Input arguments for code */
    int i;
    printf("Argument Count:%d\n",argc);
    /* scanf("%d",&argc); */
    for(i = 0; i< argc; i++){
        printf("%s\n",args[i]);
    }
}
void myCat(int x, char *ch[]){

}