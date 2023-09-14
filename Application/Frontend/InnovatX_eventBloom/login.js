document.addEventListener("DOMContentLoaded", function() {
  const loginForm = document.getElementById("login-form");
  // const welcomeMessage = document.getElementById("welcome-message");

  loginForm.addEventListener("submit", function(e) {
    e.preventDefault();
    const username = document.getElementById("username").value;

    if (username) {
      // Redirect to the welcome page with the username as a query parameter
      window.location.href = `loginhome.html?username=${encodeURIComponent(username)}`;

    }
  });

  // Check if the welcome page has a query parameter for the username
  // const params = new URLSearchParams(window.location.search);
  // const usernameParam = params.get("username");
  //
  // if (usernameParam) {
  //     welcomeMessage.textContent = `Welcome, ${decodeURIComponent(usernameParam)}!`;
  //
  // }


});


function sendRequests() {
  console.log("Button clicked");
  // Set the URL of the destination page
  var destinationURL = "plan-request.html";

  // Redirect to the destination page
  window.location.href = destinationURL;
}
var eventType = document.getElementById("eventType");
var selectedEventType = document.getElementById("selectedEventType");

eventType.addEventListener("change", function() {
  selectedEventType.textContent = eventType.value;
});


var serviceCheckboxes = document.querySelectorAll('input[type="checkbox"]');
       var selectedServices = document.getElementById("selectedServices");

       serviceCheckboxes.forEach(function(checkbox) {
           checkbox.addEventListener("change", function() {
               var selected = Array.from(serviceCheckboxes)
                   .filter(checkbox => checkbox.checked)
                   .map(checkbox => checkbox.value);

               selectedServices.textContent = selected.join(", ");
           });
       });


// Number of person to be >30
           document.getElementById("plan-form").addEventListener("submit", function(event) {
             const inputValue = parseInt(document.getElementById("numberInput").value);
             const validationMessage = document.getElementById("validationMessage");
             const successMessage = document.getElementById("successMessage");


             if (inputValue < 30) {
               validationMessage.textContent = "Value must be at least 30.";
               validationMessage.style.color = "red";
               event.preventDefault(); // Prevent form submission
             } else {
               validationMessage.textContent = ""; // Clear the validation message
             }

             successMessage.textContent = "Form submitted successfully!";
             successMessage.style.color = "green";
             event.preventDefault();
           });
