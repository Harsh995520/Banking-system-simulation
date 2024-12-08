function validateRegisterForm() {
    let username = document.getElementById("username").value.trim();
    let email = document.getElementById("email").value.trim();
    let password = document.getElementById("regPassword").value;
    let confirmPassword = document.getElementById("confirmPassword").value;
    let valid = true;

    if (username === "") {
        document.getElementById("regUsernameError").textContent = "Username is required!";
        valid = false;
    } else {
        document.getElementById("regUsernameError").textContent = "";
    }

    if (!/^\S+@\S+\.\S+$/.test(email)) {
        document.getElementById("emailError").textContent = "Please enter a valid email address!";
        valid = false;
    } else {
        document.getElementById("emailError").textContent = "";
    }

    if (password.length < 6) {
        document.getElementById("regPasswordError").textContent = "Password must be at least 6 characters!";
        valid = false;
    } else {
        document.getElementById("regPasswordError").textContent = "";
    }

    if (password !== confirmPassword) {
        document.getElementById("confirmPasswordError").textContent = "Passwords do not match!";
        valid = false;
    } else {
        document.getElementById("confirmPasswordError").textContent = "";
    }

    return valid;
}
