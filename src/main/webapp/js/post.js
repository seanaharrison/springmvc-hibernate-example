$(document).ready(
		function() {

			$("#userid").val(1);
			$("#username").val("fred");

			// User List
			$("#list-click").click(function() {
				$.getJSON(window.location + "users", function(data) {
					var str = JSON.stringify(data, undefined, 2);
					$("#list-click-div").append(str);
				});
			});
			$("#list-url").click(function() {
				window.open(window.location + "users", '_blank');
			});

			// User ID
			$("#id-click").click(function() {
				var id = $('#userid').val();
				$.getJSON(window.location + "userid/" + id, function(data) {
					var str = JSON.stringify(data, undefined, 2);
					$("#id-click-div").append(str);
				});
			});
			$("#id-url").click(function() {
				var id = $('#userid').val();
				window.open(window.location + 'userid/' + id, '_blank');
			});

			// Username
			$("#name-click").click(function() {
				var name = $('#username').val();
				$.getJSON(window.location + "username/" + name, function(data) {
					var str = JSON.stringify(data, undefined, 2);
					$("#name-click-div").append(str);
				});
			});
			$("#name-url").click(function() {
				var name = $('#username').val();
				window.open(window.location + 'username/' + name, '_blank');
			});

			// Add User
			$("#add-user-click").click(
					function() {
						var username = $('#addusername').val();
						var password = $('#addpassword').val();

						if (username == "" || password == "") {
							$("#addusername").css("background", "red");
							$("#addpassword").css("background", "red");
						} else {
							$.ajax({
								type : 'POST',
								url : window.location + 'adduser/',
								data : '{"username":"' + username
										+ '","password":"' + password + '"}',
								complete : function(data) {
									var jsondata = '{"username":"' + username
											+ '","password":"' + password
											+ '"}';
									var json = $.parseJSON(jsondata);
									var str = JSON
											.stringify(json, undefined, 2);
									$("#add-user-click-div").append(str);
								},
								contentType : "application/json",
								dataType : 'json'
							});
							$('#addusername').css('background', 'transparent');
							$('#addpassword').css('background', 'transparent');
						}
					});

		});