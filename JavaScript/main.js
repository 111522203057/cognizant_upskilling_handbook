// 1. Setup and basic console/alert
console.log("Welcome to the Community Portal");
window.onload = () => alert("Page fully loaded!");

// 2. Event constructor & prototype
function Event(name, date, seats, category, location) {
  this.name = name;
  this.date = new Date(date);
  this.seats = seats;
  this.category = category;
  this.location = location;
}

Event.prototype.checkAvailability = function() {
  return this.seats > 0 && this.date > new Date();
};

// 3. Sample event list (would come from API in real app)
let events = [
  new Event("Music Concert", "2025-09-15", 20, "Music", "Community Hall"),
  new Event("Baking Workshop", "2025-05-01", 0, "Workshop", "Kitchen Studio"),
  new Event("Football Match", "2025-08-10", 15, "Sports", "Local Stadium"),
];

// 4. Track total registrations per category using closure
function createRegistrationTracker() {
  const registrations = {};
  return {
    add: category => registrations[category] = (registrations[category] || 0) + 1,
    get: category => registrations[category] || 0
  };
}
const registrationTracker = createRegistrationTracker();

// 5. Display events dynamically
const eventsContainer = document.querySelector("#eventsContainer");
const registrationForm = document.querySelector("#registrationForm");
const eventSelect = registrationForm.elements["event"];
const categoryFilter = document.querySelector("#categoryFilter");
const searchInput = document.querySelector("#searchInput");
const messageDiv = document.querySelector("#message");
const loadingSpinner = document.querySelector("#loadingSpinner");

// Function to render event cards
function renderEvents(eventList) {
  eventsContainer.innerHTML = "";
  eventSelect.innerHTML = "<option value='' disabled selected>Select Event</option>";

  eventList.forEach(event => {
    if (!event.checkAvailability()) return;

    // Create card
    const card = document.createElement("div");
    card.className = "event-card";

    // Using template literals for content
    card.innerHTML = `
      <h3>${event.name}</h3>
      <p>Date: ${event.date.toDateString()}</p>
      <p>Seats Available: ${event.seats}</p>
      <p>Category: ${event.category}</p>
      <p>Location: ${event.location}</p>
      <button onclick="registerUser('${event.name}')">Register</button>
    `;

    eventsContainer.appendChild(card);

    // Add to form select
    const option = document.createElement("option");
    option.value = event.name;
    option.textContent = event.name;
    eventSelect.appendChild(option);
  });
}

// 6. Registration logic wrapped in try-catch
function registerUser(eventName) {
  try {
    const event = events.find(e => e.name === eventName);
    if (!event) throw new Error("Event not found");
    if (event.seats <= 0) throw new Error("No seats available");

    event.seats--;
    registrationTracker.add(event.category);

    renderEvents(filterEventsByCategory(categoryFilter.value));
    messageDiv.textContent = `Registered successfully for ${eventName}! Total registrations in ${event.category}: ${registrationTracker.get(event.category)}`;
  } catch (err) {
    messageDiv.textContent = `Error: ${err.message}`;
  }
}

// 7. Filter events by category with callback
function filterEventsByCategory(category = "") {
  if (!category) return events;
  return events.filter(event => event.category === category);
}

// 8. Handle category filter change and search input
categoryFilter.onchange = () => {
  let filtered = filterEventsByCategory(categoryFilter.value);

  // Also apply search filter (case-insensitive)
  const searchText = searchInput.value.toLowerCase();
  if (searchText) {
    filtered = filtered.filter(event =>
      event.name.toLowerCase().includes(searchText)
    );
  }
  renderEvents(filtered);
};

searchInput.onkeydown = () => {
  // Trigger same filtering as category change for simplicity
  categoryFilter.onchange();
};

// 9. Handle form submission with validation and fetch simulation
registrationForm.onsubmit = event => {
  event.preventDefault();

  const formData = new FormData(registrationForm);
  const name = formData.get("name").trim();
  const email = formData.get("email").trim();
  const eventName = formData.get("event");

  if (!name || !email || !eventName) {
    messageDiv.textContent = "Please fill in all fields.";
    return;
  }

  // Simulate sending data to server (POST)
  messageDiv.textContent = "Registering...";
  setTimeout(() => {
    registerUser(eventName);
    registrationForm.reset();
  }, 1000);
};

// 10. Fetch mock events from "API" using async/await and show spinner
async function fetchEvents() {
  loadingSpinner.style.display = "block";
  try {
    // Simulating fetch with timeout
    await new Promise(resolve => setTimeout(resolve, 1000));

    // In real scenario: const response = await fetch('https://api.example.com/events');
    // const data = await response.json();

    // For demo, we reuse existing 'events' array
    renderEvents(events);
  } catch (err) {
    messageDiv.textContent = "Failed to load events.";
  } finally {
    loadingSpinner.style.display = "none";
  }
}

// Initialize app by fetching events
fetchEvents();

// 11. Bonus: Using spread operator and destructuring in filtering
function cloneAndFilter(category) {
  const clonedEvents = [...events];
  return clonedEvents.filter(({ category: cat }) => !category || cat === category);
}
