package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.TreeMap;

@RestController
public class ChatController {

    @RequestMapping(value = "/chatMessage",method = RequestMethod.POST)
    public TreeMap<String,String> add(@Autowired HttpServletRequest request){
        TreeMap<String,String> treeMap = new TreeMap<String, String>();
        treeMap.put("toUser",request.getParameter("toUser"));
        treeMap.put("fromUser",request.getParameter("fromUser"));
        treeMap.put("message",request.getParameter("message"));
        return treeMap;
    }
}
