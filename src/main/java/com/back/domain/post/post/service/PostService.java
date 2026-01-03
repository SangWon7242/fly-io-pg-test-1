package com.back.domain.post.post.service;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
  private final PostRepository postRepository;

  public Long count() {
    return postRepository.count();
  }

  public void write(String title, String content) {
    Post post = Post.builder()
        .title(title)
        .content(content)
        .build();

    postRepository.save(post);
  }

  public List<Post> getPosts() {
    return postRepository.findAll();
  }
}
