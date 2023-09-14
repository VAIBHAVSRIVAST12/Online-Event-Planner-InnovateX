document.addEventListener("DOMContentLoaded", function() {

      document.getElementById('registrationForm').addEventListener('submit', function(event) {

        event.preventDefault();

        // Validation
        var userfullname = document.getElementById("userfullname").value;
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        const dob = document.getElementById("dob").value;
        const mobile = document.getElementById("mobile").value;
        const location = document.getElementById("location").value;
        const email = document.getElementById("email").value;

        // Sample validation (customize as needed)
        if (username.length < 6) {
            showError("Username must be at least 6 characters.");
        } else if (password.length < 8) {
            showError("Password must be at least 8 characters.");
        } else if (!isValidDate(dob)) {
            showError("Invalid Date of Birth.");
        } else if (!isValidMobile(mobile)) {
            showError("Invalid Mobile Number.");
        } else if (location.trim() === "") {
            showError("Location cannot be empty.");
        } else if (!isValidEmail(email)) {
            showError("Invalid Email Address.");
        } else {

          localStorage.setItem('username', regUsername);
          localStorage.setItem('password', regPassword);

          registrationForm.reset();
          window.location.href = 'login_form.html';
      }
    });
    function isValidDate(dateString) {
        const dateRegex = /^\d{4}-\d{2}-\d{2}$/;
        return dateRegex.test(dateString);
    }

    function isValidMobile(mobileNumber) {
        const mobileRegex = /^\d{10}$/;
        return mobileRegex.test(mobileNumber);
    }

    function isValidEmail(email) {
        const emailRegex = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i;
        return emailRegex.test(email);
    }

});
