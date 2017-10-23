package com.cn.inuyasha.model.page;

import com.cn.inuyasha.model.service.IndexPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Index page
 */
@Controller
public class IndexPage {

    @Autowired
    @Qualifier("indexPageService")
    private IndexPageService indexPageService;

    @RequestMapping(value = "/tmpl/**/*.html")
    public void html() {
    }

    @RequestMapping(value = {"/", "/index.html"})
    public Object index() {
        return indexPageService.getIndex();
    }

}
