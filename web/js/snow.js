function createSnowflake() {
    const snowflake = document.createElement('div');
    snowflake.classList.add('snowflake');
    snowflake.innerHTML = '🌸';
    snowflake.style.left = Math.random() * 100 + 'vw';
    snowflake.style.animationDuration = (Math.random() * 1.5 + 1) + 's';
    snowflake.style.opacity = Math.random();
    snowflake.style.fontSize = (Math.random() * 20 + 10) + 'px';
    document.body.appendChild(snowflake);

    setTimeout(() => {
        snowflake.remove();
    }, 3000);
}

function startSnowfall() {
    // Chỉ thêm CSS một lần
    if (!document.getElementById('snow-style')) {
        const style = document.createElement('style');
        style.id = 'snow-style';
        style.textContent = `
            .snowflake {
                position: fixed;
                top: -2em;
                color: #f9a8d4;
                pointer-events: none;
                user-select: none;
                animation-name: fall;
                animation-timing-function: linear;
                animation-iteration-count: 1;
                z-index: 9999;
            }

            @keyframes fall {
                to {
                    transform: translateY(100vh);
                }
            }
        `;
        document.head.appendChild(style);
    }

    setInterval(createSnowflake, 150);
}

window.addEventListener('load', startSnowfall);
