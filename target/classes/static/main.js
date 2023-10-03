// Sample data for comments (replace with actual data from your API)
const commentsData = [
    {
        id: 1,
        text: "This is the first comment",
        user: { userName: "User1" },
        replies: [
            { id: 11, text: "Reply to the first comment", user: { userName: "User2" } },
        ],
    },
    {
        id: 2,
        text: "This is the second comment",
        user: { userName: "User3" },
        replies: [],
    },
];

// Function to create a comment element
function createCommentElement(comment) {
    const commentElement = document.createElement("div");
    commentElement.className = "comment";
    commentElement.innerHTML = `
        <strong>${comment.user.userName}:</strong> ${comment.text}
        <div class="replies">
            <!-- Replies will be displayed here -->
        </div>
        <textarea class="replyText" placeholder="Reply to this comment"></textarea>
        <button class="postReplyButton">Post Reply</button>
    `;

    const repliesContainer = commentElement.querySelector(".replies");
    const replyText = commentElement.querySelector(".replyText");
    const postReplyButton = commentElement.querySelector(".postReplyButton");

    // Function to create a reply element
    function createReplyElement(reply) {
        const replyElement = document.createElement("div");
        replyElement.className = "reply";
        replyElement.innerHTML = `<em>${reply.user.userName}:</em> ${reply.text}`;
        repliesContainer.appendChild(replyElement);
    }

    // Event listener for posting a reply
    postReplyButton.addEventListener("click", () => {
        const reply = replyText.value;
        if (reply) {
            // Simulate posting a reply to the server (replace with actual API call)
            const newReply = { text: reply, user: { userName: "Current User" } };
            createReplyElement(newReply);
            replyText.value = "";
        }
    });

    // Create reply elements for existing replies
    comment.replies.forEach(createReplyElement);

    return commentElement;
}

// Function to display comments
function displayComments() {
    const commentsContainer = document.getElementById("comments");
    commentsContainer.innerHTML = "";

    commentsData.forEach(comment => {
        const commentElement = createCommentElement(comment);
        commentsContainer.appendChild(commentElement);
    });
}

// Event listener for posting a comment
const postCommentButton = document.getElementById("postCommentButton");
postCommentButton.addEventListener("click", () => {
    const commentText = document.getElementById("commentText").value;
    if (commentText) {
        // Simulate posting a comment to the server (replace with actual API call)
        const newComment = { text: commentText, user: { userName: "Current User" }, replies: [] };
        commentsData.push(newComment);
        displayComments();
        document.getElementById("commentText").value = "";
    }
});

// Display comments on page load
displayComments();
