/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Student.cpp
 * Author: gentilm5
 * 
 * Created on January 30, 2018, 2:06 PM
 */
#include <string>
#include <iostream>
#include "Student.h"
using namespace std;
    Student::Student(string name, unsigned int age) : Person(name, age){
        cout<<"Student constructor"<<endl;
		cout << this->name;
    }

    Student::Student(const Student& orig) {
    }

    Student::~Student() {
    }
