package com.neo.mapper;

import com.neo.model.OptimizeSuggest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhangJiaHao
 * @date 2022/8/12 17:04
 */
@Mapper
public interface OptimizeSuggestMapper {

    List<OptimizeSuggest> getById(Integer id);
}
