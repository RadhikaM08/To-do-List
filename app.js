function addTask() {
    var newTaskInput = document.getElementById("newTaskInput");
    var taskList = document.getElementById("taskList");

    if (newTaskInput.value !== "") {
        var newTask = document.createElement("li");
        newTask.textContent = newTaskInput.value;
        newTask.classList.add("task-item");

        var checkboxContainer = document.createElement("div");
        checkboxContainer.classList.add("checkbox-container");

        var checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        checkbox.classList.add("checkbox");

        checkboxContainer.appendChild(checkbox);
        newTask.appendChild(checkboxContainer);

        checkbox.addEventListener("change", function() {
            newTask.classList.toggle("completed", checkbox.checked);
        });

        taskList.appendChild(newTask);
        newTaskInput.value = "";
    }
}
