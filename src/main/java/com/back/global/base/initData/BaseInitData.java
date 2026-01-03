package com.back.global.base.initData;

import com.back.domain.post.post.service.PostService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class BaseInitData {
  private final PostService postService;

  @Autowired
  @Lazy
  private BaseInitData self;

  public BaseInitData(PostService postService) {
    this.postService = postService;
  }

  @Bean
  public ApplicationRunner baseInitDataApplicationRunner() {
    return args -> {
      self.work1();
    };
  }

  @Transactional
  public void work1() {
    if(postService.count() > 0) return;

    postService.write("제목1", "내용1");
    postService.write("제목2", "내용2");
  }
}
