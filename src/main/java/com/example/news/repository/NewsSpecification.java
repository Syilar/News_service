package com.example.news.repository;

import com.example.news.model.News;
import com.example.news.web.model.NewsFilter;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;

public interface NewsSpecification {

    static Specification<News> withFilter(NewsFilter newsFilter) {
        return Specification.where(byTitleName(newsFilter.getTitleName()))
                .and(byUserId(newsFilter.getUserId()))
                .and(byCreatedAtBefore(newsFilter.getCreatedBefore()))
                .and(byUpdatedAtBefore(newsFilter.getUpdatedBefore())
                .and(byTitleCategoryName(newsFilter.getTitleCategory()))
                .and(byAuthorName(newsFilter.getAuthorName())));
    }

    static Specification<News> byTitleName(String titleName) {
        return ((root, query, cb) -> {
            if (titleName == null) {
                return null;
            }

            return cb.equal(root.get("title"), titleName);
        });
    }

    static Specification<News> byUserId(Long userId) {
        return ((root, query, cb) -> {
            if (userId == null) {
                return null;
            }

            return cb.equal(root.get("user").get("id"), userId);
        });
    }

    static Specification<News> byCreatedAtBefore(Instant createdBefore) {
        return ((root, query, cb) -> {
            if (createdBefore == null) {
                return null;
            }

            return cb.lessThanOrEqualTo(root.get("createAt"), createdBefore);
        });
    }

    static Specification<News> byUpdatedAtBefore(Instant updatedBefore) {
        return ((root, query,cb) -> {
            if (updatedBefore == null) {
                return null;
            }

            return cb.lessThanOrEqualTo(root.get("updateAt"), updatedBefore);
        });
    }

    static Specification<News> byTitleCategoryName(String titleCategory) {
        return ((root, query, cb) -> {
            if (titleCategory == null) {
                return null;
            }

            return cb.equal(root.get("categoryNews").get("title"), titleCategory);
        });
    }

    static Specification<News> byAuthorName(String authorName) {
        return ((root, query, cb) -> {
            if (authorName == null) {
                return null;
            }

            return cb.equal(root.get("user").get("name"), authorName);
        });
    }
}
