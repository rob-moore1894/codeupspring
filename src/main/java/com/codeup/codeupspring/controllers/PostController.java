package com.codeup.codeupspring.controllers;

import com.codeup.codeupspring.models.Post;
import com.codeup.codeupspring.repositories.PostRepository;
import com.codeup.codeupspring.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {
    private PostRepository postDao;

    @Autowired
    public EmailService emailService;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String all(Model model){
        Iterable<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model){
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post) {
        Post savedPost = postDao.save(post);
        emailService.prepareAndSend(savedPost, "Post Created Successfully", "Your post was created " + savedPost.getId());
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@PathVariable long id,
                         @RequestParam(name = "title") String title,
                         @RequestParam(name = "body") String body,
                         Model model){
        Post post = postDao.findOne(id);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/delete")
    public String delete(@RequestParam(name = "id") long id){
        Post post = postDao.findOne(id);
        postDao.delete(post);
        return "redirect:/posts";
    }
}