#include <vector>
#include <string>
#pragma once

namespace lasagna_master {

    struct amount {
        int noodles;
        double sauce;
    };

    int preparationTime(std::vector<std::string> layers, int times= 2);

    amount quantities(std::vector<std::string> layers);
    std::vector<double> scaleRecipe(std::vector<double> quantities, int portions);

    void addSecretIngredient(std::vector<std::string>& my_list, const std::vector<std::string>& friend_list);
    void addSecretIngredient(std::vector<std::string>& my_list, std::string great_grand_aunt_ingredient);

}  // namespace lasagna_master
