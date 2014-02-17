/* 
 * Psychology Match Interface Usage Examples
 *
 * Written by Michael Wu on Aug 30, 2011, CopyLeft, All rights Dereserved
 *
 * to compile it:
 * c++ -O2 -fPIC -o examples examples.cpp -lfcgi -lcgicc -ljson -lmatch -I/usr/local/include/match -L/usr/local/lib/match -L/usr/local/lib/json
 *
 */

#include <iostream>
#include <fstream>

#include "match.hpp"
#include "report.hpp"

using namespace std;
using namespace psymatch;

string param(const string& file)
{
	ifstream in;	
	in.open(file.data(),ios::binary);
	filebuf *fb = in.rdbuf();
	size_t size = fb->pubseekoff(0,ios::end,ios::in);
	fb->pubseekpos(0,ios::in);
	char *buf = new char[size];
	fb->sgetn(buf,size);
	in.close();
	string data(buf);
	delete [] buf;
	
	return data;
}

int main(void)
{
	/* match, result in json format */
	string answer = param("two.txt");

	Group *group = new Group(answer);
	/* fetch the user list, there must be only two person in it */
	Users userlist = group->getuserlist();
	/* match each other */
	cout << userlist[0]->match(*userlist[1]) << endl;
	delete group;

	/* self test report, there must be only one person in the answer, result in json format */
	answer = param("one.txt");
	User user(answer);
	/* fetch the self test report directly */
	cout << user.report() << endl;

	/* match report, result in json format */
	answer = param("two.txt");
	group =  new Group(answer);
	/* fetch the user list, there must be only tow persons in it, which mentioned above already*/
	userlist = group->getuserlist();
	/* get the match report with other */
	cout << userlist[0]->match_report(*userlist[1]) << endl;
	delete group;

	/* recommendation, result in json format */
	answer = param("three.txt");
	group =  new Group(answer);
	/* all of matches between one and the others, first member in the group is the one */
	cout << group->match() << endl;
	/* ditto, but for the ones whose matched results greate than 0.8 in this instance */
	cout << group->match(0.4) << endl;
	/* ditto, but for the ones whose matched results greate than 0.8 and 100 is enough in this instance */
	cout << group->match(0.4, 100) << endl;
	delete group;
	
	return 0;
}
