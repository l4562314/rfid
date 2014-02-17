#ifndef _GROUP_HPP_
#define _GROUP_HPP_

#include "user.hpp"

namespace psymatch
{
	using namespace std;
	using namespace Json;
	using namespace boost;

	typedef vector<psymatch::User*> Users;

	class Group
	{
	public:
		Group(string& json);

		~Group();

		const int size() const;

		const vector<User*> getuserlist() const;

		const string match(double match=0, int limit=0) const;

		void display(int format=PLAIN) const;

	private:
		Users userlist;
		Group& operator=(const Group&);
	};
}

#endif
