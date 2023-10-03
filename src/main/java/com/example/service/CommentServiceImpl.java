package com.example.service;

import com.example.entity.Comment;
import com.example.entity.Reply;
import com.example.entity.User;
import com.example.repos.CommentRepository;

import com.example.repos.ReplyRepository;
import com.example.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

        @Autowired
        private CommentRepository commentRepository;
        @Autowired
        private ReplyRepository replyRepository;

        @Autowired
        private UserRepository userRepository;
        @Override
        public List<Comment> getAllComments() {
            return commentRepository.findAll();
        }

        @Override
        public Comment getCommentById(Long id) {
            Optional<Comment> commentOptional = commentRepository.findById(id);
            return commentOptional.orElse(null);
        }

        @Override
        public Comment addComment(Comment comment) {
            return commentRepository.save(comment);
        }

    @Override
    public Comment addCommentWithRepliesAndUser(Comment comment, List<Reply> replyEntities, User user) {
        comment.setReplies(replyEntities);
        comment.setUser(user);
        return commentRepository.save(comment);
    }

        @Override
        public Comment updateComment(Long id, Comment updatedComment) {
            Optional<Comment> commentOptional = commentRepository.findById(id);
            if (commentOptional.isPresent()) {
                Comment comment = commentOptional.get();
                comment.setText(updatedComment.getText());
                comment.setLikes(updatedComment.getLikes());
                comment.setDislikes(updatedComment.getDislikes());
                return commentRepository.save(comment);
            } else {
                return null;
            }
        }

        @Override
        public void deleteComment(Long id) {
            commentRepository.deleteById(id);
        }

    @Override
    public Reply addReplyToComment(Long commentId, Reply reply) {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        if (commentOptional.isPresent()) {
            Comment comment = commentOptional.get();
            reply.setParentComment(comment);
            return replyRepository.save(reply);
        } else {
            return null;
        }
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<Reply> getRepliesToComment(Long commentId) {
        return replyRepository.findRepliesByCommentId(commentId);
    }

}