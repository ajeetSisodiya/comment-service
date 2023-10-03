package com.example.dto;

import java.util.List;

public class CommentWithRepliesDTO {
    private CommentDTO comment;
    private List<ReplyDTO> replies;

    public CommentWithRepliesDTO() {
    }

    public CommentWithRepliesDTO(CommentDTO comment, List<ReplyDTO> replies) {
        this.comment = comment;
        this.replies = replies;
    }

    // Getter and Setter methods

    public CommentDTO getComment() {
        return comment;
    }

    public void setComment(CommentDTO comment) {
        this.comment = comment;
    }

    public List<ReplyDTO> getReplies() {
        return replies;
    }

    public void setReplies(List<ReplyDTO> replies) {
        this.replies = replies;
    }
}