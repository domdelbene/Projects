#pragma once
#include <iostream>
#include <string>
using namespace std;

class HealthData {
private:
	double weight;
	string exerciseType;
	int exerciseTime;
public:
	HealthData();
	HealthData(double weight, string exerciseType, int exerciseTime);
	
	void setWeight(double weight);
	void setExerciseType(string exerciseType);
	void setExerciseTime(int exerciseTime);

	double getWeight();
	string getExerciseType();
	int getExerciseTime();

	void print();
};

