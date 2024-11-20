/*
find command use ls and strcmp
*/

#include <stdio.h>
#include <stdlib.h>
#include <dirent.h> // directory functions
#include <sys/stat.h> // for stat of file
#include <string.h>

void isDir(char *dir,char *fn);
void lscmd(char *dir,char *file);

int main(int argc, char *argv[]){
    char *targ;
    char *dir;
    strcpy(dir, "."); // base directory .
    if (argc == 3){
        strcpy(dir, argv[1]);
        strcpy(targ,argv[2]);
    }else if(argc == 2){
        strcpy(targ,argv[1]);
    }else{
        perror("Not enough arguments\n");
        exit(EXIT_FAILURE);
    }

    lscmd(dir, targ);

    return 0;
}

void lscmd(char *dir,char *filename){
    DIR *dir_ptr;                // Pointer to a directory structure
    struct dirent *dirent_ptr;   // Pointer to the current directory entry
    dir_ptr = opendir(dir);
    if (dir_ptr == NULL) {       // opendir could fail, possibly because the directory does not exist
        perror(dir);        // Print error message
        exit(EXIT_FAILURE);
    }

    while ((dirent_ptr = readdir(dir_ptr)) != NULL) {
        if ((strcmp(dirent_ptr->d_name,".") == 0) || (strcmp(dirent_ptr->d_name,"..") == 0))
            continue;
        isDir(dirent_ptr->d_name, filename);
    }
    closedir(dir_ptr);
}

void isDir(char *dir,char *fn){
    //printf("%s\t",dir);
    struct stat info;
    if (stat(dir, &info) != -1){
        printf("Error getting file stats: %s\n",dir);
        exit(EXIT_FAILURE);
    }

    if (S_ISDIR(info.st_mode) == 1){
        lscmd(dir, fn);
    }else{
        if (strcmp(dir, fn) == 0)
            printf("Found file: %s\n",fn);
    }
}