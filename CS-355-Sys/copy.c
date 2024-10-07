#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
    if (argc < 3) {
        printf("Not enough arguments\n");
        exit(1);
    }
    if(argv[1][0] == '>'){
        FILE *fout = fopen(argv[2],"w");
        char ch;
        scanf("%c",&ch);
        while(ch != '*'){
            fprintf(fout,"%c",ch);
            scanf("%c",&ch);
        }
        fclose(fout);
    }else{
        printf("> needs to be the 2nd argument\n");
    }
    return 0;
}