package com.example.service;

import com.example.entity.Comment;
import com.example.entity.Reply;
import com.example.entity.User;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();

    Comment getCommentById(Long id);

    Comment addComment(Comment comment);

    Comment addCommentWithRepliesAndUser(Comment comment, List<Reply> reply, User user);

    Comment updateComment(Long id, Comment updatedComment);

    void deleteComment(Long id);

    Reply addReplyToComment(Long commentId, Reply reply);

    User saveUser(User user);

    List<Reply> getRepliesToComment(Long commentId);

}
