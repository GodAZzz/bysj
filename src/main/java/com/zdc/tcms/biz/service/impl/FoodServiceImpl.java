package com.zdc.tcms.biz.service.impl;

import com.zdc.tcms.biz.entity.RecipesDetails;
import com.zdc.tcms.biz.mapper.FoodMapper;
import com.zdc.tcms.biz.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<RecipesDetails> getFourFood() {
        List<RecipesDetails> fourFood = foodMapper.getFourFood();
        return fourFood;
    }

    @Override
    public RecipesDetails getByFoodname(String foodName) {
        RecipesDetails byFoodName = foodMapper.getByFoodName(foodName);
        return byFoodName;
    }
}
