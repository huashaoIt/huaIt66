package cn.dyh.springboot9cache.controller;

import cn.dyh.springboot9cache.dao.DescNameMapper;
import cn.dyh.springboot9cache.entity.DescName;
import cn.dyh.springboot9cache.service.DescNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DescNameController {

    //@Autowired
    //private DescNameMapper descnameMapper;

    @Resource
    private DescNameService descNameService;


    /*@GetMapping("/lists")
    public List<DescName> getList(){
        List<DescName> list = descnameMapper.getList();
        return list;
    }

    *//**
     * 添加
     * @param descName
     * @return
     *//*
    @GetMapping("/list")
    public DescName insetrDesc(DescName descName){
        int i = descnameMapper.insertDescName(descName);
        return descName;
    }*/

    @GetMapping("/list/{id}")
    public DescName getListById(@PathVariable("id") Integer id){
        DescName descName = descNameService.getDescName(id);
        return descName;

    }

    @GetMapping("/update")
    public DescName udpate(DescName descName){
        DescName up = descNameService.update(descName);
        return up;
    }

}
