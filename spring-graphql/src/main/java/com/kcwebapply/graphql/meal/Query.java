package com.kcwebapply.graphql.meal;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class Query implements GraphQLQueryResolver {

    public List<Meal> showMeal(){
        return generateMeals();
    }

    private List<Meal> generateMeals(){
        return Arrays.asList(
                new Meal("1","納豆","普通","普通",new Nutriation(8)),
                new Meal("2","肉","多い","美味しい",new Nutriation(5))
        );
    }
}
