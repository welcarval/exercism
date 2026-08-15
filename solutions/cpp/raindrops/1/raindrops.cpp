#include "raindrops.h"

namespace raindrops {
	std::string convert(int number) {
	
		std::string sound;

		if(number % 3 == 0) {
			sound.append("Pling");
		}

		if(number % 5 == 0) {
			sound.append("Plang");
		}

		if(number % 7 == 0) {
			sound.append("Plong");
		}

		if(sound.empty()) {
			return std::to_string(number);
		} else {
			return sound;
		}
	}
}  // namespace raindrops
