// CompareNumbers.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;
void order(int a, int b, int c);
int number1, number2, number3;
int main()
{
	cout << "Enter three numbers "<<endl;
	cin >> number1 >> number2 >> number3;
	int temp1, temp2, temp3;
	cout << "Here they are in order: " << endl;
	order(number1, number2, number3);
	system("pause");
    return 0;
}


void order(int a, int b, int c)
{
	if (a < b && a<c) {
		cout << a << endl;
		if (c < b) {
			cout << c << endl << b << endl;
		}
		else {
			cout << b << endl << c << endl;
		}
	}
	else if (b < a && b < c) {
		cout << b << endl;
		if (c < a) {
			cout << c << endl << a << endl;
		}
		else {
			cout << a << endl << c << endl;
		}
	}
	else {
		cout << c << endl;
		if (a < b) {
			cout << a << endl << b << endl;
		}
		else {
			cout << b << endl << a << endl;
		}
	}
}