/*
<div class="search-container1-2">
    <div class="row">
        <form method="post" name="keywords-serch" id="searchForm">
            <table class="pull-right">
                <tr>
                    <td>
                        <select class="form-control" name="searchField">
                            <option value="0">Select</option>
                            <option value="op-Shelter">ShelterName</option>
                            <option value="op-addr">Address</option>
                        </select>
                    </td>
                    <td>
                        <input type="text" class="form-control" placeholder="Put Keywords" name="searchText" maxlength="100">
                    </td>
                    <td>
                        <button type="button" class="btn btn-success" id="searchButton">Search</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
*/

$(document).ready(function(){
	console.log(11);
	//검색버튼 클릭이벤트처리!
	$("#searchButton").on("click", function(){
		
		var searchField = $("select[name='serchField']").val();
		var searchText = $("input[name='serchText']").val();
		
		console.log(searchField);
		console.log(searchText);
	
	//Ajax 요청!
	$.ajax({
		type: "POST",
		url : "SearchC",
		data : {searchField : searchField, searchText: searchText},
		success : function(data){
			$("#searchResults").html(data);
		},
		error: function(){
			console.log("검색에 실패했습니다.");
		}
		
	
	})
		
	});
		
})