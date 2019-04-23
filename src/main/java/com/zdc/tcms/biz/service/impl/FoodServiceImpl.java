package com.zdc.tcms.biz.service.impl;

import com.github.pagehelper.PageHelper;
import com.zdc.core.utils.PageBean;
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

    @Override
    public PageBean findRecipesDetailsByPage(int currentPage, int pageSize, String feilei) {
        //设置分页信息，分别是当前页数和每页显示的总记录数
        PageHelper.startPage(currentPage, pageSize);
        //根据分类查出来的膳食信息
        List<RecipesDetails> byFenlei = foodMapper.getByFenlei(feilei);
        //根据分类查出来的膳食信息的总记录数
        int byFenleiCountNums = foodMapper.getByFenleiCountNums(feilei);
        PageBean<RecipesDetails> recipesDetailsPageBean = new PageBean<RecipesDetails>(currentPage, pageSize, byFenleiCountNums);
        recipesDetailsPageBean.setItems(byFenlei);
        return recipesDetailsPageBean;
    }
}
