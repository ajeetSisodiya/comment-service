package com.example.controllers;

import com.example.dto.CommentDTO;
import com.example.dto.CommentWithRepliesDTO;
import com.example.dto.ReplyDTO;
import com.example.dto.UserDTO;
import com.example.entity.Comment;
import com.example.entity.Reply;
import com.example.entity.User;
import com.example.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @PostMapping
    public Comment addComment(@RequestBody CommentWithRepliesDTO commentWithReply) {

        CommentDTO commentDTO = commentWithReply.getComment();
        UserDTO userDTO = commentDTO.getUser();


        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setId(userDTO.getId());

        commentService.saveUser(user);

        Comment comment = new Comment();
        comment.setText(commentDTO.getText());
        comment.setLikes(commentDTO.getLikes());
        comment.setDislikes(commentDTO.getDislikes());

        List<ReplyDTO> replyDto = commentWithReply.getReplies();
        List<Reply> replies = new ArrayList<>();

        for (ReplyDTO dto : replyDto) {
            Reply rep = new Reply();
            rep.setText(dto.getText());
            rep.setLikes(dto.getLikes());
            rep.setDislikes(dto.getDislikes());
            rep.setParentComment(comment);

            UserDTO replyUserDTO = dto.getUser();
            User replyUser = new User();
            replyUser.setUserName(replyUserDTO.getUserName());
            replyUser.setId(replyUserDTO.getId());
            replyUser = commentService.saveUser(replyUser);

            rep.setUser(replyUser);
            replies.add(rep);

            rep.setUser(user);
            replies.add(rep);
        }

        return commentService.addCommentWithRepliesAndUser(comment, replies, user);
    }


    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable Long id, @RequestBody Comment updatedComment) {
        return commentService.updateComment(id, updatedComment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);

    }

    @PostMapping("/{commentId}/replies")
    public Reply addReplyToComment(
        @PathVariable Long commentId,
        @RequestBody Reply reply
    ) {
        return commentService.addReplyToComment(commentId, reply);
    }

    @GetMapping("/{commentId}/replies")
    public List<Reply> getRepliesToComment(@PathVariable Long commentId) {
        // Call a service method to fetch the replies for the specified commentId
        return commentService.getRepliesToComment(commentId);
    }

}
