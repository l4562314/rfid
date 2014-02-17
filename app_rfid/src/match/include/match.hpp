#ifndef _MATCH_HPP_
#define _MATCH_HPP_

#include "group.hpp"

namespace psymatch
{
	using namespace std;
	using namespace Json;
	using namespace boost;

	class Match
	{
	public:
		static match31 parse(const vector<double>& item);

		static const double match(const User& A, const User& B);
	private:
		static const double match1(const User& A, const User& B);

		static const double match2(const User& A, const User& B, bool only=false);

		static const double match3(const User& A, const User& B, bool only=false);

		static const double match4(const User& A, const User& B, bool only=false);

		static const double match5(const User& A, const User& B, bool only=false);

		static const double weight(const string& w);

		Match();
		~Match();
		Match(const Match&);
		Match& operator=(const Match&);
	};
}

#endif
