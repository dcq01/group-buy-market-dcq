package org.example.infrastructure.dao;

import org.example.infrastructure.dao.po.GroupBuyDiscount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 折扣配置Dao
 * @create 2024-12-07 10:10
 */
@Mapper
public interface IGroupBuyDiscountDao {

    List<GroupBuyDiscount> queryGroupBuyDiscountList();

}
