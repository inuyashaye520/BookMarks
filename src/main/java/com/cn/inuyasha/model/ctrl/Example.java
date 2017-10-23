package com.cn.inuyasha.model.ctrl;

import com.alibaba.fastjson.JSONObject;
import com.cn.inuyasha.model.bean.JsonResult;
import com.cn.inuyasha.model.bean.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("example")
@RequestMapping("/api/example")
public class Example {

    /**
     * 测试api
     */
    @RequestMapping(method = RequestMethod.GET)
    public JsonResult<Pageable<JSONObject>> selectExamples(@RequestParam(defaultValue = "1") Integer page,
                                                           @RequestParam(defaultValue = "10") Integer pageSize) {
        JSONObject json = new JSONObject();
        json.put("username", "Inuyasha叶");
        json.put("password", "5201314");
        List<JSONObject> example = new ArrayList<>();
        example.add(json);
        int total = 1;
        Pageable<JSONObject> result = new Pageable<>(total, pageSize, page);
//        json.put("start", result.getStart());
//        json.put("pageSize", pageSize);
        result.setItems(example);
        return JsonResult.success(result);

    }


}
