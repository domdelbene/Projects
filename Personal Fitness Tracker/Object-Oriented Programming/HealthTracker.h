#pragma once
#include <iostream>
#include <string>
#include "HealthData.h"
using namespace std;

class HealthTracker {
private:
	int getIntegerInput();
	double getDoubleInput();
	void showMenu();
	int selectOption();

	string name;
	string gender;
	int age;
	double height;

	int size;
	HealthData* history;
	int counter;
public:
	HealthTracker();
	~HealthTracker();

	void inputData();
	void printHistoryData();
	void printRecentData();

	void execute();
};

