package com.xingyun.springbootwithdatajpasample.mmInterface;

import com.xingyun.springbootwithdatajpasample.model.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository  extends JpaRepository<Girl,Integer>{

    //自定义接口
    public List<Girl> findByGirlAge(Integer girlAge);
}
