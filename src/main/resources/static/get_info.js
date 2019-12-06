$(document).ready(function() {
  // Allow the labs to reveal themselves once properly constructed.
  $(".product-grid").hide();
  
  // Attempt to populate the labs page with information found in the JSON file.
  $.ajax({
    // Put out a GET request for the requisite JSON file.
    type: "GET",
    url: "http://localhost:8080/main/3",
    dataType: "json",
    
    // If the get request is successful, scrape the JSON data and format it for my webpage.
    success: function(data, status) {
      var output = "";
      // Format the JSON data for each entry into HTML.
      $.each(data, function(mainIndex, item) {
        // Provide the lab name and description.  Such is the bare minimum.
        output += "&nbsp;<div class=\"grid-product\">";
        output += "<div class=\"img-name\" style=\"background-image:url(";
        output += item.img + ")\"><h4>" + item.foodName + "</h4></div>";
        output += "<p class=\"description\">Calories:" + item.calories + " kCal</p>";
        output += "<p class=\"price\">$" + item.calories + "<button class=\"add-to-cart js-add-to-cart btn\">Add</button></p></div></div>";
        // If there are any associated links, build an anchor tag for each link and add it to the output.
      });
      // Display the HTML on the website in the proper container.
      $(".product-grid").html(output); 
      // Reveal the labs all at once.
      $(".product-grid").show(1000);
    },  
    // Always account for the possibility of error.
    error: function(msg) {
      alert("There was a problem: " + msg.status + " " + msg.statusText);
    }
  });
});