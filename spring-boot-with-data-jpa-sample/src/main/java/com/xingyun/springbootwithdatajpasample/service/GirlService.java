package com.xingyun.springbootwithdatajpasample.service;

import com.xingyun.springbootwithdatajpasample.mmInterface.GirlRepository;
import com.xingyun.springbootwithdatajpasample.model.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){

        Girl girlA=new Girl();
        girlA.setGirlName("A");
        girlA.setGirlAge(16);
        girlRepository.save(girlA);

        Girl girlB=new Girl();
       // girlB.setGirlName("BBbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        girlB.setGirlName("B");
        girlB.setGirlAge(19);
        girlRepository.save(girlB);
    }


}
