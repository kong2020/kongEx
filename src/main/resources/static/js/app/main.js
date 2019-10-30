/**
 * 
 */
var main = {
	
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
        	var ret_val = _this.check();
        	console.log("ret_val=", ret_val);
            if(ret_val == true) _this.save();
        });
    },
    
    check : function() {
    	var xxx = $('#contents').val();
    	var yyy = $('#done').val();
    	
    	if(xxx = null || xxx == undefined || xxx == ""){
    		alert("할 일을 입력하세요");
    		return false;
    	}
    	return true;
    },
    
    save : function () {
        var data = {
            contents: $('#contents').val(),
            done: 'n'
        };
        
        $.ajax({
            type: 'POST',
            url: '/todo',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(result) {
            console.log(result);
            //$(location).attr("href", "http://localhost:8099/todoList");
            
            console.log("result.length=", result.length);
        	var id = result.id;
        	var contents = result.contents;
        	var done = result.done;
        	var modifiedDate = result.modifiedDate;
        	
        	console.log("확인:", "id=", id, "contents=", contents, "done=", done, "modifiedDate=", modifiedDate);
        	var text = "";
        	text += "<tr><td><input type='checkbox' name='chkbox'></td>";
        	text += "<td>" + id + "</td>";
        	text += "<td>" + contents + "</td>";
        	text += "<td>" + (done ? "완료" : "미완료") + "</td>";
        	text += "<td>" + modifiedDate + "</td>";
        	text += "<td class='del'><a href='#'>삭제</a></td>";
        	text += "</tr>";
            	
            $("#tbody").append(text);
            
        }).fail(function (error) {
            alert(error);
        });
    }

};

main.init();
