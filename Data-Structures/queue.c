#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "queue.h"
#define MAX 256


queue* new_queue(){
	queue* q = (queue*)malloc(sizeof(queue));
	q->head = 0;
	q->tail = -1;
	q->count = 0;
	return q;
}


bool is_empty(queue* q){
	return q->count == 0;
}


void put(queue* q, int e){
	if (q->count == MAX){
		printf("Space Overflow");
		exit(-1);
	}
	q->tail = q->tail % MAX + 1;
	q->data[q->tail];
	q->count++;
}


int remove(queue* q){
	if (is_empty(q)){
		printf("Bad Use");
		exit(-1);
	}
	q->count--;
	q->head = q->head % MAX + 1;
	return q->data[q->head];
}


