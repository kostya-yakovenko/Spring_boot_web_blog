package com.web.blog.controllers;

import com.web.blog.models.Post;
import com.web.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@Controller
public class BlogController {
 @Autowired
 private PostRepository postRepository;
 @GetMapping("/")
 public String blogMain(Model model) {
  Iterable<Post> posts = postRepository.findAll();
  model.addAttribute("posts", posts);
  return "blog-main";
 }
 @GetMapping("/about")
 public String about(Model model) {
  model.addAttribute("title", "I am a Java Developer with 2 years of experience studying and building projects. Here’s what I work with:\n" +
          "\n" +
          "- Java Core and OOP principles\n" +
          "- Spring Framework: Core, Boot, MVC\n" +
          "- Hibernate (JPA)\n" +
          "- SQL and relational databases\n" +
          "- Git and GitHub for version control\n" +
          "\n" +
          "And all of this frameworks i've used here to create this web blog.");
  return "about";
 }

 @GetMapping("/add")
 public String blogAdd() {
  return "blog-add";
 }
 @PostMapping("/add")
 public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String fullText){
  Post post = new Post(title, anons, fullText);
  postRepository.save(post);
  return "redirect:/";
 }
 @PostMapping("/{id}/edit")
 public String blogPostEdit(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String fullText){
  Post post = postRepository.findById(id).orElseThrow();
  post.setTitle(title);
  post.setAnons(anons);
  post.setFullText(fullText);
  postRepository.save(post);
  return "redirect:/";
 }
 @PostMapping("/{id}/delete")
 public String blogPostDelete(@PathVariable(value = "id") long id, Model model){
  Post post = postRepository.findById(id).orElseThrow();
  postRepository.delete(post);
  return "redirect:/";
 }
 @GetMapping("/{id}/edit")
 public String blogEdit(@PathVariable(value = "id") long id, Model model) {
  if (!postRepository.existsById(id)) {
   return "redirect:/";
  }
  Optional<Post> post = postRepository.findById(id);
  post.ifPresent(value -> model.addAttribute("el", value));
  return "blog-edit";
 }
 @GetMapping("/{id}")
 public String blogDetails(@PathVariable(value = "id") long id, Model model) {
  if(!postRepository.existsById(id)){
   return "redirect:/";
  }
  Optional<Post> post = postRepository.findById(id);
  ArrayList<Post> res = new ArrayList<>();
  post.ifPresent(res::add);
  model.addAttribute("post", res);
  return "blog-details";
 }

}
