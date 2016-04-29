var startCellId, stopCellId;

$(function() {	
	for (i=startHour; i<=endHour; i++) {
		insertRow(i);
	}
});

function insertRow(i) {
	var table = document.getElementById('scheduleTable');
	var row = table.insertRow(table.rows.length);
	var cell0 = row.insertCell(0);
	var text = document.createTextNode(i);
	cell0.appendChild(text);
	cell0.id = "cell_" + i + "_0";
	for (j=1; j<=5; j++) {
		var cell = row.insertCell(j);
		cell.id = "cell_" + i + "_" + j;
	}
}

$(function() {
	var isMouseDown = false;
	$("#scheduleTable td").not(":first-child").mousedown(function(e) {
		isMouseDown = true;
		$(this).toggleClass("highlighted");
		startCellId = e.target.id;
		return false;
	}).mouseover(function(e) {
		if (isMouseDown) {
			$(this).toggleClass("highlighted");
		}
	}).bind("selectstart", function() {
		return false;
	});

	$(document).mouseup(function(e) {
		isMouseDown = false;
		stopCellId = e.target.id;
		sendResult();
		window.location.href = userId + "-scheduleAddTime.html";
	});
});

function sendResult() {
	var scheduleCell = {startCell: startCellId, stopCell: stopCellId};
	
	$(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader("X-CSRF-TOKEN", csrfToken);
    });
	
	$.ajax({
		type: "POST",
		headers: { 
	        'Accept': 'application/json',
	        'Content-Type': 'application/json' 
	    },
	    dataType: 'json',
	    url: "scheduleResult",
	    data: JSON.stringify(scheduleCell),
	    success: function(result) {
	    },
	    async: false
	});
}