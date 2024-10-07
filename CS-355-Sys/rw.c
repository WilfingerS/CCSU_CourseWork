#include <stdio.h>
#include <stdlib.h> /* for exit(1) */
#include <math.h>
/* Constant Variables */
#define KMS_PER_MILE 1.609;
/* Declare Functions */
void testFunc(); /*Inclass Kilometers per Mile*/
void end_of_FILE(); /* EOF inclass stuff*/

void basic_IO(){
    int x;
    char ch;
    /* r = read, w = write */
    FILE *fp= fopen("./input.txt","r"); /* Opens the file for reading */
    FILE *fpout = fopen("./output.txt","w"); /* rewrite whole file */
    /* w if file doesn't exist it create it */

    if (fp == NULL){
        printf("(READ) File not found\n");
        exit(1); 
    }
    /* File exists so read it */
    fscanf(fp,"%d",&x); /*fscaf : file scanf*/
    printf("%d\n",x);
    fclose(fp); /* ALWAYS CLOSE the pointer */
    printf("Successfully Read File\n");

    
    fscanf(fpout,"%c",&ch);
    fprintf(fpout,"%c",ch);
    fclose(fpout);
    printf("Successfully Wrote File\n");
}

int main(){ /* Going over Reading/Writing to a file */
    /* basic_IO(); */ /*IN Class Information/Learning */
    /* testFunc(); */  /*IN CLASS TEST */
    /* end_of_FILE(); */
    argIn();
    return 0;
}

void testFunc(){
    double kms,miles;
    FILE *infile,*outfile;
    infile = fopen("./input.txt","r");
    if (infile == NULL){
        printf("Input file not found\n");
        exit(1);
    }
    outfile = fopen("./output.txt","w");
    fscanf(infile,"%lf",&miles);
    fprintf(outfile, "The distance in miles is %.2f\n",miles);
    kms = miles * KMS_PER_MILE;
    fprintf(outfile,"That equals %.2f kilometers.\n",kms);
    fclose(infile);
    fclose(outfile);
}

void end_of_FILE(){ /* Talked About Later */
    char ch;
    FILE *fpin = fopen("./input.txt", "r");
    if (fpin == NULL){
        printf("File not found\n");
        exit(1);
    }
    
    while (fscanf(fpin,"%c",&ch) != EOF){ /* Reading character til it reaches EOF */
        printf("%c",ch);
    }
    printf("\n");

    fclose(fpin);
}