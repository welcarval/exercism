#include "doctor_data.h"

heaven::Vessel::Vessel(std::string n, int gen) {
    name = n;
    generation = gen;
    current_system = star_map::System::Sol;
}   

 heaven::Vessel::Vessel(std::string n, int gen, star_map::System system) {
    name = n;
    generation = gen;
    current_system = system;

}

heaven::Vessel heaven::Vessel::replicate(std::string new_name) {
    return {new_name, ++generation, current_system};
}

void heaven::Vessel::make_buster() {
    busters++;
}

bool heaven::Vessel::shoot_buster() {
    if (busters > 0) {
        busters--;
        return true;
    }
    return false;
}

std::string heaven::get_older_bob(heaven::Vessel vessel1, heaven::Vessel vessel2) {
    if(vessel1.generation <= vessel2.generation) {
        return vessel1.name;
    }
    return vessel2.name;
}

bool heaven::in_the_same_system(heaven::Vessel vessel1, heaven::Vessel vessel2) {
    if(vessel1.current_system == vessel2.current_system) {
        return true;
    }
    return false;
}
