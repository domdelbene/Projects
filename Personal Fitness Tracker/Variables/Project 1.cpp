//Dominick Del Bene
/*The purpose of the project is to keep track of a user's health. 
The user's information and exercise will be printed to the console to simulate a Personal Fitness application.
In my implementation, I used my own information and an exercise I used to do. 
*/ 

#include <iostream>
using namespace std;

int main() {
	string name = "Dom";
	string gender = "Male";
	int age = 21;
	double height = 1.71;
	double weight = 62.14;
	string exercise = "Distance Running";
	int exerciseTime = 45;

	cout << "      " << name << endl;
	cout << gender << ", " << age << ", " << height << " m" << endl;
	cout << "Weight: " << weight << " kg" << endl;
	cout << "Exercise: " << exercise << " (" << exerciseTime << " mins)";

	return 0;
}