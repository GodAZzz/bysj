package com.zdc.tcms.biz.service;

import com.zdc.core.utils.PageBean;
import com.zdc.tcms.biz.entity.RecipesDetails;

import java.util.List;

/**
 * 膳食服务
 */
public interface FoodService {

    /**
     * 随机得到首页展示的四个膳食
     * @return
     */
    List<RecipesDetails> getFourFood();

    /**
     * 根据膳食名称查询
     */
    RecipesDetails getByFoodname(String foodName);

    /**
     * 根据分类分页查询膳食
     */
    PageBean findRecipesDetailsByPage(int currentPage, int pageSize, String feilei);
}
