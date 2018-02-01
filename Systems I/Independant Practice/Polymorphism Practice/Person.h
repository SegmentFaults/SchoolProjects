/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Person.h
 * Author: gentilm5
 *
 * Created on January 30, 2018, 2:06 PM
 */

#ifndef PERSON_H
#define	PERSON_H
#include <string.h>
#include <iostream>
using namespace std;
class Person {
    public:
            string name;
            unsigned int age;
            Person(string name="aksdjflkajsdlfkjas", unsigned int age=0);
            Person(const Person& orig);
            ~Person();
            
    private:

};

#endif	/* PERSON_H */

