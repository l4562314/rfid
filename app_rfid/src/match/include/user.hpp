#ifndef _USER_HPP_
#define _USER_HPP_

#include "common.hpp"

namespace psymatch
{
	using namespace std;
	using namespace Json;

	class User
	{
	public:
		User();

		User(string&);

		User(const string&, const int, const Value&);

		~User();

		User& operator=(const User&);

		const Value getanswer() const;

		const int getfinished() const;

		const int getsex() const;

		const string getuid() const;

		const double match(const User&, bool raw) const;

		const string match(const User&) const;

		const string report() const;

		const string match_report(const User&) const;

		void display(int format=PLAIN) const;

	private:
		basic_string<char> uid;
		int sex;
		Value answer;
		int finished;

		User(const User&);
	};
}

#endif
