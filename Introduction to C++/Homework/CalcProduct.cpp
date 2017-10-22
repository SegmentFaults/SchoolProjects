// CalcProduct.cpp : Defines the entry point for the console application.
//This creates a product of two numbers
//Michael Gentile
//

#include "stdafx.h"
#include <iostream>
using namespace std;
int main()
{
	int num1, num2;
	int product = 0;
	cout << "Enter one number "<<endl;
	cin >> num1;
	cout << "Enter another number "<<endl;
	cin >> num2;
	for (int x = 0; x < num2; x++){
		product += num1;
	}
	cout << product<<endl;
	cin.clear();
	cin.ignore();
	cin.get();
    return 0;
}

