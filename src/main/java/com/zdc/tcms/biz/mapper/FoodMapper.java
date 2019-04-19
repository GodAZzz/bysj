package com.zdc.tcms.biz.mapper;

import com.zdc.tcms.biz.entity.RecipesDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoodMapper {

    /**
     * 随机获取四个膳食食谱
     * @return
     */
    List<RecipesDetails> getFourFood();

    /**
     * 根据膳食名字查询
     */
    RecipesDetails getByFoodName(@Param("foodname") String foodname);

    /**
     * 根据分类查询膳食食谱
     */
    List<RecipesDetails> getByFenlei(@Param("fenlei") String fenlei);

    /**
     * 根据分类查询膳食食谱总数
     */
    int getByFenleiCountNums(@Param("fenlei") String fenlei);
}
