$(document).ready(function() {
    $("h1").text("Hello 62swe");
    $(".paragraph").html("<strong>This is strong paragraph!</strong>");
    $("#specific-paragraph").append("<br>This is appended text after specific paragraph");

    $("#clickable-button").click(function(){
        alert("Button clicked!");
    });

    $(".blue").hover(function(){
        $(this).css("background-color", "red");
    }, function() {
        $(this).css("background-color", "blue");
    })

    $("#toggle-button").click(function() {
        // $('.grey').hide();
        // $('.grey').show();
        // $('.grey').toggle();
        if ($('.grey').css('display') === 'none') {
            $('.grey').fadeIn();
        } else {
            $('.grey').fadeOut();
        }
    })
})
