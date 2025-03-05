#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <time.h>
#include <errno.h>
#include <string.h>

/*
mystat.c
    FileName
    Total Size: bytes
    Inode Number: 
    Time of Last Access: M-S Month Day HH:MM:SS 
*/

int main(int argc, char *argv[]) {
    // 2 args
    if (argc < 2) { // Check if the correct number of arguments are provided
        fprintf(stderr, "Usage: %s <filename>\n", argv[0]);
        return 1;
    }

    const char *fn = argv[1]; // Set a constant string as the first input
    struct stat STAT; // Declare a struct stat variable
    struct stat *fileStat = &STAT; // Pointer to the struct
    
    // stat(filepath, stat struct) fills the stat structure with information about the file
    if (stat(fn, fileStat) == -1) { // Pass the address of stat structure
        // Error check if stat fails
        fprintf(stderr, "Failed to get file stats: %s\n", strerror(errno));
        // errno is defined by errno.h and holds common error codes
        return 1; // Returning 1 in main typically indicates an error
    }
    
    // Print file information
    printf("File: %s\n", fn);
    printf("Total size: %lld bytes\n", (long long int)fileStat->st_size); // lld is for File Size (signed long)
    printf("Inode number: %llu\n", (unsigned long long)fileStat->st_ino); // 'llu' is unsigned long long for Inode
    printf("Time of last access: %s", ctime(&(fileStat ->st_atime))); // ctime expects a time_t pointer

    return 0;
}