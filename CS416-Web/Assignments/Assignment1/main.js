const logos = document.getElementsByClassName("logo");
const logoCount = logos.length;
const xyArr = new Array(logoCount); // This will hold the x/y velocities

function getrandPos(i) {
    const maxWidth = window.innerWidth - logos[i].offsetWidth;
    const maxHeight = window.innerHeight - logos[i].offsetHeight;
    const randomX = Math.floor(Math.random() * maxWidth);
    const randomY = Math.floor(Math.random() * maxHeight);
    logos[i].style.left = `${randomX}px`;
    logos[i].style.top = `${randomY}px`;
}

function collision(i) {
    const rect = logos[i].getBoundingClientRect();
    const win_w = window.innerWidth;
    const win_h = window.innerHeight;

    // Check collision with the right edge
    if (rect.right >= win_w) {
        xyArr[i][0] = -Math.abs(xyArr[i][0]); // Move left
    }
    // Check collision with the left edge
    if (rect.left <= 0) {
        xyArr[i][0] = Math.abs(xyArr[i][0]); // Move right
    }
    // Check collision with the bottom edge
    if (rect.bottom >= win_h) {
        xyArr[i][1] = -Math.abs(xyArr[i][1]); // Move up
    }
    // Check collision with the top edge
    if (rect.top <= 0) {
        xyArr[i][1] = Math.abs(xyArr[i][1]); // Move down
    }
}

function frame(i) {
    collision(i);
    const logo = logos[i];
    let y = parseInt(logo.style.top, 10) + xyArr[i][1];
    let x = parseInt(logo.style.left, 10) + xyArr[i][0];
    // Ensure the new position is within the window
    y = Math.max(0, Math.min(y, window.innerHeight - logo.offsetHeight));
    x = Math.max(0, Math.min(x, window.innerWidth - logo.offsetWidth));
    logo.style.top = `${y}px`;
    logo.style.left = `${x}px`;
}

function init() {
    document.body.style.background = "#000000";
    for (let i = 0; i < logoCount; i++) {
        let curLogo = logos[i];
        xyArr[i] = [2, 2]; // sets starting x and y velocity
        curLogo.style.position = 'absolute';
        getrandPos(i); // Get Random Starting Position
        setInterval(() => frame(i), 10); // Use arrow function to pass i correctly
    }
}

init();
