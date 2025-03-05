#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/* The headers below are for sys calls */
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>

int main(int argc, char *argv[]){
    if (argc < 3){ /* check for enough arguments */
        printf("Not enough args provided\n");
        return 1;
    }

    int in = open(argv[1],O_RDONLY);
    int out = open(argv[2],O_WRONLY | O_CREAT | O_TRUNC, 0644);
    
    if (in < 0){
        // NOTE* file doesn't exist if you wanted to use out = creat(argv[2],0644) where 0 dictates its a file or you can use O_CREAT
        perror("Error accessing input file\n");
        exit(EXIT_FAILURE);
    }
    if (out < 0){
        perror("Error accessing output file\n");
        exit(EXIT_FAILURE);
    }

    char buffer[1024]; // used for reading/writing in larger chunks to improve speed rather than 1 byte at a time
    ssize_t readSYS,writeSYS;
    do{
        readSYS = read(in,buffer,sizeof(buffer));
        if (readSYS < 0){ break; } // exit out of the loop if it returns -1 and then the outside if statment will handle error printing 
        writeSYS = write(out,buffer,readSYS); // readSys is the size due to the size of the data I wanted to enter
        if (writeSYS < 0){
            perror("Error writing file\n");
            exit(EXIT_FAILURE);
        }
    }while(readSYS > 0);
    
    if (readSYS < 0) {
        perror("Error reading file\n");
        exit(EXIT_FAILURE);
    }

    // Exit The Files
    close(in);
    close(out);
    return 0;
}
