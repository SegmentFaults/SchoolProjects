/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Student.h
 * Author: gentilm5
 *
 * Created on January 30, 2018, 2:06 PM
 */

#ifndef STUDENT_H
#define	STUDENT_H
#include <string>
#include "Person.h"
using namespace std;
class Student : Person{
public:
	Student(string name, unsigned int age);
	Student(const Student& orig);
	virtual ~Student();
private:

};

#endif	/* STUDENT_H */

