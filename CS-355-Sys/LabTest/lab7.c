/*
    ls -options

    open directory
    read entry
    display file info
    close directory

    Directory:
        opendir()
        readdir()
        closedir()

    -options:
        -l: Long listing, displays lots of information
        -a: Shows hidden files
        -t: Sorts by modification time
        -r: Sorts in reverse order
        -s: Prints the allocated size of each file, in blocks
*/
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h> // used for read write close lseek fork and exec()
#include <fcntl.h> // exec
#include <dirent.h> // directory functions


int main(int argc, char *argv[]){
    char *dir = ".";
    if (argv[1] != NULL){
        dir = argv[1];
    }else{
        
    }

    DIR *dir_pt; // Directory pointer (type) [POSIX]
    struct dirent *direntpt; // (built in structure) Directory Entry Point
    dir_pt = opendir(dir);
    if (dir_pt == NULL){ // Check if it exists
        fprintf(stderr,"Error opening directory: %s",argv[0]);
        return 1;
    }

    while((direntpt = readdir(dir_pt)) != NULL){
        printf("%s\t",direntpt->d_name);
    }
    printf("\n");

    closedir(dir_pt);
    return 0;
}