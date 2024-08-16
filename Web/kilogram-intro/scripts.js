function togglePost(id) {
    const src = document.getElementById(id).src;
    if (src.endsWith("icons/like.svg")) {
        document.getElementById(id).src = "icons/liked.svg";
    } else {
        document.getElementById(id).src = "icons/like.svg";
    }
}