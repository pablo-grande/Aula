#include <stdbool.h>
#define MAX 256


typedef struct queue{
	int head;
	int tail;
	int count;
	int data[MAX];
}


queue* new_queue();
void put(queue* q, int e);
int remove(queue* q);
bool is_empty(queue* q);
