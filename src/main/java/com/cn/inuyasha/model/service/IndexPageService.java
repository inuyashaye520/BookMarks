package com.cn.inuyasha.model.service;

import org.springframework.stereotype.Service;

/**
 * Index page service
 */
@Service("indexPageService")
public class IndexPageService {

    private String index;

    public Object getIndex() {
        return "redirect:/admin/index.html";
    }

    public void setIndex(String index) {
        this.index = index;
    }

}
