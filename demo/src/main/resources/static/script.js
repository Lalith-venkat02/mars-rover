const gridSize = 10;

async function getStatus() {

    const response = await fetch('/api/status');
    const data = await response.json();

    updateUI(data);
}

async function moveRover() {

    const commands = document.getElementById('commands').value;

    const response = await fetch(`/api/move?commands=${commands}`, {
        method: 'POST'
    });

    const data = await response.json();

    updateUI(data);
}

async function resetRover() {

    const response = await fetch('/api/reset', {
        method: 'POST'
    });

    const data = await response.json();

    updateUI(data);
}

function updateUI(data) {

    document.getElementById('roverData').innerText =
        `X: ${data.x}, Y: ${data.y}, Direction: ${data.direction}`;

    drawGrid(data);
}

function drawGrid(rover) {

    const grid = document.getElementById('grid');

    grid.innerHTML = "";

    for (let y = gridSize - 1; y >= 0; y--) {

        for (let x = 0; x < gridSize; x++) {

            const cell = document.createElement('div');

            cell.classList.add('cell');

            if (x === rover.x && y === rover.y) {

                cell.classList.add('rover');

                if (rover.direction === "N") {
                    cell.innerHTML = "⬆";
                }
                else if (rover.direction === "S") {
                    cell.innerHTML = "⬇";
                }
                else if (rover.direction === "E") {
                    cell.innerHTML = "➡";
                }
                else if (rover.direction === "W") {
                    cell.innerHTML = "⬅";
                }
            }

            grid.appendChild(cell);
        }
    }
}

getStatus();