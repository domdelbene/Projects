//Dominick Del Bene
/*The purpose of this project is to recode the program from the previous project to use functions. 
getIntegerInput() and getDoubleInput() will take in an input from the user, validate that input, and return the it when the user provides a valid one.
getBasicInfo() will ask and take in the user's name, gender, age, and height.
showMenu() will display the three options to the user.
selectOption() will take in an option from the user. 
If the input is invalid, it will print an error message and ask for another input. Valid inputs will be returned.
inputData() will ask and take in the user's weight, exercise type, and time for the day. 
outputData() will print that data.
The other requirements are the same as the previous project.*/

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
	cout << "Option 3: Exit." << endl;
	cout << "Press 1, 2, or 3 corresponding to that option: ";
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

	while (input <= 0 || input > 3) {
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

int main() {
	string name;
	string gender;
	int age;
	double height;
	double weight;
	string exercise;
	int exerciseTime;

	getBasicInfo(name, gender, age, height);

	bool dataAdded = false;
	bool exitProgram = false;
	int option;

	while (!exitProgram) {
		showMenu();
		option = selectOption();
		switch (option) {
		case 1:
			inputData(weight, exercise, exerciseTime);
			dataAdded = true;
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
			exitProgram = true;
			break;
		}
	}
	return 0;
}

