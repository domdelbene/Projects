//Dominick Del Bene
/*The purpose of the project is to allow users to repeatedly select an option from a text menu.
First, the console will prompt the user to enter information about themselves. 
Next, the console will present 3 choices to the user.
The first two choices will add or print data about their weight, exercise, and time for the day.
The third choice will close the program altogether. 
These options will loop repeatedly until the user has selected the third choice. 
Invalid numeric data and errors will be printed to the console.*/

#include <iostream>
#include <string>
using namespace std;

int main() {
	string name;
	string gender;
	int age;
	double height;
	double weight;
	string exercise;
	int exerciseTime;

	cout << "What is your name? ";
	getline(cin, name);

	cout << "What is your gender? ";
	cin >> gender;

	cout << "How old are you? ";
	cin >> age;

	while (cin.fail()) {
		cout << "Not a valid input\n";
		cin.clear();
		cin.ignore(1000, '\n');
		cout << "Enter a new int for age: ";
		cin >> age;
	}

	cout << "How tall are you? (in meters) ";
	cin >> height;

	while (cin.fail()) {
		cout << "Not a valid input\n";
		cin.clear();
		cin.ignore(1000, '\n');
		cout << "Enter a new double for height: ";
		cin >> height;
	}

	bool dataAdded = false;
	bool exitProgram = false;
	int option;

	while (!exitProgram) {
		cout << "\nOption 1: Add Data." << endl;
		cout << "Option 2: Print Data." << endl;
		cout << "Option 3: Exit." << endl;
		cout << "Press 1, 2, or 3 corresponding to that option: ";
		cin >> option;
		switch (option) {
		case 1:
			cout << "\nHow much do you weigh today? (in kilograms) ";
			cin >> weight;

			while (cin.fail()) {
				cout << "Not a valid input\n";
				cin.clear();
				cin.ignore(1000, '\n');
				cout << "Enter a new double for weight: ";
				cin >> weight;
			}

			cout << "What exercise did you do today? ";
			cin.ignore(1000, '\n');
			getline(cin, exercise);

			cout << "How long was the exercise? (in minutes) ";
			cin >> exerciseTime;

			while (cin.fail()) {
				cout << "Not a valid input\n";
				cin.clear();
				cin.ignore(1000, '\n');
				cout << "Enter a new int for time: ";
				cin >> exerciseTime;
			}
			dataAdded = true;
			break;
		case 2:
			if (dataAdded) {
				cout << "\n      " << name << endl;
				cout << gender << ", " << age << ", " << (double)height << " m" << endl;
				cout << "Weight: " << (double)weight << " kg" << endl;
				cout << "Exercise: " << exercise << " (" << exerciseTime << " mins)" << endl;
			}
			else {
				cout << "There is no fitness data to print." << endl;
			}
			break;
		case 3:
			exitProgram = true;
			break;
		default:
			cout << "The selected option is invalid." << endl;
			cin.clear();
			cin.ignore(1000, '\n');
			break;
		}
	}
	return 0;
}