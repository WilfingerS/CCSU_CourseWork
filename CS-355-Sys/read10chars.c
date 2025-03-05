#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <error.h>

int main(int argc, char *argv[]){
    if (argc < 2){
        fprintf(stderr,"Usage: %s <filepath>\n",argv[0]);
        return 1;
    }
    char *fn = argv[1];
    char buffer[10];
    int fopen = open(fn,O_RDONLY);
    if (fopen == -1){
        perror("Error opening file\n");
        return 1;
    }
    ssize_t bRead = read(fopen,buffer,sizeof(buffer));
    if (bRead == -1){
        perror("Error reading file\n");
        return 1;
    }
    close(fopen);
    printf("Buffer: %s\n",buffer); //printing the buffer
    return 0;
}