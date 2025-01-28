#include <iostream>
#include <string>
#include "HealthTracker.h"
using namespace std;

HealthTracker::HealthTracker() {
	cout << "What is your name? ";
	getline(cin, name);

	cout << "What is your gender? ";
	cin >> gender;

	cout << "How old are you? ";
	age = getIntegerInput();

	cout << "How tall are you? (in meters) ";
	height = getDoubleInput();

	cout << "How many inputs do you want to be saved? ";
	size = getIntegerInput();

	history = new HealthData[size];

	counter = 0;
}

HealthTracker::~HealthTracker() {
	delete[] history;
}

int HealthTracker::getIntegerInput() {
	int input;
	cin >> input;

	while (cin.fail()) {
		cout << "Not a valid input\n";
		cin.clear();
		cin.ignore(1000, '\n');
		cout << "Enter a new int: ";
		cin >> input;
	}
	return input;
}

double HealthTracker::getDoubleInput() {
	double input;
	cin >> input;

	while (cin.fail()) {
		cout << "Not a valid input\n";
		cin.clear();
		cin.ignore(1000, '\n');
		cout << "Enter a new double: ";
		cin >> input;
	}
	return input;
}

void HealthTracker::showMenu() {
	cout << "\nOption 1: Add Data." << endl;
	cout << "Option 2: Print Recent Data." << endl;
	cout << "Option 3: Print Data History." << endl;
	cout << "Option 4: Exit." << endl;
	cout << "Press 1, 2, 3, or 4 corresponding to that option: ";
}

int HealthTracker::selectOption() {
	int input;
	cin >> input;

	while (cin.fail()) {
		cout << "The selected option is invalid." << endl;
		cin.clear();
		cin.ignore(1000, '\n');
		showMenu();
		cin >> input;
	}

	while (input <= 0 || input > 4) {
		cout << "The selected option is invalid." << endl;
		showMenu();
		cin >> input;
	}
	return input;
}

void HealthTracker::inputData() {
	cout << "\nHow much do you weigh today? (in kilograms) ";
	history[counter].setWeight(getDoubleInput());

	string exercise;
	cout << "What type of exercise did you do today? ";
	cin.ignore(1000, '\n');
	getline(cin, exercise);
	history[counter].setExerciseType(exercise);

	cout << "How long was the exercise? (in minutes) ";
	history[counter].setExerciseTime(getIntegerInput());
}

void HealthTracker::printHistoryData() {
	if (counter != 0) {
		int day = 1;
		cout << "\n      " << name << endl;
		cout << gender << ", " << age << ", " << (double)height << " m" << endl;
		for (int i = counter - 1; i >= 0; i--) {
			cout << "Day " << day << ":" << endl;
			history[i].print();
			day++;
		}
	}
	else {
		cout << "There is no fitness data to print.\n";
	}
}

void HealthTracker::printRecentData() {
	if (counter != 0) {
		cout << "\n      " << name << endl;
		cout << gender << ", " << age << ", " << (double)height << " m" << endl;
		history[counter - 1].print();
	}
	else {
		cout << "There is no fitness data to print.\n";
	}
}

void HealthTracker::execute() {
	bool exitProgram = false;
	int option;

	while (!exitProgram) {
		showMenu();
		option = selectOption();
		switch (option) {
		case 1:
			if (counter == size) {
				for (int i = 1; i < size; i++) {
					history[i - 1] = history[i];
				}
				counter--;
			}
			inputData();
			counter++;
			break;
		case 2:
			printRecentData();
			break;
		case 3:
			printHistoryData();
			break;
		case 4:
			exitProgram = true;
			break;
		}
	}
}