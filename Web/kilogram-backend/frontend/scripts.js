function togglePost(id) {
    const src = document.getElementById(id).src;
    if (src.endsWith("icons/like.svg")) {
        document.getElementById(id).src = "icons/liked.svg";
    } else {
        document.getElementById(id).src = "icons/like.svg";
    }
}

fetch('http://localhost:5000/posts')
    .then(res => res.json())
    .then(data => {
        data.forEach((post, idx) => {
            console.log(post);

            const postElement = document.createElement('div');
            postElement.className = 'post';
            postElement.innerHTML = `
                <img src="${post.imageurl}" alt="Post${idx + 1}" class="post-img">
                <img id="like${idx + 1}" src="icons/like.svg" alt="like" onclick="togglePost('like${post.id}')">
                <p>Description here</p>
                <hr>
            `;

            const main = document.getElementsByTagName('main')[0];
            main.appendChild(postElement);
        });
    });