// TypeCasting.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;
int main()
{
	int x;
	do {
		cout << "Enter a number between 0 and 255 " << endl;
		cin >> x;
	} while (x < 0 || x>255);
	
	cout << "Here is a letter with that ASCII value: " << (char)x<<endl;
	system("pause");
    return 0;
}

