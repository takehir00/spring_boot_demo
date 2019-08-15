package com.example.demodemo;

import com.example.demodemo.repositories.MyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
public class HelloController {

    @Autowired
    MyDataRepository myDataRepository;

    @PersistenceContext
    EntityManager entityManager;

    MyDataDaoImpl dao;

    @PostConstruct
    public void init(){
        MyDataDaoImpl dao = new MyDataDaoImpl(entityManager); //●
        MyData d1 = new MyData();
        d1.setName("tuyano");
        d1.setAge(123);
        d1.setMail("syoda@tuyano.com");
        d1.setMemo("090999999");
        myDataRepository.saveAndFlush(d1);
        MyData d2 = new MyData();
        d2.setName("hanako");
        d2.setAge(15);
        d2.setMail("hanako@flower");
        d2.setMemo("080888888");
        myDataRepository.saveAndFlush(d2);
        MyData d3 = new MyData();
        d3.setName("sachiko");
        d3.setAge(37);
        d3.setMail("sachico@happy");
        d3.setMemo("070777777");
        myDataRepository.saveAndFlush(d3);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(@ModelAttribute("formModel") MyData myData, ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("msg", "マイデータのサンプルです");
        Iterable<MyData> list = dao.getAll();
        mav.addObject("datalist", list);
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView form(ModelAndView mav,
                             @ModelAttribute("formModel") MyData myData) {
        myDataRepository.saveAndFlush(myData);
        mav.setViewName("index");
        return new ModelAndView("redirect:/");
    }
}
