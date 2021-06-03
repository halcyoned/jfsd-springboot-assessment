const itemControl = new ItemController();

//When a user clicks on 'Save Item' button, call API to add items to the database
//Add an "onsubmit" eventListener for product form to add a product
newItemForm.addEventListener("submit", (event) => {

    //Prevent default action which is to submit the form using POST/GET method that is stated in the form tag
    event.preventDefault();

    //Select the inputs and store into constants
    const inputTitle = document.querySelector("#inputTitle");
    const inputDescription = document.querySelector("#inputDescription");
    const inputTargetDate = document.querySelector("#inputTargetDate");

    //Get the values of the inputs - variable names to be same as MySQL columns
    const title = inputTitle.value;
    const description = inputDescription.value;
    const date = inputTargetDate.value;

    //Clear the form
    inputTitle.value = "";
    inputDescription.value = "";
    inputTargetDate.value = "";

    //Add the task to the task manager
    itemControl.addItem(title, description, date);

})