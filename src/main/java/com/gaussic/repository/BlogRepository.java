package com.gaussic.repository;

import com.gaussic.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

/**
 * Created by max183 on 2016/7/22.
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    // 修改博文操作
    @Modifying
    @Transactional
    @Query("update Blog blog set blog.title = :title, blog.userByUserId.id = :userId, blog.content = :content, " +
            "blog.pubDate = :pubDate where blog.id = :id")
    void updateBlog(@Param("title") String title, @Param("userId") int userId, @Param("content") String content,
                    @Param("pubDate") Date pubDate, @Param("id") int id);
}