console.log("Welcome to the Community Portal");

window.onload = () => {
  alert("Page fully loaded!");
  const preferred = localStorage.getItem("preferredEvent");
  if (preferred) {
    document.getElementById("eventType").value = preferred;
    showEventFee();
  }
};

// Task 2: Data Types
const mainEvent = "Summer Festival";
const eventDate = "2025-07-15";
let availableSeats = 100;
console.log(`Upcoming: ${mainEvent} on ${eventDate}. Seats left: ${availableSeats}`);

// Task 3: Conditionals & Loops
const events = [
  { name: "Music Night", date: "2025-07-10", seats: 10, category: "Music" },
  { name: "Food Fair", date: "2025-07-05", seats: 0, category: "Food" },
  { name: "Art Workshop", date: "2025-06-10", seats: 5, category: "Art" },
  { name: "Charity Run", date: "2025-08-01", seats: 30, category: "Charity" }
];

function displayAvailableEvents() {
  const container = document.createElement("div");
  container.id = "eventList";
  events.forEach(ev => {
    const today = new Date();
    const eventDate = new Date(ev.date);
    if (ev.seats > 0 && eventDate > today) {
      const card = document.createElement("div");
      card.className = "highlight";
      card.style.margin = "1em";
      card.innerHTML = `<strong>${ev.name}</strong> (${ev.category}) - ${ev.date} - Seats: ${ev.seats}`;
      container.appendChild(card);
    }
  });
  document.body.appendChild(container);
}
displayAvailableEvents();

// Task 4: Functions & Closures
function addEvent(name, date, seats, category) {
  events.push({ name, date, seats, category });
}

function registerUser(eventName) {
  try {
    const event = events.find(e => e.name === eventName);
    if (!event || event.seats <= 0) throw "Event is full or not found.";
    event.seats--;
    alert(`Registered for ${eventName}. Seats left: ${event.seats}`);
  } catch (err) {
    alert("Error: " + err);
  }
}

function filterEventsByCategory(category) {
  return events.filter(e => e.category.toLowerCase() === category.toLowerCase());
}

// Closure to track registration count
function createCounter() {
  let count = 0;
  return () => ++count;
}
const musicCounter = createCounter();

// Task 5: Objects & Prototypes
function Event(name, date, seats, category) {
  this.name = name;
  this.date = date;
  this.seats = seats;
  this.category = category;
}
Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};

const e1 = new Event("Dance Night", "2025-09-01", 20, "Dance");
console.log(Object.entries(e1));

// Task 6: Arrays & Methods
const musicEvents = events.filter(e => e.category === "Music");
const eventTitles = events.map(e => `Workshop on ${e.name}`);
console.log(eventTitles);

// Task 7: DOM Manipulation
document.querySelectorAll(".event-img").forEach(img => {
  img.addEventListener("dblclick", () => img.classList.toggle("enlarged"));
});

// Task 8: Event Handling
document.getElementById("eventType").addEventListener("change", showEventFee);

// Task 9: Async JS
async function fetchEvents() {
  const spinner = document.createElement("p");
  spinner.textContent = "Loading events...";
  document.body.appendChild(spinner);
  try {
    const res = await fetch("https://jsonplaceholder.typicode.com/posts?_limit=3");
    const data = await res.json();
    console.log("Fetched Events:", data);
  } catch (err) {
    console.error("Failed to fetch events", err);
  } finally {
    spinner.remove();
  }
}
// fetchEvents(); // Uncomment to test with mock API

// Task 10: Modern JS
const showInfo = (name = "Guest", type = "General") => {
  console.log(`Hello ${name}, interested in ${type} event.`);
};
const [firstEvent, ...rest] = events;

// Task 11: Forms
document.getElementById("regForm").addEventListener("submit", function (event) {
  event.preventDefault();
  const form = event.target.elements;
  const name = form["name"].value.trim();
  const email = form["email"].value.trim();
  const phone = form["phone"].value.trim();
  const type = form["eventType"].value;
  if (!name || !email || !phone || !type) {
    alert("All fields are required.");
    return;
  }
  document.getElementById("confirmation").textContent =
    `Thanks, ${name}, for registering for ${type}!`;
  availableSeats--;
});

// Task 12: AJAX & Fetch
async function submitRegistration(data) {
  try {
    const res = await fetch("https://jsonplaceholder.typicode.com/posts", {
      method: "POST",
      body: JSON.stringify(data),
      headers: { "Content-Type": "application/json" }
    });
    const result = await res.json();
    console.log("Submitted:", result);
    alert("Registration sent successfully!");
  } catch (err) {
    alert("Failed to submit registration.");
  }
}