#include <iostream>
//Michael Gentile
using namespace std;
int main() {
	int array1[] = { 1,2,3,4,1,2,3,6,1,2 };
	int array2[30];
	int incrememnt = 0;
	cout << "Original ";
	for (int x = 0; x < 10; x++) {
		cout << array1[x] << " ";
	}
	cout << endl<<"Duplicates will now be removed"<<endl;
	//init values
	for (int x = 0; x < 30; x++) {
		array2[x] = 0;
	}
	//check for duplicate
	for (unsigned int x = 0; x < sizeof(array1) / sizeof(array1[0]); x++) {
		bool dupe = false;
		for (unsigned int y = 0; y < sizeof(array2) / sizeof(array1[0]); y++) {
			if (array1[x] == array2[y] && x != y) {
				dupe = true;
				break;
			}
		}
		//if not a duplicate add it to the array.
		if (!dupe) {
			array2[incrememnt] = array1[x];
			incrememnt++;
		}
		dupe = false;
	}
	//print the array
	int x = 0;
	while (array2[x] != 0) {
		cout << array2[x];
		x++;
	}
	char g;
	cout << endl << "Enter anything to exit";
	cin >> g;
	return 0;
}