#include "HealthData.h"
#include <iostream>
using namespace std;

HealthData::HealthData() {
	weight = 0.0;
	exerciseType = "";
	exerciseTime = 0;
}

HealthData::HealthData(double weight, string exerciseType, int exerciseTime) {
	this->weight = weight;
	this->exerciseType = exerciseType;
	this->exerciseTime = exerciseTime;
}

void HealthData::setWeight(double weight) {
	this->weight = weight;
}

void HealthData::setExerciseType(string exerciseType) {
	this->exerciseType = exerciseType;
}

void HealthData::setExerciseTime(int exerciseTime) {
	this->exerciseTime = exerciseTime;
}

double HealthData::getWeight() {
	return weight;
}

string HealthData::getExerciseType() {
	return exerciseType;
}

int HealthData::getExerciseTime() {
	return exerciseTime;
}

void HealthData::print() {
	cout << "Weight: " << (double)weight << " kg" << endl;
	cout << "Exercise: " << exerciseType << " (" << exerciseTime << " mins)" << endl;
}