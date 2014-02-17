#ifndef _COMMON_HPP_
#define _COMMON_HPP_

#include <map>
#include <cmath>
#include <ctime>
#include <vector>
#include <cstdlib>
#include <sstream>
#include <iterator>
#include <algorithm>
#include <functional>
#include <json/json.h>
#include <fcgi_stdio.h>
#include <cgicc/Cgicc.h>
#include <boost/lexical_cast.hpp>
#include <boost/algorithm/string.hpp>

#define min(a,b) ((a) < (b) ? (a) : (b))
#define max(a,b,c) ((a) > ((b) > (c) ? (b) : (c)) ? (a) : ((b) > (c) ? (b) : (c)))
#define round2(d) (round(d * 100) / 100)
#define round3(d) (round(d * 1000) / 1000)

using namespace std;
using namespace Json;
using namespace cgicc;

namespace psymatch
{
	typedef struct
	{
		double avoidance, anxiety, sec2, fear2, pre2, dis2, ls1, ls2, ls3, ls4, ls5, ls6, rb;
	}match31;

	enum {PLAIN,CASCADE};
	enum {FEMALE = 0, MALE = 1};
	enum {EGAY = -1, EZERO = -2};

	string json_encode(const Value& root, int format=PLAIN);
	Value json_decode(const string& json);

	struct mysort
	{
		bool operator()(double, double);
	};

	struct FCgiInput: public CgiInput
	{
		size_t read(char *data, size_t length);
	};
}
#endif
