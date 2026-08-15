#include <vector>
#include <string>
#include "lasagna_master.h"

namespace lasagna_master {

    int preparationTime(std::vector<std::string> layers, int times) {
        return std::size(layers) * times;
    }

    amount quantities(std::vector<std::string> layers) {
        
        int noodles_count{0};
        int sauce_count{0};

        for(std::size_t i = 0; i < std::size(layers); i++) {
            if(layers[i] == "noodles") {
                noodles_count++;
            } else if(layers[i] == "sauce") {
                sauce_count++;
            }
        }
        return amount{50 * noodles_count, 0.2 * sauce_count};
    }

    std::vector<double> scaleRecipe(std::vector<double> quantities, int portions) {
        std::vector<double> new_list{};

        for(std::size_t i = 0; i < std::size(quantities); i++) {
            new_list.push_back(quantities[i] * portions * 0.5);
        }

        return new_list;
    }

    void addSecretIngredient(std::vector<std::string>& my_list, const std::vector<std::string>& friend_list) {
        my_list[std::size(my_list) - 1] = friend_list[std::size(friend_list) - 1];
    }

    void addSecretIngredient(std::vector<std::string>& my_list, std::string great_grand_aunt_ingredient) {
        my_list[std::size(my_list) - 1] = great_grand_aunt_ingredient;
    }
}  // namespace lasagna_master
