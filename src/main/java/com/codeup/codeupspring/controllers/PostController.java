package com.codeup.codeupspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
        return "Posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String indivdualPosts(@PathVariable long id){
        return "View an individual post" + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostForm(){
        return "View the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "Create a new post";
    }

}
