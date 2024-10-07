#include <stdio.h>
#include <string.h>

struct Book {
    char title[50];
    int id;
};

int main(){
    struct Book book1;
    struct Book *p; // pointer 
    printf("Size of Struct: %lu bytes\n",sizeof(*p));
    // Setting the value
    strcpy(book1.title, "Book Title Here");
    book1.id = 8008135;
    p = &book1;

    //Printing
    printf("%s\t%d\n",book1.title,book1.id);
    printf("%s\t%d\n",p->title,p->id);

    // NOT POSSIBLE => book1.title = "HelloWorld";
    // *p.title is not possible use p->fieldName instead
}