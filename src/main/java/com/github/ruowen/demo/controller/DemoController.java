package com.github.ruowen.demo.controller;

import com.github.ruowen.demo.model.DemoData;
import com.github.ruowen.demo.model.Result;
import com.github.ruowen.demo.model.ServiceException;
import com.github.ruowen.demo.service.DemoDataService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoDataService demoDataService;

    @ResponseBody
    @GetMapping("/data/add/random")
    public Result<DemoData> addRandom() {
        return Result.succ(demoDataService.createRandomData());
    }

    @ResponseBody
    @GetMapping("/exception/service")
    public Result<DemoData> exceptionService() {
        throw new ServiceException(400, "test");
    }

    @ResponseBody
    @GetMapping("/exception/npe")
    public Result<DemoData> exceptionNpe() {
        DemoData data = new DemoData();
        int npe = data.getSomeData().length();
        return Result.succ(null);
    }
}