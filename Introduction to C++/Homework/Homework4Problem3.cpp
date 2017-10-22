#include <iostream>
using namespace std;
int main() {
	int matrix[3][3] = { 1,2,3
						,3,4,5,
						3,5,8 };
	bool sym = true;
	for (int x = 0; x < 3; x++) {
		for (int y = 0; y < 3; y++) {
			cout << matrix[x][y] << " " << matrix[y][x]<<endl;
			if (matrix[x][y] != matrix[y][x]) {
				sym = false;
			}
		}
	}
	if (sym) {
		cout << "True";
	}
	else {
		cout << "false";
	}
	char z;
	cin >> z;
	return 0;
}