#include <string>

namespace star_map{
    enum class System {
       BetaHydri, 
       Sol,
       EpsilonEridani,
       AlphaCentauri,
       DeltaEridani,
       Omicron2Eridani,
    };
}

namespace heaven {
    class Vessel{
        public:
            Vessel(std::string name, int generation);

            Vessel(std::string name, int generation, star_map::System system);
            Vessel replicate(std::string name);

            void make_buster();
            bool shoot_buster();

            star_map::System current_system{};
            int generation{};
            int busters{0};
            std::string name{};
    };
    
    std::string get_older_bob(heaven::Vessel vessel1, heaven::Vessel vessel2);

    bool in_the_same_system(heaven::Vessel vessel1, heaven::Vessel vessel2);
}


