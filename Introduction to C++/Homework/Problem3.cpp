//Michael Gentile
//CSE 253
//Section A
//Prof. Ishmat Zerin
//Problem 3 of Homework
#include <iostream>
using namespace std;
int main() {
	int rows, columns;
	cout << "How many rows? " << endl;
	cin >> rows;
	cout << "How many columns? " << endl;
	cin >> columns;
	int * arr; 
	arr = (int *)malloc(sizeof(int) * rows*columns);

	//populate
	for (int i = 0; i < rows; i++) {
		for (int j = 0; j < columns; j++) {
			cout << "Please enter a number. " << endl;
			cin >> *(arr + i*columns + j);
		}
	}
		
	//output
	for (int i = 0; i < rows; i++) {
		for (int j = 0; j < columns; j++) {
			cout << *(arr + i*columns + j) << " and the address is "<< (arr + i*columns + j)<<endl;
		}
	}
	free(arr);
	char z;
	cin >> z;
	return 0;
}