// AddNumbers.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;

int main()
{
	int num=-1;
	do {
		cout << "Enter a number between 0-1000 ";
		cin >> num;
	} while (num > 1000 || num < 0);
	int sum = 0;
	while (num > 0) {
		sum+=num % 10;
		num/= 10;
	}
	cout << sum<<endl;
	system("pause");
    return 0;
}

