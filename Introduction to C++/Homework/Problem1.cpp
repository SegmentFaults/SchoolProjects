//Michael Gentile
//CSE 253
//Section A
//Prof. Ishmat Zerin
//Problem 1 of Homework
#include <iostream>
using namespace std;

struct Distance {
	int feet;
	int inch;
}distance1, distance2, sum;//declare the distances


int main() {
	cout << "Enter the first distance in feet and inches." << endl;
	cout << "Please enter feet " << endl;
	cin >> distance1.feet;
	cout << "Please enter inches " << endl;
	cin >> distance1.inch;
	cout << "Now enter the second distance. " << endl;
	cout << "First, enter feet. " << endl;
	cin >> distance2.feet;
	cout << "Now, inches. " << endl;
	cin >> distance2.inch;
	//i didn't need to do this
	distance1.feet = distance1.feet + (distance1.inch / 12);
	distance1.inch = distance1.inch % 12;
	distance2.feet = distance2.feet + (distance2.inch / 12);
	distance2.inch = distance2.inch % 12;
	//i needed to do this.
	sum.inch = distance1.inch + distance2.inch;
	sum.feet = distance2.feet + distance2.feet + (sum.inch / 12);
	sum.inch = sum.inch % 12;

	cout << "The resultant distance is " << sum.feet << " feet and " << sum.inch << " inches";
	char z;
	cin >> z;
	return 0;
}