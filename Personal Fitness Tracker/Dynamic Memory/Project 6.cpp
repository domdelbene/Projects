//Dominick Del Bene
/*The purpose of this project is to use dynamic arrays to allow users to customize their view history.
The requirements are the same as Project 5, however Project 5 is limited to 7 recent inputs.
Project 6 allows the user to provide the number of most recent inputs to be saved. 
A new functionality is implemented in this project that prompts the user to provide a number of inputs.
This function is invoked after getting the user's basic information and before showing the text menu.
The other functionality stays the same as Project 5 for the text menu.*/

#include <iostream>
#include <string>
using namespace std;

int getIntegerInput() {
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

double getDoubleInput() {
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

void getBasicInfo(string& name, string& gender, int& age, double& height) {
	cout << "What is your name? ";
	getline(cin, name);

	cout << "What is your gender? ";
	cin >> gender;

	cout << "How old are you? ";
	age = getIntegerInput();

	cout << "How tall are you? (in meters) ";
	height = getDoubleInput();
}

void showMenu() {
	cout << "\nOption 1: Add Data." << endl;
	cout << "Option 2: Print Data." << endl;
	cout << "Option 3: Print Data History." << endl;
	cout << "Option 4: Exit." << endl;
	cout << "Press 1, 2, 3, or 4 corresponding to that option: ";
}

int selectOption() {
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

void inputData(double& weight, string& exercise, int& exerciseTime) {
	cout << "\nHow much do you weigh today? (in kilograms) ";
	weight = getDoubleInput();

	cout << "What exercise did you do today? ";
	cin.ignore(1000, '\n');
	getline(cin, exercise);

	cout << "How long was the exercise? (in minutes) ";
	exerciseTime = getIntegerInput();
}

void printData(string name, string gender, int age, double height, double weight, string exercise, int exerciseTime) {
	cout << "\n      " << name << endl;
	cout << gender << ", " << age << ", " << (double)height << " m" << endl;
	cout << "Weight: " << (double)weight << " kg" << endl;
	cout << "Exercise: " << exercise << " (" << exerciseTime << " mins)" << endl;
}

void printDataHistory(string name, string gender, int age, double height, double weight[], string exercise[], int exerciseTime[], int size) {
	int day = 1;
	cout << "\n      " << name << endl;
	cout << gender << ", " << age << ", " << (double)height << " m" << endl;
	for (int i = size - 1; i >= 0; i--) {
		cout << "Day " << day << ":" << endl;
		cout << "Weight: " << (double)weight[i] << " kg" << endl;
		cout << "Exercise: " << exercise[i] << " (" << exerciseTime[i] << " mins)" << endl;
		day++;
	}
}

void shiftArraysToLeft(double weight[], string exercise[], int exerciseTime[], int size) {
	for (int i = 1; i < size; i++) {
		weight[i - 1] = weight[i];
		exercise[i - 1] = exercise[i];
		exerciseTime[i - 1] = exerciseTime[i];
	}
}

void getNumberInputs(int& size) {
	cout << "How many inputs do you want to be saved? ";
	size = getIntegerInput();
}

int main() {
	string name;
	string gender;
	int age;
	double height;
	double weight;
	string exercise;
	int exerciseTime;

	getBasicInfo(name, gender, age, height);

	int size;
	getNumberInputs(size);

	double* weightData = new double[size];
	string* exerciseData = new string[size];
	int* exerciseTimeData = new int[size];
	int sizeOfArray = 0;
	int index = 0;

	bool dataAdded = false;
	bool exitProgram = false;
	int option;

	while (!exitProgram) {
		showMenu();
		option = selectOption();
		switch (option) {
		case 1:
			if (size == sizeOfArray) {
				shiftArraysToLeft(weightData, exerciseData, exerciseTimeData, sizeOfArray);
				sizeOfArray--;
				index--;
			}
			inputData(weight, exercise, exerciseTime);
			weightData[index] = weight;
			exerciseData[index] = exercise;
			exerciseTimeData[index] = exerciseTime;
			dataAdded = true;
			sizeOfArray++;
			index++;
			break;
		case 2:
			if (dataAdded) {
				printData(name, gender, age, height, weight, exercise, exerciseTime);
			}
			else {
				cout << "There is no fitness data to print." << endl;
			}
			break;
		case 3:
			if (dataAdded) {
				printDataHistory(name, gender, age, height, weightData, exerciseData, exerciseTimeData, sizeOfArray);
			}
			else {
				cout << "There is no fitness data to print." << endl;
			}
			break;
		case 4:
			exitProgram = true;
			break;
		}
	}
	delete[] weightData;
	delete[] exerciseData;
	delete[] exerciseTimeData;

	return 0;
}
