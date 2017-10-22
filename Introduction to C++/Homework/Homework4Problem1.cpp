//Made by Michael Gentile
#include <iostream>
#include <ctime>
using namespace std;
int main() {
	int array1[10], array2[10], array3[20];
	srand(time(0));
	cout << "Array 1"<<endl;
	for (int x = 0; x < 10; x++) {
		array1[x] = rand() % 100 + 1;
		array2[x] = rand() % 100 + 1;
		cout << array1[x] << " ";
	}
	//assign values
	cout << endl<<"Array 2" << endl;
	for (int y = 0; y < 10; y++) {
		array3[y] = array2[y];
		array3[y + 10] = array1[y];
		cout << array2[y]<< " ";
	}
	cout <<endl<< "Array 3" << endl;
	//print value
	for (int z = 0; z < 20; z++) {
		cout << array3[z] << " " ;
	}
	char q;
	cout << endl << "Press anything to exit";
	cin >> q;
	return 0;
}