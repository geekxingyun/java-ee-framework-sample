package com.xingyun.springbootwithdatajpasample.controller;


import com.xingyun.springbootwithdatajpasample.mmInterface.GirlRepository;
import com.xingyun.springbootwithdatajpasample.model.Girl;
import com.xingyun.springbootwithdatajpasample.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @Return
     * */
    @GetMapping("/girls")
    public List<Girl> getGirlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
    * */
    @PostMapping("/girls")
    public Girl girlAdd(@RequestParam("girlName") String girlName,@RequestParam("girlAge") Integer girlAge){

        Girl girl=new Girl();
        girl.setGirlName(girlName);
        girl.setGirlAge(girlAge);
        girlRepository.save(girl);
        return girl;
    }

    /**
     * 添加两个女生
     * */
    @GetMapping("/girls/two")
    public String girlAddTwo(){
        girlService.insertTwo();
        return "success";
    }

    /**
     * 通过Id查询一个女生
     * */
    @GetMapping("/girls/{id}")
    public Optional<Girl> girlFindById(@PathVariable("id") Integer uid){
         return girlRepository.findById(uid);
    }
    /**
     * 通过年龄查询一个女生
     * */
    @GetMapping("/girls/age/{girlAge}")
    public List<Girl> girlFindByAge(@PathVariable("girlAge") Integer age){
        return girlRepository.findByGirlAge(age);
    }

    /**
     * 修改一个女生
     */
    @PostMapping(value="/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer uid,@RequestParam("girlName") String girlName,@RequestParam("girlAge") Integer girlAge){
        Girl girl=new Girl();
        girl.setId(uid);
        girl.setGirlName(girlName);
        girl.setGirlAge(girlAge);
        return girlRepository.save(girl);
    }

    /**
     * 删除一个Id
    * */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer uid){
        girlRepository.deleteById(uid);
    }
}

