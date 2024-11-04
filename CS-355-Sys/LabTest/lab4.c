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
    int out = open(argv[2],O_WRONLY | O_CREAT | O_TRUNC,0644);
    
    if (in == -1){
        // file doesn't exist if you wanted to use out = creat(argv[2],0644) where 0 dictates its a file
        perror("Error accessing input file\n");
        exit(EXIT_FAILURE);
    }
    if (out == -1){
        perror("Error accessing output file\n");
        exit(EXIT_FAILURE);
    }

    char buffer[1024];
    ssize_t readSYS,writeSYS;
    readSYS = read(in,buffer,sizeof(buffer));
    
    do{
        writeSYS = write(out,buffer,readSYS); // readSys is the size due to the size of the data I wanted to enter
        if (writeSYS < 0){
            perror("Error writing file\n");
            exit(EXIT_FAILURE);
        }
        readSYS = read(in,buffer,sizeof(buffer));
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
