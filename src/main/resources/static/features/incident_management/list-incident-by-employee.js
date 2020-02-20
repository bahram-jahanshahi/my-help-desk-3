$("#list-incident-by-employee").ready(function () {
    listIncidentByEmployee();
});

function listIncidentByEmployee() {
    const listIncidentByEmployeeCommand = {"searchTitle": '', "userId": 1};
    jQuery.ajax({
        url: "http://localhost:9001/incident/list-incident-by-employee",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(listIncidentByEmployeeCommand),
        success: function(data, textStatus, jQxhr) {
            console.table(data.incidentsOfEmployee);
            prepareTable(data.incidentsOfEmployee);
        },
        failure: function (errorMessage) {
            alert(errorMessage)
        }
    });
}

function prepareTable(data) {
    let content = '';
    for (let i = 0; i < data.length; i++) {
        content +=  "<tr>";
        content +=  "<th scope='row'>" + data[i].incidentId + "</th>";
        content +=  "<td >" + data[i].incidentIssue + "</td>";
        content +=  "<td >" + data[i].incidentDescription + "</td>";
        content +=  "<td >" +
            "<button type='button' class='btn btn-outline-primary btn-sm' onclick='showEdit("+ data[i].id +")'>edit</button>" +
            "</td>";
        content +=  "</tr>";
    }
    $('#table-body').html(content);
}
