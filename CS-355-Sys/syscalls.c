// Using Systemm calls to copy file 
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h> // used for read write close lseek fork and exec()
#include <fcntl.h> // exec

#define BUFFER_SIZE 1028
// cpy src dest

int main(int argc, char *argv[]) {
    if (argc != 3) {
        write(STDERR_FILENO, "Usage: <source> <destination>\n", 31);
        exit(1);
    }

    int source_fd = open(argv[1], O_RDONLY);
    if (source_fd < 0) {
        perror("src file not found");
        exit(1);
    }

    int dest_fd = open(argv[2], O_WRONLY | O_CREAT | O_TRUNC, 0644);
    if (dest_fd < 0) {
        perror("destination not found");
        close(source_fd);
        exit(1);
    }

    char buffer[BUFFER_SIZE];
    ssize_t bytes_read;

    while ((bytes_read = read(source_fd, buffer, BUFFER_SIZE)) > 0) {
        write(dest_fd, buffer, bytes_read);
    }

    close(source_fd);
    close(dest_fd);

    printf("Copied\n");
    return 0;
}
