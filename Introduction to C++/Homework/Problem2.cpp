//Michael Gentile
//CSE 253
//Section A
//Prof. Ishmat Zerin
//Problem 2 of Homework
#include <iostream>

using namespace std;
int* reverse(const int* list, int size);
void printArray(const int* list, int size);

int main() {
	const int arrayThing[] = { 1,2,3,4,5,6 };
	printArray(arrayThing, 6);
	int* reversed;
	reversed =reverse(arrayThing, 6);
	printArray(reversed, 6);

	char z;
	cin >> z;
	return 0;
}
void printArray(const int* list, int size) {
	for (int i = 0; i < 6; i++) {
		cout << *(list + i);
	}
	cout << endl;
}
int* reverse(const int* list, int size) {
	int arrayTemp[6];
	for (int x = 0; x < size; x++) {
		arrayTemp[x] = *(list+(5-x));
	}
	return arrayTemp;
}