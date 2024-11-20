#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <time.h>
#include <errno.h>
#include <string.h>

int main(int argc, char *argv[]){
    if (argc < 2){
        fprintf(stderr,"Usage: %s <filepath>",argv[0]);
        return 1;
    }

    const char *fn = argv[1];
    struct stat fileStat;

    if (stat(fn,&fileStat) == -1){
        fprintf(stderr,"Error getting stats:%s",strerror(errno));
        return 1;
    }

    printf("File:%s\n",fn);
    printf("Size: %lld bytes\n",fileStat.st_size);
    printf("Inode #: %llu\n",fileStat.st_ino);
    printf("Time of last access: %s",ctime(&fileStat.st_atime));
}