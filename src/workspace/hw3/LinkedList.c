/********************************************************************/
/* Applied Programming - LinkedList		   			                */
/* The program creates a data structure named LinkedList.			*/
/* Edited: Vu X. Dinh, September 23, 2013					        */
/********************************************************************/
#include <stdlib.h>
#include "LinkedLists.h"

/******************************************************************************
 * Initialize doubly linked list data structure
 ******************************************************************************/
void InitLinkedList(LinkedLists *ListPtr)
{
	ListPtr -> NumElements = 0;
	ListPtr -> FrontPtr = NULL;
	ListPtr -> BackPtr = NULL;
}

/******************************************************************************
 * Add a node (e.g., data record) to the front of the list.
 ******************************************************************************/
void AddToFrontOfLinkedList(LinkedLists *ListPtr, ElementStructs *DataPtr)
{
	LinkedListNodes *newNode = malloc(sizeof(LinkedListNodes));
	newNode -> Previous = NULL;
	newNode -> Next = NULL;
	newNode -> ElementPtr = DataPtr;

	if (ListPtr -> NumElements == 0)
	{
		ListPtr -> FrontPtr = newNode;
		ListPtr -> BackPtr = newNode;
	}
	else
	{
		ListPtr -> FrontPtr -> Previous = newNode;
		newNode -> Next = ListPtr -> FrontPtr;
		ListPtr -> FrontPtr = newNode;
	}

	(ListPtr -> NumElements)++;
}

/******************************************************************************
 * Add node (e.g., data record) to the back of the list.
 ******************************************************************************/
void AddToBackOfLinkedList(LinkedLists *ListPtr, ElementStructs *DataPtr) 
{
	LinkedListNodes *newNode = malloc(sizeof(LinkedListNodes));
	newNode -> Previous = NULL;
	newNode -> Next = NULL;
	newNode -> ElementPtr = DataPtr;

	if (ListPtr -> NumElements == 0)
	{
		ListPtr -> FrontPtr = newNode;
		ListPtr -> BackPtr = newNode;
	}
	else
	{
		ListPtr -> BackPtr -> Next = newNode;
		newNode -> Previous = ListPtr -> BackPtr;
		ListPtr -> BackPtr = newNode;
	}

	(ListPtr -> NumElements)++;
}

/******************************************************************************
 * Remove node (and return) a record from the front of the list
 * must 'work' on an empty lists by returning NULL
 ******************************************************************************/
ElementStructs *RemoveFromFrontOfLinkedList(LinkedLists *ListPtr)
{
	if (ListPtr -> NumElements == 0)
	{
		return NULL;
	}
	else
	{
		ElementStructs *temp = ListPtr -> FrontPtr -> ElementPtr;
		ListPtr -> FrontPtr = ListPtr -> FrontPtr -> Next;
		free(ListPtr -> FrontPtr -> Previous);
		ListPtr -> FrontPtr -> Previous = NULL;
		return temp;
	}

	(ListPtr -> NumElements)--;
}

/******************************************************************************
 * Remove node (and return) a record from the back of the list
 * must 'work' on an empty list by returning NULL
 ******************************************************************************/
ElementStructs *RemoveFromBackOfLinkedList(LinkedLists *ListPtr)
{
	if (ListPtr -> NumElements == 0)
	{
		return NULL;
	}
	else
	{
		ElementStructs *temp = ListPtr -> BackPtr -> ElementPtr;
		ListPtr -> BackPtr = ListPtr -> BackPtr -> Previous;
		free(ListPtr -> BackPtr -> Next);
		ListPtr -> BackPtr -> Next = NULL;
		return temp;
	}

	(ListPtr -> NumElements)--;
}

/******************************************************************************
 * De-allocate the linked list and reset the struct fields as if the
 * list was empty.
 ******************************************************************************/
void DestroyLinkedList(LinkedLists *ListPtr) 
{
	while(RemoveFromFrontOfLinkedList(ListPtr))
	{
	}
}
