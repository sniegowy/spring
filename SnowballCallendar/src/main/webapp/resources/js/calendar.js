$(function() {
	for (i = startHour; i <= endHour; i++) {
		insertRow(i);
	}

	var array = selectedCells.split(";"), i;
	for (i = 0; i < array.length; i++) {
		if (document.getElementById("cell_" + array[i]) != null) {
			document.getElementById("cell_" + array[i]).className = "highlighted";
		}
	}
	
	var array = eventCells.split(";"), i;
	for (i = 0; i < array.length; i++) {
		if (document.getElementById("cell_" + array[i]) != null) {
			document.getElementById("cell_" + array[i]).className = "event";
		}
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
		if (document.getElementById(e.target.id).className == "highlighted") {
			if (document.getElementById(e.target.id).className != "event") {
				isMouseDown = true;
				document.getElementById(e.target.id).className = "event";
				startCellId = e.target.id;
				return false;
			}
		} 
	}).mouseover(function(e) {
		if (isMouseDown) {
			document.getElementById(e.target.id).className = "event";
		}
	}).bind("selectstart", function() {
		return false;
	});
	
	$("#scheduleTable td").mouseup(function(e) {
		if (isMouseDown) {
			isMouseDown = false;
			stopCellId = e.target.id;
			window.location.href = userId + '-' + startCellId + '-' + stopCellId + "-addCalendarTile.html";
		}
	});
});
