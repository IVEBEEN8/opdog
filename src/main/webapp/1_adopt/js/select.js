$(document).ready(function () {
  $('input[type=radio][name="sido"]').on("change", function () {
    /*
			response = 시/군/구 배열
			.orgCd = 도시 코드
			.orgdownNm = 도시 이름
		 */

    var selectedValue = $(this).val();
    $("#sidoSelect").val(selectedValue);
    if (selectedValue != "") {
      $.ajax({
        url: "SelectConditionC",
        type: "GET",
        data: { value: selectedValue },
        success: function (response) {
          $("label").remove("#sigungulabel");
          $("label").remove("#centerlabel");
          $("option").remove("#sigunop");
          $("option").remove("#centerop");
          if (selectedValue == 5690000) {
            $("#sigungudiv").append(
              '<label id="sigungulabel"><input type="radio" value="' +
                selectedValue +
                "!" +
                selectedValue +
                '" name="sigungu" id="sigungurd">세종특별자치시</label>'
            );
            $("#sigunSelect").append(
              '<option value="' +
                selectedValue +
                "!" +
                selectedValue +
                '" id="sigunop">세종특별자치시</option>'
            );
          } else {
            for (var i = 0; i < response.length; i++) {
              $("#sigungudiv").append(
                '<label id="sigungulabel"><input type="radio" value="' +
                  selectedValue +
                  "!" +
                  response[i].orgCd +
                  '" name="sigungu" id="sigungurd">' +
                  response[i].orgdownNm +
                  "</label>"
              );
              $("#sigunSelect").append(
                '<option value="' +
                  selectedValue +
                  "!" +
                  response[i].orgCd +
                  '" id="sigunop">' +
                  response[i].orgdownNm +
                  "</option>"
              );
            }
          }
        },
        error: function (error) {
          console.log("Ajax 요청 에러:", error);
        },
      });
    } else {
      $("label").remove("#sigungulabel");
      $("label").remove("#centerlabel");
      $("option").remove("#sigunop");
      $("option").remove("#centerop");
    }
  });

  $(document).on("change", 'input[type=radio][name="sigungu"]', function () {
    /*
			response = 보호소 배열
			...RegNo = 보호소 코드
			...Nm = 보호소 이름
		 */
    var selectedValue = $(this).val();
    $("#sigunSelect").val(selectedValue);
    if (selectedValue != "") {
      $.ajax({
        url: "SelectConditionC",
        type: "POST",
        data: { value: selectedValue },
        success: function (response) {
          $("label").remove("#centerlabel");
          $("option").remove("#centerop");
          for (var i = 0; i < response.length; i++) {
            $("#centerdiv").append(
              '<label id="centerlabel"><input type="radio" value="' +
                response[i].careRegNo +
                '" name="center" id="centerrd">' +
                response[i].careNm +
                "</label>"
            );
            $("#centerSelect").append(
              '<option value="' +
                response[i].careRegNo +
                '" id="centerop">' +
                response[i].careNm +
                "</option>"
            );
          }
        },
        error: function (error) {
          console.log("Ajax 요청 에러:", error);
        },
      });
    } else {
      $("label").remove("#centerlabel");
      $("option").remove("#centerop");
    }
  });
  $(document).on("change", 'input[type=radio][name="center"]', function () {
    var selectedValue = $(this).val();
    $("#centerSelect").val(selectedValue);
  });

  $("#sidoSelect").on("change", function () {
    /*
			response = 시/군/구 배열
			.orgCd = 도시 코드
			.orgdownNm = 도시 이름
			
		 */
    var selectedValue = $(this).val();
    $('input[type=radio][name="sido"][value="' + selectedValue + '"]').prop(
      "checked",
      true
    );

    if (selectedValue != "") {
      $.ajax({
        url: "SelectConditionC",
        type: "GET",
        data: { value: selectedValue },
        success: function (response) {
          console.log(response);
          $("label").remove("#sigungulabel");
          $("label").remove("#centerlabel");
          $("option").remove("#sigunop");
          $("option").remove("#centerop");
          if (selectedValue == 5690000) {
            $("#sigungudiv").append(
              '<label id="sigungulabel"><input type="radio" value="' +
                selectedValue +
                "!" +
                selectedValue +
                '" name="sigungu" id="sigungurd">세종특별자치시</label>'
            );
            $("#sigunSelect").append(
              '<option value="' +
                selectedValue +
                "!" +
                selectedValue +
                '" id="sigunop">세종특별자치시</option>'
            );
          } else {
            for (var i = 0; i < response.length; i++) {
              $("#sigungudiv").append(
                '<label id="sigungulabel"><input type="radio" value="' +
                  selectedValue +
                  "!" +
                  response[i].orgCd +
                  '" name="sigungu" id="sigungurd">' +
                  response[i].orgdownNm +
                  "</label>"
              );
              $("#sigunSelect").append(
                '<option value="' +
                  selectedValue +
                  "!" +
                  response[i].orgCd +
                  '" id="sigunop">' +
                  response[i].orgdownNm +
                  "</option>"
              );
            }
          }
        },
        error: function (error) {
          console.log("Ajax 요청 에러:", error);
        },
      });
    } else {
      $("label").remove("#sigungulabel");
      $("label").remove("#centerlabel");
      $("option").remove("#sigunop");
      $("option").remove("#centerop");
    }
  });

  $("#sigunSelect").on("change", function () {
    /*
			response = 보호소 배열
			...RegNo = 보호소 코드
			...Nm = 보호소 이름
		 */
    var selectedValue = $(this).val();
    $('input[type=radio][name="sigungu"][value="' + selectedValue + '"]').prop(
      "checked",
      true
    );
    if (selectedValue != "") {
      $.ajax({
        url: "SelectConditionC",
        type: "POST",
        data: { value: selectedValue },
        success: function (response) {
          $("label").remove("#centerlabel");
          $("option").remove("#centerop");
          for (var i = 0; i < response.length; i++) {
            $("#centerdiv").append(
              '<label id="centerlabel"><input type="radio" value="' +
                response[i].careRegNo +
                '" name="center" >' +
                response[i].careNm +
                "</label>"
            );
            $("#centerSelect").append(
              '<option value="' +
                response[i].careRegNo +
                '" id="centerop">' +
                response[i].careNm +
                "</option>"
            );
          }
        },
        error: function (error) {
          console.log("Ajax 요청 에러:", error);
        },
      });
    } else {
      $("label").remove("#centerlabel");
      $("option").remove("#centerop");
    }
  });
  $("#centerSelect").on("change", function () {
    var selectedvalue = $(this).val();
    $('input[type=radio][name="center"][value="' + selectedvalue + '"]').prop(
      "checked",
      true
    );
  });

  $(document).on("click", "button[id=selectbutton]", function () {
    var sidoVal = $("#sidoSelect").val();
    var gunguVal = $("#sigunSelect").val();
    var centerVal = $("#centerSelect").val();
    console.log(sidoVal);
    console.log(gunguVal);
    console.log(centerVal);

    $.ajax({
      url: "SearchDoginfo",
      type: "GET",
      data: { value1: sidoVal, value2: gunguVal, value3: centerVal },
      success: function (response) {
        pagination(response);
      },
    });
  });
  $(document).on("click", "button[id=radiobutton]", function () {
    var sidoVal = $("input[name='sido']:checked").val();
    var gunguVal = $("input[name='sigungu']:checked").val();
    var centerVal = $("input[name='center']:checked").val();
    console.log(sidoVal);
    console.log(gunguVal);
    console.log(centerVal);

    $.ajax({
      url: "SearchDoginfo",
      type: "GET",
      data: { value1: sidoVal, value2: gunguVal, value3: centerVal },
      success: function (response) {
        //				console.log(response);
        pagination(response);
      },
    });
  });
  $(document).on("click", "span[id=closeBtn]", function () {
    $("#modalWrap").css({
      display: "none",
    });
  });
  $(window).on("click", function (event) {
    if ($(event.target).is("#modalWrap")) {
      $("#modalWrap").css({
        display: "none",
      });
    }
  });
  $(document).on("click", "button[id=detail]", function () {
    var values = $(this).children().text();
    var items = JSON.parse(values);
    $("div").remove("#detailinfo");
    $("#modalBody").append(
      '<div class="modalWrap" id="detailinfo">' +
        '<div class="modalImg" id="detailinfo"><img src="' +
        items.popfile +
        '" style="width:300px;"></div>' +
        '<div class="modalInfoWrap" id="detailinfo">' +
        '<div class="modal-list" id="detailinfo"><p>Age</p>' +
        '<span class="spandesign">' +
        items.age +
        "</span>" +
        "</div>" +
        '<div class="modal-list" id="detailinfo"><p>Number</p>' +
        '<span class="spandesign">' +
        items.desertionNo +
        "</span>" +
        "</div>" +
        '<div class="modal-list" id="detailinfo"><p>Kind</p>' +
        '<span class="spandesign">' +
        items.kindCd +
        "</span>" +
        "</div>" +
        '<div class="modal-list" id="detailinfo"><p>Color</p>' +
        '<span class="spandesign">' +
        items.colorCd +
        "</span>" +
        "</div>" +
        '<div class="modal-list" id="detailinfo"><p>Gender</p>' +
        '<span class="spandesign">' +
        items.sexCd +
        "</span>" +
        "</div>" +
        '<div class="modal-list" id="detailinfo"><p>Neutering</p>' +
        '<span class="spandesign">' +
        items.neuterYn +
        "</span>" +
        "</div>" +
        '<div class="modal-list" id="detailinfo"><p>Characteristic</p>' +
        '<span class="spandesign">' +
        items.specialMark +
        "</span>" +
        "</div>" +
        '<div class="Shelter" id="detailinfo"><p>Shelter</p>' +
        '<span class="spandesign2">' +
        items.careNm +
        "(" +
        items.careTel +
        ")" +
        items.careAddr +
        "</span>" +
        "</div>" +
        '<div class="agency" id="detailinfo"><p>agency</p>' +
        '<span class="spandesign2">' +
        items.orgNm +
        "&nbsp;" +
        items.chargeNm +
        "(" +
        items.officetel +
        ")" +
        "</span>" +
        "</div>" +
        '<div class="likebtn" id="detailinfo"><button id="like" ><p style="display:none;">' +
        values +
        '</p>Like</button><button id="liketrigger">spon</button>' +
        "</div>" +
        "</div>"
    );
    $("#modalWrap").css({ display: "block" });
  });
  $(document).on("click", "button[id=like]", function () {
    var selectedValue = $(this).children().text();
    var id = $("#account").text();

    if (id != "") {
      $.ajax({
        url: "MyPageLikeC",
        type: "GET",
        data: { value: selectedValue },
        success: function () {
          alert("등록완료되었습니다.");
        },
        error: function (error) {
          console.log("Ajax 요청 에러:", error);
        },
      });
    } else {
      let goLogin = confirm(
        "로그인이 필요한 메뉴입니다.\n로그인하러 가시겠습니까?"
      );
      if (goLogin) {
        location.href = "LoginMainHC";
      }
    }
  });
});

function pagination(json) {
  console.log(json);
  console.log("---------");
  let container = $("#pagination");
  container.css({
    display: "flex",
    justifyContent: "center",
    margin: "1vw 0",
  });
  container.pagination({
    dataSource: json,
    pageSize: 12,
    callback: function (data, pagination) {
      var dataHtml = '<div class="infoinnerbox">';
      $.each(data, function (index, item) {
        dataHtml +=
          '<div class="doginfobox" id="dog">' +
          '<div class="infoimg"> <img alt="" src="' +
          item.popfile +
          '"></div>' +
          '<div class="doginfoWrap">' +
          '<div class="infotext">' +
		  '<div class=dDay>d-10day</div>'+
          '<div class="kind"> kind: ' +
          item.kindCd +
          "</div>" +
          '<div class="etc"> age:' +
          item.age +
          "<br> gender:" +
          item.sexCd +
          "&nbsp; neuter:" +
          item.neuterYn +
          "</div>" +
          "</div>" +
          '<div class="infobutton">' +
          "<span>" +
          '<button id="detail"><p style="display:none;">' +
          JSON.stringify(item) +
          "</p>View More</button>" +
          "</span>" +
          "</div>" +
          "</div>" +
          "</div>";
        console.log(item);
      });
      dataHtml += "</div>";
      $("#data-container").html(dataHtml);
    },
  });
}

$(window).on("load", function () {
  var uprCd = $("#defaultUpr").val();
  //var orgCd = $('#defaultOrg').val();
  //console.log(orgCd);
  $('input[name="sido"][value="' + uprCd + '"]').click();
  //$('input[name="sigungu"][value="'+ orgCd+'"]').click();
  if (uprCd != "") {
    $("#radiobutton").click();
  }
});
