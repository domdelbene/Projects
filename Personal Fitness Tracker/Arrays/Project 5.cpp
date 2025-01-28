//Dominick Del Bene
/*The purpose of this project is the extend the functionality of Project 4 to store and view weekly fitness data.
Three arrays were created to store weight, exercise, and exercise time data.
The size of these arrays are 7 to imitate the days in a week.
To store multiple inputs in the array, the user must repeatedly select option 1 to add data.
The program will only save the 7 most recent inputs. If there are less than 7 inputs, the program will print the exact number of inputs.
An additional option will be added called 'Print History Data'. 
This option will print the history of inputs from most recent one to oldest one.
The other requirements are the same as Project 4.*/

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

int main() {
	string name;
	string gender;
	int age;
	double height;
	double weight;
	string exercise;
	int exerciseTime;

	getBasicInfo(name, gender, age, height);

	const int size = 7;
	double weightData[size];
	string exerciseData[size];
	int exerciseTimeData[size];
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
	return 0;
}
