#ifndef _REPORT_HPP_ 
#define _REPORT_HPP_ 

#include "user.hpp"

namespace psymatch
{
	using namespace std;
	using namespace Json;
	using namespace boost;

	class Report
	{
	public:
		static const Value report(const User&);

		static const Value match_report(const User&, const User&);
	private:
		static void report1(const User&, Value&);

		static void report2(const User&, Value&);

		static void report3(const User&, Value&);

		static void report4(const User&, Value&);

		static void report5(const User&, Value&);

		static const int getlevel(const double&);

		static const int getfinished(const Value&);

		Report();
		~Report();
		Report(const Report&);
		Report& operator=(const Report&);
	};
}

#endif
