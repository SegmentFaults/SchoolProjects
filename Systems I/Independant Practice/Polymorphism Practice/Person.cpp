/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Person.cpp
 * Author: gentilm5
 * 
 * Created on January 30, 2018, 2:06 PM
 */

#include <string>
#include <iostream> 
#include "Person.h"
using namespace std;
   Person::Person(string name, unsigned int age) {
        this->name= name;
        this->age = age;
		cout << this->name;
        cout<<"Person constructor "<<this->name<<" passed value:"<<name<<endl;
    }
    
     Person::Person(const Person& orig) {
    }

    Person::~Person() {
    }

