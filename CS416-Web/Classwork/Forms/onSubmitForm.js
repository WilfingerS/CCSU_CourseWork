function submitForm(event){
    event.preventDefault();//prevent from submitting usual way
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const car = document.getElementById("cars").value
    const dob = document.getElementById("DOB").value
    //alert('Name:' + name + '\nEmail:' + email); // String concatenation
    alert(`Name: ${name}\nEmail: ${email}\nSelectedCar: ${car}\nD.O.B: ${dob}`); //String Interpolation
}