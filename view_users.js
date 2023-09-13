// Sample user data (replace with your data)
const userData = [
    { 
        FullName: 'Tina Joy',
        Password: 'Password1',
        'Date of Joining': '2023-09-01',
        'Date of Birth': '1990-01-15',
        Mobile: '9877652209',
        Location: 'Mumbai',
        Email: 'tinajoy@gmail.com',
        Status: 'Active',
    },
    { 
        FullName: 'Joseph Samuel ',
        Password: 'Quezsxyz24',
        'Date of Joining': '2023-09-05',
        'Date of Birth': '1985-05-20',
        Mobile: '9876543210',
        Location: 'Kerala',
        Email: 'josephsamuel@gmail.com',
        Status: 'Inactive',
    },
    { 
        FullName: 'Alizah Khan ',
        Password: 'qwertyui67',
        'Date of Joining': '2022-02-09',
        'Date of Birth': '1989-09-27',
        Mobile: '9120956423',
        Location: 'Bangalore',
        Email: 'alizahkhan@gmail.com',
        Status: 'Inactive',
    },
    { 
        FullName: 'Diya S ',
        Password: 'Azsxedc09',
        'Date of Joining': '2021-08-04',
        'Date of Birth': '1988-09-23',
        Mobile: '7865435508',
        Location: 'Lucknow',
        Email: 'diyas12@gmail.com',
        Status: 'Inactive',
    },
    { 
        FullName: 'Akash Reddy ',
        Password: 'Thnmjuo237',
        'Date of Joining': '2020-01-02',
        'Date of Birth': '1981-01-26',
        Mobile: '8176543210',
        Location: 'Delhi',
        Email: 'areddy@gmail.com',
        Status: 'Inactive',
    },
    { 
        FullName: 'Stuti Bhansal ',
        Password: 'Water12t',
        'Date of Joining': '2019-03-04',
        'Date of Birth': '1983-04-28',
        Mobile: '8876543223',
        Location: 'Odhisha',
        Email: 'sbhansal@gmail.com',
        Status: 'Inactive',
    },
    { 
        FullName: 'Maithili Shetty ',
        Password: 'Wytzsxy54',
        'Date of Joining': '2022-05-05',
        'Date of Birth': '1987-09-21',
        Mobile: '7872543210',
        Location: 'Madurai',
        Email: 'maithshetty@gmail.com',
        Status: 'Inactive',
    }
    // Add more user data here
];

// Function to populate the user table
function populateUserTable() {
    const tableBody = document.getElementById('userTable');

    userData.forEach((user, index) => {
        const row = tableBody.insertRow();
        const cellFullName = row.insertCell(0);
        const cellPassword = row.insertCell(1);
        const cellDateOfJoining = row.insertCell(2);
        const cellDateOfBirth = row.insertCell(3);
        const cellMobile = row.insertCell(4);
        const cellLocation = row.insertCell(5);
        const cellEmail = row.insertCell(6);
        const cellStatus = row.insertCell(7);
        const cellAction = row.insertCell(8);

        cellFullName.textContent = user.FullName;
        cellPassword.textContent = user.Password;
        cellDateOfJoining.textContent = user['Date of Joining'];
        cellDateOfBirth.textContent = user['Date of Birth'];
        cellMobile.textContent = user.Mobile;
        cellLocation.textContent = user.Location;
        cellEmail.textContent = user.Email;

        // Create checkboxes for Activate and Deactivate
        const activateCheckbox = document.createElement('input');
        activateCheckbox.type = 'checkbox';
        activateCheckbox.checked = user.Status === 'Active';
        activateCheckbox.addEventListener('change', () => {
            if (activateCheckbox.checked) {
                alert(`${user.FullName} has been activated.`);
                user.Status = 'Active';

                // Ensure only one checkbox is checked
                deactivateCheckbox.checked = false;
            }
        });

        const deactivateCheckbox = document.createElement('input');
        deactivateCheckbox.type = 'checkbox';
        deactivateCheckbox.checked = user.Status === 'Inactive';
        deactivateCheckbox.addEventListener('change', () => {
            if (deactivateCheckbox.checked) {
                alert(`${user.FullName} has been deactivated.`);
                user.Status = 'Inactive';

                // Ensure only one checkbox is checked
                activateCheckbox.checked = false;
            }
        });

        cellStatus.appendChild(activateCheckbox);
        cellStatus.appendChild(document.createTextNode(' Activate '));
        cellStatus.appendChild(deactivateCheckbox);
        cellStatus.appendChild(document.createTextNode(' Deactivate '));

        
    });
}


window.addEventListener('load', populateUserTable);

