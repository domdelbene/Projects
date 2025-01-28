//Dominick Del Bene
/*The purpose of the project is to allow users to provide inputs about their health.
The console will prompt the user to enter information about themself and their exercise for the day.
The user will enter their information and it will be printed to the console to simulate a Personal Fitness application.*/

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

	cout << "How much do you weigh today? (in kilograms) ";
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

	cout << "\n      " << name << endl;
	cout << gender << ", " << age << ", " << (double)height << " m" << endl;
	cout << "Weight: " << (double)weight << " kg" << endl;
	cout << "Exercise: " << exercise << " (" << exerciseTime << " mins)" << endl;

	return 0;
}