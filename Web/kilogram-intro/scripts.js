function togglePost(id) {
    const src = document.getElementById(id).src;
    if (src === "file:///Users/mj/kilogram/icons/like.svg") {
        document.getElementById(id).src = "icons/liked.svg";
    } else {
        document.getElementById(id).src = "icons/like.svg";
    }
}