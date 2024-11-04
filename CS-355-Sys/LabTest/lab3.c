#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[]){
    if (argc < 3){
        printf("Not Enough Arguments Passed\n");
        exit(1);
    }
    FILE *fin,*fout;
    fin = fopen(argv[1],"r");
    fout = fopen(argv[2],"w");
    
    if (fin == NULL || fout == NULL){
        printf("%s does not exist or %s",argv[1],argv[2]);
        exit(1);
    }

    char ch;
    while (fscanf(fin,"%c",&ch) != EOF){
        fprintf(fout,"%c",ch);
    }

    fclose(fin);
    fclose(fout);
}