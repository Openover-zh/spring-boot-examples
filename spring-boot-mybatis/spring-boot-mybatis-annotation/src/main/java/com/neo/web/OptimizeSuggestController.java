package com.neo.web;

import com.neo.model.OptimizeSuggest;
import com.neo.service.OptimizeSuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangJiaHao
 * @date 2022/8/12 16:51
 */
@RestController
@RequestMapping("/optimize/suggest")
public class OptimizeSuggestController {
    @Autowired
    private OptimizeSuggestService optimizeSuggestService;


}
